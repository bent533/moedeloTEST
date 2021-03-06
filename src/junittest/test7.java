/*
 * 7. Ввeсти некорректный логин и некорректный пароль.
 */
package junittest;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.junit.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;



public class test7 {
     private static ChromeDriverService service;
     public static WebDriver driver;
     private String baseUrl;
     
     @BeforeClass
     public static void createAndStartService() throws IOException {
         service = new ChromeDriverService.Builder()
            .usingDriverExecutable(new File("D://тестирование/chromedriver.exe"))
            .usingAnyFreePort()
            .build();
         service.start();
     }
 
     @Before
     public void setUp(){
    	 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    	 ChromeOptions options = new ChromeOptions();
    	 options.addArguments("--test-type");
    	 capabilities.setCapability("chrome.binary","D://тестирование/chromedriver.exe");
    	 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    	 driver = new ChromeDriver(service, capabilities);
    	 baseUrl = "http://www.moedelo.org/";
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }
 
     @Test
     public void simpleTest7() {    
    	 driver.get(baseUrl + "/Default/Auth");
    	 driver.findElement(By.id("signinEmail")).clear();
    	 driver.findElement(By.id("signinEmail")).sendKeys("bent755@gmail.com");
    	 driver.findElement(By.id("signinPassword")).clear();
    	 driver.findElement(By.id("signinPassword")).sendKeys("qwerty12345");
    	 driver.findElement(By.xpath("//input[@value='Войти в сервис']")).click();
    	 driver.get(baseUrl + "/Default/Auth");
     }
 
     @After
     public void tearDown(){
         driver.quit();
     }
 
     @AfterClass
     public static void createAndStopService() {
         service.stop();
     }

}
