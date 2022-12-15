package com.unittesting.unit.testing.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertExample {

    String actual =
            "{\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"id\":1}";

    @Test
    public void jsonassert_Strict_true() throws JSONException {
        String expect =  "{\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"id\":1}";
        JSONAssert.assertEquals (expect,actual,true);

    }

    @Test
    public void jsonassert_Strict_false() throws JSONException {
        String expect =  "{\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals (expect,actual,false);

    }

    @Test
    public void jsonassert_WithoutEscapeCharecters() throws JSONException {
        String expect =  "{name:Ball,price:10}";
        //we need to have / if we have space between value price 2: 12
        JSONAssert.assertEquals (expect,actual,false);

    }
}
