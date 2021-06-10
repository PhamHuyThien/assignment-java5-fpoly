/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import thiendz.j5.assignment.model.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.account.username = ?1")
    List<Order> findByUsernameEqual(String username);

    @Query("SELECT o FROM Order o WHERE o.account.username = ?1")
    List<Order> findByUsernameEqual(String username, Sort sort);

    @Query("SELECT o FROM Order o WHERE o.account.username = ?1")
    List<Order> findByUsernameEqual(String username, Pageable pageable);
}
