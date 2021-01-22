package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Cursor;
import net.thumbtack.school.winobjects.v3.Desktop;

public abstract class Picture implements Movable, Resizable {
	// REVU private
    PictureFormat format;


    // REVU есть поле - должен быть конструктор
    public PictureFormat getFormat() {

        return format;
    }

    public void setFormat(PictureFormat format) throws GraphicException {
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        this.format = format;
    }

    // REVU не нужно, есть в Movable
    public abstract void moveTo(int x, int y);

    // REVU не нужно, есть в Movable
    public abstract void moveTo(Point point);

    // REVU не нужно, есть в Movable
    public abstract void moveRel(int dx, int dy);

    // REVU не нужно, есть в Resizable
    public abstract void resize(double ratio);

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    // REVU эти методы не должны быть абстрактными. 
    public abstract boolean equals(Object o);

    public abstract int hashCode();


}
