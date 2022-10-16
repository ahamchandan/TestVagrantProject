package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class Wikipedia extends AbstractComponent {

	WebDriver driver;

	public Wikipedia(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String movieName = "Pushpa";

	@FindBy(xpath = "//input[@id='searchInput']")
	WebElement searchBox;

	@FindBy(xpath = "//input[@id='searchButton']")
	WebElement searchSymbol;

	@FindBy(xpath = "//div[contains(text(),'Release date')]//ancestor::tr//div[@class='plainlist']")
	WebElement date;

	@FindBy(xpath = "//th[text()='Country']//following-sibling::td[@class='infobox-data']")
	WebElement country;

	public Imdb navigation() {
		// TODO Auto-generated method stub

		searchBox.sendKeys(movieName);
		searchSymbol.click();

		Imdb imdbRef = new Imdb(driver);
		return imdbRef;
	}

	public String pushpaDateFromWiki() {

		return date.getText();

	}

	public String pushpaCountryFromWiki() {

		return country.getText();

	}

	public void goTo() {
		driver.get("https://en.wikipedia.org/");
	}

}
