import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.ResponseInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class App {
    private static Builder newBuilder;
    private static CompletableFuture<HttpResponse<String>> result;
    private static String body;
    private static String formatTitle;

    public static void main(String[] args) throws Exception {

        // recuperar os dados do imdb-api.com com os top 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b";

        URI uri = new URI(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).build();
        CompletableFuture<HttpResponse<String>> result = client.sendAsync(request , BodyHandlers.ofString());

        String body = result.get().body();

        // extrair só os dados que interessam (título, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
          var title = filme.get("title");
          var image = filme.get("image");
          var imDbRating = Double.parseDouble(filme.get("imDbRating"));
          
          var formatTitle = String.format("Título: \u001b[1m%s\u001b[m", title);
          var formatImage = String.format("Poster: \u001b[3m%s\u001b[m", image);
          var rating = String.format("\u001b[36;1mClassificação: \u001b[1m%.1f\u001b[m", imDbRating);
          var stars = "";
          for (int i = 1; i <= imDbRating; i++) {
            stars += "\u2b50";
          }

          System.out.println(formatTitle);
          System.out.println(formatImage);
          System.out.println(rating);
          System.out.println(stars);

          System.out.println();
        }

    }

}
