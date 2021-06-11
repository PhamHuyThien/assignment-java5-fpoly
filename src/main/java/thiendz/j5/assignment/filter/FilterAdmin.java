/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import thiendz.j5.assignment.model.Account;

public class FilterAdmin implements Filter {

    @Override
    public void doFilter(ServletRequest rq, ServletResponse rp, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest hrq = (HttpServletRequest) rq;
        HttpServletResponse hrp = (HttpServletResponse) rp;
        Account account = (Account) hrq.getSession().getAttribute("account");
        if (account == null) {
            hrp.sendRedirect(hrq.getContextPath() + "/login");
            return;
        }
        if (!account.getRole()) {
            hrp.sendRedirect(hrq.getContextPath() + "/");
            return;
        }
        fc.doFilter(rq, rp);
    }
}
