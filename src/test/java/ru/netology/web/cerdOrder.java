package ru.netology.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class cerdOrder {

 private WebDriver driver;

@BeforeAll
static void setUpAll(){
 if (System.getProperty("os.name").contains("Linux")) {
  System.setProperty("webdriver.chrome.driver", "linux/chromedriver");
 } else {
  System.setProperty("webdriver.chrome.driver", "win/chromedriver.exe");
 }
}
@BeforeEach
 void setUp2(){    // запускается перед каждым тестом
 driver= new ChromeDriver();
}

@AfterEach     // закрывает все окна браузера
 public void close(){
 driver.quit();
 driver=null;
}

@Test
  public void test(){
 driver.get("http://localhost:9999/");
 List<WebElement> elements= driver.findElements(By.className("input__control"));
 elements.get(0).sendKeys("Иван Иванов");
 elements.get(1).sendKeys("+79173456724");
 driver.findElement(By.className("checkbox__box")).click();
 driver.findElement(By.className("button__content")).click();
String text = driver.findElement (By.cssSelector("[data-test-id=\"order-success\"]")).getText();

 assertEquals ("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
}

}
