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
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.cucumber.listener.Reporter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
//import com.sun.jna.platform.FileUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Dados_Bancarios;
import pageObjects.Dados_Estabelecimento;
import pageObjects.Endereco_Entrega;
import pageObjects.Envio_Link_Vender;
import pageObjects.Escolha_Maquina;
import pageObjects.Login_Cielo;
import pageObjects.Login_Gerente_BB;
import pageObjects.Login_Gerente_BRA;

import org.apache.commons.io.FileUtils;



public class Login {
	public void gerar_evidencia(int nomePrint) throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(".\\target\\"+nomePrint+".png"));
			Reporter.addScreenCaptureFromPath(nomePrint+".png");
    }
	
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
	
	Date dataAtual = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	String strDataAtual = sdf.format(dataAtual);
	
	int contador;

	WebDriver driver = new ChromeDriver();
	//WebDriver driver = new InternetExplorerDriver();
	
	@Given("^Usuario acessa o site de compra de maquininha$")
	public void usuario_acessa_o_site_de_compra_de_maquininhas() throws Throwable {
		driver.manage().window().maximize();
		driver.get("https://credenciamento.hml.stelo.com.br/");
		gerar_evidencia(contador); contador++;
	}
	
	@Given("^Usuario acessa o site de compra de maquininha Bradesco$")
	public void usuario_acessa_o_site_de_compra_de_maquininhas_Bradesco() throws Throwable {
		driver.manage().window().maximize();
		driver.get("https://credenciamento.hml.stelo.com.br/credenciamento/bra");
		
		Login_Gerente_BRA.nome(driver).sendKeys("Operador Bradesco");
		Login_Gerente_BRA.agencia(driver).sendKeys("1234");
		Login_Gerente_BRA.funcional(driver).sendKeys("3333333");
		gerar_evidencia(contador); contador++;
		Login_Gerente_BRA.acessar(driver).click();
	}
	
	@Given("^Usuario acessa o site de compra de maquininha BB$")
	public void usuario_acessa_o_site_de_compra_de_maquininhas_BB() throws Throwable {
		driver.manage().window().maximize();
		driver.get("https://credenciamento.hml.stelo.com.br/credenciamento/bb");

		Login_Gerente_BB.nome(driver).sendKeys("Operador BB");
		Login_Gerente_BB.agencia(driver).sendKeys("1234");
		Login_Gerente_BB.matricula(driver).sendKeys("F6666666");
		gerar_evidencia(contador); contador++;
		Login_Gerente_BB.acessar(driver).click();
	}
	
	@Given("^Usuario acessa o site de compra de maquininha CIELO$")
	public void usuario_acessa_o_site_de_compra_de_maquininhas_CIELO() throws Throwable {
		driver.manage().window().maximize();
		driver.get("https://credenciamento.hml.stelo.com.br/credenciamento/cielo");

		Login_Cielo.nome(driver).sendKeys("Operador Cielo");
		Login_Cielo.cpf(driver).sendKeys(geradorcpf);
		Login_Cielo.loja(driver).click();
		gerar_evidencia(contador); contador++;
		Login_Cielo.acessar(driver).click();
	}
	
	@And("^Escolher a opcao vender$")
	public void escolher_a_opcao_vender() throws Throwable {
		Thread.sleep(1000);
		gerar_evidencia(contador); contador++;
		Envio_Link_Vender.vender(driver).click();
		Thread.sleep(1000);
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}

	@And("^Escolher a maquina MOB$")
	public void escolher_a_maquina_MOB() throws Throwable {
		
		Escolha_Maquina.operadora(driver).click();	
		Escolha_Maquina.adicionar(driver).click();
		gerar_evidencia(contador); contador++;
		Escolha_Maquina.avancar(driver).click();
	}
	
	@And("^Informar o endereco$")
	public void informar_o_endereco() throws Throwable {
		Endereco_Entrega.destinatario(driver).sendKeys("Destinatario Teste");
		gerar_evidencia(contador); contador++;
		Endereco_Entrega.cep(driver).sendKeys("06725025");
		Endereco_Entrega.numero(driver).sendKeys("123");
		gerar_evidencia(contador); contador++;
		Endereco_Entrega.continuar(driver).click();
	}

	@And("^Informar dados do meu negocio CNPJ$")
	public void informar_dados_do_meu_negocio_CNPJ() throws Throwable {
		Dados_Estabelecimento.documento(driver).sendKeys(geradorcnpj);
		Thread.sleep(1000);
		Dados_Estabelecimento.email(driver).sendKeys(strDataAtual + "@gmail.com");
		Dados_Estabelecimento.confirmaEmail(driver).sendKeys(strDataAtual + "@gmail.com");
		Dados_Estabelecimento.razaoSocial(driver).sendKeys("Automacao Comercio Eletronico Ltda");
		Dados_Estabelecimento.nomeFantasia(driver).sendKeys("Automacao Gamers Club");
		gerar_evidencia(contador); contador++;
		Dados_Estabelecimento.categoria(driver).click();
		Dados_Estabelecimento.selecionaCategoria(driver).click();
		Thread.sleep(500);
		Dados_Estabelecimento.subCategoria(driver).click();
		Dados_Estabelecimento.selecionaSubCategoria(driver).click();
		Dados_Estabelecimento.celular(driver).sendKeys("11912341234");
		Dados_Estabelecimento.idFatura(driver).sendKeys("Gamers Club");
		Dados_Estabelecimento.nomeResponsavel(driver).sendKeys("Proprietario Responsavel");
		Dados_Estabelecimento.cpfResponsavel(driver).sendKeys(geradorcpf);
		Dados_Estabelecimento.dataNasc(driver).sendKeys("01011999");
		gerar_evidencia(contador); contador++;
		Dados_Estabelecimento.continuar(driver).click();
		Thread.sleep(500);
	}

	@And("^Informar dados do meu negocio CPF$")
	public void informar_dados_do_meu_negocio_CPF() throws Throwable {
		Dados_Estabelecimento.cliqueCPF(driver).click();
		Dados_Estabelecimento.documento(driver).sendKeys(geradorcpf);
		Thread.sleep(1000);
		Dados_Estabelecimento.email(driver).sendKeys(strDataAtual + "@gmail.com");
		Dados_Estabelecimento.confirmaEmail2(driver).sendKeys(strDataAtual + "@gmail.com");
		Dados_Estabelecimento.nomeCompleto(driver).sendKeys("Proprietario Nome");
		Dados_Estabelecimento.dataNasc(driver).sendKeys("01011999");
		Dados_Estabelecimento.celular(driver).sendKeys("11912341234");
		gerar_evidencia(contador); contador++;
		Dados_Estabelecimento.nomeFantasia(driver).sendKeys("Automacao Gamers Club");
		gerar_evidencia(contador); contador++;
		Dados_Estabelecimento.categoriaCpf(driver).click();
		Dados_Estabelecimento.selecionaCategoriaCpf(driver).click();
		Thread.sleep(500);
		Dados_Estabelecimento.subCategoriaCpf(driver).click();
		Dados_Estabelecimento.selecionaSubCategoriaCpf(driver).click();
		Dados_Estabelecimento.idFatura(driver).sendKeys("Gamers Club");
		gerar_evidencia(contador); contador++;
		Dados_Estabelecimento.continuarCpf(driver).click();
		Thread.sleep(500);
	}
	
	@When("^Informar dados bancarios$")
	public void informar_dados_bancarios() throws Throwable {
		Thread.sleep(500);
		Dados_Bancarios.banco(driver).click();
		Dados_Bancarios.selecionaBanco(driver).click();
		Dados_Bancarios.tipoCorrente(driver).click();
		Dados_Bancarios.agencia(driver).sendKeys("1234");
		Dados_Bancarios.conta(driver).sendKeys("123456");
		Dados_Bancarios.contaDigito(driver).sendKeys("9");
		gerar_evidencia(contador); contador++;
		Dados_Bancarios.continuar(driver).click();
		Thread.sleep(20000);
		if(Dados_Bancarios.irPagamento(driver).isDisplayed()){
			gerar_evidencia(contador); contador++;
			Dados_Bancarios.irPagamento(driver).click();
		};
	}
	
	@When("^Informar dados bancarios BRA$")
	public void informar_dados_bancarios_BRA() throws Throwable {
		Thread.sleep(500);
		Dados_Bancarios.tipoCorrente(driver).click();
		Dados_Bancarios.agencia(driver).sendKeys("1234");
		Dados_Bancarios.conta(driver).sendKeys("123456");
		Dados_Bancarios.contaDigito(driver).sendKeys("9");
		gerar_evidencia(contador); contador++;
		Dados_Bancarios.continuar(driver).click();
		Thread.sleep(20000);
	}

	@When("^Informar dados bancarios BB$")
	public void informar_dados_bancarios_BB() throws Throwable {
		Thread.sleep(500);
		Dados_Bancarios.tipoCorrente(driver).click();
		Dados_Bancarios.agencia(driver).sendKeys("1234");
		Dados_Bancarios.agenciaDigito(driver).sendKeys("3");
		Dados_Bancarios.conta(driver).sendKeys("1234");
		Dados_Bancarios.contaDigito(driver).sendKeys("3");
		gerar_evidencia(contador); contador++;
		Dados_Bancarios.continuar(driver).click();
		Thread.sleep(19000);
		gerar_evidencia(contador); contador++;
		Dados_Bancarios.irPagamento(driver).click();
		
	}

	@Then("^Deve acessar a tela de pagamento$")
	public void deve_acessar_a_tela_de_pagamento() throws Throwable {
		try{
			Thread.sleep(10000);
			assertEquals("Faça o pagamento da(s) suas maquininha(s)", driver.findElement(By.xpath("/html/body/div[3]")).getText());
			gerar_evidencia(contador); contador++;		
			for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
				driver.close();
			}
		
		}
		catch (Exception e) {
			gerar_evidencia(contador); contador++;
			driver.close();
		}
	}
}
