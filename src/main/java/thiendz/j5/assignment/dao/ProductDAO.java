package thiendz.j5.assignment.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import thiendz.j5.assignment.model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
