package com.codegym.product_management.repositories.impl;

import com.codegym.product_management.models.Product;
import com.codegym.product_management.repositories.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository(value = "productRepository")
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> products = BaseRepository.entityManager.createQuery("select s from product s", Product.class).getResultList();
        return products;
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Product product = BaseRepository.entityManager.find(Product.class, id);
        if (product != null) {
            BaseRepository.entityManager.remove(product);
        }
        transaction.commit();
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery("select s from product s where s.name = :name", Product.class);
        query.setParameter("name", name);
        List<Product> products = query.getResultList();
        return products;
    }
}
