import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ClienteHttp {
  
  public String buscaDados(String url) {

    try {
      URI uri = new URI(url);

      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder(uri).build();
      CompletableFuture<HttpResponse<String>> result = client.sendAsync(request, BodyHandlers.ofString());
  
      String body = result.get().body();
      return body;
    } catch ( URISyntaxException | IllegalArgumentException | ExecutionException | InterruptedException e) {
      throw new RuntimeException(e);
    }

   
  }
}
