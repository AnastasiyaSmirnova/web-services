package itmo.web_services;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageUtils {
    private static final String imageFormat = "JPG";

    public static String encodeToString(String path) {
        String imageString = null;
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try {
            ImageIO.write(getBufferedImage(path), imageFormat, os);
            byte[] imageBytes = os.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();

            imageString = encoder.encode(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    private static BufferedImage getBufferedImage(String path) throws IOException {
        return ImageIO.read(new File(path));
    }
}
