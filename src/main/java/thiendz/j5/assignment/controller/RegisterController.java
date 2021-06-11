/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
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
import thiendz.j5.assignment.dao.AccountDAO;
import thiendz.j5.assignment.model.Account;
import thiendz.j5.assignment.model.atrributes.AccountRegister;
import thiendz.j5.assignment.service.ErrorManager;
import thiendz.j5.assignment.util.Utils;

@Controller
@RequestMapping({"/register"})
public class RegisterController {

    @Autowired
    AccountDAO accountDAO;
    @Autowired
    HttpServletRequest rq;
    @Autowired
    ErrorManager error;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("account-register", new AccountRegister());
        return "register";
    }

    @PostMapping
    public String register(
            @Valid @ModelAttribute("account-register") AccountRegister accountRegister,
            BindingResult bind
    ) {
        error.start("register", "redirect:/login");
        if (bind.hasErrors()) {
            error.add("Form not valid!");
            return error.path();
        }
        Optional<Account> optional = accountDAO.findById(accountRegister.getUsername());
        if (optional.isPresent()) {
            error.add("username is exists!");
            return error.path();
        }
        Account account = new Account(
                accountRegister.getUsername(),
                accountRegister.getPassword(),
                accountRegister.getFullname(),
                accountRegister.getEmail(),
                null, false, true, new Date()
        );
        accountDAO.save(account);
        return error.path();
    }
}
