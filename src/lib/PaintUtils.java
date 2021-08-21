package lib;


import java.awt.*;

public class PaintUtils {
    public static final int FIELD_INNER_SIZE = 60;
    public static final int FIELD_BORDER_THICKNESS = 4;
    public static final int FIELD_INNER_OFFSET = 4;
    public static final int BOARD_OFFSET = 20;

    public PaintUtils() {
    }

    public static Point getBoardSize(KarelWorld world) {
        int w = 4 * (world.getWidth() + 1) + 60 * world.getWidth();
        int h = 4 * (world.getHeight() + 1) + 60 * world.getHeight();
        return new Point(w, h);
    }

    protected static Point getUpperLeftCornerInField(FieldEntity ce, int worldHeight) {
        int y_m = Math.abs(ce.getY() - worldHeight + 1);
        int width = 24;
        int height = 24;
        width = width + ce.getX() * 64;
        height = height + y_m * 64;
        width += 4;
        height += 4;
        return new Point(width, height);
    }
}
