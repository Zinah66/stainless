import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TabelTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.webstaurantstore.com/");
        driver.manage().window().maximize();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchval']"));
        searchBox.sendKeys("stainless work table");
        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        searchButton.click();
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='ag ag-category-grid ag-wide box ']//a[@class='description  ossRelatedLinks']"));
        int count = 0;
        for (WebElement product : products) {
            count++;
            if (product.getText().contains("Table")) {
                String num = count == 1 ? " st" : count == 2 ? " nd" : count == 3 ? " rd" : " th";
                System.out.println("The " + count + "" + num + " Product is " + product.getText() + " \"CONTAIN TABLE\" ");
                driver.quit();
            } else {
                System.out.println("The " + count + " Product " + product.getText() + " Dos Not CONTAIN \"TABLE\" ");

                driver.quit();
            }

        }

        // Test Completed

    }
}
