/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thiendz.j5.assignment.model.OrderDetail;

/**
 *
 * @author Administrator
 */
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {

    @Query("SELECT od FROM OrderDetail od WHERE od.order.id=?1")
    public List<OrderDetail> findByIdOrder(int id);

    @Query("SELECT SUM(od.price * od.quantity) FROM OrderDetail od WHERE od.order.id=?1")
    public Double totalMoneyOrder(int id);

}
