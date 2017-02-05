package task3.images;

import java.awt.image.BufferedImage;
import java.awt.Color;

public class ImageApp {

	public static final String IMAGE_PATH = System.getProperty("user.dir") + "/src/task3/images/fizfak.png";

	private static void makeImageOneA() {
        int[][] data = new int[256][256];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = i;
            }
        }
        ImageTools.writeImage(ImageTools.createImage(data), "gradient-vert.png");
	}

	private static void makeImageOneB() {
        int[][] data = new int[256][256];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = 255 - j;
            }
        }
        ImageTools.writeImage(ImageTools.createImage(data), "gradient-horiz.png");
	}

	private static void makeImageOneC() {
        int[][] data = new int[256][256];
        for (int i = 0; i < 128; i++) {
            for (int j = 128; j < 256; j++) {
                data[i][j] = 255;
            }
        }
        for (int i = 128; i < 256; i++) {
            for (int j = 0; j < 128; j++) {
                data[i][j] = 255;
            }
        }
        ImageTools.writeImage(ImageTools.createImage(data), "tiles-2.png");
    }

	private static void makeImageOneD() {
        int[][] data = new int[256][256];
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                if (((i / 16 + j / 16) & 1) != 0) {
                    data[i][j] = 255;
                }
            }
        }
        ImageTools.writeImage(ImageTools.createImage(data), "tiles-16.png");
	}

	private static void makeImageTwoA() {
        BufferedImage image = ImageTools.readImage(IMAGE_PATH);
        int[][] data = ImageTools.getImageData(image);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = data[i][j] < 128 ? 0 : 255;
            }
        }
        BufferedImage output = ImageTools.createImage(data);
        ImageTools.writeImage(output, "fizfak-2colors.png");
	}

	private static void makeImageTwoB() {
        BufferedImage image = ImageTools.readImage(IMAGE_PATH);
        int[][] data = ImageTools.getImageData(image);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = 255 - data[i][j];
            }
        }
        BufferedImage output = ImageTools.createImage(data);
        ImageTools.writeImage(output, "fizfak-inverted-bw.png");
	}

	private static void makeImageTwoC() {
        BufferedImage image = ImageTools.readImage(IMAGE_PATH);
        int[][] data = ImageTools.getImageData(image);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                Color c = new Color(image.getRGB(j, i));
                image.setRGB(j, i, new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue()).getRGB());
            }
        }
        ImageTools.writeImage(image, "fizfak-inverted-color.png");
	}

	private static void makeImageThree() {
        BufferedImage image = ImageTools.readImage(IMAGE_PATH);
        int[][] srcData = ImageTools.getImageData(image);
        int[][] destData = new int[srcData.length][srcData[0].length];
        for (int i = 1; i < srcData.length - 1; i++) {
            for (int j = 1; j < srcData[0].length - 1; j++) {
                destData[i][j] = 8 * srcData[i][j]
                        - srcData[i-1][j-1] - srcData[i][j] - srcData[i+1][j+1]
                        - srcData[i-1][j-1] - srcData[i][j] - srcData[i+1][j+1]
                        - srcData[i-1][j-1] - srcData[i][j] - srcData[i+1][j+1];
                destData[i][j] = (destData[i][j] + 512) * 256 / 768;
            }
        }
        ImageTools.writeImage(ImageTools.createImage(destData), "fizfak-edge.png");
	}

    public static void main(String[] args) {
        makeImageOneA();
        makeImageOneB();
        makeImageOneC();
        makeImageOneD();
        makeImageTwoA();
        makeImageTwoB();
        makeImageTwoC();
        makeImageThree();
    }

}
