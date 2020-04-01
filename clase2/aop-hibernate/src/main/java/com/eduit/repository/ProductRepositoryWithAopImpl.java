package com.eduit.repository;

import com.eduit.config.aop.PerformanceCheckAble;
import com.eduit.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryWithAopImpl implements ProductRepository {

    private SessionFactory sessionFactory;

    public ProductRepositoryWithAopImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT p FROM Product p";

    @Override
    @Transactional
    public List<Product> findAll() {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Product> query = session.createQuery(GET_ALL_PRODUCTS_QUERY, Product.class);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    @Transactional
    public Product findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    @Transactional
    @PerformanceCheckAble
    public void save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }
}
