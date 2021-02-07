package com.elcentr.dao;

import com.elcentr.factory.impl.PostgresSessionFactory;
import com.elcentr.model.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class BaseDAO<T extends BaseEntity> {

    private Class<T> type;
    PostgresSessionFactory postgresSessionFactory = new PostgresSessionFactory();

    public BaseDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T findById(Integer id) {
        if (isNull(id)) {
            throw new RuntimeException("Search is failed!");
        }
        SessionFactory sessionFactory = postgresSessionFactory.getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T t = session.get(type, id);
        transaction.commit();
        session.close();
        return t;
    }


    public T save(T t) {
        if (nonNull(t.getId())) {
            throw new RuntimeException("Creation is failed!");
        }
        SessionFactory sessionFactory = postgresSessionFactory.getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(t);
        transaction.commit();
        t.setId(id);
        session.close();
        return t;
    }

    public T update(T t) {
        if (isNull(t.getId())) {
            throw new RuntimeException("Update is failed!");
        }
        SessionFactory sessionFactory = postgresSessionFactory.getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
        session.close();
        return t;
    }

    public void delete(T t) {
        if (isNull(t.getId())) {
            throw new RuntimeException("Delete is failed!");
        }
        SessionFactory sessionFactory = postgresSessionFactory.getHibernateSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(t);
        transaction.commit();
        session.close();
    }


}
