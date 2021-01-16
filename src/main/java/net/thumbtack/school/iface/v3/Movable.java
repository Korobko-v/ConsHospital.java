package net.thumbtack.school.iface.v3;

import net.thumbtack.school.pictures.v3.Point;

public interface Movable {
    Point point = new Point();
    void moveTo(int x, int y);

    default void moveTo(Point point) {
        this.point.setX(point.getX());
        this.point.setY(point.getY());
    }

    void moveRel(int dx, int dy);
}
