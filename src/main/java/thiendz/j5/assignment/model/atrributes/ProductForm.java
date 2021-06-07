/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.model.atrributes;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm {

    @NumberFormat
    Integer categoryId;
    @NumberFormat
    Integer id;
    @NotBlank
    String name;
    String image;
    @NotNull
    @NumberFormat
    Double price;
    Boolean status;
    Date time;
}
