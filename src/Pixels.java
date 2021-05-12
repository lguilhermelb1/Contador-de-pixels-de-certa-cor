import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pixels {

	public static void main(String[] args) {
		int count = 0; //Inicia contador

		BufferedImage img; //Variável da imagem
		
		try {
			img = ImageIO.read(new File("Syngenta.bmp")); //Pega imagem da pasta do arquivo
			int w = img.getWidth(); //Define width da imagem
			int h = img.getHeight(); //Define height da imagem

			for (int x = 0; x < w; x++) { //Percorrer pixel por pixel pelo width
				for (int y = 0; y < h; y++) { //Percorrer pixel por pixel pelo height
					Color cor = new Color(img.getRGB(x, y)); //Guarda o RGB do pixel
					if (cor.getGreen() > 0 && cor.getBlue() < 255 && cor.getRed() < 255) { //Pega a cor verde com RGB blue e red menores que 255 e green maior que 0 para não pegar preto e branco
						count++; //Contador incrementado
					}
				}
			}

			float percent = (float) (count * 100) / (w * h); //Um bônus, para mostrar a porcentagem da imagem que tem os pixels verdes
			System.out.println("Existem " + count + " pixels verdes, uma área equivalente a " + percent + "%"); //Imprime as informações
		} catch (IOException e) {}
	}

}
