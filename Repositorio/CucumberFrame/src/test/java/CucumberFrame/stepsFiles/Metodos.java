package CucumberFrame.stepsFiles;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Metodos {
	WebDriver driver = new ChromeDriver();
	String emailglobal = null;
	
	public void gerar_evidencia(int nomePrint) throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(".\\target\\"+nomePrint+".png"));
			Reporter.addScreenCaptureFromPath(nomePrint+".png");
    }
	
	
	private String gerar_documento(String tipo) {
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
	String geradorcnpj = gerar_documento("cnpj");
	String geradorcpf = gerar_documento("cpf");
	
	Date dataAtual = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	String strDataAtual = sdf.format(dataAtual);
	
	public void conexao_banco() throws ClassNotFoundException{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		String url = "jdbc:oracle:thin:@10.150.51.173:1521:HMLTRNG";
		String username = "udb_inmetrics";
		String password = "stinm2910";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			String sqlQuerry = "select * from USR_GEPD.TB_VDA_MAQNA order by DT_INCL desc";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlQuerry);
			result.next();
			System.out.println(result.getString("EMAIL"));
			if(result.getString("EMAIL").equals(emailglobal))
				System.out.println("email confere com a base");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				conn = null;
			}
		}
		assertEquals("Faça o pagamento da(s) suas maquininha(s)", driver.findElement(By.xpath("/html/body/div[3]")).getText());
	}
}
