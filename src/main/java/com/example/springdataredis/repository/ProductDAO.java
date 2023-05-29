package com.example.springdataredis.repository;


import com.example.springdataredis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {
    @Autowired
    private RedisTemplate template;

    public Product save(Product product){
        template.opsForHash().put("Product",product.getId(),product);
        return product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values("Product");
    }


    public Product findProductById(int id){
        return (Product) template.opsForHash().get("Product",id);
    }


    public String deleteProduct(int id){
        template.opsForHash().delete("Product",id);
        return "product removed !!";
    }
}
