package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.iface.v3.Signed;
import net.thumbtack.school.winobjects.v3.Desktop;

import java.util.Objects;

public class SignedRoundPicture extends RoundPicture implements Signed {
    private Point center;
    private int radius;
    // REVU оба поля не нужны
    private PictureFormat format;
    private String signature;

    // REVU см. REVU в классе RectPicture
   public SignedRoundPicture(Point center, int radius, PictureFormat format, String signature) throws GraphicException {
        super(center, radius, format);
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.signature = signature;
    }

    public SignedRoundPicture(Point center, int radius, String sFormat, String signature) throws GraphicException {
        super(center, radius);
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

    public SignedRoundPicture(int xCenter, int yCenter, int radius, PictureFormat format, String signature) throws GraphicException {
        super(xCenter, yCenter, radius);
        if (format == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);

        }
        this.format = format;
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.signature = signature;
    }
    public SignedRoundPicture(int xCenter, int yCenter, int radius, String sFormat, String signature) throws GraphicException {
        super(xCenter, yCenter, radius);
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        try {
            this.format = PictureFormat.fromString(sFormat);

        } catch (IllegalArgumentException ex) {
            throw new GraphicException(GraphicErrorCode.WRONG_PICTURE_FORMAT);
        }
        catch (NullPointerException ex) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE_FORMAT);
        }
        this.signature = signature;
    }

    public SignedRoundPicture(Point center, int radius, String signature) throws GraphicException {
        super(center, radius);
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.signature = signature;
        this.format = PictureFormat.GIF;
    }

    public SignedRoundPicture(int xCenter, int yCenter, int radius, String signature) throws GraphicException {
        super(xCenter, yCenter, radius);
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.signature = signature;
        this.format = PictureFormat.GIF;
    }
    @Override
    public Point getCenter() {
        return super.getCenter();
    }

    @Override
    public int getRadius() {
        return super.getRadius();
    }

    @Override
    public PictureFormat getFormat() {
        return super.getFormat();
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

    @Override
    public void moveTo(int x, int y) {
        super.moveTo(x, y);
    }


    @Override
    public void setCenter(int x, int y) {
        super.setCenter(x, y);
    }

    @Override
    public void setRadius(int radius) {
        super.setRadius(radius);
    }


    public void setActive(PictureFormat format) {
            this.format = format;
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
    public boolean isFullyVisibleOnDesktop(Desktop desktop) {
        return super.isFullyVisibleOnDesktop(desktop);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SignedRoundPicture that = (SignedRoundPicture) o;
        return radius == that.radius &&
                format == that.format &&
                Objects.equals(center, that.center) &&
                Objects.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), center, radius, format, signature);
    }
}
