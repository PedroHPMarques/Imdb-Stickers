import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinha {
    public void cria(InputStream inputStream,String nomeArquivo) throws Exception{
        /* Leitura da imagem baixando a foto em png e criando um diretorio

        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme-maior.jpg"));

        /* */

        //leitura da imagem pegando url direto da internet
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem com transparencia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura,novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original pra nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //configurar a font
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem
        graphics.drawString("Malvadao", 150, novaAltura - 100);

       

        //escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }    
}
