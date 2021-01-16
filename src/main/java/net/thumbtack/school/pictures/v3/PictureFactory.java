package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;

public class PictureFactory {
    Point leftTop;
    Point rightBottom;
    PictureFormat format;
    static int rectPictureCount = 0;

    Point center;
    int radius;
    static int roundPictureCount = 0;

    static int pictureCount = 0;

    public static RectPicture createRectPicture(Point leftTop, Point rightBottom, PictureFormat format) throws GraphicException {
        rectPictureCount++;
        pictureCount++;
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        return new RectPicture(leftTop, rightBottom, format);
    }

    public static RoundPicture createRoundPicture(Point center, int radius, PictureFormat format) throws GraphicException {
        roundPictureCount++;
        pictureCount++;
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        return new RoundPicture(center, radius, format);
    }
    public static int getRectPictureCount() {

        return rectPictureCount;
    }
    public static int getRoundPictureCount() {

        return roundPictureCount;
    }
    public static int getPictureCount() {

        return  pictureCount++;
    }
    public static void reset() {
        rectPictureCount = 0;
        roundPictureCount = 0;
        pictureCount = 0;
    }
}
