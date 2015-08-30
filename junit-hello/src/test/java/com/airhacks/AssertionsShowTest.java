package com.airhacks;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import org.hamcrest.CustomMatcher;
import org.hamcrest.Matcher;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class AssertionsShowTest {

    private List<String> stringList;

    @Before
    public void init() {
        this.stringList = Arrays.asList("java", "javaee", "joker");

    }

    @Test
    public void lists() {
        assertThat(stringList, hasItem("java"));
        assertThat(stringList, hasItem("javaee"));
        assertThat(stringList, hasItems("javaee", "joker"));
        assertThat(stringList, everyItem(containsString("j")));
    }

    @Test
    public void combinableMathers() {
        assertThat(stringList, both(hasItem("java")).and(hasItem("javaee")));
        assertThat(stringList, either(hasItem("java")).or(hasItem("javascript")));
        assertThat(stringList, anyOf(hasItem("javascript"), hasItem("javaee")));
        assertThat(stringList, allOf(hasItem("java"), not(hasItem("erlang"))));
    }

    @Test
    public void customMatcher() {
        Matcher<String> containsJ = new CustomMatcher<String>("contains j") {

            @Override
            public boolean matches(Object item) {
                if (!(item instanceof String)) {
                    return false;
                }
                String content = (String) item;
                return content.contains("j");
            }
        };

        assertThat("java", containsJ);
    }

}
