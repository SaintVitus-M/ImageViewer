package software.ulpgc.images.architecture.presenter;

import software.ulpgc.images.architecture.io.ImageLoader;

/**
 * Represents an entity capable of presenting an image using a provided {@link ImageLoader}.
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public interface ImagePresenter {
    /**
     * Displays the image using the specified {@link ImageLoader}.
     *
     * @param loader the {@link ImageLoader} responsible for loading and providing the image to display
     */
    void showWith(ImageLoader loader);
}
