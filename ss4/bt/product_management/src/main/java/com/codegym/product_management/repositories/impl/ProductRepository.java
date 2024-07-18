package com.codegym.product_management.repositories.impl;

import com.codegym.product_management.models.Product;
import com.codegym.product_management.repositories.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository(value = "productRepository")
public class ProductRepository implements IProductRepository {

    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"Iphone12",10000,"Tot lam","Apple"));
        products.add(new Product(2,"Iphone13",10000,"Tot lam","Apple"));
        products.add(new Product(3,"Iphone14",10000,"Tot lam","Apple"));
        products.add(new Product(4,"Nokia",2000,"Tot lam","Nokia"));
        products.add(new Product(5,"SamSung",50000,"Hoi cui","SamSung"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        product.setId(products.get(products.size()-1).getId() + 1);
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for(Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for(Product p : products) {
            if(p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setProduce(product.getProduce());
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
            for (Product product : products) {
                if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                    result.add(product);
                }
            }
        return result;
        }
}
