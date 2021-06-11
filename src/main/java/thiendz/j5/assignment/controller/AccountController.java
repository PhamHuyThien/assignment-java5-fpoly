/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import thiendz.j5.assignment.dao.AccountDAO;
import thiendz.j5.assignment.model.Account;
import thiendz.j5.assignment.model.atrributes.AccountForm;
import thiendz.j5.assignment.service.ErrorManager;
import thiendz.j5.assignment.service.MailService;
import thiendz.j5.assignment.service.ParamService;
import thiendz.j5.assignment.service.SessionService;

@Controller
@RequestMapping("/account")
public class AccountController {

    private static final String PATH_SAVE_ACCOUNT_IMG = "/assets/img/account/";
    @Autowired
    HttpServletRequest rq;
    @Autowired
    SessionService sessionService;
    @Autowired
    ParamService paramService;
    @Autowired
    MailService mailService;
    @Autowired
    ErrorManager errorManager;
    @Autowired
    AccountDAO accountDAO;

    @GetMapping
    public String getIndex() {
        Account account = sessionService.get("account");
        AccountForm accountForm = new AccountForm();
        accountForm.setUsername(account.getUsername());
        accountForm.setPassword(account.getPassword());
        accountForm.setFullname(account.getFullname());
        accountForm.setEmail(account.getEmail());
        accountForm.setPhoto(account.getPhoto());
        rq.setAttribute("accountForm", accountForm);
        return "account";
    }

    @GetMapping("/update")
    public String returnIndex() {
        return "redirect:/account";
    }

    @RequestMapping("/update")
    public String updateAccount(
            @Valid @ModelAttribute("accountForm") AccountForm accountForm,
            BindingResult bindingResult,
            @RequestParam("file") MultipartFile multipartFile
    ) {
        errorManager.start("account");
        if (bindingResult.hasErrors()) {
            errorManager.add("form not valid!");
            return errorManager.path();
        }
        Account account = sessionService.get("account");
        account.setUsername(accountForm.getUsername());
        account.setFullname(accountForm.getFullname());
        account.setEmail(accountForm.getEmail());
        if (!multipartFile.isEmpty()) {
            errorManager = paramService.saveImg(multipartFile, errorManager, PATH_SAVE_ACCOUNT_IMG);
            if (errorManager.exists()) {
                return errorManager.path();
            }
            account.setPhoto(errorManager.success());
        }
        if (!account.getPassword().equals(accountForm.getPassword())) {
            mailService.push(
                    account.getEmail(),
                    "[J5Shop] Mật khẩu đã thay đổi!",
                    "Mật khẩu được thay đổi, nếu bạn không làm hãy báo việc này cho admin, cảm ơn!"
            );
            account.setPassword(accountForm.getPassword());
            errorManager.start("redirect:/logout");
        }
        accountDAO.save(account);
        errorManager.success("Cập nhật thành công!");
        return errorManager.path();
    }
}
