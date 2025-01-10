package software.ulpgc.images.picsum;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * A utility class to generate random images by fetching them from the Picsum API.
 *
 * <p>The class retrieves 10 random images of size 1000x800 pixels from the Picsum API and returns them as a list of byte arrays.</p>
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public class PicsumImageGenerator {
    public static final String URL = "https://picsum.photos/1000/800";
    /**
     * Fetches 10 random images from the Picsum API.
     *
     * <p>Each image is downloaded and stored as a byte array. The method handles potential
     * exceptions during the download process, and if an error occurs, it returns {@code null}.</p>
     *
     * @return a list of byte arrays, where each byte array represents an image, or {@code null} if an error occurs.
     */
    public static List<byte[]> getRandomImages() {
        List<byte[]> contents = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            try (InputStream urlStream = new URI(URL).toURL().openStream()){
                contents.add(urlStream.readAllBytes());
            } catch(Exception e) {
                return null;
            }
        }
        return contents;
    }
}
