package software.ulpgc.images.architecture.model;

import java.awt.*;

/**
 * Represents a navigable picture in a sequence. Provides methods to access the content of the picture,
 * and to navigate to the next or previous picture in the sequence. It also defines a constant {@code None},
 * which represents an empty or non-existent picture.
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public interface Picture {
    /**
     * Returns the content of the picture as an {@link Image}.
     *
     * @return the image content of the picture, or {@code null} if no content exists.
     */
    Image content();
    /**
     * Returns the next picture in the sequence.
     *
     * @return the next {@link Picture} in the sequence, or {@link #None} if no next picture exists.
     */
    Picture next();
    /**
     * Returns the previous picture in the sequence.
     *
     * @return the previous {@link Picture} in the sequence, or {@link #None} if no previous picture exists.
     */
    Picture previous();

    /**
     * A constant {@link Picture} instance representing a non-existent or empty picture.
     * The {@code None} instance provides default implementations where:
     * <ul>
     *   <li>{@link #content()} returns {@code null}.</li>
     *   <li>{@link #next()} returns {@code None}.</li>
     *   <li>{@link #previous()} returns {@code None}.</li>
     * </ul>
     */
    Picture None = new Picture() {
        @Override
        public Image content() {
            return null;
        }

        @Override
        public Picture next() {
            return None;
        }

        @Override
        public Picture previous() {
            return None;
        }
    };
}
