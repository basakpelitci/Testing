package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class BackendTest {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        String apiUrl = "https://flights-api.buraky.workers.dev/";

        driver.get("https://flights-api.buraky.workers.dev/");

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int statusCode = connection.getResponseCode();

        System.out.println("URL: " + apiUrl);

        System.out.println("Status Code: " + statusCode);

        String contentType = connection.getHeaderField("Content-Type");
        if (contentType != null && contentType.equals("application/json")) {
            System.out.println("Content-Type: application/json");
        } else {
            System.out.println("Content-Type is not application/json");
        }

        System.out.println("--------------------------------------");
        System.out.println("Response content:   "+ driver.getPageSource());

    }
}
