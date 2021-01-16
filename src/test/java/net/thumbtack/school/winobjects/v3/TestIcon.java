package net.thumbtack.school.winobjects.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.pictures.v3.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestIcon {

    @Test
    public void testIcon1() throws GraphicException {
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
    public void testIcon2() throws GraphicException {
        Point point = new Point(10, 20);
        Icon icon = new Icon(point, "подпись");
        assertAll(
                () -> assertEquals(10, icon.getX()),
                () -> assertEquals(20, icon.getY()),
                () -> assertEquals("подпись", icon.getSignature())
        );
    }

    @Test
    public void testSetIcon() throws GraphicException {
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
    public void testMoveIcon() throws GraphicException {
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

    @SuppressWarnings("unused")
    @Test
    public void testWrongSettings() throws GraphicException {
        boolean failed = false;
        try {
            Point point = new Point(10, 20);
            Icon icon = new Icon(point, null);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_SIGNATURE, ex.getGraphicErrorCode());
        }
        try {
            Point point = new Point(10, 20);
            Icon icon = new Icon(point, "подпись");
            icon.setSignature(null);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_SIGNATURE, ex.getGraphicErrorCode());
        }
        if (failed) {
            fail();
        }
    }


}
