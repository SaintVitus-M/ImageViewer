package software.ulpgc.images.picsum;

import software.ulpgc.images.architecture.io.Deserializer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * A custom deserializer for converting byte arrays into {@link Image} objects.
 * <p>
 * This class implements the {@code Deserializer} interface and provides a
 * method to deserialize byte arrays into {@link Image} instances using the
 * {@link ImageIO} library.
 * </p>
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public class PicsumImageDeserializer implements Deserializer<byte[], Image> {

    /**
     * Deserializes a byte array into an {@link Image} object.
     * <p>
     * This method reads the provided byte array using {@link ImageIO#read(java.io.InputStream)}
     * and returns the resulting {@link Image} object. If the deserialization fails,
     * it throws an {@link IOException} wrapping the original exception.
     * </p>
     *
     * @param bytes the byte array containing the serialized image data.
     * @return the deserialized {@link Image} object.
     * @throws IOException if the deserialization fails or the byte array does not contain valid image data.
     */
    @Override
    public Image deserialize(byte[] bytes) throws IOException {
        try {
            return ImageIO.read(new ByteArrayInputStream(bytes));
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
