package com.truthwear.truthwear.controller;

import com.truthwear.truthwear.entity.ShippingMethod;
import com.truthwear.truthwear.service.ShippingMethodServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ShippingMethodController {
    private final ShippingMethodServiceImpl shippingMethodService;

    public ShippingMethodController(ShippingMethodServiceImpl shippingMethodService) {
        this.shippingMethodService = shippingMethodService;
    }

    @GetMapping("shipping-methods")
    ResponseEntity<List<ShippingMethod>> getAllShippingMethod(){
        return shippingMethodService.getAllShippingMethod();
    }

    @GetMapping("shipping-methods/{id}")
    ResponseEntity<ShippingMethod> getShippingMethodById(@PathVariable int id){
        return shippingMethodService.getShippingMethodById(id);
    }

    @PostMapping("shipping-methods")
    ResponseEntity<ShippingMethod> createShippingMethod(@RequestBody ShippingMethod shippingMethod){
        return shippingMethodService.createShippingMethod(shippingMethod);
    }

    @PutMapping("shipping-methods/{id}")
    ResponseEntity<ShippingMethod> updateShippingMethod(@PathVariable int id,
                                                        @RequestParam(value = "shippingMethod",required = false) String shippingMethod,
                                                        @RequestParam(value = "price",required = false) BigDecimal price
                                                        ){
        return shippingMethodService.updateShippingMethod(id,shippingMethod, price);
    }

    @DeleteMapping("shipping-methods/{id}")
    ResponseEntity<ShippingMethod> deleteShippingMethod(@PathVariable int id){
        return shippingMethodService.deleteShippingMethod(id);
    }
}
