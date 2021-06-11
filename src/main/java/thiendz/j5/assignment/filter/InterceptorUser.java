/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import thiendz.j5.assignment.model.Account;
import thiendz.j5.assignment.service.SessionService;

@Component
public class InterceptorUser implements HandlerInterceptor {

    @Autowired
    SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest rq, HttpServletResponse rp, Object handler) throws IOException {
        Account account = sessionService.getAccount();
        if (account == null) {
            rp.sendRedirect(rq.getContextPath() + "/login");
            return false;
        }
        return true;
    }
}
