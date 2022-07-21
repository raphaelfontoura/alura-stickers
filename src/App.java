import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class App {

  public static void main(String[] args) throws Exception {

    String urlFilmes = "https://api.mocki.io/v2/549a5d8b";

    var httpClient = new ClienteHttp();
    String jsonFilmes = httpClient.buscaDados(urlFilmes);

    ExtratorConteudo extratorFilmes = new ExtratorDeConteudoIMDB();
    List<Conteudo> conteudosFilmes = extratorFilmes.extraiConteudos(jsonFilmes);

    GeradorDeStickers geradorDeStickers = new GeradorDeStickers();

    generateStickersAndPrint(geradorDeStickers, conteudosFilmes, "Só filme TOPZERA!!");

    String urlNasa = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
    String jsonNasa = httpClient.buscaDados(urlNasa);

    ExtratorConteudo extratorNasa = new ExtratorDeConteudoNasa();
    List<Conteudo> conteudosNasa = extratorNasa.extraiConteudos(jsonNasa);

    generateStickersAndPrint(geradorDeStickers, conteudosNasa, "Só foto LOKA!!");

  }

  private static void generateStickersAndPrint(GeradorDeStickers geradorDeStickers, List<Conteudo> conteudos, String frase)
      throws IOException, MalformedURLException {
    for (Conteudo conteudo : conteudos) {
        InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
        String nomeArquivo = conteudo.getTitulo() + ".png";
        geradorDeStickers.gerarSticker(inputStream, nomeArquivo, frase);
        System.out.println(conteudo);
    }
  }

}
