import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyStore{
	
	static WebDriver driver;
	
	public static String getData(int rowNo,int cellNo) throws IOException {
		String v = null;
		File loc = new File("C:\\Users\\Swetha\\eclipse-workspace\\Ecommerce\\Data\\Book1.xlsx");
		FileInputStream Stream = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(Stream);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowNo);
		Cell c =  r.getCell(cellNo);
		int type = c.getCellType();
		if(type==1) {
			v = c.getStringCellValue();
	
		}
		else if(type==0){
			if(DateUtil.isCellDateFormatted(c)) {
				Date DateCellValue= c.getDateCellValue();
				SimpleDateFormat sim =new SimpleDateFormat("dd-MMM-YYYY");
				v=sim.format(DateCellValue);
	
			}
			else {
				double numericCellValue = c.getNumericCellValue();
			Long l = (long)numericCellValue;
			v= String.valueOf(l);
			}
		}
			
		return v;
	}
	
	
	//launch the browser.
	public static void launchChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Swetha\\eclipse-workspace\\Ecommerce\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();			
}
	
	//load url
	public static void loadUrl(String u) {
driver.get(u);

	}
	
	//screenshot
	public static void screenShot(WebDriver driver, String filePath) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File d = new File(filePath);
		FileUtils.copyFile(src, d);
	}
	
	public static void fill(WebElement e ,String value) {
		e.sendKeys(value);
		}
	
	public static void Action1(WebElement e) throws IOException {
		Actions acc = new Actions(driver);
		acc.moveToElement(e).perform();
	}
		
		public static void btnclick (WebElement e) {
			e.click();
		}
		
		
		
}
	
	
