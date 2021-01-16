package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.util.Objects;

public class RoundPicture extends Picture implements Movable, Resizable {
    private Point center;
    private int radius;
    private PictureFormat format;
    private String sFormat;

    public RoundPicture(Point center, int radius, PictureFormat format) throws GraphicException {
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        this.center = center;
        this.radius = radius;
        this.format = format;
    }
    public RoundPicture(Point center, int radius, String sFormat) throws GraphicException {
        this.center = center;
        this.radius = radius;
        try {
            this.format = PictureFormat.fromString(sFormat);

        } catch (IllegalArgumentException ex) {
            throw new GraphicException(GraphicErrorCode.WRONG_PICTURE_FORMAT);
        }
    }

    public RoundPicture(int xCenter, int yCenter, int radius, PictureFormat format) throws GraphicException {
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }

        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
        this.format = format;
    }
    public RoundPicture(int xCenter, int yCenter, int radius, String sFormat) throws GraphicException {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
        try {
            this.format = PictureFormat.fromString(sFormat);

        } catch (IllegalArgumentException ex) {
            throw new GraphicException(GraphicErrorCode.WRONG_PICTURE_FORMAT);
        }
        catch (NullPointerException e) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
    }
    public RoundPicture(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.format = PictureFormat.GIF;
    }
    public RoundPicture(int xCenter, int yCenter, int radius) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
        this.format = PictureFormat.GIF;
    }
    public Point getCenter() {

        return center;
    }
    public int getRadius() {

        return radius;
    }
    public PictureFormat getFormat() {

        return format;
    }
    public void moveTo(int x, int y) {
        this.center.setX(x);
        this.center.setY(y);
    }

    @Override
    public void moveTo(Point point) {
        this.center.setX(point.getX());
        this.center.setY(point.getY());
    }

    public void setCenter(int x, int y) {

        this.center = new Point(x, y);
    }
    public void setRadius(int radius) {

        this.radius = radius;
    }
    public void setFormat(PictureFormat format) {

        this.format = format;
    }
    public void moveRel(int dx, int dy) {
        this.center.setX(this.center.getX() + dx);
        this.center.setY(this.center.getY() + dy);
    }
    public void resize(double ratio) {
        this.radius = (int) (this.radius * ratio);
        if (this.radius < 1) {
            this.radius = 1;
        }
    }
    public boolean isInside(int x, int y) {
        if (Math.pow(this.center.getX() - x, 2) + Math.pow(this.center.getY() - y, 2) > Math.pow(this.radius, 2)) {
            return false;
        }
        return true;
    }
    public boolean isInside(Point point) {
        if (Math.pow(this.center.getX() - point.getX(), 2) + Math.pow(this.center.getY() - point.getY(), 2) > Math.pow(this.radius, 2)) {
            return false;
        }
        return true;
    }
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        if (this.center.getX() + this.getRadius() >= desktop.getWidth() || this.center.getY() + this.getRadius() >= desktop.getHeight()) {
            return false;
        }
        if (this.center.getX() - this.getRadius() < 0 || this.center.getY() - this.getRadius() < 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundPicture that = (RoundPicture) o;
        return radius == that.radius &&
                format == that.format &&
                Objects.equals(center, that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, format);
    }
}