package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Escolha_Maquina {
	private static WebElement element = null;
	 
	public static WebElement operadora (WebDriver driver){
	 
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div/div[2]/ul/li[1]"));

	    return element;
	 
	}
	
	public static WebElement adicionar (WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div/div[3]/div/a"));

	    return element;
	 
	}
	
	public static WebElement avancar (WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div/div/a"));

	    return element;
	 
	}
}
