package com.baseclasstenstng;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class BaseClassTestNG {
	
public static WebDriver driver;
	
	//Takescreenshot with report for each testcase
	public static ExtentReports extentReports;

	public static File file;

	
	
	
	
//	 // Reset //art
//    public static final String RESET = "\033[0m";  // Text Reset
//
//    // Regular Colors
//    public static final String BLACK = "\033[0;30m";   // BLACK
//    public static final String RED = "\033[0;31m";     // RED
//    public static final String GREEN = "\033[0;32m";   // GREEN
//    public static final String YELLOW = "\033[0;33m";  // YELLOW
//    public static final String BLUE = "\033[0;34m";    // BLUE
//    public static final String PURPLE = "\033[0;35m";  // PURPLE
//    public static final String CYAN = "\033[0;36m";    // CYAN
//    public static final String WHITE = "\033[0;37m";   // WHITE
//
//    // Bold
//    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
//    public static final String RED_BOLD = "\033[1;31m";    // RED
//    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
//    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
//    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
//    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
//    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
//    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
//
//    // Underline
//    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
//    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
//    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
//    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
//    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
//    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
//    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
//    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
//
//    // Background
//    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
//    public static final String RED_BACKGROUND = "\033[41m";    // RED
//    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
//    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
//    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
//    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
//    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
//    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
//
//    // High Intensity
//    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
//    public static final String RED_BRIGHT = "\033[0;91m";    // RED
//    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
//    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
//    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
//    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
//    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
//    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE
//
//    // Bold High Intensity
//    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
//    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
//    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
//    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
//    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
//    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
//    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
//    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
//
//    // High Intensity backgrounds
//    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
//    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
//    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
//    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
//    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
//    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
//    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
//    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

	static String Reset = "\u001b[0m";
	static String BrightWhit = "\u001b[37;1m";
	static String BackgroundBrightBlack = "\u001b[40;1m";
	static String Blue = "\u001b[34m";
	
	
	

	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}

			else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}

			else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}

		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING BROWSER LAUNCH");
		}
		driver.manage().window().maximize();
		return driver;

	}

	protected static WebDriver launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING LAUNCH URL");
		}
		return driver;
	}

	protected static String getText(WebElement driver) {
		try {
			return driver.getText();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING LAUNCH URL");
		}
		return null;
	}

	protected static String getTitle() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING LAUNCH URL");
		}
		return null;
	}

	protected static String getCurrentUrl() {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING LAUNCH URL");
		}
		return null;
	}

	protected static void navigatePage(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING NAVIGATE PAGE");
		}
	}

	protected static void navigateBackPage() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING NAVIGATE BACK PAGE");
		}
	}

	protected static void navigateForwardPage() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING NAVIGATE BACK PAGE");
		}
	}

	protected static void navigateRefresh() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING NAVIGATE REFRESH");
		}
	}

	protected static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING ELEMENT CLICK");
		}
	}

	protected static void passInput(WebElement element, String input) {
		try {
			element.sendKeys(input);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING PASSING INPUT");
		}
	}

	protected static Select dropDownObject(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	protected static void selectByVisibleText(WebElement element4, String text) {
		try {
			dropDownObject(element4).selectByVisibleText(text);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING SELECT BY VISIBLE TEXT");
		}
	}

	protected static void selectByIndex(WebElement element5, int num) {
		try {
			dropDownObject(element5).selectByIndex(num);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING SELECT BY INDEX");
		}
	}

//	public static void selectDropDownOption(WebElement element, String option, String value) {
//
//		Select s = new Select(element);
//
//		if (option.equalsIgnoreCase("value")) {
//			s.selectByValue(value);
//		} else if (option.equalsIgnoreCase("visibletext")) {
//			s.selectByVisibleText(value);
//		} else if (option.equalsIgnoreCase("index")) {
//			s.selectByIndex(Integer.parseInt(value));
//		}
//
//	}

	protected static String windowsHandles(int num) {
		try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING WINDOWS HANDLES");
		}
		return null;
	}

	protected static void scrollDown(int x, int y) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scroll(" + x + ", " + y + ")");
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING WINDOWS HANDLES");
		}
	}

//dynamic screenshot
	protected static void takeScreenshot(String fileName) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File Source = screenshot.getScreenshotAs(OutputType.FILE);

		File Destination = new File(
				"C:\\Users\\Jana\\eclipse-workspace\\MavenProject\\Screenshot\\ " + fileName + ".png");

		try {
			FileHandler.copy(Source, Destination);
		} catch (IOException e) {
			Assert.fail("ERROR : OCCURED DURING TAKESCREENSHOT");

		}
	}

	// static screenshot
//	protected static void takeScreenshot(String valueby_png) throws Exception {
//		TakesScreenshot screenshot = (TakesScreenshot)driver;
//		File srcFile =  screenshot.getScreenshotAs(OutputType.FILE);
//
//		File destFile = new File(valueby_png);
//		try {
//			//			FileHandler.copy(srcFile , destFile);
//			FileUtils.copyFile(srcFile , destFile);
//		} catch (IOException e) {
//			Assert.fail("ERROR ; OCCUR DURING TAKING SCREENSHOT AND SAVING IT");
//		}
//	}
	
	//takescreenShoot with report --->ExtentReport_Test,ITestListener--->pageobjectmodel(OpenMRSLoginPage)
	public static void extentReportStart(String location) {
		extentReports = new ExtentReports();
		file = new File(location);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
	}

	public static void extentReportTearDown(String location) throws IOException {
		extentReports.flush();
		file = new File(location);
		Desktop.getDesktop().browse((file).toURI());
	}

	public String takeScreenshot() throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("Screenshort\\.png" + "_" + timeStamp + ".png");
		FileUtils.copyFile(scrfile, destfile);
		return destfile.getAbsolutePath();
	}
