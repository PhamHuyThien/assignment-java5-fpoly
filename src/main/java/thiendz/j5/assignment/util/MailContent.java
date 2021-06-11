/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiendz.j5.assignment.util;

import java.util.ArrayList;
import java.util.List;
import thiendz.j5.assignment.model.OrderDetail;

/**
 *
 * @author PhamHuyThien
 */
public class MailContent {

    private final String title;
    private final String body;
    //
    private List<OrderDetail> listOrderDetails = new ArrayList<>();

    public MailContent(List<OrderDetail> listOrderDetails) {
        this.listOrderDetails = listOrderDetails;
        title = "[J5Shop] Bạn vừa đặt một hàng mới!";
        body = "Bạn vừa đặt hàng thành công trên shop, shipper sẽ gọi điện cho bạn sớm thôi!";
    }

    public String buildTitle() {
        return title;
    }

    public String buildBody() {
        return body;
    }
}
