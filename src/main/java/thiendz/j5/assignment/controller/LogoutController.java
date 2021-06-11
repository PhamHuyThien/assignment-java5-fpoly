package thiendz.j5.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import thiendz.j5.assignment.service.AccountSessionService;
import thiendz.j5.assignment.service.CookieService;
import thiendz.j5.assignment.service.SessionService;
import thiendz.j5.assignment.service.ShoppingCartServiceImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {

    @Autowired
    SessionService sessionService;
    @Autowired
    CookieService cookieService;
    @Autowired
    AccountSessionService accountSessionService;
    @Autowired
    ShoppingCartServiceImpl shoppingCartServiceImpl;

    @GetMapping
    public String logout() {
        sessionService.remove("account");
        cookieService.remove("username");
        cookieService.remove("password");
        cookieService.remove("role");
        shoppingCartServiceImpl.clear();
        accountSessionService.setAccount(null);
        accountSessionService.setCountShoppingCart(0);
        return "redirect:/";
    }
}
