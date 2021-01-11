package net.thumbtack.school.pictures.v2;

import net.thumbtack.school.iface.v2.Signed;
import net.thumbtack.school.winobjects.v2.Desktop;

import java.util.Objects;

public class SignedRoundPicture extends RoundPicture implements Signed {
    private Point center;
    private int radius;
    private int format;
    private String signature;

    public SignedRoundPicture(Point center, int radius, int format, String signature) {
        super(center, radius, format);
        this.signature = signature;
    }

    public SignedRoundPicture(int xCenter, int yCenter, int radius, int format, String signature) {
        super(xCenter, yCenter, radius, format);
        this.signature = signature;
    }

    public SignedRoundPicture(Point center, int radius, String signature) {
        super(center, radius);
        this.signature = signature;
        this.format = 1;
    }

    public SignedRoundPicture(int xCenter, int yCenter, int radius, String signature) {
        super(xCenter, yCenter, radius);
        this.signature = signature;
        this.format = 1;
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
    public int getFormat() {
        return super.getFormat();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
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


    public void setActive(int format) {
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
