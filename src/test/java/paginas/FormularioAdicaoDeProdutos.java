package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicaoDeProdutos {

    private WebDriver navegador;

    public FormularioAdicaoDeProdutos(WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioAdicaoDeProdutos informarNomeDoProduto(String nomedoProduto) {
        navegador.findElement(By.id("produtonome")).sendKeys(nomedoProduto);
        return this;

    }
    public FormularioAdicaoDeProdutos informarValorDoProduto(String valorDoProduto) {
        navegador.findElement(By.name("produtovalor")).sendKeys(valorDoProduto);
        return this;
    }
    public FormularioAdicaoDeProdutos informarCoresDoProduto(String cores) {
        navegador.findElement(By.id("produtocores")).sendKeys(cores);
        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        return new ListaDeProdutosPage(navegador);
    }

}
