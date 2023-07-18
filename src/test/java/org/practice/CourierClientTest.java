package org.practice;


import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourierClientTest {
    private int idCourier;

    @Test
    @DisplayName("Создание курьера")
    public void courierTest() {
        Courier courier = Courier.getRandom();

        boolean isCourierCreated = CourierClient.createCourier(courier);
        idCourier = CourierClient.loginCourier(CourierCrendentials.from(courier));

        assertTrue(isCourierCreated);
        assertNotNull(idCourier);
    }

    @After
    public void tearDown() {
        CourierClient.deleteCourier(idCourier);
    }
}
