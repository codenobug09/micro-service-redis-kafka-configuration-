package com.example.product.service;


import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceInterface{
    private final ProductRepository repo;

    public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product create(Product p) {
        return repo.save(p);
    }

    @Cacheable(value = "product", key = "#id")
    public Product update(Product p, Long id){
        Product product = repo.findById(id).orElse(null);
        if(product != null){
            product.setName(p.getName());
            product.setPrice(p.getPrice());
            return repo.save(product);
        }
        return null;
    }

    public void delete(Long id){
        repo.findById(id).ifPresent(repo::delete);
    }
}
