/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.controller.admin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import thiendz.j5.assignment.dao.OrderDetailDAO;

@Controller
@RequestMapping("/admin/analysis-manager")
public class AnanlysisManagerController {

    @Autowired
    HttpServletRequest rq;
    @Autowired
    OrderDetailDAO orderDetailDAO;

    @GetMapping
    public String getIndex() {
        rq.setAttribute("bigOrder", orderDetailDAO.getListProductBigOrder(PageRequest.of(0, 10)));
        return "admin/analysis-manager";
    }
}
