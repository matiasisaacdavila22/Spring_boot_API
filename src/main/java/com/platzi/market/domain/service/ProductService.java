package com.platzi.market.domain.service;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Product> getAll(){
        return productoRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productoRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productoRepository.getByCategory(categoryId);
    }

    public  Product save(Product product){
        return productoRepository.save(product);
    }

    public boolean delete(int productoId){
        return getProduct(productoId).map(product -> {
                    productoRepository.delete(productoId);
                    return true;
        }).orElse(false);
    }

}
