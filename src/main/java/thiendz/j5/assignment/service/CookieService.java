/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class CookieService {
    
    @Autowired
    HttpServletRequest rq;
    @Autowired
    HttpServletResponse rp;
    
    public Cookie get(String name) {
        Cookie[] cookies = rq.getCookies();
        Cookie result = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                result = cookie;
                break;
            }
        }
        return result;
    }
    
    public String getValue(String name) {
        Cookie cookie = this.get(name);
        return cookie == null ? "" : cookie.getValue();
    }
    
    public Cookie add(String name, String value, int hour) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hour * 60 * 60);
        rp.addCookie(cookie);
        return cookie;
    }
    
    public void remove(String name) {
        int len = rq.getCookies().length;
        for (int i = 0; i < len; i++) {
            if (rq.getCookies()[i].getName().equalsIgnoreCase(name)) {
                rq.getCookies()[i].setMaxAge(0);
            }
        }
    }
    
}
