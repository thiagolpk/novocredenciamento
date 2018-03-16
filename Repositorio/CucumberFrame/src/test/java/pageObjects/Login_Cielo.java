package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class Login_Cielo {
	
	private static WebElement element = null;
		 
	public static WebElement nome (WebDriver driver){
	 
	    element = driver.findElement(By.name("nome"));

	    return element;
	 
	    }
	
	public static WebElement cpf (WebDriver driver){
	 
	    element = driver.findElement(By.name("cpf"));
	 
	 return element;
	 
	    }
	
	
	public static WebElement acessar (WebDriver driver){
		 
		    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[4]/div/a"));
		 
		 return element;
		 
		    }
	
	public static WebElement loja (WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[3]/ul/li[1]"));
	 
	 return element;
	 
	    }
	
	public static WebElement credenciamento (WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[3]/ul/li[2]"));
	 
	 return element;
	 
	    }
	
	public static WebElement retencao (WebDriver driver){
		 
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[3]/ul/li[3]"));
	 
	 return element;
	 
	    }

}
