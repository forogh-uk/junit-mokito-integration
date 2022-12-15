package com.unittesting.unit.testing.controller;


import com.unittesting.unit.testing.business.ItemBusinessService;
import com.unittesting.unit.testing.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

   @Autowired
    private MockMvc mockMvc;


   //we have to use mock mvc to create a mock from business service and not access to data directly
    //then use when and return
   @MockBean
    ItemBusinessService itemBusinessService;

   @Test
    public void dummyItemBasic() throws Exception {

        //to execute request, we are using mock mvc to perform
        //before perform we have to tell what is the request contain, which url

        //call /dummy-item
        //which method ->get
        //what type -> json

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get ("/dummy-item")
                .accept (MediaType.APPLICATION_JSON);


       // to execute request, we are using mock mvc to perform

       MvcResult result = mockMvc.perform (requestBuilder)
               .andExpect (status().isOk ())
               .andExpect (content ().json ("{\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"id\":1}"))
               .andReturn ();

       //	go to .json method we can see:
       //	JSONAssert.assertEquals(expected, actual, strict);
       //strict is false that is mean if we have not one of the them like price but the value the same still pass
       //expected : "name":"Ball","price":10,"quantity":100,"id":1
       //actual is: String content = result.getResponse().getContentAsString(StandardCharsets.UTF_8);


    }
    @Test
    public void itemFromBusinessService() throws Exception {

       when(itemBusinessService.retreiveItem ()).thenReturn (
               new Item (2,"item2",10,10));

       RequestBuilder requestBuilder = MockMvcRequestBuilders
               .get ("/dummy-item-from-business")
               .accept (MediaType.APPLICATION_JSON);

       MvcResult mvcResult = mockMvc.perform (requestBuilder)
               .andExpect (status ().isOk ())
               .andExpect (content ().json ("{id:2,name:item2,price:10}"))
               .andReturn ();
    }

    @Test
    public void retrieveAllItems() throws Exception {
       when (itemBusinessService.retrieveAllItem ()).thenReturn (
               Arrays.asList (new Item (2,"item2",10,10),
                              new Item (3,"item3",20,20))
               );


       RequestBuilder requestBuilder = MockMvcRequestBuilders
               .get ("/find-items-from-database")
               .accept (MediaType.APPLICATION_JSON);

       MvcResult mvcResult = mockMvc.perform (requestBuilder)
               .andExpect (status ().isOk ())
               .andExpect (content ().json ("[{id:2,name:item2,price:10},{id:3,name:item3,price:20}]"))
               .andReturn ();

    }



}
