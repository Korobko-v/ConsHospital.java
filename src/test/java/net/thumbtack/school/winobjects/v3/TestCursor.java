package net.thumbtack.school.winobjects.v3;

import net.thumbtack.school.pictures.v3.Point;
import net.thumbtack.school.winobjects.v3.Cursor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCursor {

    @Test
    public void testCursor1() {
        int x = 10;
        int y = 20;
        Cursor cursor = new Cursor(x, y, CursorForm.ARROW);
        assertAll(
                () -> assertEquals(10, cursor.getX()),
                () -> assertEquals(20, cursor.getY()),
                () -> assertEquals(CursorForm.ARROW, cursor.getCursorForm())
        );
    }

    @Test
    public void testCursor2() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, CursorForm.ARROW);
        assertAll(
                () -> assertEquals(10, cursor.getX()),
                () -> assertEquals(20, cursor.getY()),
                () -> assertEquals(CursorForm.ARROW, cursor.getCursorForm())
        );
    }

    @Test
    public void testSetCursor() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, CursorForm.ARROW);
        cursor.setX(100);
        cursor.setY(200);
        cursor.setCursorForm(CursorForm.CROSS);
        assertAll(
                () -> assertEquals(100, cursor.getX()),
                () -> assertEquals(200, cursor.getY()),
                () -> assertEquals(CursorForm.CROSS, cursor.getCursorForm())
        );
    }

    @Test
    public void testMoveCursor() {
        Point point = new Point(10, 20);
        Cursor cursor = new Cursor(point, CursorForm.ARROW);
        cursor.moveTo(100, 200);
        assertAll(
                () -> assertEquals(100, cursor.getX()),
                () -> assertEquals(200, cursor.getY()),
                () -> assertEquals(CursorForm.ARROW, cursor.getCursorForm())
        );
        cursor.moveTo(point);
        assertAll(
                () -> assertEquals(10, cursor.getX()),
                () -> assertEquals(20, cursor.getY())
        );
        cursor.moveRel(10, 10);
        assertAll(
                () -> assertEquals(20, cursor.getX()),
                () -> assertEquals(30, cursor.getY()));

    }


}
