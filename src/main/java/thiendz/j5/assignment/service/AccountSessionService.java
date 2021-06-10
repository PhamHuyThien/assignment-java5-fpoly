/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thiendz.j5.assignment.model.Account;

@Service
public class AccountSessionService {

    @Autowired
    SessionService sessionService;
    @Autowired
    HttpServletRequest rq;

    public void setAccount(Account account) {
        rq.getSession().setAttribute("account", account);
    }

    public void setCountShoppingCart(int count) {
        String c = "";
        if (count > 0) {
            c = "+" + count;
        }
        rq.getSession().setAttribute("countShoppingCart", c);
    }
}
