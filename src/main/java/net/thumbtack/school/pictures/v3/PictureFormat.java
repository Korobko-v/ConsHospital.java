package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;

public enum PictureFormat {
    TIFF,
    GIF,
    PNG,
    JPG;

    public static PictureFormat fromString(String formatString) throws GraphicException {

        try {
            return PictureFormat.valueOf(formatString);
        } catch (IllegalArgumentException ex) {
            throw new GraphicException(GraphicErrorCode.WRONG_PICTURE_FORMAT);
        }
    }
}

