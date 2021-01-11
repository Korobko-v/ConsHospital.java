package net.thumbtack.school.pictures.v2;

import net.thumbtack.school.iface.v2.Signed;
import net.thumbtack.school.winobjects.v2.Desktop;

public class SignedRectPicture extends RectPicture implements Signed {
    private String signature;

    public SignedRectPicture(Point topLeft, Point bottomRight, int format, String signature) {
        super(topLeft, bottomRight, format);
        this.signature = signature;
    }

    public SignedRectPicture(int xLeft, int yTop, int width, int height, int format, String signature) {
        super(xLeft, yTop, width, height, format);
        this.signature = signature;
    }

    public SignedRectPicture(Point topLeft, Point bottomRight, String signature) {
        super(topLeft, bottomRight);
        this.signature = signature;
    }

    public SignedRectPicture(int xLeft, int yTop, int width, int height, String signature) {
        super(xLeft, yTop, width, height);
        this.signature = signature;
    }


    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public Point getTopLeft() {

        return super.getTopLeft();
    }

    @Override
    public Point getBottomRight() {

        return super.getBottomRight();
    }

    @Override
    public int getFormat() {

        return super.getFormat();
    }

    @Override
    public void setTopLeft(Point topLeft) {

        super.setTopLeft(topLeft);
    }

    @Override
    public void setBottomRight(Point bottomRight) {

        super.setBottomRight(bottomRight);
    }

    @Override
    public int getWidth() {

        return super.getWidth();
    }

    @Override
    public int getHeight() {

        return super.getHeight();
    }

    @Override
    public void moveTo(int x, int y) {

        super.moveTo(x, y);
    }


    @Override
    public void moveRel(int dx, int dy) {

        super.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {

        super.resize(ratio);
    }

    @Override
    public boolean isInside(int x, int y) {

        return super.isInside(x, y);
    }

    @Override
    public boolean isInside(Point point) {

        return super.isInside(point);
    }

    @Override
    public boolean isIntersects(RectPicture rectPicture) {

        return super.isIntersects(rectPicture);
    }

    @Override
    public boolean isInside(RectPicture rectPicture) {

        return super.isInside(rectPicture);
    }

    @Override
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {

        return super.isFullyVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {

        return super.equals(o);
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }

}
