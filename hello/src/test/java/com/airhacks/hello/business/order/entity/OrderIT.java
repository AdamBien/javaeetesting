package com.airhacks.hello.business.order.entity;

import com.airhacks.rulz.em.EntityManagerProvider;
import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class OrderIT {

    @Rule
    public EntityManagerProvider provider = EntityManagerProvider.persistenceUnit("it");

    @Test
    public void verifyMappings() {
        this.provider.tx().begin();
        this.provider.em().merge(new Order("42"));
        this.provider.tx().commit();
    }

}
