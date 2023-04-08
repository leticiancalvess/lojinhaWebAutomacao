package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver navegador; //precisa ter um atributo privado q representa o driver

    public LoginPage(WebDriver navegador) { //construtor q recebe o estado atual do navegador e passa pra dentro da classe
        this.navegador = navegador;

    }

    //metodo de interação com cada elemento da tela
    public LoginPage informarOUsuario(String usuario) { //loginpage porque vai continuar na mesma página, se fosse outra página, informaria a outra página
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys(usuario);

        return this; //retorna loginpage, fluid pages, vai retornar a proxima pagina nem que ela seja a atual


    }

    public LoginPage informarAsenha(String senha) {
        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys(senha);

        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeLogin() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador); //retorna nova página
    }

}
