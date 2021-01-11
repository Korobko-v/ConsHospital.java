package net.thumbtack.school.pictures.v2;

public class PictureFactory {
    Point leftTop;
    Point rightBottom;
    int format;
    static int rectPictureCount = 0;

    Point center;
    int radius;
    static int roundPictureCount = 0;

    static int pictureCount = 0;

    public static RectPicture createRectPicture(Point leftTop, Point rightBottom, int format) {
        rectPictureCount++;
        pictureCount++;
        return new RectPicture(leftTop, rightBottom, format);
    }

    public static RoundPicture createRoundPicture(Point center, int radius, int format) {
        roundPictureCount++;
        pictureCount++;
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
