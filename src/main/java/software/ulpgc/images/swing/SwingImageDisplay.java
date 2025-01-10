package software.ulpgc.images.swing;

import software.ulpgc.images.architecture.control.OnClickListener;
import software.ulpgc.images.architecture.model.Picture;
import software.ulpgc.images.architecture.model.ViewPort;
import software.ulpgc.images.architecture.view.ImageDisplay;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel that displays an image and allows navigation between images using previous and next buttons.
 * Implements the {@link ImageDisplay} interface to provide a custom image display with basic navigation functionality.
 * The class supports listeners for the previous and next image buttons.
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Picture currentImage;
    private OnClickListener previousImageListener = OnClickListener.None;
    private OnClickListener nextImageListener = OnClickListener.None;

    /**
     * Displays the given picture on the panel.
     *
     * @param picture the {@link Picture} to be displayed
     */
    @Override
    public void show(Picture picture) {
        currentImage = picture;
        repaint();
    }

    /**
     * Resets the display, removing the current image and listeners.
     * Sets the picture to {@link Picture#None}.
     */
    @Override
    public void reset() {
        previousImageListener = OnClickListener.None;
        nextImageListener = OnClickListener.None;
        show(Picture.None);
    }


    /**
     * Sets the listener for the previous image button.
     *
     * @param listener the {@link OnClickListener} to be called when the previous image button is clicked
     */
    @Override
    public void setPreviousImageButtonListener(OnClickListener listener) {
        previousImageListener = listener;
    }

    /**
     * Sets the listener for the next image button.
     *
     * @param listener the {@link OnClickListener} to be called when the next image button is clicked
     */
    @Override
    public void setNextImageButtonListener(OnClickListener listener) {
        nextImageListener = listener;
    }

    /**
     * Paints the current image on the panel.
     *
     * @param g the {@link Graphics} object used to draw the image
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(0,0, getWidth(), getHeight());
        draw(currentImage.content(), g);
    }

    /**
     * Draws the given image on the panel using a suitable viewport.
     *
     * @param image the {@link Image} to be drawn
     * @param g     the {@link Graphics} object used to draw the image
     */
    private void draw(Image image, Graphics g) {
        ViewPort viewPort = adaptViewportTo(image);
        g.drawImage(image,
                viewPort.x(),
                viewPort.y(),
                viewPort.width(),
                viewPort.height(),
                null);
    }

    /**
     * Adapts the viewport to fit the given image dimensions.
     *
     * @param image the {@link Image} to be fitted
     * @return the {@link ViewPort} that fits the image within the panel dimensions
     */
    private ViewPort adaptViewportTo(Image image) {
        return ViewPort.ofSize(this.getWidth(), this.getHeight())
                .fit(image.getWidth(null),
                        image.getHeight(null)
                );
    }

    /**
     * Returns the listener for the previous image button.
     *
     * @return the {@link OnClickListener} for the previous image button
     */
    @Override
    public OnClickListener previousImageListener() {
        return previousImageListener;
    }

    /**
     * Returns the listener for the next image button.
     *
     * @return the {@link OnClickListener} for the next image button
     */
    @Override
    public OnClickListener nextImageListener() {
        return nextImageListener;
    }
}
