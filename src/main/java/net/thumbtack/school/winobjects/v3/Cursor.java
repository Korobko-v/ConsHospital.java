package net.thumbtack.school.winobjects.v3;

import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.pictures.v3.Point;

public class Cursor implements Movable {
    private int x;
    private int y;
    private Point point;
    private CursorForm cursorForm;


    public Cursor(int x, int y, CursorForm cursorForm) {
        this.x = x;
        this.y = y;
        this.cursorForm = cursorForm;
    }

    public Cursor(Point point, CursorForm cursorForm) {
        this.x = point.getX();
        this.y = point.getY();
        this.cursorForm = cursorForm;
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

    public CursorForm getCursorForm() {
        return cursorForm;
    }

    public void setCursorForm(CursorForm cursorForm) {
        this.cursorForm = cursorForm;
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
