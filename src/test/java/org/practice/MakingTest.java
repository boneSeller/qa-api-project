package org.practice;

import org.junit.Test;

public class MakingTest {
    @Test
    public void makeTwoCourierWithSameLogin() {
        Courier courier = Courier.getRandom();
        boolean isCourierCreated = CourierClient.createCourier(courier);
        boolean isAnotherCourierCreaterd = CourierClient.createCourier(courier);
    }
}
