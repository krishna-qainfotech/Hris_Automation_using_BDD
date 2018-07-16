package StepDefination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import junit.framework.Assert;

public class StepDefination {
	WebDriver driver;
	//System.setProperty("webdriver.chrome.driver", "/home/qainfotech/chromedriver");
	//driver = new ChromeDriver();

@Given("^Hris Login Page$")
public void hris_Login_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	//System.setProperty("webdriver.chrome.driver", "/home/qainfotech/chromedriver");
	String dir = System.getProperty("user.dir");
	  System.out.println(System.getProperty("user.dir"));
	  String chromedriver= "chromedriver";
	  System.setProperty("webdriver.chrome.driver", dir+"///"+chromedriver);
	driver = new ChromeDriver();
	driver.get("https://hris.qainfotech.com/login.php");
}

@When("^user name and password is Entered$")
public void user_name_and_password_is_Entered() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(By.id("txtUserName")).clear();
    driver.findElement(By.id("txtUserName")).sendKeys("Krishnachauhan");
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("Krishna@321#");
    
}

@Then("^click on Login Button$")
public void click_on_Login_Button() throws Throwable {
	driver.findElement(By.id("txtPassword")).submit();
}

@Then("^check on timesheet page by title$")
public void check_on_timesheet_page_by_title() throws Throwable {
    Assert.assertTrue(driver.getCurrentUrl().equals("https://hris.qainfotech.com:8086/time/timesheet"));
}

@Then("^Get detail of Employee in Text file$")
public void get_detail_of_Employee_in_Text_file() throws Throwable {
  String name = driver.findElement(By.cssSelector("#drawerDiv > user-profile-sidebar > div > div.pro-dtl-brief > div > ul.list-unstyled.pro-details-left.marginTop15 > li:nth-child(2) > span.pro-dtl-val.ng-scope > a")).getText();
  System.out.println("name : "+name);
  String id = driver.findElement(By.cssSelector("#drawerDiv > user-profile-sidebar > div > div.pro-dtl-brief > div > ul.list-unstyled.pro-details-left.marginTop15 > li:nth-child(3) > span.pro-dtl-val.ng-binding")).getText();
  System.out.println("id : "+id);
  String designation = driver.findElement(By.cssSelector("#drawerDiv > user-profile-sidebar > div > div.pro-dtl-brief > div > ul.list-unstyled.pro-details-left.marginTop15 > li:nth-child(4) > span.pro-dtl-val.ng-binding")).getText();
  System.out.println("D\"#menu1 > ul > li.treeview.active > ul > li:nth-child(1) > a\"esignation : "+designation);
  String supervisor = driver.findElement(By.cssSelector("#drawerDiv > user-profile-sidebar > div > div.pro-dtl-brief > div > ul.list-unstyled.pro-details-left.marginTop15 > li:nth-child(6) > span.pro-dtl-val > a")).getText();
  System.out.println("SuperVisor : "+supervisor);
  String email = driver.findElement(By.cssSelector("#drawerDiv > user-profile-sidebar > div > div.pro-dtl-brief > div > ul.list-unstyled.pro-details-left.marginTop45 > li:nth-child(2) > span.pro-dtl-val.email-id.word-break.ng-binding")).getText();
  System.out.println("Email : "+email);
  String PhoneNo = driver.findElement(By.cssSelector("#drawerDiv > user-profile-sidebar > div > div.pro-dtl-brief > div > ul.list-unstyled.pro-details-left.marginTop45 > li:nth-child(3) > span.pro-dtl-val.ng-binding.ng-scope")).getText();
  System.out.println("Phone No : "+PhoneNo);
  String SkypeId = driver.findElement(By.cssSelector("#drawerDiv > user-profile-sidebar > div > div.pro-dtl-brief > div > ul.list-unstyled.pro-details-left.marginTop45 > li:nth-child(4) > span.pro-dtl-val.ng-binding.ng-scope")).getText();
  System.out.println("Skype Id : "+SkypeId);
  //File file = new File()
  String dir = System.getProperty("user.dir");
  System.out.println("it is the path of the file in current dir : "+System.getProperty("user.dir"));
  System.out.println("File name in the current dir is : EmployeeDetail.txt");
  File file = new File(dir+"///"+"EmployeeDetail.txt");
  file.createNewFile();
  FileWriter fr = null;
  try {
      fr = new FileWriter(file);
      BufferedWriter brwriter = new BufferedWriter(fr);
      brwriter.write("name : "+name+"		");
      brwriter.write("id : "+id+"		");
      brwriter.write("Designation : "+designation+"		");
      brwriter.write("SuperVisor : "+supervisor+"		");
      brwriter.write("Email : "+email+"       ");
      brwriter.write("Phone No : "+PhoneNo+"      ");
      brwriter.write("Skype Id : "+SkypeId+"      ");
      brwriter.close();
      fr.close();
  } catch (IOException e) {
      e.printStackTrace();
  }
  
}

@Then("^Mail the Detail of the Text file$")
public void Mail_the_Detail_of_the_Text_file() throws Throwable {
  
driver.get("http://webmail.qainfotech.com");
driver.findElement(By.id("username")).clear();
driver.findElement(By.id("username")).sendKeys("Krishnachauhan");
driver.findElement(By.id("password")).clear();
driver.findElement(By.id("password")).sendKeys("Krishna@123#");;
driver.findElement(By.id("password")).submit();
Thread.sleep(1000);

driver.findElement(By.cssSelector("#zb__NEW_MENU_title")).click();
Thread.sleep(3000);
driver.findElement(By.cssSelector("input[class='addrInputField user_font_system']")).sendKeys("udaykumar@qainfotech.com");
driver.findElement(By.id("zv__COMPOSE-1_subject_control")).sendKeys("My code should be on git");
driver.switchTo().frame("ZmHtmlEditor1_body_ifr");
System.out.println("krsihna");
String dir = System.getProperty("user.dir");
System.out.println("it is the path of the file in current dir : "+System.getProperty("user.dir"));
System.out.println("File name in the current dir is : EmployeeDetail.txt");

File file = new File(dir+"///"+"EmployeeDetail.txt");
BufferedReader br = new BufferedReader(new FileReader(file));
String st,str = "";
while ((st = br.readLine()) != null)
  str = str + st; 

driver.findElement(By.cssSelector("#tinymce")).sendKeys(str);
driver.switchTo().defaultContent();
driver.findElement(By.cssSelector("#zb__COMPOSE-2__SEND_left_icon")).click();
}

@Then("^click on backlog create task$")
public void click_on_backlog_create_task() throws Throwable {
   }



}
