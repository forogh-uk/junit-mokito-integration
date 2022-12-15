package com.unittesting.unit.testing.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;



public class JsonPathTest {

    @Test
    public void learning(){
        String responseFromService = "[" +
                "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100},"+
                "{\"id\":2,\"name\":\"pen\",\"price\":10,\"quantity\":10}," +
                "{\"id\":3,\"name\":\"pencil\",\"price\":10,\"quantity\":100}" +

                "]";

        DocumentContext context = JsonPath.parse (responseFromService);
        //$ is root
        int length = context.read ("$.length()");
        assertThat(length).isEqualTo (3);
        List<Integer> ids = context.read ("$..id");
      assertThat (ids).containsExactly(1,2,3);
        System.out.println (ids.toString ());
        //get the second element which is pen
        System.out.println ("get the second element: " + context.read ("$.[1]").toString ());
        //get 1 and 2 elements
        System.out.println ("get the first and second elements " +
                context.read ("$.[0:1]").toString ());
        System.out.println ("get the one of the element " +
                context.read ("$.[?(@.id==1)]").toString ());

    }


}
