package ua.edu.uzhnu.biks.training.task3.images;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Утилітний клас із допоміжними методами для роботи зі зображеннями
 */
public class ImageTools {

    /**
     * Створює чорно-біле зображення у пам’яті із заданого двовимірного масиву точок у форматі <code>data[y][x]</code>,
     * де <code>(0, 0)</code> є точкою у верхньому лівому куті. Значення кожної точки відповідає інтенсивності свічення
     * білого, де 0 - чорний, 255 - білий.
     *
     * @param data двовимірний масив чисел у діапазоні 0-255
     * @return об’єкт-зображення у пам’яті
     */
    public static BufferedImage createImage(int[][] data) {
        BufferedImage img = new BufferedImage(data[0].length, data.length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] < 0) {
                    data[i][j] = 0;
                }
                if (data[i][j] > 255) {
                    data[i][j] = 255;
                }
                int rgb = new Color(data[i][j], data[i][j], data[i][j]).getRGB();
                img.setRGB(j, i, rgb);
            }
        }

        return img;
    }

    /**
     * Записує дане зображення у файл із заданою назвою у форматі png
     *
     * @param img      Об’єкт-зображення
     * @param filename Назва файлу із розширенням (указуйте <code>.png</code> в кінці)
     */
    public static void writeImage(BufferedImage img, String filename) {
        String dir = System.getProperty("user.dir");
        try {
            File file = new File(dir, filename);
            ImageIO.write(img, "png", file);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Не вдалось записати файл " + filename);
        }
    }

    /**
     * Читає зображення у пам’ять із файлу
     *
     * @param filename Назва файлу із розширенням
     * @return Об’єкт-зображення
     */
    public static BufferedImage readImage(String filename) {
        BufferedImage img = null;
        File file;
        try {
            file = new File(filename);
            img = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("Не вдалось прочитати файл " + filename);
            System.exit(0);
        }
        return img;
    }

    /**
     * Створює чорно-білу (256 відтінків сірого) копію зображення у вигляді двовимірного масиву
     * <code>int[висота][ширина]</code>. Значення кожної точки відповідає інтенсивності свічення
     * білого, де 0 - чорний, 255 - білий.
     *
     * @param img об’єкт-зображення
     * @return двовимірний масив, що кодує зображення відтінками сірого
     */
    public static int[][] getImageData(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();

        int[][] data = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Color c = new Color(img.getRGB(j, i));
                int gVal = mapToGray(c);
                data[i][j] = gVal;
            }
        }
        return data;
    }

    /**
     * Обчислює суб’єктивну яскравість кольору у ч/б діапазоні 0-255.
     *
     * @param c колір, що зводиться до відтінку сірого
     * @return відповідний відтінок сірого (значення інтенсивності у діапазоні 0-255)
     */
    private static int mapToGray(Color c) {
        int r = c.getRed();
        int g = c.getGreen();
        int b = c.getBlue();
        return (int) (0.299 * r + 0.587 * g + 0.114 * b);
    }

}
