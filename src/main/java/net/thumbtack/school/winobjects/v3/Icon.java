package net.thumbtack.school.winobjects.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Signed;
import net.thumbtack.school.pictures.v3.Point;

public class Icon implements Movable, Signed {
    private int x;
    private int y;
    private Point point;
    private String signature;

    public Icon(int x, int y, String signature) throws GraphicException {
        this.x = x;
        this.y = y;
        if (signature == null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.signature = signature;
    }

    public Icon(Point point, String signature) throws GraphicException {

        this.x = point.getX();
        this.y = point.getY();
     if (signature == null)
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        this.signature = signature;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getSignature() {

        return signature;
    }

    @Override
    public void setSignature(String signature) throws GraphicException {
        if (signature==null) {
            throw new GraphicException(GraphicErrorCode.NULL_SIGNATURE);
        }
        this.signature = signature;
    }



    @Override
    public void moveTo(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
    public void moveTo(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    @Override
    public void moveRel(int dx, int dy) {
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);
    }


}
