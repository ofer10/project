import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class FinalProject {

 public WebDriver driver = null;// Empty driver

 @BeforeEach
 void intiallaizedSelenium() { // Conection to Edge brwoser
  System.setProperty("webdriver.edge.driver", "C:\\Users\\ofers\\OneDrive\\שולחן העבודה\\msedgedriver.exe");
  driver = new EdgeDriver();
  driver.manage().window().maximize();//Make the browser open the whole screen
 }

 //question no 1
 //Test for registration
 @Test
 void harshamaTest() throws InterruptedException {
  driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
  Thread.sleep(500);

  var firstName = driver.findElement(By.name("firstname"));
  Thread.sleep(500);
  firstName.sendKeys("Iris");
  Thread.sleep(500);

  var lastName = driver.findElement(By.name("lastname"));
  Thread.sleep(500);
  lastName.sendKeys("Pesach");
  Thread.sleep(500);

  var eMail = driver.findElement(By.id("input-email"));
  Thread.sleep(500);
  eMail.sendKeys("E@yahoo.com");
  Thread.sleep(500);

  var telUser = driver.findElement(By.name("telephone"));
  Thread.sleep(500);
  telUser.sendKeys("0509499991");
  Thread.sleep(500);

  var passWord = driver.findElement(By.id("input-password"));
  Thread.sleep(500);
  passWord.sendKeys("1234");
  Thread.sleep(500);

  var confirmPass = driver.findElement(By.id("input-confirm"));
  Thread.sleep(500);
  confirmPass.sendKeys("1234");
  Thread.sleep(500);

  var subScribeButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/label"));
  Thread.sleep(500);
  subScribeButton.click();
  Thread.sleep(500);

  var noButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[3]/div/div/label[2]/input"));
  Thread.sleep(500);
  noButton.click();
  Thread.sleep(500);

  var privecyButton = driver.findElement(By.name("agree"));
  Thread.sleep(500);
  privecyButton.click();
  Thread.sleep(500);

  var continueButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div/div/input[2]"));
  Thread.sleep(500);
  continueButton.click();
  Thread.sleep(500);
 }
 // Check the current url
  @Test
  void currentUrlTest() {
  Assertions.assertSame("http://tutorialsninja.com/demo/index.php?route=account/success", driver.getCurrentUrl());
 }


 //question no 2
//log in test
 @Test
 void logInTest() throws InterruptedException {
  driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
  Thread.sleep(500);

  var eMail = driver.findElement(By.id("input-email"));
  Thread.sleep(500);
  eMail.sendKeys("D@yahoo.com");
  Thread.sleep(500);

  var passWord = driver.findElement(By.id("input-password"));
  Thread.sleep(500);
  passWord.sendKeys("1234");
  Thread.sleep(500);

  var logIn = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input"));
  Thread.sleep(500);
  logIn.click();
  Thread.sleep(500);

  Assertions.assertEquals("http://tutorialsninja.com/demo/index.php?route=account/account", driver.getCurrentUrl());

 }


 //question no 3
//Add to cart test
 @Test
 void addToCartTest() throws InterruptedException {

  driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");
  Thread.sleep(500);
  var addButton = driver.findElement(By.id("button-cart"));
  addButton.click();
  Thread.sleep(500);
  driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=33");
  Thread.sleep(500);
  var addButton1 = driver.findElement(By.id("button-cart"));
  addButton1.click();
  Thread.sleep(500);


  // check the total amount
  var cartTotalButton = driver.findElement(By.id("cart-total"));
  cartTotalButton.click();
  Thread.sleep(500);
   var totalAmount = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/table/tbody/tr[4]"));
   Thread.sleep(500);
  Assertions.assertEquals(844,totalAmount );

 }

 //question no 4
//Opinion about the product
 @Test
 void customerOpinionTest() throws InterruptedException {

  driver.get("http://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");
  var reviewsButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/ul[2]/li[3]/a"));
  reviewsButton.click();
  Thread.sleep(500);

  var custumerName = driver.findElement(By.id("input-name"));
  custumerName.sendKeys("Iris");
  Thread.sleep(500);

  var textBox = driver.findElement(By.id("input-review"));

  for (int i = 0; i < 10; i++) {
   String opinion = ("excellent, very good,");
   textBox.sendKeys(opinion);
  }
   //String opinion = " excellent, very good,excellent, very good,excellent, very good,excellent, very good,excellent, very good,excellent, very good" +
   //  ",excellent, very good,excellent, very good,excellent, very good ";
 }
}



