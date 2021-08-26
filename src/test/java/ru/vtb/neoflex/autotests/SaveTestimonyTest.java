package ru.vtb.neoflex.autotests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.dao.MySQLConnector;
import ru.neoflex.model.CurrentTestimony;
import ru.neoflex.model.RequestSaveTestimony;
import ru.neoflex.model.ResponseSaveTestimony;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import static ru.vtb.neoflex.autotests.TestBase.validRequest;

public class SaveTestimonyTest {

    static String saveTestimonyURI = "http://localhost:8080/services/testimony/save";

    public static Iterator<Object[]> dataRead() throws IOException {
        String requestFile = "src/test/resources/SaveTestimonyTest";
        return validRequest(requestFile);
    }

    @MethodSource("dataRead")
    @ParameterizedTest
    public void checkCodeSuccessTest(RequestSaveTestimony requestSaveTestimony) {
        int actualStatusCode = RequestTestController.getRequestCode(saveTestimonyURI, requestSaveTestimony);
        Assertions.assertEquals(200, actualStatusCode);
        System.out.println("Status code is : " + actualStatusCode);
    }


  /*  @Test
    public void checkCodeSuccessTest() {

        String saveTestimonyURI = "http://localhost:8080/services/testimony/save";

        RequestSaveTestimony requestSaveTestimony = new RequestSaveTestimony();
        CurrentTestimony currentTestimony = new CurrentTestimony();

        requestSaveTestimony.setDate("02-2020");
        currentTestimony.setColdWater(30);
        currentTestimony.setHotWater(40);
        currentTestimony.setGas(50);
        currentTestimony.setElectricity(60);
        requestSaveTestimony.setCurrentTestimony(currentTestimony);

        int actualStatusCode = RequestTestController.getRequestCode(saveTestimonyURI, requestSaveTestimony);

        Assertions.assertEquals(200,actualStatusCode);
        System.out.println("StatusCode is  : " + actualStatusCode);
    }

    @Test
    public void checkFaultCodeSuccessTest() throws SQLException {
        String saveTestimonyURI = "http://localhost:8080/services/testimony/save";
        RequestSaveTestimony requestSaveTestimony = new RequestSaveTestimony();
        CurrentTestimony currentTestimony = new CurrentTestimony();

        requestSaveTestimony.setDate("02-2020");
        currentTestimony.setColdWater(30);
        currentTestimony.setHotWater(40);
        currentTestimony.setGas(50);
        currentTestimony.setElectricity(60);
        requestSaveTestimony.setCurrentTestimony(currentTestimony);

        ResponseSaveTestimony responseSaveTestimony = RequestTestController.getResponseBodySave(saveTestimonyURI, requestSaveTestimony);
        String resultCode = responseSaveTestimony.getFaultcode().getResultCode();
        String resultText = responseSaveTestimony.getFaultcode().getResultText();
        System.out.println(resultCode);
        System.out.println(resultText);
        Assertions.assertEquals("0", resultCode);
        Assertions.assertEquals("success", resultText);


        ResultSet expectedResultSet = MySQLConnector.selectAllFromBilling(requestSaveTestimony.getDate());
        while(expectedResultSet.next()) {

            String date = expectedResultSet.getString("currentmonth");
            double coldWater = expectedResultSet.getInt("coldWater");
            double hotWater = expectedResultSet.getInt("hotWater");
            double gas = expectedResultSet.getInt("gas");
            double electricity = expectedResultSet.getInt("electricity");

            Assertions.assertEquals(date, requestSaveTestimony.getDate());
            Assertions.assertEquals(coldWater, requestSaveTestimony.getCurrentTestimony().getColdWater());
            Assertions.assertEquals(hotWater, requestSaveTestimony.getCurrentTestimony().getHotWater());
            Assertions.assertEquals(gas, requestSaveTestimony.getCurrentTestimony().getGas());
            Assertions.assertEquals(electricity, requestSaveTestimony.getCurrentTestimony().getElectricity());

        }

    } */
}
