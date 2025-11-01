package YatracalenderAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class YatraCalenderAutomation {

	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Disable notifications
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));// Synchronizing the webDriver!!
		driver.get("https://www.yatra.com/");
		System.out.println("Yatra website opened successfully!");

		clickOnPoup(wait);
		clickOnDepartureButton(wait);

		WebElement currentMonthWebElement = selectTheMonthFromCalendar(wait, 0); // current month
		WebElement nextMonthWebElement = selectTheMonthFromCalendar(wait, 1); // Next Month

		Thread.sleep(3000);
		String lowestPriceForCurrentMonth =getMeLowestPrice(currentMonthWebElement);
		String lowestPriceForNextMonth =getMeLowestPrice(nextMonthWebElement);
		System.out.println(lowestPriceForCurrentMonth);
		System.out.println(lowestPriceForNextMonth);
		compareTwoMonthPrice(lowestPriceForCurrentMonth, lowestPriceForNextMonth );
	}

	private static void clickOnDepartureButton(WebDriverWait wait) {
		By DepartureDateButtonLocator = By
				.xpath("//div[(@aria-label=\"Departure Date inputbox\" and @role=\"button\")]");
		WebElement DepartureDateButton = wait
				.until(ExpectedConditions.elementToBeClickable(DepartureDateButtonLocator));
		DepartureDateButton.click();
	}

	private static void clickOnPoup(WebDriverWait wait) {
		By crossButtonLocator = By.xpath("//span[@class='style_cross__q1ZoV']//img[@alt='cross']");
		WebElement crossButton = wait.until(ExpectedConditions.elementToBeClickable(crossButtonLocator));
		crossButton.click();
	}

	private static String getMeLowestPrice(WebElement monthWebElement) {
		By PriceLocator = By.xpath(".//span[contains(@class, \"custom-day-content\")]");

		List<WebElement> JunePriceList = monthWebElement.findElements(PriceLocator);

		int lowestPrice = Integer.MAX_VALUE;
		WebElement priceElement = null;
		for (WebElement Price : JunePriceList) {
			String priceString = Price.getText();
			priceString = priceString.replace("₹", "").replace(",", "");

			if (priceString.isEmpty()) {
				continue;
			}
		
			int pricetInt = Integer.parseInt(priceString);

			if (pricetInt < lowestPrice) {
				lowestPrice = pricetInt;
				priceElement = Price;
			}

		}

		WebElement dataElement = priceElement.findElement(By.xpath(".//../.."));

		String result = dataElement.getAttribute("aria-label") + "---Price is Rs" + lowestPrice;
		return result;
	}

	public static WebElement selectTheMonthFromCalendar(WebDriverWait wait, int index) {
		By CalendarMonthsLocator = By.xpath("//div[@class=\"react-datepicker__month-container\"]");
		List<WebElement> CalendarMonthsList = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CalendarMonthsLocator));
		System.out.println("the size of WebElements Appears " + CalendarMonthsList.size());

		WebElement monthCalendarWebElement = CalendarMonthsList.get(index); // current month
		return monthCalendarWebElement;
	}
	
	public static void compareTwoMonthPrice(String currentMonthPrice, String nextMonthPrice) {
		int currentMonthRsIndex = currentMonthPrice.indexOf("Rs");
		int nextMonthRsIndex = nextMonthPrice.indexOf("Rs");
			
		String currentPrice = currentMonthPrice.substring(currentMonthRsIndex + 2); 
		String NextPrice = nextMonthPrice.substring(nextMonthRsIndex + 2); 
		
		int Current = Integer.parseInt(currentPrice);
		int Next = Integer.parseInt(NextPrice);
		
		if (Current < Next) {
			System.out.println("The lowest Price for the two months is " + Current);
		}
		else if(Current == Next) {
			System.out.println("Price is same for both months! Choose whatever you prefer!!");
		}
		else{
			System.out.println("The lowest price for the two months is" + Next);
		}
	}
}
