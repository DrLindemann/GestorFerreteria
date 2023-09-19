package com.mario.GestorFerreteria.service;

import com.mario.GestorFerreteria.exception.ProductNotFoundException;
import com.mario.GestorFerreteria.model.Product;
import com.mario.GestorFerreteria.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //Añadir mas stock en el caso de reposicion

    public Product addStock(Long id, int quantity){
        Product product = productRepository.findById(id).orElse(null);

        if (product != null){
            product.setStock(product.getStock() + quantity);
            return productRepository.save(product);
        }else{
            throw new ProductNotFoundException("Producto no encontrado");
        }
    }

    //CRUD

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findProductByName(String name){
        return productRepository.findProdutcByName(name);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id,Product updatedProduct){
        Product product = productRepository.findById(id).orElse(null);

        if (product != null){
            if (updatedProduct.getName() != null){
                product.setName(updatedProduct.getName());
            }
            if (updatedProduct.getPrice() != null){
                product.setPrice(updatedProduct.getPrice());
            }
            if (updatedProduct.getStock() != null){
                product.setStock(updatedProduct.getStock());
            }
            return productRepository.save(product);
        }else {
            return null;
        }


    }

    public void deleteProductById(Long id){
        productRepository.deleteById(id);
    }


}
