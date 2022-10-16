package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class Imdb extends AbstractComponent {

	WebDriver driver;

	public Imdb(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	String movieName = "Pushpa";

	@FindBy(xpath = "//input[@placeholder='Search IMDb']")
	WebElement searchImdb;

	@FindBy(xpath = "//button[@id='suggestion-search-button']")
	WebElement searchSymbolImdb;

	@FindBy(xpath = "//a[contains(text(),'Pushpa: The Rise - Part 1')]")
	WebElement movieLink;

	@FindBy(xpath = "//a[contains(text(),'Release date')]//parent::li/div//a")
	WebElement dateImdb;

	@FindBy(xpath = "//span[contains(text(),'Country of origin')]//parent::li//a")
	WebElement countryImdb;

	public void navigation() {

		searchImdb.sendKeys("Pushpa");

		searchSymbolImdb.click();

		movieLink.click();

	}

	public void goTo() {
		driver.navigate().to("https://www.imdb.com/");
	}

	public String pushpaDateFromImdb() {

		return dateImdb.getText();

	}

	public String pushpaCountryFromImdb() {

		return countryImdb.getText();

	}
}
