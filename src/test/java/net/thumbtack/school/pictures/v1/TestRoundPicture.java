package net.thumbtack.school.pictures.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRoundPicture {

    @Test
    public void testRoundPicture1() {
        Point center = new Point(10, 20);
        RoundPicture roundPicture = new RoundPicture(center, 10, 1);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(1, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture2() {
        RoundPicture roundPicture = new RoundPicture(10, 20, 10, 1);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(1, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture3() {
        Point center = new Point(10, 20);
        RoundPicture roundPicture = new RoundPicture(center, 10);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(1, roundPicture.getFormat())
        );
    }

    @Test
    public void testRoundPicture4() {
        RoundPicture roundPicture = new RoundPicture(10, 20, 10);
        assertAll(
                () -> assertEquals(10, roundPicture.getCenter().getX()),
                () -> assertEquals(20, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius()),
                () -> assertEquals(1, roundPicture.getFormat())
        );
    }


    @Test
    public void testMoveToRoundPicture1() {
        RoundPicture roundPicture = new RoundPicture(10, 20, 30);
        roundPicture.moveTo(100, 50);
        assertAll(
                () -> assertEquals(100, roundPicture.getCenter().getX()),
                () -> assertEquals(50, roundPicture.getCenter().getY()),
                () -> assertEquals(30, roundPicture.getRadius()),
                () -> assertEquals(1, roundPicture.getFormat())
        );
    }

    @Test
    public void testMoveToRoundPicture2() {
        RoundPicture roundPicture = new RoundPicture(10, 20, 30);
        roundPicture.moveTo(new Point(100, 50));
        assertAll(
                () -> assertEquals(100, roundPicture.getCenter().getX()),
                () -> assertEquals(50, roundPicture.getCenter().getY()),
                () -> assertEquals(30, roundPicture.getRadius()),
                () -> assertEquals(1, roundPicture.getFormat())
        );
    }

    @Test
    public void testMoveRelRoundPicture() {
        RoundPicture roundPicture = new RoundPicture(10, 20, 10);
        roundPicture.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, roundPicture.getCenter().getX()),
                () -> assertEquals(70, roundPicture.getCenter().getY()),
                () -> assertEquals(10, roundPicture.getRadius())
        );
    }

    @Test
    public void testResizeRoundPicture() {
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
    public void testIsPointInsideRoundPicture1() {
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
    public void testIsPointInsideRoundPicture2() {
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
    public void testRoundPicturesAreEqual() {
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
