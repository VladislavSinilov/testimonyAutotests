package ru.vtb.neoflex.autotests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.neoflex.controllers.RequestTestController;


public class OldTestimonyTest {



    @Test
    public void checkStatus200() {


        String oldTestimonyURI = "http://localhost:8080/services/testimony/get/old/testimony/02-2020";


        int statusCode = RequestTestController.getRequestCode(oldTestimonyURI);

        Assertions.assertEquals(200, statusCode);
        System.out.println("codeStatus is :" + statusCode);
        System.out.println("");

    }

    @Test
    public void checkStatus404() {

        String oldTestimonyURI = "http://localhost:8080/services/testimony/get/old/testimony/";

        int statusCode = RequestTestController.getRequestCode(oldTestimonyURI);

        Assertions.assertEquals(404, statusCode);
        System.out.println("codeStatus is :" + statusCode);
        System.out.println("");

    }

    @Test
    public void checkStatus405() {

        String oldTestimonyURI = "http://localhost:8080/services/testimony/get/old/testimony/50-2020";

        int statusCode = RequestTestController.getRequestCode(oldTestimonyURI);

        Assertions.assertEquals(405, statusCode);
        System.out.println("codeStatus is :" + statusCode);

    }
}
