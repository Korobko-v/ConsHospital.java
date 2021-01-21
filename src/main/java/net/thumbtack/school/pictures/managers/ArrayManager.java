package net.thumbtack.school.pictures.managers;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.pictures.v3.Picture;
import net.thumbtack.school.pictures.v3.Point;
import net.thumbtack.school.winobjects.v3.Cursor;
import net.thumbtack.school.winobjects.v3.Desktop;

public class ArrayManager <T extends Picture>   {
    private Picture[] objects;

    public ArrayManager(Picture[] objects) throws GraphicException {

        for (Picture t : objects) {
            if (t == null) {
                throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
            }
        }
            this.objects = getPictures(objects);
    }

    public Picture[] getPictures(Picture[] objects) throws GraphicException {
        for (Picture t : objects) {
            if (t == null) {
                throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
            }
        }
        return objects;
    }
    public void setPictures(Picture[]objects) throws GraphicException {
        for (Picture t : objects) {
            if (t == null) {
                throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
            }
        }
        this.objects = (Picture[]) objects;
    }
    public Picture getPicture(int i) throws GraphicException {
        for (Picture t : objects) {
            if (t == null) {
                throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
            }
        }
        return objects[i];
    }
    public void setPicture (Picture picture, int i) throws GraphicException {
            if (picture == null) {
                throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
            }
        objects[i] = picture;
    }

    public boolean isSameSize(ArrayManager<? extends Picture> pictures) {
        return (this.objects.length == pictures.objects.length);
    }

    public boolean allPicturesFullyVisibleOnDesktop(Desktop desktop) {
        for (Picture t : objects) {
            if (!t.isFullyVisibleOnDesktop(desktop)) {
                return false;
            }
        }
        return true;
    }

    public boolean anyPictureFullyVisibleOnDesktop(Desktop desktop) {
        for (Picture t : objects) {
            if (t.isFullyVisibleOnDesktop(desktop)) {
                return true;
            }
        }
        return false;
    }
    public Picture getFirstPictureFromCursor(Cursor cursor) {
        for (Picture pic : objects) {
            Point point = new Point(cursor.getX(), cursor.getY());
            if (pic.isInside(point)) {
                return pic;
            }
        }
        return null;
    }


}
