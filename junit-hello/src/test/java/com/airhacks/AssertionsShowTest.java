package com.airhacks;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class AssertionsShowTest {

    @Test
    public void lists() {
        List<String> stringList = Arrays.asList("java", "javaee", "joker");
        assertThat(stringList, hasItem("java"));
        assertThat(stringList, hasItem("javaee"));
        assertThat(stringList, hasItems("javaee", "joker"));
        assertThat(stringList, everyItem(containsString("j")));
    }

}
