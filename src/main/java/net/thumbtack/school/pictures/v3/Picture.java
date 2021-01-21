package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Cursor;
import net.thumbtack.school.winobjects.v3.Desktop;

public abstract class Picture implements Movable, Resizable {
    PictureFormat format;


    public PictureFormat getFormat() {

        return format;
    }

    public void setFormat(PictureFormat format) throws GraphicException {
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        this.format = format;
    }

    public abstract void moveTo(int x, int y);

    public abstract void moveTo(Point point);

    public abstract void moveRel(int dx, int dy);

    public abstract void resize(double ratio);

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    public abstract boolean equals(Object o);

    public abstract int hashCode();


}
