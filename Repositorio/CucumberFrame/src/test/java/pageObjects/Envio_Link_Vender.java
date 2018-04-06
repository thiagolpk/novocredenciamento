package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Envio_Link_Vender {
	
	private static WebElement element = null;
	 
	public static WebElement vender (WebDriver driver){
	 
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[1]/div/div[3]/div/div[2]/div/div/a"));

	    return element;
	 
	}

}
