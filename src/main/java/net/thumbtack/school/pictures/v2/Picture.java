package net.thumbtack.school.pictures.v2;

import net.thumbtack.school.iface.v2.Movable;
import net.thumbtack.school.iface.v2.Resizable;
import net.thumbtack.school.winobjects.v2.Desktop;

public abstract class Picture implements Movable, Resizable {
    int format;


    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {

        this.format = format;
    }

    public abstract void moveTo(int x, int y);

    public abstract void moveTo(Point point);

    public abstract void moveRel(int dx, int dy);

    public abstract void resize(double ratio);

    public abstract boolean isInside(int x, int y);

    public abstract boolean isInside(Point point);

    public abstract boolean isFullyVisibleOnDesktop(Desktop desktop);

    public abstract boolean equals(Object o);

    public abstract int hashCode();
}
