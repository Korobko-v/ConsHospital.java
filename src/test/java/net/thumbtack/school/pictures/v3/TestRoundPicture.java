package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.winobjects.v3.Desktop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRoundPicture {

    @Test
    public void testRoundPicture1() throws GraphicException {
        Point center = new Point(10, 20);
        RoundPicture roundPicture = new RoundPicture(center, 10, PictureFormat.GIF);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture2() throws GraphicException {
        Point center = new Point(10, 20);
        RoundPicture roundPicture = new RoundPicture(center, 10, "GIF");
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture3() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(10, 20, 10, PictureFormat.GIF);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture4() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(10, 20, 10, PictureFormat.GIF);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture5() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(10, 20, 10, PictureFormat.GIF);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture6() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(10, 20, 10, "GIF");
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture7() throws GraphicException {
        Point center = new Point(10, 20);
        RoundPicture roundPicture = new RoundPicture(center, 10);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture8() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(10, 20, 10);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @SuppressWarnings("unused")
    @Test
    public void testWrongSettings() {
        boolean failed = false;
        try {
            RoundPicture picture = new RoundPicture(10, 20, 10, (PictureFormat) null);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        try {
            RoundPicture picture = new RoundPicture(10, 20, 10, (String) null);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        try {
            RoundPicture picture = new RoundPicture(10, 20, 10, "BMP");
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.WRONG_PICTURE_FORMAT, ex.getGraphicErrorCode());
        }
        if (failed) {
            fail();
        }
    }

    @Test
    public void testMoveToRoundPicture1() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(10, 20, 30);
        roundPicture.moveTo(100, 50);
        assertAll(
                () -> assertEquals(100, roundPicture.getCenter().getX()),
                () -> assertEquals(50, roundPicture.getCenter().getY()),
                () -> assertEquals(30, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @Test
    public void testMoveToRoundPicture2() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(10, 20, 30);
        roundPicture.moveTo(new Point(100, 50));
        assertAll(
                () -> assertEquals(100, roundPicture.getCenter().getX()),
                () -> assertEquals(50, roundPicture.getCenter().getY()),
                () -> assertEquals(30, roundPicture.getRadius()),
                () -> assertEquals(PictureFormat.GIF, roundPicture.getFormat())
        );
    }

    @Test
    public void testMoveRelRoundPicture() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(10, 20, 10);
        roundPicture.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, roundPicture.getCenter().getX()),
                () -> assertEquals(70, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius())
        );
    }

    @Test
    public void testResizeRoundPicture() throws GraphicException {
        RoundPicture roundPicture1 = new RoundPicture(10, 20, 10);
        roundPicture1.resize(2);
        assertAll(
                () -> assertEquals(10, roundPicture1.getCenter().getX()),
                () -> assertEquals(20, roundPicture1.getCenter().getY()),
                () -> assertEquals(20, roundPicture1.getRadius())
        );
        RoundPicture roundPicture2 = new RoundPicture(10, 20, 10);
        roundPicture2.resize(0.5);
        assertAll(
                () -> assertEquals(10, roundPicture2.getCenter().getX()),
                () -> assertEquals(20, roundPicture2.getCenter().getY()),
                () -> assertEquals(5, roundPicture2.getRadius())
        );
        RoundPicture roundPicture3 = new RoundPicture(10, 20, 10);
        roundPicture3.resize(0.01);
        assertAll(
                () -> assertEquals(10, roundPicture3.getCenter().getX()),
                () -> assertEquals(20, roundPicture3.getCenter().getY()),
                () -> assertEquals(1, roundPicture3.getRadius())
        );
    }

    @Test
    public void testIsPointInsideRoundPicture1() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(10, 10, 10);
        assertAll(
                () -> assertTrue(roundPicture.isInside(10, 10)),
                () -> assertTrue(roundPicture.isInside(20, 10)),
                () -> assertTrue(roundPicture.isInside(10, 20)),
                () -> assertTrue(roundPicture.isInside(15, 15)),
                () -> assertFalse(roundPicture.isInside(18, 18))
        );
    }

    @Test
    public void testIsPointInsideRoundPicture2() throws GraphicException {
        RoundPicture roundPicture = new RoundPicture(new Point(10, 10), 10);
        assertAll(
                () -> assertTrue(roundPicture.isInside(new Point(10, 10))),
                () -> assertTrue(roundPicture.isInside(new Point(20, 10))),
                () -> assertTrue(roundPicture.isInside(new Point(10, 20))),
                () -> assertTrue(roundPicture.isInside(new Point(15, 15))),
                () -> assertFalse(roundPicture.isInside(new Point(18, 18)))
        );
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        Desktop desktop = new Desktop();
        assertAll(
                () -> assertTrue(new RoundPicture(100, 100, 100).isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new RoundPicture(100, 100, 101).isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new RoundPicture(539, 100, 100).isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new RoundPicture(539, 100, 101).isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new RoundPicture(539, 379, 100).isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new RoundPicture(539, 379, 101).isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new RoundPicture(100, 379, 100).isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new RoundPicture(100, 379, 101).isFullyVisibleOnDesktop(desktop))
        );
    }


    @Test
    public void testRoundPicturesAreEqual() throws GraphicException {
        RoundPicture roundPicture1 = new RoundPicture(new Point(10, 10), 10);
        RoundPicture roundPicture2 = new RoundPicture(new Point(10, 10), 10);
        RoundPicture roundPicture3 = new RoundPicture(new Point(10, 10), 20);
        RoundPicture roundPicture4 = new RoundPicture(new Point(0, 0), 10);
        assertNotEquals(roundPicture1, null);
        assertEquals(roundPicture1, roundPicture2);
        assertNotEquals(roundPicture1, roundPicture3);
        assertNotEquals(roundPicture1, roundPicture4);
    }

}
