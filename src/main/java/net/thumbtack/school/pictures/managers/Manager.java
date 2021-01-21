package net.thumbtack.school.pictures.managers;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.pictures.v3.Picture;
import net.thumbtack.school.pictures.v3.Point;

public class Manager<T extends  Picture> {
    private T picture;

    public Manager (T picture) throws GraphicException {
        super();
        if (picture == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
        this.picture = picture;
    }

    public T getPicture() {
        return picture;
    }

    public void setPicture(T picture) throws GraphicException {
        if (picture == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
        this.picture = picture;
    }
    public void moveTo(int x, int y) throws GraphicException {
        if (picture == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
        this.picture.moveTo(x, y);
    }
    public void moveTo(Point point) throws GraphicException {
        if (picture == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
        this.picture.moveTo(point);
    }

}
