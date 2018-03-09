package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Login_Gerente_BRA {
	
	private static WebElement element = null;
		 
	public static WebElement nome (WebDriver driver){
	 
	    element = driver.findElement(By.name("nome"));

	    return element;
	 
	    }
	
	public static WebElement agencia (WebDriver driver){
	 
	    element = driver.findElement(By.name("agencia"));
	 
	 return element;
	 
	    }
	
	public static WebElement funcional (WebDriver driver){
		 
		    element = driver.findElement(By.name("funcional"));
		 
		 return element;
		 
		    }
	
	public static WebElement acessar (WebDriver driver){
		 
		    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[4]/div/a"));
		 
		 return element;
		 
		    }

}
