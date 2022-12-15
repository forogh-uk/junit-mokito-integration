package com.unittesting.unit.testing.business;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {
    List<String> mock = mock (List.class);

    @Test
    public void sizeBasic(){
        when(mock.size ()).thenReturn (5);
        assertEquals(5,mock.size ());
    }

    @Test
    public void returnDifferentValue(){
        when (mock.size ()).thenReturn (5).thenReturn (10);
        assertEquals (5,mock.size ());
        assertEquals (10,mock.size ());
    }

    @Test
    public void returnWithParameters(){
        when (mock.get (0)).thenReturn ("in28min");
        assertEquals ("in28min",mock.get (0));
        assertEquals (null,mock.get (1));
    }

    //use any int to have the value of any numbers
    //argument matcher = anyInt,anyString .....
    @Test
    public void returnWithAnyParameters(){
        when (mock.get (anyInt())).thenReturn ("In28Mini");
        assertEquals ("In28Mini",mock.get (2));
        assertEquals ("In28Mini",mock.get (0));
    }

    //verification
    //how to verify the method calls the specific value on the mock
    @Test
    public void verificationBasic(){
        String value = mock.get (0);
        String value1 = mock.get (1);
        verify(mock).get(0);
        verify (mock,times (2)).get (anyInt ());
        //get called at least one time
        verify (mock, atLeast (1)).get (anyInt ());
        verify (mock,atMost (2)).get (anyInt ());
        //never get called
        verify (mock,never ()).get (2);


    }

    //how to capture an argument that is pass to the method call

    @Test
    public void argumentCapturing(){
        //assume that this code is being executed in SUT
        mock.add ("SomeString");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass (String.class);
        verify (mock).add (captor.capture ());
        assertEquals ("SomeString",captor.getValue ());

    }

    @Test
    public void multipleArgumentCapturing(){
        mock.add ("SomeString1");
        mock.add ("SomeString2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass (String.class);
        verify (mock,times (2)).add (captor.capture ());

        List<String> allValue = captor.getAllValues ();
        assertEquals ("SomeString1",allValue.get (0));
        assertEquals ("SomeString2",allValue.get (1));


    }
    //mock we have the defualt value

    @Test
    public void mockArray(){
        ArrayList arrayList = mock(ArrayList.class);
        System.out.println (arrayList.get (0)); //default is null, because we have nothing in location 0
        System.out.println (arrayList.size ()); //default is 0
        arrayList.add ("Test1");
        arrayList.add ("Test2");
        when (arrayList.size ()).thenReturn (5);
        System.out.println (arrayList.size ());//return 5

    }

    //spy using the real class
    //spy is like real world spy
    //you can stub(override)and verify specific behavior(methods) on spy
    //if we have no access to specific class to get data from it, but we want to check
    //what is going underneth that specific class
    //what methods are getting called and things like that we can create a spy
    @Test
    public void spyArray(){
        ArrayList arrayList = spy (ArrayList.class);
        arrayList.add ("We need value in location 0 to get(0)");
        System.out.println (arrayList.get (0));//we can see the value in location 0
        // if we have no value in location 0,
        // throw null point exception because we have nothing in get(0)
        System.out.println (arrayList.size ()); // size is 1
        arrayList.add ("Test1");
        arrayList.add ("Test2");
        System.out.println (arrayList.size ()); //value is 3
        when(arrayList.size ()).thenReturn (5); // override the value, it does not matter if we add value
       arrayList.add ("Test4");
        System.out.println (arrayList.size ());

        //we can verify if arrayList.add called with the value test4
        verify (arrayList).add ("Test4");
    }

}
