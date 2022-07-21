public class ConteudoFilme extends Conteudo {

  private final Double imdbRating;

  public ConteudoFilme(String titulo, String urlImage, Double imdbRating ) {
    super(titulo, urlImage);
    this.imdbRating = imdbRating;
  }

  @Override
  public String getTitulo() {
    return super.getTitulo();
  }

  @Override
  public String getUrlImagem() {
    return super.getUrlImagem();
  }
  
  public Double getImdbRating() {
    return imdbRating;
  }
  
  @Override
  public String toString() {
    var stars = "";
    for (int i = 1; i <= imdbRating; i++) {
      stars += "\u2b50";
    }

    String result = "";
    result += String.format("Título: \u001b[1m%s\u001b[m", super.getTitulo()) + System.lineSeparator();
    result += String.format("Poster: \u001b[3m%s\u001b[m", super.getUrlImagem()) + System.lineSeparator();
    result += String.format("\u001b[36;1mClassificação: \u001b[1m%.1f\u001b[m", imdbRating) + System.lineSeparator();
    result += stars;

    return result;
  }
}
