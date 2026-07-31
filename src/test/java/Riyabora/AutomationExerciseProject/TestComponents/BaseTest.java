package Riyabora.AutomationExerciseProject.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Riyabora.AutomationExerciseProject.UserFlows.User;
import Riyabora.AutomationExerciseProject.pageobjects.HomePage;
import Riyabora.AutomationExerciseProject.pageobjects.LoginSignupPage;
import Riyabora.AutomationExerciseProject.pageobjects.SignUpInfoPage;
import Riyabora.AutomationExerciseProject.pageobjects.SignupAccountCreatedPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	 public HomePage homePage;

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Riyabora\\AutomationExerciseProject\\resource\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		  ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//firefox
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else if(browserName.equalsIgnoreCase("edge")) {
	//Edge
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}else {
	    throw new RuntimeException("Invalid browser name");
	}
		driver.manage().window().maximize();
		return driver;
	}

	public void goTo() {
		driver.get("https://automationexercise.com");
	}

	@BeforeMethod(alwaysRun = true)
	public HomePage homePageApplication() throws IOException {
		driver = initializeDriver();
		goTo();
		homePage = new HomePage(driver);
		return homePage;

	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();

	}
	public User registerUser() {

	    String email = "riya" + System.currentTimeMillis() + "@gmail.com";
	    String password = "riya123";
	    String userName = "RIYA";

	    String firstName = "Riya";
	    String lastName = "Bora";
	    String company = "Redhu Tech";
	    String address1 = "A-301";
	    String address2 = "Omicron Society";
	    String state = "UP";
	    String city = "Greater Noida";
	    String zipCode = "201310";
	    String mobile = "9837567192";

	    LoginSignupPage loginSignupPage = homePage.verifyhomepage().clicksignin_login();

	    loginSignupPage.verifysigninpage();
	    loginSignupPage.enterSignupDetails(userName, email);

	    SignUpInfoPage signUpInfoPage = loginSignupPage.clickSignup();

	    signUpInfoPage.verifysignupInfoPage();

	    SignupAccountCreatedPage accountCreatedPage =
	            signUpInfoPage.fillAccountInformation(
	                    password,
	                    firstName,
	                    lastName,
	                    company,
	                    address1,
	                    address2,
	                    state,
	                    city,
	                    zipCode,
	                    mobile);

	    accountCreatedPage.verifyAccountCreated();

	    homePage = accountCreatedPage.clickcontinuebtn();

	    return new User(email, password);
	}
	public String getScreensshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
	    File file =new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source,file);
		return  System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png";
	}
	
}
