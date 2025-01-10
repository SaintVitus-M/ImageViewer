package software.ulpgc.images.picsum;

import software.ulpgc.images.architecture.io.Deserializer;
import software.ulpgc.images.architecture.io.ImageLoader;
import software.ulpgc.images.architecture.model.Picture;

import java.awt.*;
import java.util.List;

/**
 * A loader for fetching and navigating through images generated by the PicsumImageGenerator.
 * This loader deserializes image data into {@link Image} objects and supports navigation
 * between images in a sequence.
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public class PicsumImageLoader implements ImageLoader {
    private final Deserializer<byte[], Image> deserializer;
    private final List<byte[]> images;

    /**
     * Constructs a new {@code PicsumImageLoader}.
     * Initializes the image list with random images from {@link PicsumImageGenerator}
     * and sets up the deserializer with a {@link PicsumImageDeserializer}.
     */
    public PicsumImageLoader() {
        this.images = PicsumImageGenerator.getRandomImages();
        this.deserializer = new PicsumImageDeserializer();
    }

    /**
     * Loads the first {@link Picture} in the image list.
     *
     * @return the first {@link Picture}.
     */

    @Override
    public Picture load() {
        return imageAt(0);
    }

    /**
     * Retrieves a {@link Picture} at the specified index within the image list.
     * The returned {@link Picture} provides methods to access its content and navigate
     * to the next or previous pictures in the sequence.
     *
     * @param index the index of the desired image in the list.
     * @return a {@link Picture} representing the image at the specified index.
     */
    private Picture imageAt(int index) {
        byte[] current = images.get(index);
        return new Picture() {
            @Override
            public Image content() {
                try {
                    return deserializer.deserialize(current);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public Picture next() {
                return imageAt(nextIndex());
            }

            @Override
            public Picture previous() {
                return imageAt(previousIndex());
            }

            private int nextIndex() {return (index + 1) % images.size();}

            private int previousIndex() {return index > 0 ? index - 1 : images.size() - 1;}
        };
    }
}
