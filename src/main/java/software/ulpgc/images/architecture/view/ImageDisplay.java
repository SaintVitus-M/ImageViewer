package software.ulpgc.images.architecture.view;

import software.ulpgc.images.architecture.control.OnClickListener;
import software.ulpgc.images.architecture.model.Picture;

/**
 * Represents a contract for displaying images and managing navigation buttons.
 * Provides methods to display an image, set listeners for navigation buttons,
 * and reset the display state.
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public interface ImageDisplay {
    /**
     * Displays the given image on the screen.
     *
     * @param image the {@link Picture} object representing the image to display.
     */
    void show(Picture image);
    /**
     * Sets the listener for the "Previous Image" button.
     *
     * @param listener the {@link OnClickListener} to invoke when the "Previous Image" button is clicked.
     */
    void setPreviousImageButtonListener(OnClickListener listener);
    /**
     * Sets the listener for the "Next Image" button.
     *
     * @param listener the {@link OnClickListener} to invoke when the "Next Image" button is clicked.
     */
    void setNextImageButtonListener(OnClickListener listener);
    /**
     * Resets the image display state to its default configuration.
     */
    void reset();
    /**
     * Retrieves the listener currently associated with the "Previous Image" button.
     *
     * @return the {@link OnClickListener} for the "Previous Image" button, or {@code null} if no listener is set.
     */
    OnClickListener previousImageListener();
    /**
     * Retrieves the listener currently associated with the "Next Image" button.
     *
     * @return the {@link OnClickListener} for the "Next Image" button, or {@code null} if no listener is set.
     */
    OnClickListener nextImageListener();
}
