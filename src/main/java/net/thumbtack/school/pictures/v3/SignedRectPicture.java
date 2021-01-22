package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.iface.v3.Signed;
import net.thumbtack.school.winobjects.v3.Desktop;

public class SignedRectPicture extends RectPicture implements Signed {
    private String signature;
    // REVU оба поля не нужны
    private String sFormat;
    private PictureFormat format;


    // REVU см. REVU в классе RectPicture

    public SignedRectPicture(Point topLeft, Point bottomRight, PictureFormat format, String signature) throws GraphicException {


        super(topLeft, bottomRight);
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.format = format;
        this.signature = signature;
    }
    public SignedRectPicture(Point topLeft, Point bottomRight, String sFormat, String signature) throws GraphicException {
        super(topLeft, bottomRight);
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        try {
            this.format = PictureFormat.fromString(sFormat);

        } catch (IllegalArgumentException ex) {
            throw new GraphicException(GraphicErrorCode.WRONG_PICTURE_FORMAT);
        }
        this.signature = signature;
    }

    public SignedRectPicture(int xLeft, int yTop, int width, int height, PictureFormat format, String signature) throws GraphicException {
        super(xLeft, yTop, width, height);
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.format = format;
        this.signature = signature;
    }

    public SignedRectPicture(int xLeft, int yTop, int width, int height, String sFormat, String signature) throws GraphicException {
        super(xLeft, yTop, width, height);
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        try {
            this.format = PictureFormat.fromString(sFormat);

        } catch (IllegalArgumentException ex) {
            throw new GraphicException(GraphicErrorCode.WRONG_PICTURE_FORMAT);
        }
        catch (NullPointerException e) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        this.signature = signature;
    }

    public SignedRectPicture(Point topLeft, Point bottomRight, String signature) throws GraphicException {
        super(topLeft, bottomRight);
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.signature = signature;
    }

    public SignedRectPicture(int xLeft, int yTop, int width, int height, String signature) throws GraphicException {
        super(xLeft, yTop, width, height);
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.signature = signature;
    }


    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) throws GraphicException {
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.signature = signature;
    }

    // REVU Если метод у потомка только вызывает тот же метод родителя и ничего больше не делает, то его переопределять не надо. Удалите все такие методы
    @Override
    public Point getTopLeft() {

        return super.getTopLeft();
    }

    @Override
    public Point getBottomRight() {

        return super.getBottomRight();
    }

    @Override
    public PictureFormat getFormat() {

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
