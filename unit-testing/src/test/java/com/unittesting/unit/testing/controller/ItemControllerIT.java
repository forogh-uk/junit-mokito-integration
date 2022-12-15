package com.unittesting.unit.testing.controller;


import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

   @Autowired
    private TestRestTemplate restTemplate;
   @Test
   public void contextLoad() throws JSONException {
      String response= this.restTemplate.getForObject ("/find-items-from-database",String.class);
       JSONAssert.assertEquals ("[{id:10001},{id:10002},{id:10003}]",
               response,false);
   }
}
