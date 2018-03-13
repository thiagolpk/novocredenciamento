package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Endereco_Entrega {

		private static WebElement element = null;
		 
		public static WebElement destinatario (WebDriver driver){
		    element = driver.findElement(By.name("name"));
		    return element;	 
		}
		public static WebElement cep (WebDriver driver){
		    element = driver.findElement(By.name("zip"));
		    return element;	 
		}
		public static WebElement numero (WebDriver driver){
		    element = driver.findElement(By.name("number"));
		    return element;	 
		}
		public static WebElement continuar (WebDriver driver){
		    element = driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
		    return element;	 
		}
	
}
