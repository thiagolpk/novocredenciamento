package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dados_Estabelecimento {
	private static WebElement element = null;
	 
	public static WebElement documento (WebDriver driver){
	    element = driver.findElement(By.name("document"));
	    return element;	 
	}
	
	public static WebElement nomeCompleto (WebDriver driver){
	    element = driver.findElement(By.name("company-name"));
	    return element;	 
	}
	
	public static WebElement email (WebDriver driver){
	    element = driver.findElement(By.name("e-mail"));
	    return element;	 
	}
	
	public static WebElement confirmaEmail (WebDriver driver){
	    element = driver.findElement(By.name("confirmacaoE-mail"));
	    return element;	 
	}
	
	public static WebElement confirmaEmail2 (WebDriver driver){
	    element = driver.findElement(By.name("confirmae-mail"));
	    return element;	 
	}
	
	public static WebElement razaoSocial (WebDriver driver){
	    element = driver.findElement(By.name("company-name"));
	    return element;	 
	}
	
	public static WebElement nomeFantasia (WebDriver driver){
	    element = driver.findElement(By.name("public-name"));
	    return element;	 
	}
	
	public static WebElement categoria (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[7]/div/button/span"));
	    return element;	 
	}
	
	public static WebElement selecionaCategoria (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[5]/div/div/button[5]"));
	    return element;	 
	}
	
	public static WebElement subCategoria (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[8]/div/button/span"));
	    return element;	 
	}
	
	public static WebElement selecionaSubCategoria (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[6]/div/div/button[3]"));
	    return element;	 
	}
	////////////CPF/////////////
	public static WebElement categoriaCpf (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[7]/div/button/span"));
	  //  element = driver.findElement(By.cssSelector("a[class='custom-label']"));
	    return element;	 
	}
	
	
	public static WebElement selecionaCategoriaCpf (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[7]/div/div/button[5]"));
	    return element;	 
	}
	
	public static WebElement subCategoriaCpf (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[8]/div/button/span"));
	    return element;	 
	}
	
	public static WebElement selecionaSubCategoriaCpf (WebDriver driver){
		element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[8]/div/div/button[1]"));
	    return element;	 
	}
	
	////////////
	
	public static WebElement celular (WebDriver driver){
	    element = driver.findElement(By.name("phone"));
	    return element;	 
	}
	
	public static WebElement idFatura (WebDriver driver){
	    element = driver.findElement(By.name("billname"));
	    return element;	 
	}
	
	public static WebElement nomeResponsavel (WebDriver driver){
	    element = driver.findElement(By.name("resp-name"));
	    return element;	 
	}
	
	public static WebElement cpfResponsavel (WebDriver driver){
	    element = driver.findElement(By.name("resp-cpf"));
	    return element;	 
	}
	
	public static WebElement dataNasc (WebDriver driver){
	    element = driver.findElement(By.name("resp-birth-date"));
	    return element;	 
	}
	
	public static WebElement continuar (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[12]/div/div[2]/div/a"));
	    return element;	 
	}
	
	public static WebElement continuarCpf (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[10]/div/div/div[2]/div/a"));
	    return element;	 
	}
	
	public static WebElement cliqueCPF (WebDriver driver){
	    element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[2]/div/a/i"));
	    return element;	 
	}


}
