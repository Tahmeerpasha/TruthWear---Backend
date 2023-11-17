package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.OrderPaymentMethod;
import com.truthwear.truthwear.service.OrderPaymentMethodServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class OrderPaymentMethodController {
    private final OrderPaymentMethodServiceImpl orderPaymentMethodService;

    public OrderPaymentMethodController(OrderPaymentMethodServiceImpl orderPaymentMethodService) {
        this.orderPaymentMethodService = orderPaymentMethodService;
    }

    @GetMapping("order-payment-methods")
    ResponseEntity<List<OrderPaymentMethod>> getAllOrderPaymentMethods(){
        return orderPaymentMethodService.getAllOrderPaymentMethods();
    }
    @GetMapping("order-payment-methods/{id}")
    ResponseEntity<OrderPaymentMethod> getAllOrderPaymentMethod(@PathVariable int id){
        return orderPaymentMethodService.getAllOrderPaymentMethod(id);
    }
    @PostMapping("order-payment-methods")
    ResponseEntity<OrderPaymentMethod> createOrderPaymentMethod(@RequestBody OrderPaymentMethod orderPaymentMethod){
        return orderPaymentMethodService.createOrderPaymentMethod(orderPaymentMethod);
    }

    @PutMapping("order-payment_methods/{id}")
    ResponseEntity<OrderPaymentMethod> updateOrderPaymentMethod(@PathVariable int id,
                                                                @RequestParam(name = "orderId",required = false) Integer orderId,
                                                                @RequestParam(name = "userPaymentMethodId",required = false) Integer userPaymentMethodId){
        return orderPaymentMethodService.updateOrderPaymentMethod(id,orderId,userPaymentMethodId);
    }
    @DeleteMapping("order-payment-methods/{id}")
    ResponseEntity<OrderPaymentMethod> deleteOrderPaymentMethod(@PathVariable int id){
        return orderPaymentMethodService.deleteOrderPaymentMethod(id);
    }


}
