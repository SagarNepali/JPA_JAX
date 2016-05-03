/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dumbweb.jpajax.entity.da.impl;

import com.dumbweb.jpajax.entity.Department;
import com.dumbweb.jpajax.entity.dao.DepartmentDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

/**
 *
 * @author user
 */
public class DepartmentDAOImpl implements DepartmentDAO {

    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction trans = null;

    public DepartmentDAOImpl() {

        emf = Persistence.createEntityManagerFactory("JPA_JAXPU");
        em = emf.createEntityManager();
    }

    @Override
    public List<Department> getAll() {

        return em.createQuery("Select d from Department d").getResultList();
    }

    @Override
    public int insert(Department d) {

        trans = em.getTransaction();
        if (!trans.isActive()) {
            trans.begin();

        }
        em.persist(d);
        em.flush();
        trans.commit();

        return d.getDeptId();
    }

    @Override
    public Department getById(int id) {
        
        return em.find(Department.class, id);
    }

}
