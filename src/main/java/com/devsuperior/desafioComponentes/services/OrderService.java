package com.devsuperior.desafioComponentes.services;

import com.devsuperior.desafioComponentes.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;


    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public double total(Order order) {

        double discont = order.getBasic()  * (order.getDiscount() / 100);
        double discontedPrice = order.getBasic() - discont;
        return discontedPrice + shippingService.shipment(order);
    }
}
