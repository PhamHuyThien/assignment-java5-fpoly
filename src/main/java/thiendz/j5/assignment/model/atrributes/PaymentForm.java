/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.model.atrributes;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentForm {

    @NotBlank
    String name;
    @NotBlank
    @Length(min = 10, max = 15)
    String phone;
    @NotBlank
    String andress;
}
