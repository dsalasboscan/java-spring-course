/*
package com.eduit.repository;

import com.eduit.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryWithoutAopImpl implements ProductRepository {

    private SessionFactory sessionFactory;

    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT p FROM Product p";

    @Autowired
    public ProductRepositoryWithoutAopImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            TypedQuery<Product> query = session.createQuery(GET_ALL_PRODUCTS_QUERY, Product.class);
            products.addAll(query.getResultList());

            if (transaction != null) {
                transaction.commit();
            }

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return products;
    }

    @Override
    public Product findById(Long id) {
        Product product = null;
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.getTransaction();

            product = session.get(Product.class, id);

            if (transaction != null) {
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return product;
    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.persist(product);

            if (transaction != null) {
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }
}
*/
