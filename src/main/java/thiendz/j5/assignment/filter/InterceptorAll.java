/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import thiendz.j5.assignment.model.Account;
import thiendz.j5.assignment.service.AccountSessionService;
import thiendz.j5.assignment.service.CookieService;
import thiendz.j5.assignment.service.SessionService;

@Component
public class InterceptorAll implements HandlerInterceptor {

    @Autowired
    AccountSessionService accountSessionService;
    @Autowired
    SessionService sessionService;
    @Autowired
    CookieService cookieService;

    @Override
    public boolean preHandle(HttpServletRequest rq, HttpServletResponse rp, Object handler) {
        Account account = sessionService.getAccount();
        if (account == null) {
            account = cookieService.getAccount();
            accountSessionService.setAccount(account);
        }
        return true;
    }
}
