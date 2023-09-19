package com.mario.GestorFerreteria.controller;


import com.mario.GestorFerreteria.model.Order;
import com.mario.GestorFerreteria.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<Order> findAllOrders(){
        return orderService.findAllOrders();
    }

    @GetMapping("/customer/{id}")
    public List<Order> findOrderByCustomer(@PathVariable Long id){
        return orderService.findOrderByCustomerId(id);
    }

    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable Long id){
        return orderService.findOrderById(id);
    }

    @PostMapping("/")
    public Order addOrder(@RequestBody Order order, @PathVariable int quantity){
        return orderService.addOrder(order, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id){
        orderService.deleteOrderById(id);
    }

}
