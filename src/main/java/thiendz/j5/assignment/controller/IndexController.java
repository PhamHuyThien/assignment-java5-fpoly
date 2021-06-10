package thiendz.j5.assignment.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import thiendz.j5.assignment.dao.CategoryDAO;
import thiendz.j5.assignment.dao.ProductDAO;
import thiendz.j5.assignment.model.atrributes.CartItem;
import thiendz.j5.assignment.model.Category;
import thiendz.j5.assignment.model.Product;
import thiendz.j5.assignment.service.AccountSessionService;
import thiendz.j5.assignment.service.ShoppingCartServiceImpl;

@Controller
@RequestMapping({"/", "/index", "/index.*"})
public class IndexController {
    
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    ProductDAO productDAO;
    @Autowired
    HttpServletRequest rq;
    @Autowired
    ShoppingCartServiceImpl shoppingCartServiceImpl;
    @Autowired
    AccountSessionService accountSessionService;
    
    @GetMapping
    public String index() {
        List<Category> listCategories = categoryDAO.findAll();
        rq.setAttribute("listCategories", listCategories);
        return "index";
    }
    
    @GetMapping({"/cart/add/{id}"})
    public String addCart(
            @PathVariable(name = "id", required = true) int id
    ) {
        Product product = productDAO.getById(id);
        CartItem cartItem = new CartItem(product.getId(), product.getName(), product.getPrice(), 1);
        shoppingCartServiceImpl.add(cartItem);
        accountSessionService.setCountShoppingCart(shoppingCartServiceImpl.getCount());
        return "redirect:/index";
    }    
}
