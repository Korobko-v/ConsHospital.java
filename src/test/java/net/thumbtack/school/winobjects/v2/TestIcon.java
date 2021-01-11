package net.thumbtack.school.winobjects.v2;

import net.thumbtack.school.pictures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIcon {

    @Test
    public void testIcon1() {
        int x = 10;
        int y = 20;
        Icon icon = new Icon(x, y, "подпись");
        assertAll(
                () -> assertEquals(10, icon.getX()),
                () -> assertEquals(20, icon.getY()),
                () -> assertEquals("подпись", icon.getSignature())
        );
    }

    @Test
    public void testIcon2() {
        Point point = new Point(10, 20);
        Icon icon = new Icon(point, "подпись");
        assertAll(
                () -> assertEquals(10, icon.getX()),
                () -> assertEquals(20, icon.getY()),
                () -> assertEquals("подпись", icon.getSignature())
        );
    }

    @Test
    public void testSetIcon() {
        Point point = new Point(10, 20);
        Icon icon = new Icon(point, "подпись");
        icon.setX(100);
        icon.setY(200);
        icon.setSignature("signature");
        assertAll(
                () -> assertEquals(100, icon.getX()),
                () -> assertEquals(200, icon.getY()),
                () -> assertEquals("signature", icon.getSignature())
        );
    }

    @Test
    public void testMoveIcon() {
        Point point = new Point(10, 20);
        Icon icon = new Icon(point, "подпись");
        icon.moveTo(100, 200);
        assertAll(
                () -> assertEquals(100, icon.getX()),
                () -> assertEquals(200, icon.getY()),
                () -> assertEquals("подпись", icon.getSignature())
        );
        icon.moveTo(point);
        assertAll(
                () -> assertEquals(10, icon.getX()),
                () -> assertEquals(20, icon.getY())
        );
        icon.moveRel(10, 10);
        assertAll(
                () -> assertEquals(20, icon.getX()),
                () -> assertEquals(30, icon.getY()));

    }
}
