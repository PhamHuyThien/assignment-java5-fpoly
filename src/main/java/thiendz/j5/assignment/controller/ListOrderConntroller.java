/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thiendz.j5.assignment.dao.OrderDAO;
import thiendz.j5.assignment.dao.OrderDetailDAO;
import thiendz.j5.assignment.model.Account;
import thiendz.j5.assignment.service.SessionService;

@Controller
@RequestMapping("/list-order")
public class ListOrderConntroller {

    @Autowired
    OrderDAO orderDAO;
    @Autowired
    OrderDetailDAO orderDetailDAO;
    @Autowired
    HttpServletRequest rq;
    @Autowired
    SessionService sessionService;

    @GetMapping
    public String getIndex(
            @RequestParam(name = "view-detail", defaultValue = "-1") int idOrder,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "col-sort", defaultValue = "time") String colSort,
            @RequestParam(name = "type-sort", defaultValue = "DESC") String typeSort
    ) {
        if (idOrder != -1) {
            rq.setAttribute("idOrder", idOrder);
            rq.setAttribute("listOrderDetails", orderDetailDAO.findByIdOrder(idOrder));
            rq.setAttribute("totalMoneyOrder", orderDetailDAO.totalMoneyOrder(idOrder));
        }

        Account account = sessionService.getAccount();
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.valueOf(typeSort), colSort));
        rq.setAttribute("listOrders", orderDAO.findByUsernameEqual(account.getUsername(), pageable));
        rq.setAttribute("page", page);
        rq.setAttribute("typeSort", typeSort.equals("DESC") ? "ASC" : "DESC");
        return "list-order";
    }

}