//Static File Upload
	
//	protected static void fileUpload() throws InterruptedException, AWTException {
//		try {
////			WebDriver driver = new ChromeDriver();
//			//driver.get("https://demo.openmrs.org/openmrs/attachments/attachments.page?patient=0b26bf11-89a9-4e1a-bfb7-d9d018bbb8ba&patientId=550&visit=70b36dc3-03f1-4495-be64-3d37baee6a35&returnUrl=%2Fopenmrs%2Fcoreapps%2Fpatientdashboard%2FpatientDashboard.page%3FpatientId%3D550%26%26visitId%3D2390");
//			driver.findElement(By.xpath("//div[text()='Click or drop a file here.']")).click();
//			Robot r = new Robot();// copy the file //Keyboardevents
//			r.delay(2000);
//			StringSelection ss = new StringSelection("D:\\IPT Premium\\Amazon_RTM.xlsx");
//			//StringSelection ss = new StringSelection("C:\\Users\\Jana\\OneDrive\\Pictures\\Screenshots\\Screenshot");
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//			r.keyPress(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_V); // paste
//			r.keyRelease(KeyEvent.VK_CONTROL);
//			r.keyRelease(KeyEvent.VK_V);
//			r.keyPress(KeyEvent.VK_ENTER);
//			r.keyRelease(KeyEvent.VK_V);
//		} catch (Exception e) {
//			Assert.fail("ERROR ; OCCUR DURING FILEUPLOAD");
//		}
//	}
	
	//Dynamic File Upload

	    // This method takes WebDriver, filePath, and xpath for the file upload dynamically
	    protected static void fileUpload(WebDriver driver, String filePath, String uploadButtonXPath) throws InterruptedException, AWTException {
	        try {
	            // Navigate to the desired page dynamically (optional, if required)
	            // driver.get("your_dynamic_url");

	            // Click the file upload button dynamically based on the provided XPath
	            driver.findElement(By.xpath(uploadButtonXPath)).click();

	            // Initialize Robot for keyboard events
	            Robot r = new Robot();
	            r.delay(2000);

	            // Set the file path dynamically
	            StringSelection ss = new StringSelection(filePath);
	            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

	            // Simulate keyboard events to paste the file path and press Enter
	            r.keyPress(KeyEvent.VK_CONTROL);
	            r.keyPress(KeyEvent.VK_V);
	            r.keyRelease(KeyEvent.VK_CONTROL);
	            r.keyRelease(KeyEvent.VK_V);
	            r.keyPress(KeyEvent.VK_ENTER);
	            r.keyRelease(KeyEvent.VK_ENTER);

	        } catch (Exception e) {
	            Assert.fail("ERROR: Occurred during file upload: " + e.getMessage());
	        }
	    }


	// Consol changing color in TestNg
	protected static WebDriver art() throws FileNotFoundException, InterruptedException {

		try {
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\OctoberIPT\\Test\\Testing.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				System.out.println(BackgroundBrightBlack + line + Blue + Reset);
				Thread.sleep(54);
			}
		} catch (IOException e) {
			Assert.fail("ERROR : OCCURED DURING COLOR CHANGING IN TESTNG");
		}
		return driver;
	}

	protected static String getAttribute(WebElement element, String input) {
		try {
			return element.getAttribute(input);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING WINDOWS HANDLES");
			return null;
		}
	}

	protected static void threadSleep(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING IMPLICIT WAIT");
		}
	}

	protected static void implicitlyWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING IMPLICIT WAIT");
		}
	}

	protected static WebElement explicitlyWait(int second, String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING EXPLICIT WAIT");
		}
		return null;
	}

	protected static String getExcelData(int sheetIndexNum, int rowNum, int cellNum) throws Throwable {
		try {
			File file = new File("C:\\Users\\Jana\\Downloads\\Register_OpenMRS.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheetAt(sheetIndexNum);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);

			DataFormatter dataFormat = new DataFormatter();
			String data = dataFormat.formatCellValue(cell);
			System.out.println(data);
			return data;
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING GETTING THE EXCELDATA");
		}
		return null;
	}


	protected static void frameSwitch(WebElement index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED ELEMENT CLEARED");
		}
	}

//	protected static void validation(String string, String expected) {
//		try {
//			Assert.assertEquals(string, expected);
//		} catch (Exception e) {
//			Assert.fail("ERROR : OCCURED DURING VALIDATION");
//		}
//	}
	

	protected static void validation(String actual, String excepected) {
		try {
			Assert.assertEquals(actual, excepected);
		} catch (Exception e) {

			Assert.fail("ERROR : OCCUR DURING VALIDATION");
		}
	}
	
	protected static void verification(String actual, String excepected) {
		try {
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actual, excepected);
			System.out.println("Verification");
		} catch (Exception e) {

			Assert.fail("ERROR : OCCUR DURING VALIDATION");
		}
	}


	protected static void clearElement(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED ELEMENT CLEARED");
		}
	}

	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING BROWSER CLOSE");
		}
	}

	protected static void terminateBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURED DURING BROWSER LAUNCH TERMINATED");
		}
	}

}
