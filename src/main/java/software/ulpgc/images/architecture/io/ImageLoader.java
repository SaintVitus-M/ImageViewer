package software.ulpgc.images.architecture.io;

import software.ulpgc.images.architecture.model.Picture;

/**
 * Interface for loading images.
 * <p>
 * This interface defines a contract for classes that implement image loading functionality.
 * The implementation is expected to provide the logic for loading an image and returning it
 * as a {@link Picture} object.
 * </p>
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public interface ImageLoader {

    /**
     * Loads an image and returns it as a {@link Picture} object.
     * <p>
     * Implementing classes should define the specific logic to load the image, which could
     * involve reading from a file, a URL, or other sources.
     * </p>
     *
     * @return the loaded image as a {@link Picture}.
     */
    Picture load();
}
