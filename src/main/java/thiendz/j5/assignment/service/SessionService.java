/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.service;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thiendz.j5.assignment.dao.AccountDAO;
import thiendz.j5.assignment.model.Account;

/**
 *
 * @author Administrator
 */
@Service
public class SessionService {

    @Autowired
    HttpSession session;
    @Autowired
    CookieService cookieService;
    @Autowired
    AccountSessionService accountSessionService;
    @Autowired
    AccountDAO accountDAO;

    public <T> T get(String name) {
        return (T) session.getAttribute(name);
    }

    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    public void remove(String name) {
        session.removeAttribute(name);
    }

    public Account getAccount() {
        return get("account");
    }

    public boolean isLogin() {
        Account account = get("account");
        return account != null;
    }

    public boolean isAdmin() {
        Account account = get("account");
        return isLogin() && account.getRole();
    }
}
