package com.airhacks.hello.business.order.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class OrderIT {

    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void initEM() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("it");
        this.em = emf.createEntityManager();
        this.tx = this.em.getTransaction();
    }

    @Test
    public void verifyMappings() {
        this.tx.begin();
        this.em.merge(new Order("42"));
        this.tx.commit();
    }

}
