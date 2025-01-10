package software.ulpgc.images.architecture.io;

import java.io.IOException;

/**
 * A functional interface for deserializing data from a source type to a target type.
 *
 * @param <Source> the type of the input data to be deserialized
 * @param <Target> the type of the resulting deserialized object
 *
 * @author      Vít Mikula
 * @version     1.0, 10/01/2025
 * @since       1.0
 */
public interface Deserializer<Source, Target> {

    /**
     * Deserializes the given input of type {@code Source} into an object of type {@code Target}.
     *
     * @param input the source data to be deserialized
     * @return the deserialized object of type {@code Target}
     * @throws IOException if an I/O error occurs during deserialization
     */
    Target deserialize(Source input) throws IOException;
}
