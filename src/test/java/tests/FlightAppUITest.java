package tests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FlightAppUITest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://flights-app.pages.dev/");
    }

    @Test
    public void testSameFromToInput() {
        String inputText = "Paris"; // Test için kullanılacak şehir adı

        WebElement fromInput = driver.findElement(By.id("headlessui-combobox-input-:Rq9lla:"));
        fromInput.sendKeys(inputText);

        WebElement toInput = driver.findElement(By.id("headlessui-combobox-input-:Rqhlla:"));
        toInput.sendKeys(inputText);

        String fromValue = fromInput.getAttribute("value");
        String toValue = toInput.getAttribute("value");

        Assert.assertNotEquals("Error: From and To can not be same values.", fromValue, toValue);

    }

    @Test
    public void testFlightListCount() {
        // Set city options
        String fromCity = "Istanbul";
        String toCity = "Los Angeles";

        // "From" ve "To" input alanlarına seçenekleri gir
        WebElement fromInput = driver.findElement(By.xpath("//input[@id='headlessui-combobox-input-:Rq9lla:']"));
        fromInput.sendKeys(fromCity);

        WebElement toInput = driver.findElement(By.xpath("//input[@id='headlessui-combobox-input-:Rqhlla:']"));
        toInput.sendKeys(toCity);


        int expectedFlightCount = 2; // Test fails at other(false) numbers


        List<WebElement> flightListItems = driver.findElements(By.tagName("li"));

        // Uçuş sayısını al
        int actualFlightCount = flightListItems.size();

        // Karşılaştırma yap
        Assert.assertEquals("Flight count does not match the expected count.", expectedFlightCount, actualFlightCount);

    }

 }
