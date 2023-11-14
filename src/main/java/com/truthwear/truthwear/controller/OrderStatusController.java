package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.OrderStatus;
import com.truthwear.truthwear.service.OrderStatusServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderStatusController {

    private final OrderStatusServiceImpl orderStatusService;

    public OrderStatusController(OrderStatusServiceImpl orderStatusService) {
        this.orderStatusService = orderStatusService;
    }

    @GetMapping("order_status")
    ResponseEntity<List<OrderStatus>> getAllOrderStatus(){
        return orderStatusService.getAllOrderStatus();
    }

    @GetMapping("order_status/{id}")
    ResponseEntity<OrderStatus> getAllOrderStatusById(@PathVariable int id){
        return orderStatusService.getAllOrderStatusById(id);
    }

    @PostMapping("order_status")
    ResponseEntity<OrderStatus> createOrderStatus(@RequestBody OrderStatus orderStatus){
        return orderStatusService.createOrderStatus(orderStatus);
    }
    @PutMapping("order_status/{id}")
    ResponseEntity<OrderStatus> updateOrderStatus(@PathVariable int id, @RequestParam("orderStatus") String orderStatus){
        return orderStatusService.updateOrderStatus(id,orderStatus);
    }

    @DeleteMapping("order_status/{id}")
    ResponseEntity<OrderStatus> deleteOrderStatusById(@PathVariable int id){
        return orderStatusService.deleteOrderStatusById(id);
    }
}
