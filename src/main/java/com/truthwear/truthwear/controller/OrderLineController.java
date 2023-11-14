package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.OrderLine;
import com.truthwear.truthwear.service.OrderLineServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderLineController {
    private final OrderLineServiceImpl orderLineService;

    public OrderLineController(OrderLineServiceImpl orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping("order_lines")
    ResponseEntity<List<OrderLine>> getAllOrderLines(){
        return orderLineService.getAllOrderLines();
    }

    @GetMapping("order_lines/{id}")
    ResponseEntity<OrderLine> getAllOrderLinesById(@PathVariable int id){
        return orderLineService.getAllOrderLinesById(id);
    }

    @PostMapping("order_lines")
    ResponseEntity<OrderLine> createOrderLines(@RequestBody OrderLine orderLine){
        return orderLineService.createOrderLines(orderLine);
    }

    @PutMapping("order_lines/{id}")
    ResponseEntity<OrderLine> updateOrderLines(@PathVariable int id,
                                                   @RequestParam(name = "productId",required = false) Integer productId,
                                                   @RequestParam(name = "orderId",required = false) Integer orderId,
                                                   @RequestParam(name = "quantity",required = false) Integer quantity,
                                                   @RequestParam(name = "price",required = false) Integer price
                                                   ){
        return orderLineService.updateOrderLines(id,productId,orderId,quantity,price);
    }

    @DeleteMapping("order_lines/{id}")
    ResponseEntity<OrderLine> deleteOrderLines(@PathVariable int id){
        return orderLineService.deleteOrderLines(id);
    }


}
