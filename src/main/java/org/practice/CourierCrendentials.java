package org.practice;

public class CourierCrendentials {

    public final String login;
    public final String password;

    public CourierCrendentials(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public static CourierCrendentials from(Courier courier) {
        return new CourierCrendentials(courier.login, courier.password);
    }
}
