package modules.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.ListaDeProdutosPage;
import paginas.LoginPage;

@DisplayName("Testes Web do modulo de produtos")
public class ProdutosTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        //abrir o navegador
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        this.navegador = new ChromeDriver();

        //navegar para a pagina lojinha web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2");
    }

    @Test
    @DisplayName("Não e permitido registrar um produto com o valor igual a zero")
    public void testNaoPermitidoRegistrarProdutoComValorIgualAZero() {

        //fazer login
      String mensagemApresentada = new LoginPage(navegador)
              .informarOUsuario("admin")
              .informarAsenha("admin")
              .submeterFormularioDeLogin()
              .clicarEmAdicionarProduto()
              .informarNomeDoProduto("Macbook")
              .informarValorDoProduto("000")
              .informarCoresDoProduto("preto, branco")
              .submeterFormularioDeAdicaoComErro()
                      .capturarMensagemApresentada();

      Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


        //submeter o formulario



        }
    @AfterEach
    public void afterEach () {
        navegador.quit();
    }
}
