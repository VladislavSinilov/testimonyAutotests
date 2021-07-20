package ru.vtb.neoflex.autotests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import ru.neoflex.controllers.RequestTestController;
import ru.neoflex.model.Price;
import ru.neoflex.model.RequestChangePriceTestimony;

public class ChangePriceTest {

    @Test
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




}
