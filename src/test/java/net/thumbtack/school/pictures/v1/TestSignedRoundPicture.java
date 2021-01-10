package net.thumbtack.school.pictures.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSignedRoundPicture {

    @Test
    public void testSignedRoundPicture1() {
        Point center = new Point(10, 20);
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(center, 10, 1, "подпись");
        assertAll(
                () -> assertEquals(10, signedRoundPicture.getCenter().getX()),
                () -> assertEquals(20, signedRoundPicture.getCenter().getY()),
                () -> assertEquals(10, signedRoundPicture.getRadius()),
                () -> assertEquals(1, signedRoundPicture.getFormat()),
                () -> assertEquals("подпись", signedRoundPicture.getSignature())
        );
    }

    @Test
    public void testSignedRoundPicture2() {
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(10, 20, 10, 1, "подпись");
        assertAll(
                () -> assertEquals(10, signedRoundPicture.getCenter().getX()),
                () -> assertEquals(20, signedRoundPicture.getCenter().getY()),
                () -> assertEquals(10, signedRoundPicture.getRadius()),
                () -> assertEquals(1, signedRoundPicture.getFormat()),
                () -> assertEquals("подпись", signedRoundPicture.getSignature())
        );
    }

    @Test
    public void testSignedRoundPicture3() {
        Point center = new Point(10, 20);
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(center, 10, "подпись");
        assertAll(
                () -> assertEquals(10, signedRoundPicture.getCenter().getX()),
                () -> assertEquals(20, signedRoundPicture.getCenter().getY()),
                () -> assertEquals(10, signedRoundPicture.getRadius()),
                () -> assertEquals(1, signedRoundPicture.getFormat()),
                () -> assertEquals("подпись", signedRoundPicture.getSignature())
        );
    }

    @Test
    public void testSignedRoundPicture4() {
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(10, 20, 10, "подпись");
        assertAll(
                () -> assertEquals(10, signedRoundPicture.getCenter().getX()),
                () -> assertEquals(20, signedRoundPicture.getCenter().getY()),
                () -> assertEquals(10, signedRoundPicture.getRadius()),
                () -> assertEquals(1, signedRoundPicture.getFormat()),
                () -> assertEquals("подпись", signedRoundPicture.getSignature())
        );
    }

    @Test
    public void testMoveToSignedRoundPicture1() {
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(10, 20, 30, "подпись");
        signedRoundPicture.moveTo(100, 50);
        assertAll(
                () -> assertEquals(100, signedRoundPicture.getCenter().getX()),
                () -> assertEquals(50, signedRoundPicture.getCenter().getY()),
                () -> assertEquals(30, signedRoundPicture.getRadius()),
                () -> assertEquals(1, signedRoundPicture.getFormat())
        );
    }

    @Test
    public void testMoveToSignedRoundPicture2() {
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(10, 20, 30, "подпись");
        signedRoundPicture.moveTo(new Point(100, 50));
        assertAll(
                () -> assertEquals(100, signedRoundPicture.getCenter().getX()),
                () -> assertEquals(50, signedRoundPicture.getCenter().getY()),
                () -> assertEquals(30, signedRoundPicture.getRadius()),
                () -> assertEquals(1, signedRoundPicture.getFormat())
        );
    }

    @Test
    public void testMoveRelSignedRoundPicture() {
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(10, 20, 10, "подпись");
        signedRoundPicture.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, signedRoundPicture.getCenter().getX()),
                () -> assertEquals(70, signedRoundPicture.getCenter().getY()),
                () -> assertEquals(10, signedRoundPicture.getRadius())
        );
    }

    @Test
    public void testResizeSignedRoundPicture() {
        SignedRoundPicture signedRoundPicture1 = new SignedRoundPicture(10, 20, 10, "подпись");
        signedRoundPicture1.resize(2);
        assertAll(
                () -> assertEquals(10, signedRoundPicture1.getCenter().getX()),
                () -> assertEquals(20, signedRoundPicture1.getCenter().getY()),
                () -> assertEquals(20, signedRoundPicture1.getRadius())
        );
        SignedRoundPicture signedRoundPicture2 = new SignedRoundPicture(10, 20, 10, "подпись");
        signedRoundPicture2.resize(0.5);
        assertAll(
                () -> assertEquals(10, signedRoundPicture2.getCenter().getX()),
                () -> assertEquals(20, signedRoundPicture2.getCenter().getY()),
                () -> assertEquals(5, signedRoundPicture2.getRadius())
        );
        SignedRoundPicture signedRoundPicture3 = new SignedRoundPicture(10, 20, 10, "подпись");
        signedRoundPicture3.resize(0.01);
        assertAll(
                () -> assertEquals(10, signedRoundPicture3.getCenter().getX()),
                () -> assertEquals(20, signedRoundPicture3.getCenter().getY()),
                () -> assertEquals(1, signedRoundPicture3.getRadius())
        );
    }

    @Test
    public void testIsPointInsideSignedRoundPicture1() {
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(10, 10, 10, "подпись");
        assertAll(
                () -> assertTrue(signedRoundPicture.isInside(10, 10)),
                () -> assertTrue(signedRoundPicture.isInside(20, 10)),
                () -> assertTrue(signedRoundPicture.isInside(10, 20)),
                () -> assertTrue(signedRoundPicture.isInside(15, 15)),
                () -> assertFalse(signedRoundPicture.isInside(18, 18))
        );
    }

    @Test
    public void testIsPointInsideSignedRoundPicture2() {
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(new Point(10, 10), 10, "подпись");
        assertAll(
                () -> assertTrue(signedRoundPicture.isInside(new Point(10, 10))),
                () -> assertTrue(signedRoundPicture.isInside(new Point(20, 10))),
                () -> assertTrue(signedRoundPicture.isInside(new Point(10, 20))),
                () -> assertTrue(signedRoundPicture.isInside(new Point(15, 15))),
                () -> assertFalse(signedRoundPicture.isInside(new Point(18, 18)))
        );
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        Desktop desktop = new Desktop();
        assertAll(
                () -> assertTrue(new SignedRoundPicture(100, 100, 100, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new SignedRoundPicture(100, 100, 101, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new SignedRoundPicture(539, 100, 100, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new SignedRoundPicture(539, 100, 101, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new SignedRoundPicture(539, 379, 100, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new SignedRoundPicture(539, 379, 101, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new SignedRoundPicture(100, 379, 100, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new SignedRoundPicture(100, 379, 101, "подпись").isFullyVisibleOnDesktop(desktop))
        );
    }


    @Test
    public void testSignedRoundPicturesAreEqual() {
        SignedRoundPicture signedRoundPicture1 = new SignedRoundPicture(new Point(10, 10), 10, "подпись");
        SignedRoundPicture signedRoundPicture2 = new SignedRoundPicture(new Point(10, 10), 10, "подпись");
        SignedRoundPicture signedRoundPicture3 = new SignedRoundPicture(new Point(10, 10), 20, "подпись");
        SignedRoundPicture signedRoundPicture4 = new SignedRoundPicture(new Point(0, 0), 10, "подпись");
        SignedRoundPicture signedRoundPicture5 = new SignedRoundPicture(new Point(10, 10), 10, "Signature");
        assertNotEquals(signedRoundPicture1, null);
        assertEquals(signedRoundPicture1, signedRoundPicture2);
        assertNotEquals(signedRoundPicture1, signedRoundPicture3);
        assertNotEquals(signedRoundPicture1, signedRoundPicture4);
        assertNotEquals(signedRoundPicture1, signedRoundPicture5);
    }

    @Test
    public void testSignedRoundPictureSetText() {
        SignedRoundPicture signedRoundPicture = new SignedRoundPicture(new Point(10, 10), 10, "подпись");
        signedRoundPicture.setSignature("Signature");
        assertEquals("Signature", signedRoundPicture.getSignature());
    }

}
