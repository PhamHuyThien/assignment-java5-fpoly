/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thiendz.j5.assignment.model.OrderDetail;
import thiendz.j5.assignment.model.ReportProduct;


public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {

    @Query("SELECT od FROM OrderDetail od WHERE od.order.id=?1")
    public List<OrderDetail> findByIdOrder(int id);

    @Query("SELECT SUM(od.price * od.quantity) FROM OrderDetail od WHERE od.order.id=?1")
    public Double totalMoneyOrder(int id);

    //select product_id, sum(quantity) as c FROM order_detail GROUP by (product_id) ORDER BY (c) DESC;
    @Query("SELECT new thiendz.j5.assignment.model.ReportProduct(od.product, SUM(od.price * od.quantity), SUM(od.quantity) AS s)  FROM OrderDetail od GROUP BY od.product ORDER BY (s) DESC")
    public List<ReportProduct> getListProductBigOrder(Pageable pageable);
}
