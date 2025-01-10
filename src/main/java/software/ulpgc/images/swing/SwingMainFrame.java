package software.ulpgc.images.swing;

import javax.swing.*;
import java.awt.*;

/**
 * SwingMainFrame is the main window of the image viewer application.
 * It extends {@link javax.swing.JFrame} and provides the basic GUI layout
 * to display images along with navigation buttons for browsing through images.
 *
 * <p>This class sets up the main frame with a title, layout, and adds an image display component
 * along with navigation buttons (Previous and Next) at the bottom of the frame.</p>
 *
 * <p>The navigation buttons allow the user to move through images using the {@link SwingImageDisplay} component.</p>
 *
 * <p>This frame is intended to be used as part of an image viewer application.</p>
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 * @see SwingImageDisplay
 */
public class SwingMainFrame extends JFrame {
    private final SwingImageDisplay imageDisplay;

    /**
     * Constructs a new {@code SwingMainFrame} with the specified {@link SwingImageDisplay}.
     *
     * @param display the {@link SwingImageDisplay} component to display the images.
     * @throws HeadlessException if the environment does not support a display or keyboard.
     */
    public SwingMainFrame(SwingImageDisplay display) throws HeadlessException {
        setTitle("Image Viewer");
        setSize(1000, 800);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(imageDisplay = display, BorderLayout.CENTER);
        add(createBottomPane(), BorderLayout.SOUTH);
    }

    /**
     * Creates the bottom pane with navigation buttons for image navigation.
     *
     * @return a {@link Component} containing the navigation buttons.
     */
    private Component createBottomPane() {
        JPanel buttonPane = new JPanel();
        JButton previous = new JButton("Previous");
        previous.addActionListener(_ -> imageDisplay.previousImageListener().clickPerformed());
        JButton next = new JButton("Next");
        next.addActionListener(_ -> imageDisplay.nextImageListener().clickPerformed());
        buttonPane.add(previous);
        buttonPane.add(next);
        return buttonPane;
    }
}
