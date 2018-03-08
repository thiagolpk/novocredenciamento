package CucumberFrame.stepsFiles;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
//import com.sun.jna.platform.FileUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.commons.io.FileUtils;

public class Login {
	public void getscreenshot(String nomePrint) throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
			FileUtils.copyFile(scrFile, new File(".\\target\\"+nomePrint+".png"));
    }
	
	//private static final String BaseTest = null;
	WebDriver driver = new ChromeDriver();

	private String getDocumento(String tipo) {
		try {
			URL url = new URL("http://geradorapp.com/api/v1/" + tipo + "/generate?token=b3a3cf63de5f428c911ed3aed3e18880");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) 
			{
				sb.append(line);
			}
			Gson gson = new Gson();
			JsonElement element = gson.fromJson(sb.toString(), JsonElement.class);
			JsonObject jsonObject = element.getAsJsonObject();
			return jsonObject.getAsJsonObject("data").get("number").getAsString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	String geradorcnpj = getDocumento("cnpj");
	String geradorcpf = getDocumento("cpf");
	

	@Given("^Usuario acessa o site de compra de maquininha$")
	public void usuario_acessa_o_site_de_compra_de_maquininhas() throws Throwable {
		driver.manage().window().maximize();
		driver.get("https://credenciamento.hml.stelo.com.br/");
		getscreenshot("AcessoSite");
		Reporter.addScreenCaptureFromPath("AcessoSite.png");
	}
	
	@Given("^Usuario acessa o site de compra de maquininha Bradesco$")
	public void usuario_acessa_o_site_de_compra_de_maquininhas_Bradesco() throws Throwable {
		driver.manage().window().maximize();
		driver.get("https://credenciamento.hml.stelo.com.br/credenciamento/bra");
		WebElement nome, agencia, funcional, acessar;
		nome = driver.findElement(By.name("nome"));
		nome.sendKeys("Operador Bradesco");
		
		agencia = driver.findElement(By.name("agencia"));
		agencia.sendKeys("1234");
		
		funcional = driver.findElement(By.name("funcional"));
		funcional.sendKeys("3333333");
		
		getscreenshot("AcessoSiteBra");
		Reporter.addScreenCaptureFromPath("AcessoSiteBra.png");
		
		acessar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[4]/div/a"));
		acessar.click();
	}
	
	@Given("^Usuario acessa o site de compra de maquininha BB$")
	public void usuario_acessa_o_site_de_compra_de_maquininhas_BB() throws Throwable {
		driver.manage().window().maximize();
		driver.get("https://credenciamento.hml.stelo.com.br/credenciamento/bb");
		WebElement nome, agencia, matricula, acessar;
		nome = driver.findElement(By.name("nome"));
		nome.sendKeys("Operador BB");
		
		agencia = driver.findElement(By.name("agencia"));
		agencia.sendKeys("1234");
		
		matricula = driver.findElement(By.name("matricula"));
		matricula.sendKeys("F6666666");
		
		getscreenshot("AcessoSiteBB");
		Reporter.addScreenCaptureFromPath("AcessoSiteBB.png");
		
		acessar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div/div[2]/div/div[4]/div/a"));
		acessar.click();
	}
	
	@And("^Escolher a opcao vender$")
	public void escolher_a_opcao_vender() throws Throwable {
		Thread.sleep(1000);
		getscreenshot("SelecionaVender");
		Reporter.addScreenCaptureFromPath("SelecionaVender.png");
		WebElement vender;
		vender = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div[3]/div/div[2]/div[1]/div/a"));
		vender.click();
		Thread.sleep(1000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}

	@And("^Escolher a maquina MOB$")
	public void escolher_a_maquina_MOB() throws Throwable {
		WebElement operadora, adicionar, continuar;
		operadora = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div/div[2]/ul/li[1]"));
		operadora.click();						 
		adicionar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div/div[3]/div/a"));
		adicionar.click();
		getscreenshot("AdicionaMob");
		Reporter.addScreenCaptureFromPath("AdicionaMob.png");
		continuar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div/div/a"));
		continuar.click();
	}
	
	@And("^Informar o endereco$")
	public void informar_o_endereco() throws Throwable {
		WebElement destinatario, cep, numero, avancar;
		destinatario = driver.findElement(By.name("name"));
		destinatario.sendKeys("Destinatario Teste");
		getscreenshot("Endereco1");
		Reporter.addScreenCaptureFromPath("Endereco1.png");
		cep = driver.findElement(By.name("zip"));
		cep.sendKeys("06725025");
		numero = driver.findElement(By.name("number"));
		numero.sendKeys("123");
		getscreenshot("Endereco2");
		Reporter.addScreenCaptureFromPath("Endereco2.png");
		avancar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[8]/div[2]/div/a"));
		avancar.click();
	}

	@And("^Informar dados do meu negocio CNPJ$")
	public void informar_dados_do_meu_negocio_CNPJ() throws Throwable {
		WebElement cnpj, email, confirmEmail, razaoSocial, nomeFantasia, inscricaoEst, categoria, selctCategoria,
		subCategoria, selctSubCategoria, celular, identCartao, nomeResponsavel, cpfResponsavel, dtNasc, avancar;
		Date dataAtual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String strDataAtual = sdf.format(dataAtual);
		cnpj = driver.findElement(By.name("document"));
		cnpj.sendKeys(geradorcnpj);
		Thread.sleep(1000);
		
		email = driver.findElement(By.name("e-mail"));
		email.sendKeys(strDataAtual + "@gmail.com");
		
		confirmEmail = driver.findElement(By.name("confirmacaoE-mail"));
		confirmEmail.sendKeys(strDataAtual + "@gmail.com");
		
		razaoSocial = driver.findElement(By.name("company-name"));
		razaoSocial.sendKeys("Comercio Eletronico Ltda");
		
		nomeFantasia = driver.findElement(By.name("public-name"));
		nomeFantasia.sendKeys("Eletronic Game");
		
		getscreenshot("DadosCNPJ1");
		Reporter.addScreenCaptureFromPath("DadosCNPJ1.png");
		
		inscricaoEst = driver.findElement(By.name("inc-est"));
		inscricaoEst.sendKeys("123456789012");
		
		categoria = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[7]/div/button/span[2]"));
		categoria.click();
		
		selctCategoria = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[7]/div/div/button[4]"));
		selctCategoria.click();
		Thread.sleep(500);
		
		subCategoria = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[8]/div/button/span[2]/b"));
		subCategoria.click();
		
		selctSubCategoria = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[8]/div/div/button[3]"));
		selctSubCategoria.click();
		
		celular = driver.findElement(By.name("phone"));
		celular.sendKeys("11912341234");
		
		identCartao = driver.findElement(By.name("billname"));
		identCartao.sendKeys("Eletro Game");
		
		nomeResponsavel = driver.findElement(By.name("resp-name"));
		nomeResponsavel.sendKeys("Proprietario Responsavel");
		
		cpfResponsavel = driver.findElement(By.name("resp-cpf"));
		cpfResponsavel.sendKeys("00000000191");
		
		dtNasc = driver.findElement(By.name("resp-birth-date"));
		dtNasc.sendKeys("01011999");
		
		getscreenshot("DadosCNPJ2");
		Reporter.addScreenCaptureFromPath("DadosCNPJ2.png");
		
		avancar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[14]/div/div[2]/div/a"));
		avancar.click();
		Thread.sleep(500);
	}

	@And("^Informar dados do meu negocio CPF$")
	public void informar_dados_do_meu_negocio_CPF() throws Throwable {
		WebElement cliqueCPF, cpf, email, confirmEmail, nomeCompleto, dtNasc, celular, nomeFantasia, 
		subCategoria, selctSubCategoria, identCartao, avancar, categoria, selctCategoria;
		Date dataAtual = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String strDataAtual = sdf.format(dataAtual);
		cliqueCPF = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[2]/div/a/i"));
		cliqueCPF.click();
		
		cpf = driver.findElement(By.name("document"));
		cpf.sendKeys(geradorcpf);
		Thread.sleep(1000);
		
		email = driver.findElement(By.name("e-mail"));
		email.sendKeys(strDataAtual + "@gmail.com");
		
		confirmEmail = driver.findElement(By.name("confirmae-mail"));
		confirmEmail.sendKeys(strDataAtual + "@gmail.com");
		
		nomeCompleto = driver.findElement(By.name("company-name"));
		nomeCompleto.sendKeys("Proprietario Nome");
		
		dtNasc = driver.findElement(By.name("resp-birth-date"));
		dtNasc.sendKeys("01011999");
		
		celular = driver.findElement(By.name("phone"));
		celular.sendKeys("11912341234");
		
		getscreenshot("DadosCPF1");
		Reporter.addScreenCaptureFromPath("DadosCPF1.png");
		
		nomeFantasia = driver.findElement(By.name("public-name"));
		nomeFantasia.sendKeys("Eletronic Game");
		
		categoria = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[7]/div/button/span[2]"));
		categoria.click();
		
		selctCategoria = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[7]/div/div/button[5]"));
		selctCategoria.click();
		Thread.sleep(500);
		
		subCategoria = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[8]/div/button/span[2]"));
		subCategoria.click();
		
		selctSubCategoria = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[8]/div/div/button[1]"));
		selctSubCategoria.click();
		
		identCartao = driver.findElement(By.name("billname"));
		identCartao.sendKeys("Eletro Game");
		
		getscreenshot("DadosCPF2");
		Reporter.addScreenCaptureFromPath("DadosCPF2.png");
		
		avancar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div/div[10]/div/div[2]/div/a"));
		avancar.click();
		Thread.sleep(500);
	}
	
	@When("^Informar dados bancarios$")
	public void informar_dados_bancarios() throws Throwable {
		Thread.sleep(500);
		WebElement banco, selctBanco, tipoCorrente, agencia, conta, contaDigito, avancar;
		banco = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div/button/span[2]"));
		banco.click();
		
		selctBanco = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div/div/div/button[5]"));
		selctBanco.click();
		
		tipoCorrente = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[4]/div/div/div[1]/ul/li[1]/span"));
		tipoCorrente.click();
		
		agencia = driver.findElement(By.name("agencia"));
		agencia.sendKeys("1234");
		
		conta = driver.findElement(By.name("conta"));
		conta.sendKeys("123456");
		
		contaDigito = driver.findElement(By.name("digito"));
		contaDigito.sendKeys("7");
		
		getscreenshot("DadosBancarios");
		Reporter.addScreenCaptureFromPath("DadosBancarios.png");
		
		avancar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[7]/div[2]/div/a"));
		avancar.click();
		
		Thread.sleep(20000);
	}
	
	@When("^Informar dados bancarios BRA$")
	public void informar_dados_bancarios_BRA() throws Throwable {
		Thread.sleep(500);
		WebElement tipoCorrente, agencia, conta, contaDigito, avancar;
		tipoCorrente = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[4]/div/div/div[1]/ul/li[1]/span"));
		tipoCorrente.click();
		
		agencia = driver.findElement(By.name("agencia"));
		agencia.sendKeys("1234");
		
		conta = driver.findElement(By.name("conta"));
		conta.sendKeys("123456");
		
		contaDigito = driver.findElement(By.name("digito"));
		contaDigito.sendKeys("7");
		
		getscreenshot("DadosBancariosBRA");
		Reporter.addScreenCaptureFromPath("DadosBancariosBRA.png");
		
		avancar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[7]/div[2]/div/a"));
		avancar.click();
		
		Thread.sleep(20000);
	}

	@When("^Informar dados bancarios BB$")
	public void informar_dados_bancarios_BB() throws Throwable {
		Thread.sleep(500);
		WebElement tipoCorrente, agencia, agenciaDigito, conta, contaDigito, avancar, irPagamento;
		tipoCorrente = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[4]/div/div/div[1]/ul/li[1]/span"));
		tipoCorrente.click();
		
		agencia = driver.findElement(By.name("agencia"));
		agencia.sendKeys("1234");
		
		agenciaDigito = driver.findElement(By.name("digito-ag"));
		agenciaDigito.sendKeys("3");
		
		conta = driver.findElement(By.name("conta"));
		conta.sendKeys("1234");
		
		contaDigito = driver.findElement(By.name("digito"));
		contaDigito.sendKeys("3");
		
		getscreenshot("DadosBancariosBB");
		Reporter.addScreenCaptureFromPath("DadosBancariosBB.png");
		
		avancar = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[7]/div[2]/div/a"));
		avancar.click();
		
		Thread.sleep(19000);
		
		getscreenshot("IrPagamento");
		Reporter.addScreenCaptureFromPath("IrPagamento.png");
		
		irPagamento = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div/div/div[2]/div/div[2]/div/a/i"));
		irPagamento.click();
		
	}

	@Then("^Deve acessar a tela de pagamento$")
	public void deve_acessar_a_tela_de_pagamento() throws Throwable {
		Thread.sleep(10000);
		assertEquals("Faça o pagamento da(s) suas maquininha(s)", driver.findElement(By.xpath("/html/body/div[3]")).getText());
		getscreenshot("AmbienteVTex");
		Reporter.addScreenCaptureFromPath("AmbienteVTex.png");
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		    driver.close();

		}
		
		
	}
}
