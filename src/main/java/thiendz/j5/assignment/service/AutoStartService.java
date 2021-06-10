/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.service;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import thiendz.j5.assignment.dao.AccountDAO;

@Component
public class AutoStartService {

    @PostConstruct
    public void ahihi() {
        System.out.println("ThienDepTrai!");
    }
}
