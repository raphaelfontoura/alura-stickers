import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorConteudo{

  @Override
  public List<Conteudo> extraiConteudos(String json) {
    var parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();

    for (Map<String, String> item: listaDeAtributos) {
      String titulo = item.get("title");
      String urlImage = item.get("image");
      Double imdbRating = Double.parseDouble(item.get("imDbRating"));
      var conteudo = new ConteudoFilme(titulo, urlImage, imdbRating);
      conteudos.add(conteudo);
    }

    return conteudos;

  }
  
}
