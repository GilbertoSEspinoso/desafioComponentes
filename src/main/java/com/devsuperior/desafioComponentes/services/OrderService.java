package com.devsuperior.desafioComponentes.services;

import com.devsuperior.desafioComponentes.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {

        double discont = order.getBasic()  * (order.getDiscount() / 100);
        double discontedPrice = order.getBasic() - discont;
        return discontedPrice + shippingService.shipment(order);
    }
}
