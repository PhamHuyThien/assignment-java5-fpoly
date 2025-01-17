/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thiendz.j5.assignment.config.J5ShopConfig;
import thiendz.j5.assignment.dao.AccountDAO;
import thiendz.j5.assignment.model.Account;
import thiendz.j5.assignment.model.atrributes.AccountLogin;
import thiendz.j5.assignment.service.AccountSessionService;
import thiendz.j5.assignment.service.CookieService;
import thiendz.j5.assignment.service.ErrorManager;
import thiendz.j5.assignment.service.SessionService;

@Controller
@RequestMapping({"/login"})
public class LoginController {

    @Autowired
    ErrorManager error;
    @Autowired
    AccountDAO accountDAO;
    @Autowired
    CookieService cookieService;
    @Autowired
    SessionService sessionService;
    @Autowired
    AccountSessionService accountSessionService;

    @GetMapping
    public String getIndex(Model model) {
        if (sessionService.isLogin()) {
            return "redirect:/";
        }
        model.addAttribute("account-login", new AccountLogin());
        return "login";
    }

    @PostMapping
    public String login(
            @Valid @ModelAttribute("account-login") AccountLogin accountLogin,
            BindingResult bind,
            @RequestParam(name = "remember-me", defaultValue = "false") boolean rememberMe
    ) {
        error.start("login", "redirect:/");
        if (bind.hasErrors()) {
            error.add("Form not valid!");
            return error.path();
        }
        Optional<Account> optional = accountDAO.findById(accountLogin.getUsername());
        if (!optional.isPresent()) {
            error.add("username không tồn tại!");
            return error.path();
        }
        Account account = accountDAO.getAccount(accountLogin.getUsername(), accountLogin.getPassword());
        if (account == null) {
            error.add("password không đúng!");
            return error.path();
        }
        int hour = rememberMe ? J5ShopConfig.LOGIN_TIME_REMEMBER_ME : J5ShopConfig.LOGIN_TIME_NO_REMEMBER_ME;
        cookieService.add("username", account.getUsername(), hour);
        cookieService.add("password", account.getPassword(), hour);
        sessionService.set("account", account);
        accountSessionService.setAccount(account);
        return error.path();
    }
}
