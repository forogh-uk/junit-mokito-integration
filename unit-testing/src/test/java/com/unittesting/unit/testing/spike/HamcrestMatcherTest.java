package com.unittesting.unit.testing.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatcherTest {
    @Test
    public void learning(){
        List<Integer> number = Arrays.asList (12,15,45);
        assertThat(number,hasSize(3));
        assertThat (number,hasItems(12,45));
        assertThat (number,everyItem ((greaterThan (10))));
        assertThat (number,everyItem (lessThan (100)));
        assertThat ("" ,isEmptyString ());
        assertThat ("ABCD", containsString ("BCD"));
        assertThat ("ABCD",startsWith ("AB"));
        assertThat ("ABCD",endsWith ("CD"));
    }
}
