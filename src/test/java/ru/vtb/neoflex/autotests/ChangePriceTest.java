package ru.vtb.neoflex.autotests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.dao.MySQLConnector;
import ru.neoflex.model.Price;
import ru.neoflex.model.RequestChangePriceTestimony;
import ru.neoflex.model.ResponseChangePriceTestimony;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import static ru.vtb.neoflex.autotests.TestBase.validRequestChangePriceTestimony;


public class ChangePriceTest {

    static String changePriceURI = "http://localhost:8080/services/testimony/changePrice";

    public static Iterator<Object[]> dataRead() throws IOException {
        String requestFile = "src/test/resources/ChangePriceTest";
        return validRequestChangePriceTestimony(requestFile);
    }

    @MethodSource("dataRead")
    @ParameterizedTest
    public void checkCodeSuccessTest(RequestChangePriceTestimony requestChangePriceTestimony) {
        int actualStatusCode = RequestTestController.getRequestCode(changePriceURI, requestChangePriceTestimony );
        Assertions.assertEquals(200, actualStatusCode);
        System.out.println("Status code is : " + actualStatusCode);
    }

   /* @Test
    public void checkStatus200() {

        String changePriceURI = "http://localhost:8080/services/testimony/changePrice";

        RequestChangePriceTestimony requestChangePriceTestimony = new RequestChangePriceTestimony();
        Price price = new Price();

        price.setPriceHotWater(20);
        price.setPriceGas(30);
        price.setPriceElectricity(50);
        price.setPriceColdWater(20);

        requestChangePriceTestimony.setPrice(price);

        int statusCode = RequestTestController.getRequestCode(changePriceURI, requestChangePriceTestimony);

        Assertions.assertEquals(200, statusCode);
        System.out.println("codeStatus is :" + statusCode);
        System.out.println("");

    }

    @Test
    public void checkStatus404() {

        String changePriceURI = "http://localhost:8080/services/testimony/";

        RequestChangePriceTestimony requestChangePriceTestimony = new RequestChangePriceTestimony();
        Price price = new Price();

        price.setPriceHotWater(50);
        price.setPriceGas(30);
        price.setPriceElectricity(50);
        price.setPriceColdWater(20);

        requestChangePriceTestimony.setPrice(price);

        int statusCode = RequestTestController.getRequestCode(changePriceURI, requestChangePriceTestimony);

        Assertions.assertEquals(404, statusCode);
        System.out.println("codeStatus is :" + statusCode);

    }

    @Test
    public void checkResponseCodeSuccess() throws SQLException {

        String changePriceURI = "http://localhost:8080/services/testimony/changePrice";

        RequestChangePriceTestimony requestChangePriceTestimony = new RequestChangePriceTestimony();
        Price price = new Price();

        price.setPriceHotWater(30);
        price.setPriceGas(30);
        price.setPriceElectricity(30);
        price.setPriceColdWater(30);

        requestChangePriceTestimony.setPrice(price);

        ResponseChangePriceTestimony responseChangePriceTestimony = RequestTestController.getResponseBodySave(changePriceURI, requestChangePriceTestimony);
        String resultCode = responseChangePriceTestimony.getResultCode();
        String resultText = responseChangePriceTestimony.getResultText();
        System.out.println(resultCode);
        System.out.println(resultText);
        Assertions.assertEquals("0", resultCode);
        Assertions.assertEquals("success", resultText);

        ResultSet expectedResultSet = MySQLConnector.selectAllFromPriceGuide(requestChangePriceTestimony.getPrice().getPriceGas());
            while(expectedResultSet.next()) {
                double priceColdWater = expectedResultSet.getInt("priceColdWater");
                double priceHotWater = expectedResultSet.getInt("priceHotWater");
                double priceGas = expectedResultSet.getInt("priceGas");
                double priceElectricity = expectedResultSet.getInt("priceElectricity");

                Assertions.assertEquals(priceColdWater,requestChangePriceTestimony.getPrice().getPriceColdWater());
                Assertions.assertEquals(priceHotWater,requestChangePriceTestimony.getPrice().getPriceHotWater());
                Assertions.assertEquals(priceGas,requestChangePriceTestimony.getPrice().getPriceGas());
                Assertions.assertEquals(priceElectricity,requestChangePriceTestimony.getPrice().getPriceElectricity());
            }

    } */


}
