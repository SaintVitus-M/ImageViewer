package software.ulpgc.images.architecture.control;

/**
 * Represents a listener for handling click events.
 * This interface provides a method to handle actions when a click is performed.
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public interface OnClickListener {
    /**
     * A default implementation of {@link OnClickListener} that performs no action.
     * This can be used as a placeholder to avoid null checks.
     */
    OnClickListener None = () -> { };

    /**
     * Method to be called when a click event is performed.
     * Implement this method to define the behavior that occurs on a click.
     */
    void clickPerformed();
}
