package com.airhacks.hello.business.order.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author airhacks.com
 */
public class EntityManagerProvider implements TestRule {

    private EntityManager em;
    private EntityTransaction tx;

    private EntityManagerProvider(String unitName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(unitName);
        this.em = emf.createEntityManager();
        this.tx = this.em.getTransaction();
    }

    public static EntityManagerProvider withUnit(String unitName) {
        return new EntityManagerProvider(unitName);
    }

    public EntityTransaction tx() {
        return this.tx;
    }

    public void begin() {
        this.tx.begin();
    }

    public void commit() {
        this.tx.commit();
    }

    public EntityManager em() {
        return this.em;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                base.evaluate();
                em.clear();
            }
        };
    }

}
