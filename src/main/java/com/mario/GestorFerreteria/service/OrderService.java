package com.mario.GestorFerreteria.service;


import com.mario.GestorFerreteria.exception.InsufficientStockExecption;
import com.mario.GestorFerreteria.model.Order;
import com.mario.GestorFerreteria.model.Product;
import com.mario.GestorFerreteria.repository.OrderRepository;
import com.mario.GestorFerreteria.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    //CRUD
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }

    public List<Order>findOrderByCustomerId(Long id){
        return orderRepository.findOrdersByCustomerId(id);
    }

    public Order findOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order addOrder (Order order, int quantity){
        double total = calculateTotalPrice(order.getProducts());
        order.setTotal(total);

        for (Product product : order.getProducts()){
            Product productOnBd = productRepository.findById(product.getId()).orElse(null);
            if (productOnBd != null){
                int actualStock = productOnBd.getStock();
                if (actualStock >= quantity){
                    productOnBd.setStock(actualStock - quantity);
                    productRepository.save(productOnBd);
                }else {
                    throw new InsufficientStockExecption("No hay suficiente Stock");
                }

            }

        }
        return orderRepository.save(order);
    }

    //Calcula el precio total del pedido
    private double calculateTotalPrice(List<Product> products){
        double total = 0.0;

        for (Product product : products){
            total += product.getPrice();
        }
        return total;

    }

    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }








}
