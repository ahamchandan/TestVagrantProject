package pushpa;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Imdb;
import testComponents.BaseTest;

public class PushpaValidation extends BaseTest {
	//This test is supposed to get passed as date values were same but format was different 
	//so after modification it is supposed to get passed.
	
	
	@Test
	public void pushpaValidationWithModifications() {

		Imdb imdbRef = wikiVar.navigation();
		String countryWiki = wikiVar.pushpaCountryFromWiki();
		String dateWiki = wikiVar.pushpaDateFromWiki();

		imdbRef.goTo();
		imdbRef.navigation();

		String countryImdb = imdbRef.pushpaCountryFromImdb();
		String dateImdb = imdbRef.pushpaDateFromImdb();

		// For extracting date values

		String[] splitedDatesWiki = dateWiki.split(" ");

		String modifiedDateWiki = splitedDatesWiki[0] + splitedDatesWiki[1] + splitedDatesWiki[2];


		String[] splitedDatesImdb = dateImdb.split(",");

		String montAndDateImdb = splitedDatesImdb[0];

		String monthImdb = montAndDateImdb.split(" ")[0];
		String extractedDateImdb = montAndDateImdb.split(" ")[1];

		String yearArrImdb = splitedDatesImdb[1].split(" ")[1];

		

		String modifiedDateImdb = extractedDateImdb + monthImdb + yearArrImdb;

		System.out.println("Final Wiki date " + modifiedDateWiki + " final imdb " + modifiedDateImdb);

		Assert.assertEquals(countryWiki, countryImdb);
		Assert.assertEquals(modifiedDateWiki, modifiedDateImdb);

	}
	
	//This test will fail as the dates were not manipulated and absolute date values were compared.
	@Test
	public void pushpaValidationWithoutModifications() {

		Imdb imdbRef = wikiVar.navigation();
		String countryWiki = wikiVar.pushpaCountryFromWiki();
		String dateWiki = wikiVar.pushpaDateFromWiki();

		imdbRef.goTo();
		imdbRef.navigation();

		String countryImdb = imdbRef.pushpaCountryFromImdb();
		String dateImdb = imdbRef.pushpaDateFromImdb();
		System.out.println("2nd test");

		Assert.assertEquals(countryWiki, countryImdb);
		Assert.assertEquals(dateWiki, dateImdb);

	}
}
