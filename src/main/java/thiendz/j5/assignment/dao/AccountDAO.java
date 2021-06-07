/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import thiendz.j5.assignment.model.Account;

/**
 *
 * @author Administrator
 */
@Service
public interface AccountDAO extends JpaRepository<Account, String> {

    @Query("SELECT account FROM Account account WHERE account.username=?1 AND account.password=?2")
    Account getAccount(String username, String password);
}
