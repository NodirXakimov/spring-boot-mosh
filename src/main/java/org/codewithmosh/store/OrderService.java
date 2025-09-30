package org.codewithmosh.store;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;

//@Service
public class OrderService {
    private PaymentService paymentService;

    //    @Autowired
    public OrderService(@Qualifier("stripe") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostConstruct
    public void init() {
        System.out.println("Order Service PostConstruct");
    }

    public void placeOrder() {
        paymentService.processPayment(10);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
