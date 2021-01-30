package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.util.Objects;


public class RectPicture extends Picture {
    private Point topLeft;
    private Point bottomRight;

    // REVU сделайте конструктор в родительском классе с параметром PictureFormat и вызывайте его через super
    public RectPicture(Point topLeft, Point bottomRight, PictureFormat format) {
        super(format);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public RectPicture(Point topLeft, Point bottomRight, String sFormat) throws GraphicException {
        this(topLeft, bottomRight, PictureFormat.fromString(sFormat));
    }

    public RectPicture(int xLeft, int yTop, int width, int height, PictureFormat format) throws GraphicException {
        this(xLeft, yTop, width, height);
        this.setFormat(format);
    }

    public RectPicture(int xLeft, int yTop, int width, int height, String sFormat) throws GraphicException {
        this(xLeft, yTop, width, height, PictureFormat.fromString(sFormat));
        }


    public RectPicture(Point topLeft, Point bottomRight) {
        this(topLeft, bottomRight,PictureFormat.GIF);
    }

    public RectPicture(int xLeft, int yTop, int width, int height) {
        this(new Point(xLeft, yTop), new Point(xLeft + width - 1, yTop + height - 1),PictureFormat.GIF);
    }

    public Point getTopLeft() {

        return topLeft;
    }

    public Point getBottomRight() {

        return bottomRight;
    }

    public PictureFormat getFormat() {
       return super.getFormat();
    }

    public void setTopLeft(Point topLeft) {

        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {

        this.bottomRight = bottomRight;
    }

    public int getWidth() {

        return bottomRight.getX() - topLeft.getX() + 1;
    }

    public int getHeight() {

        return  bottomRight.getY() - topLeft.getY() + 1;
    }

    public void moveTo(int x, int y) {
        this.bottomRight.setX(x + this.getWidth() - 1);
        this.bottomRight.setY(y + this.getHeight() - 1);
        this.topLeft = new Point(x, y);
    }

    @Override
    public void moveTo(Point point) {
        this.bottomRight.setX(point.getX() + this.getWidth() - 1);
        this.bottomRight.setY(point.getY() + this.getHeight() -1);
        this.setTopLeft(point);
    }


    public void moveRel(int dx, int dy) {
        this.topLeft.setX(this.topLeft.getX() + dx);
        this.topLeft.setY(this.topLeft.getY() + dy);
        this.bottomRight.setX(this.bottomRight.getX() + dx);
        this.bottomRight.setY(this.bottomRight.getY() + dy);
    }

    public void resize(double ratio) {
        int resizeWidth = (int) (this.getWidth() * ratio);
        int resizeHeight = (int) (this.getHeight() * ratio);
        this.bottomRight.setX((int) (this.topLeft.getX() + resizeWidth) - 1);
        this.bottomRight.setY((int) (this.topLeft.getY() + resizeHeight) - 1);
        if (this.getHeight() < 1) {
            this.bottomRight.setY(this.topLeft.getY());
        }
        if (this.getWidth() < 1) {
            this.bottomRight.setX(this.topLeft.getX());
        }
    }

    public boolean isInside(int x, int y) {
        if (this.bottomRight.getX() < x || this.topLeft.getX() > x || this.bottomRight.getY() < y || this.topLeft.getY() > y) {
            return false;
        }
        return true;
    }

    public boolean isInside(Point point) {
        if (point.getX() < this.topLeft.getX() || point.getX() > this.bottomRight.getX() || this.bottomRight.getY() < point.getY() || this.topLeft.getY() > point.getY()) {
            return false;
        }
        return true;
    }


    public boolean isIntersects(RectPicture rectPicture) {
        if (rectPicture.bottomRight.getY() < this.topLeft.getY() || rectPicture.topLeft.getY() > this.bottomRight.getY()) {
            return false;
        }
        if (rectPicture.bottomRight.getX() < this.topLeft.getX() || rectPicture.topLeft.getX() > this.bottomRight.getX()) {
            return false;
        }
        return true;
    }

    public boolean isInside(RectPicture rectPicture) {
        if (rectPicture.bottomRight.getY() > this.bottomRight.getY() || rectPicture.topLeft.getX() < this.topLeft.getX()) {
            return false;
        }
        if (rectPicture.topLeft.getY() < this.topLeft.getY() || rectPicture.bottomRight.getX() > this.bottomRight.getX()) {
            return false;
        }
        return true;
    }
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if (this.getWidth() > desktop.getWidth() || this.getHeight() > desktop.getHeight()) {
            return false;
        }
        if (this.topLeft.getX() + this.getWidth() > desktop.getWidth() || this.topLeft.getX() < 0) {
            return false;
        }
        if (this.topLeft.getY() + this.getHeight() > desktop.getHeight() || this.topLeft.getY() < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RectPicture that = (RectPicture) o;
        return Objects.equals(topLeft, that.topLeft) &&
                Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topLeft, bottomRight);
    }
}

