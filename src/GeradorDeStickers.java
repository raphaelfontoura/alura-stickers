import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;


public class GeradorDeStickers {


  public void gerarSticker(InputStream inputStream, String nomeArquivo, String frase) throws IOException, IllegalArgumentException {

    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;

    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = novaImagem.createGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);
    Integer fontSize = largura / frase.length();

    Font font = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);
    graphics.setFont(font);
    graphics.setColor(Color.CYAN);
    String imgText = "TOPZERA";
    int positionX = imgText.length() * fontSize / 2;

    graphics.drawString(frase, positionX, novaAltura - 100);

    ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));

  }
}
