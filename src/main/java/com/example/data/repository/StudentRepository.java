package com.example.data.repository;

import com.example.data.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentRepository {
    private static EntityManager entityManager;
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory =  new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> findAll() {
        //HQL truy vấn CSDL dựa theo tên model tạo bảng trước đó
        String query = "select s from Student s";
        TypedQuery<Student> typedQuery =
                entityManager.createQuery(query, Student.class);
        return typedQuery.getResultList();
    }

    public Student findById(Long id) {
        String query = "select s from Student s where s.id = :id";
        TypedQuery<Student> typedQuery =
                entityManager.createQuery(query, Student.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }
}
