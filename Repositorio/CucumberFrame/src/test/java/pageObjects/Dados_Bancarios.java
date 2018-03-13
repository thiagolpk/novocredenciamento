package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dados_Bancarios {
	private static WebElement element = null;
	 
	public static WebElement banco (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div/button/span[2]"));
	    return element;	 
	}
	
	public static WebElement selecionaBanco (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div/div/div/button[5]"));
	    return element;	 
	}

	public static WebElement tipoCorrente (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[4]/div/div/div[1]/ul/li[1]/span"));
	    return element;	 
	}
	
	public static WebElement agencia (WebDriver driver){
	    element = driver.findElement(By.name("agencia"));
	    return element;	 
	}
	
	public static WebElement agenciaDigito (WebDriver driver){
	    element = driver.findElement(By.name("digito-ag"));
	    return element;	 
	}
	
	public static WebElement conta (WebDriver driver){
	    element = driver.findElement(By.name("conta"));
	    return element;	 
	}
	
	public static WebElement contaDigito (WebDriver driver){
	    element = driver.findElement(By.name("digito"));
	    return element;	 
	}
	
	public static WebElement irPagamento (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div/div/div[2]/div/div[2]/div/a/i"));
	    return element;	 
	}
	
	public static WebElement continuar (WebDriver driver){
	    element = driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
	    return element;	 
	}
}
