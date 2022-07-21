import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

  private static String urlImagem;

  public static void main(String[] args) throws Exception {

    String url = "https://api.mocki.io/v2/549a5d8b";

    var httpClient = new ClienteHttp();
    String json = httpClient.buscaDados(url);

    ExtratorConteudo extratorFilmes = new ExtratorDeConteudoIMDB();
    List<Conteudo> conteudosFilmes = extratorFilmes.extraiConteudos(json);

    GeradorDeStickers geradorDeStickers = new GeradorDeStickers();

    for (Conteudo item : conteudosFilmes) {
      InputStream inputStream = new URL(item.getUrlImagem()).openStream();
      String nomeArquivo = item.getTitulo() + ".png";
      geradorDeStickers.gerarSticker(inputStream, nomeArquivo, "Só Filme TOPZERA!!");
      System.out.println(item);
    }

  }

}
