package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShopOrder;
import com.truthwear.truthwear.service.ShopOrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopOrderController {

    private final ShopOrderServiceImpl shopOrderService;

    public ShopOrderController(ShopOrderServiceImpl shopOrderService) {
        this.shopOrderService = shopOrderService;
    }

    @GetMapping("/shop_orders")
    ResponseEntity<List<ShopOrder>> getAllShopOrders(){
        return shopOrderService.getAllShopOrders();
    }

    @GetMapping("/shop_orders/{id}")
    ResponseEntity<ShopOrder> getAllShopOrdersById(@PathVariable int id){
        return shopOrderService.getAllShopOrdersById(id);
    }
    @GetMapping("/shop_orders/user/{userId}")
    ResponseEntity<List<ShopOrder>> getAllShopOrdersByUserId(@PathVariable int userId){
        return shopOrderService.getAllShopOrdersByUserId(userId);
    }

    @PostMapping("/shop_orders")
    ResponseEntity<ShopOrder> createShopOrder( @RequestBody ShopOrder shopOrder){
        return shopOrderService.createShopOrder(shopOrder);
    }

    @PutMapping("/shop_orders/{id}")
    ResponseEntity<ShopOrder> updateShopOrder(
            @RequestParam(value = "orderDate", required = false)Timestamp orderDate,
            @RequestParam(value = "orderPaymentMethodId", required = false)Integer orderPaymentMethodId,
            @RequestParam(value = "shippingAddressId", required = false)Integer shippingAddressId,
            @RequestParam(value = "shippingMethodId", required = false)Integer shippingMethodId,
            @RequestParam(value = "orderTotal", required = false) BigDecimal orderTotal,
            @RequestParam(value = "orderStatus", required = false) Integer orderStatus,
            @PathVariable int id){
        return shopOrderService.updateShopOrder(id,orderDate,shippingAddressId,shippingMethodId,orderTotal,orderStatus,orderPaymentMethodId);
    }
    @DeleteMapping("/shop_orders/{id}")
    ResponseEntity<ShopOrder> deleteShopOrder(@PathVariable int id){
        return shopOrderService.deleteShopOrder(id);
    }
}
