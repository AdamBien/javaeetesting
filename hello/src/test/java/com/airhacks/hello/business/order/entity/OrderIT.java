package com.airhacks.hello.business.order.entity;

import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class OrderIT {

    @Rule
    public EntityManagerProvider provider = EntityManagerProvider.withUnit("it");

    @Test
    public void verifyMappings() {
        this.provider.begin();
        this.provider.em().merge(new Order("42"));
        this.provider.commit();
    }

}
