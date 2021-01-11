package net.thumbtack.school.iface.v2;

import net.thumbtack.school.winobjects.v2.Desktop;
import net.thumbtack.school.pictures.v2.Picture;
import net.thumbtack.school.pictures.v2.Point;
import net.thumbtack.school.pictures.v2.RectPicture;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class TestPicture {

    @Test
    public void testFormat() {
        Picture picture = new RectPicture(10, 20, 30, 40, 1);
        assertEquals(1, picture.getFormat());
    }

    @Test
    public void testIsPointInsidePicture1() {
        Picture picture = new RectPicture(10, 20, 30, 40, 1);
        assertAll(
                () -> assertTrue(picture.isInside(20, 30)),
                () -> assertTrue(picture.isInside(10, 30)),
                () -> assertTrue(picture.isInside(30, 30)),
                () -> assertTrue(picture.isInside(10, 59)),
                () -> assertFalse(picture.isInside(10, 60)),
                () -> assertFalse(picture.isInside(0, 0)),
                () -> assertFalse(picture.isInside(10, 100)),
                () -> assertFalse(picture.isInside(-10, 20)),
                () -> assertFalse(picture.isInside(10, -20))
        );
    }

    @Test
    public void testIsPointInsidePicture2() {
        Picture picture = new RectPicture(10, 20, 30, 40, 1);
        assertAll(
                () -> assertTrue(picture.isInside(new Point(20, 30))),
                () -> assertTrue(picture.isInside(new Point(10, 30))),
                () -> assertTrue(picture.isInside(new Point(30, 30))),
                () -> assertTrue(picture.isInside(new Point(10, 59))),
                () -> assertFalse(picture.isInside(new Point(10, 60))),
                () -> assertFalse(picture.isInside(new Point(0, 0))),
                () -> assertFalse(picture.isInside(new Point(10, 100))),
                () -> assertFalse(picture.isInside(new Point(-10, 20))),
                () -> assertFalse(picture.isInside(new Point(10, -20)))
        );
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        Desktop desktop = new Desktop();
        Picture picture = new RectPicture(15, 25, 25, 35, 1);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(0, 0, 639, 479, 1);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(200, 200, 640, 480, 1);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(-200, -200, 640, 480, 1);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(-1200, 700, 1199, 480, 1);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(200, -200, 100, 100, 1);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(200, 300, 100, 100, 1);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(200, 700, 100, 100, 1);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
    }

    @Test
    public void testMovePicture() {
        Desktop desktop = new Desktop();
        Picture picture = new RectPicture(0, 0, 639, 479, 1);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        picture.moveTo(-100, 100);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        Movable movable = picture;
        movable.moveTo(739, 479);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        movable.moveTo(0, 479);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        movable.moveTo(739, 0);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        movable.moveRel(-739, 0);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
    }

    @Test
    public void testResizePicture() {
        Desktop desktop = new Desktop();
        Picture picture = new RectPicture(0, 0, 320, 240, 1);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        Resizable resizable = picture;
        resizable.resize(2);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        resizable.resize(2);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
    }
}
