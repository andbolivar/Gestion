package org.example;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;

public class RestAssured1 {

    final static String url="http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1";

    public static void main(String args[]) {

        getResponseNoLogin();
        getResponseLogin();
        getResponseTime();
    }
    public static void getResponseNoLogin() {
        System.out.println("Prueba sin Usuario/contraseña");
        given().queryParam("Account_No", "1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
        System.out.println("");
        System.out.println("");
        System.out.println("");


    }

    public static void getResponseLogin() {

        given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    public static void getResponseTime(){
        System.out.println("The time taken to fetch the response "+get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }

    @Test
    public void getResponseCuenta1() {

        given().queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log().body();
    }

    @Test
    public void getResponse200(){
        get(url).then().assertThat().statusCode(200);
    }
}
