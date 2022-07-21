public class Conteudo {

  private final String titulo;
  private final String urlImagem;

  public Conteudo(String titulo, String urlImage) {
    this.titulo = titulo;
    this.urlImagem = urlImage;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getUrlImagem() {
    return urlImagem;
  }

  @Override
  public String toString() {

    String result = "";
    result += String.format("Título: \u001b[1m%s\u001b[m", titulo) + System.lineSeparator();
    result += String.format("Poster: \u001b[3m%s\u001b[m", urlImagem) + System.lineSeparator();

    return result;
  }
}
