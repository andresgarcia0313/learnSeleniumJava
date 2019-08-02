package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExample {

	public static void main(String[] args) {
		/**Crear objeto ChromeDriver y el constructor abre el navegador*/
		WebDriver driver = new ChromeDriver();
		/**Indica al objeto obtener una web y cargarla en el navegador web del objeto*/
		driver.get("http://www.google.com");
		/**Crear Objeto WebElement y lo asocia a un input llamado q*/
		WebElement element = driver.findElement(By.name("q"));
		/**Element se le agregara la palabra Cheese!*/
		element.sendKeys("Cheese!");
		/**Envía los datos*/
		element.submit();
		/**Imprime en consola el titulo de la web cargada*/
		System.out.println("Page title is: " + driver.getTitle());
		/**La búsqueda de Google se muestra dinámicamente  con JavaScript*/
		/**Espera a que se cargue la página, tiempo de espera después de 10 segundos*/
		(new WebDriverWait(driver, 10)
		).until(
			new ExpectedCondition<Boolean>(){
				public Boolean apply(WebDriver d){
					return d.getTitle().toLowerCase().startsWith("cheese!");
				}
			}
		);
		System.out.println("Page title is: " + driver.getTitle());
		/**El objeto webdriver se llama el metodo quit para salir y cerar el navegador*/
		driver.quit();
	}

}
