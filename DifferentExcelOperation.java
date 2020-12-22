package ExcelOperation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DifferentExcelOperation {
	static Object name;
	static Object place;
	static Object mobileNumber;
		
	public static void main(String arg[]) throws InterruptedException, IOException {
		getRowCount();
		//desireCapabilitiesForAppium();
		
		
	}
		
	public static void desireCapabilitiesForAppium() throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability(MobileCapabilityType.APP, "D:\\chaldal.apk");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
		Thread.sleep(15000);

		WebElement menu = driver.findElementByXPath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.widget.l/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView\r\n");
		menu.click();
		Thread.sleep(10000);

		WebElement loginMenu = driver.findElementByXPath("hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.widget.l/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup//android.widget.TextView[1]\r\n");
		loginMenu.click();

//		Thread.sleep(10000);
		
		String number = (String)mobileNumber;
		System.out.println(number);
		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[83,552][998,690]']")).sendKeys(number);
		
	}

	public static void getRowCount() throws IOException {
		
			
		try {
			
			String dir = System.getProperty("user.dir");
			String excelPath = dir + "./data/datasheet.xlsx";
			XSSFWorkbook workBook = new XSSFWorkbook(excelPath);
			XSSFSheet sheet = workBook.getSheet("Sheet1");
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println(rowCount);
			
			DataFormatter formatter = new DataFormatter();
			
			for(int i=0;i<=rowCount;i++) {
				
				name = formatter.formatCellValue(sheet.getRow(i).getCell(0));
				place = formatter.formatCellValue(sheet.getRow(i).getCell(1));
				mobileNumber = formatter.formatCellValue(sheet.getRow(i).getCell(2));
				
				System.out.println(i + " I am " + name + " I live in " + place + " my Mobile Number is "+ mobileNumber);
				
			}
			
		}
		catch(Exception e) {
//			System.out.println(e.getCause());
//			System.out.println(e.getMessage());			
		}
		
		
	}
	
}
