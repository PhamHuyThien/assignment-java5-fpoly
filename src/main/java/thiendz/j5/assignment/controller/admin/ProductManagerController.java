/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import thiendz.j5.assignment.dao.CategoryDAO;
import thiendz.j5.assignment.dao.ProductDAO;
import thiendz.j5.assignment.model.Category;
import thiendz.j5.assignment.model.Product;
import thiendz.j5.assignment.model.atrributes.ProductForm;
import thiendz.j5.assignment.service.ErrorManager;
import thiendz.j5.assignment.service.ParamService;
import thiendz.j5.assignment.util.Utils;

@Controller
@RequestMapping({"/admin/product-manager"})
public class ProductManagerController {

    private static final String PATH_SAVE_AVATAR = "/assets/avatar/";
    @Autowired
    HttpServletRequest rq;
    @Autowired
    ErrorManager error;
    @Autowired
    ProductDAO productDAO;
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    ParamService paramService;

    @GetMapping
    public String index(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "col-sort", defaultValue = "id") String colSort,
            @RequestParam(name = "type-sort", defaultValue = "DESC") String typeSort,
            @RequestParam(name = "edit", defaultValue = "") String edit
    ) {
        //
        Page<Product> pageProducts = productDAO.findAll(PageRequest.of(page, size, Sort.Direction.valueOf(typeSort), colSort));
        List<Product> listProducts = pageProducts.getContent();
        //
        ProductForm productForm = new ProductForm();
        if (!edit.equals("")) {
            int id = Integer.parseInt(edit);
            Product product = productDAO.getById(id);
            productForm.setCategoryId(product.getCategory().getId());
            productForm.setId(product.getId());
            productForm.setName(product.getName());
            productForm.setPrice(product.getPrice());
            productForm.setStatus(product.getStatus());
        }
        //
        rq.setAttribute("productForm", productForm);
        rq.setAttribute("listProduct", listProducts);
        rq.setAttribute("listCategory", categoryDAO.findAll());
        //
        rq.setAttribute("page", page);
        rq.setAttribute("typesort", typeSort.equals("DESC") ? "ASC" : "DESC");
        return "/admin/product-manager";
    }

    @GetMapping({"/add", "/delete"})
    public String returnIndex() {
        return "redirect:/admin/product-manager";
    }

    @RequestMapping("/add")
    public String add(
            @Valid @ModelAttribute("productForm") ProductForm productForm,
            BindingResult bind,
            @RequestParam("avatar") MultipartFile multipartFile
    ) {
        String type = "Thêm thành công";
        error.start("/admin/product-manager");
        if (bind.hasErrors()) {
            error.add("form not valid!");
            return error.path();
        }
        Product product = null;
        if (productForm.getId() == null) { // thêm mới
            if (multipartFile.isEmpty()) {
                error.add("file is empty!");
                return error.path();
            }
            if (!multipartFile.getOriginalFilename().endsWith(".jpg")) {
                error.add("Chỉ hỗ trợ ảnh jpg!");
                return error.path();
            }
            String name = "avt" + Utils.random.nextInt(999999) + ".jpg";
            File result = paramService.save(multipartFile, PATH_SAVE_AVATAR, name);
            if (result == null) {
                error.add("lưu ảnh vào db thất bại!");
                return error.path();
            }
            Category category = categoryDAO.getById(productForm.getCategoryId());
            product = new Product(
                    productForm.getId(),
                    productForm.getName(),
                    PATH_SAVE_AVATAR + name,
                    productForm.getPrice(),
                    true,
                    new Date(),
                    category,
                    null
            );
        } else { // sửa
            Category category = categoryDAO.getById(productForm.getCategoryId());
            product = productDAO.getById(productForm.getId());
            if (!multipartFile.isEmpty()) {
                if (!multipartFile.getOriginalFilename().endsWith(".jpg")) {
                    error.add("Chỉ hỗ trợ ảnh jpg!");
                    return error.path();
                }
                String name = "avt" + Utils.random.nextInt(999999) + ".jpg";
                File result = paramService.save(multipartFile, PATH_SAVE_AVATAR, name);
                if (result == null) {
                    error.add("lưu ảnh vào db thất bại!");
                    return error.path();
                }
                product.setImage(PATH_SAVE_AVATAR + name);
            }
            product.setCategory(category);
            product.setName(productForm.getName());
            product.setPrice(productForm.getPrice());
            product.setStatus(productForm.getStatus());
            type = "Sửa thành công!";
        }
        productDAO.save(product);
        error.success(type);
        return error.path();
    }

    @RequestMapping("/delete")
    public String delete(
            @Valid @ModelAttribute("productForm") ProductForm productForm
    ) {
        error.start("/admin/product-manager");
        if (productForm.getId() == null) {
            error.add("Bạn phải nhập id!");
            return error.path();
        }
        Product product = new Product();
        product.setId(productForm.getId());
        productDAO.delete(product);
        error.success("Xóa thành công!");
        return error.path();
    }
}
