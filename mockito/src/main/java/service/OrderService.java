package service;

import dto.OrderRequest;
import dto.OrderResponse;
import util.NotificationUtil;

public class OrderService {

    public OrderResponse checkoutOrder(OrderRequest order) {
        // call DAO
        int discount = addDiscount(order);
        order.setPrice(order.getPrice() - discount);
        String message = NotificationUtil.sendEmail(order.getEmailId());
        return new OrderResponse(order, message, 200);
    }

    // 2. Mock private method
    private int addDiscount(OrderRequest order) {
        System.out.println("called...");
        int price = order.getPrice();
        int discountAMount = 0;
        if (order.isDiscountable()) {
            if (order.getPrice() > 1000) {
                discountAMount = price * 10 / 100;
            } else {
                discountAMount = price;
            }
        } else {
            discountAMount = price;
        }
        return discountAMount;
    }
}
