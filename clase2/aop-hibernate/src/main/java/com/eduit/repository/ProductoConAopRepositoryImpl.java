package com.eduit.repository;

import com.eduit.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductoConAopRepositoryImpl implements ProductoRepository {

  @Autowired
  private SessionFactory sessionFactory;

  private static final String GET_ALL_PRODUCTS_QUERY = "SELECT p FROM Product p";

  @Override
  @Transactional
  public List<Product> findAll() {
    Session session = sessionFactory.getCurrentSession();
    TypedQuery<Product> query = session.createQuery(GET_ALL_PRODUCTS_QUERY, Product.class);
    return query.getResultList();
  }

  @Override
  @Transactional
  public Product findById(Long id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Product.class, id);
  }

  @Override
  @Transactional
  public void save(Product product) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(product);
  }
}
