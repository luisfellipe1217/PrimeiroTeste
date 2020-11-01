package com.example.tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class CT01ValidarLayoutTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    String pathDriver = "C:\\Selenium\\chromedriver.exe"; 

    @Before 
    public void setUp(){     
        //setup do googlechrome
        System.setProperty("webdriver.chrome.driver", pathDriver);
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void cT01ValidarLayout() {
        // Test name: CT01ValidarLayout
        // Step # | name | target | value
        // 2 | open | /contato | 
        driver.get("https://livros.inoveteste.com.br/contato");
        // 4 | assertText | css=.wpb_column:nth-child(1) h1 | Envie uma mensagem
        assertThat(driver.findElement(By.cssSelector(".wpb_column:nth-child(1) h1")).getText(), is("Envie uma mensagem"));
        // 5 | assertElementPresent | name=your-name | 
        {
            List<WebElement> elements = driver.findElements(By.name("your-name"));
            assert (elements.size() > 0);
        }
        // 6 | assertElementPresent | name=your-email | 
        {
            List<WebElement> elements = driver.findElements(By.name("your-email"));
            assert (elements.size() > 0);
        }
        // 7 | assertElementPresent | name=your-subject | 
        {
            List<WebElement> elements = driver.findElements(By.name("your-subject"));
            assert (elements.size() > 0);
        }
        // 8 | assertElementPresent | name=your-message | 
        {
            List<WebElement> elements = driver.findElements(By.name("your-message"));
            assert (elements.size() > 0);
        }
        // 9 | assertElementPresent | css=.wpcf7-submit | 
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".wpcf7-submit"));
            assert (elements.size() > 0);
        }
    }
}
