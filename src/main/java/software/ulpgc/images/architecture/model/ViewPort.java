package software.ulpgc.images.architecture.model;

/**
 * The {@code ViewPort} class represents a rectangular viewport defined by its position
 * (x, y) and dimensions (width, height). It provides methods to fit a given content area
 * (with its own dimensions) into the viewport while maintaining aspect ratio, as well as
 * utilities for creating and manipulating viewports.
 *
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Static factory method {@link #ofSize(int, int)} for creating a viewport with default position (0, 0).</li>
 *   <li>Dynamic resizing methods like {@link #fit(int, int)} to adjust content into the viewport.</li>
 *   <li>Aspect ratio management for scaling and centering content.</li>
 * </ul>
 *
 * @param x      the x-coordinate of the viewport's top-left corner
 * @param y      the y-coordinate of the viewport's top-left corner
 * @param width  the width of the viewport
 * @param height the height of the viewport
 *
 * @version     1.0, 02/01/2025
 * @since       1.0
 */
public record ViewPort(int x, int y, int width, int height) {
    /**
     * Creates a new {@code ViewPort} with the specified width and height,
     * positioned at the origin (0, 0).
     *
     * @param width  the width of the viewport
     * @param height the height of the viewport
     * @return a new {@code ViewPort} instance
     */
    public static ViewPort ofSize(int width, int height) {
        return new ViewPort(0, 0, width, height);
    }

    /**
     * Adjusts the viewport to fit content with the specified width and height
     * while maintaining the aspect ratio. Centers the content within the viewport
     * if it fits; otherwise, scales it to either fit the width or height.
     *
     * @param width  the width of the content
     * @param height the height of the content
     * @return a new {@code ViewPort} instance with adjusted dimensions
     */
    public ViewPort fit(int width, int height) {
        if (canFit(width, height)) return centeredViewPort(width, height);

        return shouldScaleWidth(width, height) ?
                fitToWidthViewPort(width, height) :
                fitToHeightViewPort(width, height);
    }

    // Private helper methods for internal calculations and logic

    private boolean shouldScaleWidth(int width, int height) {
        return ratio(width, height) > viewPortRatio();
    }

    private double viewPortRatio() {
        return ratio(this.width, this.height);
    }

    private static double ratio(double width, double height) {
        return width / height;
    }

    private ViewPort fitToWidthViewPort(int width, int height) {
        return new ViewPort(0, yCenterFor(calculateNewHeight(width, height)), this.width, calculateNewHeight(width, height));
    }

    private ViewPort fitToHeightViewPort(int width, int height) {
        return new ViewPort(xCenterFor(calculateNewWidth(width, height)), 0, calculateNewWidth(width, height), this.height);
    }

    private int calculateNewWidth(int width, int height) {
        return this.height * width / height;
    }

    private int calculateNewHeight(int width, int height) {
        return this.width * height / width;
    }

    private boolean canFit(int width, int height) {
        return width <= this.width && height <= this.height;
    }

    private ViewPort centeredViewPort(int width, int height) {
        return new ViewPort(xCenterFor(width), yCenterFor(height), width, height);
    }

    private int yCenterFor(int height) {
        return (this.height - height) / 2;
    }

    private int xCenterFor(int width) {
        return (this.width - width) / 2;
    }
}
