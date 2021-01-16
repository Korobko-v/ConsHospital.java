package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.iface.v3.Movable;
import net.thumbtack.school.iface.v3.Resizable;
import net.thumbtack.school.winobjects.v3.Desktop;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class TestPicture {

    @Test
    public void testFormat1() throws GraphicException {
        Picture picture = new RectPicture(10, 20, 30, 40, PictureFormat.GIF);
        assertEquals(PictureFormat.GIF, picture.getFormat());
    }

    @Test
    public void testFormat2() throws GraphicException {
        Picture picture = new RectPicture(10, 20, 30, 40, "GIF");
        assertEquals(PictureFormat.GIF, picture.getFormat());
    }

    @SuppressWarnings("unused")
    @Test
    public void testWrongSettings() {
        boolean failed = false;
        try {
            Picture picture = new RoundPicture(10, 20, 10, (PictureFormat) null);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        try {
            Picture picture = new RoundPicture(10, 20, 10, (String) null);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        try {
            Picture picture = new RoundPicture(10, 20, 10, "BMP");
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.WRONG_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        if (failed) {
            fail();
        }
    }

    @Test
    public void testIsPointInsidePicture1() throws GraphicException {
        Picture picture = new RectPicture(10, 20, 30, 40, PictureFormat.GIF);
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
    public void testIsPointInsidePicture2() throws GraphicException {
        Picture picture = new RectPicture(10, 20, 30, 40, PictureFormat.GIF);
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
    public void testIsFullyVisibleOnDesktop() throws GraphicException {
        Desktop desktop = new Desktop();
        Picture picture = new RectPicture(15, 25, 25, 35, PictureFormat.GIF);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(0, 0, 639, 479, PictureFormat.GIF);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(200, 200, 640, 480, PictureFormat.GIF);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(-200, -200, 640, 480, PictureFormat.GIF);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(-1200, 700, 1199, 480, PictureFormat.GIF);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(200, -200, 100, 100, PictureFormat.GIF);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(200, 300, 100, 100, PictureFormat.GIF);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        picture = new RectPicture(200, 700, 100, 100, PictureFormat.GIF);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
    }

    @Test
    public void testMovePicture() throws GraphicException {
        Desktop desktop = new Desktop();
        Picture picture = new RectPicture(0, 0, 639, 479, PictureFormat.GIF);
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
    public void testResizePicture() throws GraphicException {
        Desktop desktop = new Desktop();
        Picture picture = new RectPicture(0, 0, 320, 240, PictureFormat.GIF);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        Resizable resizable = picture;
        resizable.resize(2);
        assertTrue(picture.isFullyVisibleOnDesktop(desktop));
        resizable.resize(2);
        assertFalse(picture.isFullyVisibleOnDesktop(desktop));
    }
}
