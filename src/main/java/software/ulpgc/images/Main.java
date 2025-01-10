package software.ulpgc.images;

import software.ulpgc.images.architecture.io.ImageLoader;
import software.ulpgc.images.picsum.PicsumImagePresenter;
import software.ulpgc.images.picsum.PicsumImageLoader;
import software.ulpgc.images.swing.SwingImageDisplay;
import software.ulpgc.images.swing.SwingMainFrame;

public class Main {
    public static void main() {

        SwingImageDisplay imageDisplay = new SwingImageDisplay();
        SwingMainFrame mainFrame = new SwingMainFrame(imageDisplay);
        PicsumImagePresenter presenter = new PicsumImagePresenter(imageDisplay);
        ImageLoader loader = new PicsumImageLoader();
        presenter.showWith(loader);
        mainFrame.setVisible(true);
    }
}