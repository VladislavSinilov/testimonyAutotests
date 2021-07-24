package ru.vtb.neoflex.autotests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.dao.MySQLConnector;
import ru.neoflex.model.ResponseSaveTestimony;
import java.sql.ResultSet;
import java.sql.SQLException;


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
    public void checkResponseCodeSuccess() throws SQLException {


        String oldTestimonyURI = "http://localhost:8080/services/testimony/get/old/testimony/02-2020";
        String dateForTest = "02-2020";


        ResponseSaveTestimony responseSaveTestimony = RequestTestController.getResponseBodySave(oldTestimonyURI);
        String resultCode = responseSaveTestimony.getFaultcode().getResultCode() ;
        String resultText = responseSaveTestimony.getFaultcode().getResultText();
        System.out.println(resultCode);
        System.out.println(resultText);
        Assertions.assertEquals("0", resultCode);
        Assertions.assertEquals("success", resultText);

        ResultSet expectedResult = MySQLConnector.selectAllFromTestimony_History(dateForTest);
                while(expectedResult.next()) {
                    String date  = expectedResult.getString("currentmonth");
                    Assertions.assertEquals(date, dateForTest);

                }
    }
}
