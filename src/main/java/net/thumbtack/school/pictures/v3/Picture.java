package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Cursor;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.io.Serializable;
import java.util.Objects;

public abstract class Picture implements Movable, Resizable, Serializable {

   private transient PictureFormat format;
    public Picture() {
    }

    public Picture(PictureFormat format) {
        this.format = format;
    }



    public PictureFormat getFormat() {

        return format;
    }

    public void setFormat(PictureFormat format) throws GraphicException {
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        this.format = format;
    }

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return format == picture.format;
    }

    @Override
    public int hashCode() {
        return Objects.hash(format);
    }
}
