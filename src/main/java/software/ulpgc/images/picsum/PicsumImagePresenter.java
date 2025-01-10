package software.ulpgc.images.picsum;

import software.ulpgc.images.architecture.io.ImageLoader;
import software.ulpgc.images.architecture.model.Picture;
import software.ulpgc.images.architecture.presenter.ImagePresenter;
import software.ulpgc.images.swing.SwingImageDisplay;

/**
 * The {@code PicsumImagePresenter} class implements the {@link ImagePresenter} interface
 * to handle the presentation logic for displaying images using a {@link SwingImageDisplay}.
 * It integrates with an {@link ImageLoader} to load and display images, and manages navigation
 * through previous and next images.
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public class PicsumImagePresenter implements ImagePresenter {
    private final SwingImageDisplay imageDisplay;
    private Picture currentImage;

    /**
     * Constructs a {@code PicsumImagePresenter} with the specified {@link SwingImageDisplay}.
     *
     * @param imageDisplay the display component for showing images
     */
    public PicsumImagePresenter(SwingImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    /**
     * Loads and displays images using the specified {@link ImageLoader}.
     * It also sets up navigation controls for viewing previous and next images.
     *
     * @param loader the {@link ImageLoader} used to load images
     */
    @Override
    public void showWith(ImageLoader loader) {
        imageDisplay.reset();
        show(loader.load());
        imageDisplay.setPreviousImageButtonListener(() -> show(currentImage.previous()));
        imageDisplay.setNextImageButtonListener(() -> show(currentImage.next()));
    }

    /**
     * Displays the specified {@link Picture} on the {@link SwingImageDisplay}.
     *
     * @param picture the {@link Picture} to display
     */
    private void show(Picture picture) {
        imageDisplay.show(currentImage = picture);
    }
}
