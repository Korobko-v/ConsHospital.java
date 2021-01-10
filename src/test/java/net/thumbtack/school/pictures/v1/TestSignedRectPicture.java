package net.thumbtack.school.pictures.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSignedRectPicture {
    @Test
    public void testRectPicture1() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        SignedRectPicture signedRectPicture = new SignedRectPicture(topLeft, bottomRight, 1, "подпись");
        assertAll(
                () -> assertEquals(10, signedRectPicture.getTopLeft().getX()),
                () -> assertEquals(20, signedRectPicture.getTopLeft().getY()),
                () -> assertEquals(30, signedRectPicture.getBottomRight().getX()),
                () -> assertEquals(40, signedRectPicture.getBottomRight().getY()),
                () -> assertEquals(21, signedRectPicture.getWidth()),
                () -> assertEquals(21, signedRectPicture.getHeight()),
                () -> assertEquals(1, signedRectPicture.getFormat()),
                () -> assertEquals("подпись", signedRectPicture.getSignature())
        );
    }

    @Test
    public void testRectPicture2() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, 1, "подпись");
        assertAll(
                () -> assertEquals(10, signedRectPicture.getTopLeft().getX()),
                () -> assertEquals(20, signedRectPicture.getTopLeft().getY()),
                () -> assertEquals(39, signedRectPicture.getBottomRight().getX()),
                () -> assertEquals(59, signedRectPicture.getBottomRight().getY()),
                () -> assertEquals(30, signedRectPicture.getWidth()),
                () -> assertEquals(40, signedRectPicture.getHeight()),
                () -> assertEquals(1, signedRectPicture.getFormat()),
                () -> assertEquals("подпись", signedRectPicture.getSignature())
        );
    }

    @Test
    public void testRectPicture3() {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        SignedRectPicture signedRectPicture = new SignedRectPicture(topLeft, bottomRight, "подпись");
        assertAll(
                () -> assertEquals(10, signedRectPicture.getTopLeft().getX()),
                () -> assertEquals(20, signedRectPicture.getTopLeft().getY()),
                () -> assertEquals(30, signedRectPicture.getBottomRight().getX()),
                () -> assertEquals(40, signedRectPicture.getBottomRight().getY()),
                () -> assertEquals(21, signedRectPicture.getWidth()),
                () -> assertEquals(21, signedRectPicture.getHeight()),
                () -> assertEquals(1, signedRectPicture.getFormat()),
                () -> assertEquals("подпись", signedRectPicture.getSignature())

        );
    }

    @Test
    public void testRectPicture4() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        assertAll(
                () -> assertEquals(10, signedRectPicture.getTopLeft().getX()),
                () -> assertEquals(20, signedRectPicture.getTopLeft().getY()),
                () -> assertEquals(39, signedRectPicture.getBottomRight().getX()),
                () -> assertEquals(59, signedRectPicture.getBottomRight().getY()),
                () -> assertEquals(30, signedRectPicture.getWidth()),
                () -> assertEquals(40, signedRectPicture.getHeight()),
                () -> assertEquals(1, signedRectPicture.getFormat()),
                () -> assertEquals("подпись", signedRectPicture.getSignature())
        );
    }

    @Test
    public void testSetRectPicture() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        signedRectPicture.setTopLeft(new Point(0, 0));
        signedRectPicture.setBottomRight(new Point(200, 100));
        signedRectPicture.setSignature("signature");
        assertAll(
                () -> assertEquals(0, signedRectPicture.getTopLeft().getX()),
                () -> assertEquals(0, signedRectPicture.getTopLeft().getY()),
                () -> assertEquals(200, signedRectPicture.getBottomRight().getX()),
                () -> assertEquals(100, signedRectPicture.getBottomRight().getY()),
                () -> assertEquals(201, signedRectPicture.getWidth()),
                () -> assertEquals(101, signedRectPicture.getHeight()),
                () -> assertEquals(1, signedRectPicture.getFormat()),
                () -> assertEquals("signature", signedRectPicture.getSignature())
        );
    }

    @Test
    public void testMoveToRectPicture1() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        signedRectPicture.moveTo(100, 50);
        assertAll(
                () -> assertEquals(100, signedRectPicture.getTopLeft().getX()),
                () -> assertEquals(50, signedRectPicture.getTopLeft().getY()),
                () -> assertEquals(129, signedRectPicture.getBottomRight().getX()),
                () -> assertEquals(89, signedRectPicture.getBottomRight().getY()),
                () -> assertEquals(30, signedRectPicture.getWidth()),
                () -> assertEquals(40, signedRectPicture.getHeight()),
                () -> assertEquals("подпись", signedRectPicture.getSignature())
        );
    }

    @Test
    public void testMoveToRectPicture2() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        signedRectPicture.moveTo(new Point(100, 50));
        assertAll(
                () -> assertEquals(100, signedRectPicture.getTopLeft().getX()),
                () -> assertEquals(50, signedRectPicture.getTopLeft().getY()),
                () -> assertEquals(129, signedRectPicture.getBottomRight().getX()),
                () -> assertEquals(89, signedRectPicture.getBottomRight().getY()),
                () -> assertEquals(30, signedRectPicture.getWidth()),
                () -> assertEquals(40, signedRectPicture.getHeight()),
                () -> assertEquals("подпись", signedRectPicture.getSignature())
        );
    }

    @Test
    public void testMoveRelRectPicture() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        signedRectPicture.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, signedRectPicture.getTopLeft().getX()),
                () -> assertEquals(70, signedRectPicture.getTopLeft().getY()),
                () -> assertEquals(139, signedRectPicture.getBottomRight().getX()),
                () -> assertEquals(109, signedRectPicture.getBottomRight().getY()),
                () -> assertEquals(30, signedRectPicture.getWidth()),
                () -> assertEquals(40, signedRectPicture.getHeight()),
                () -> assertEquals("подпись", signedRectPicture.getSignature())
        );
    }

    @Test
    public void testResizeRectPicture() {
        SignedRectPicture signedRectPicture1 = new SignedRectPicture(10, 20, 30, 40, "подпись");
        signedRectPicture1.resize(2);
        assertAll(
                () -> assertEquals(10, signedRectPicture1.getTopLeft().getX()),
                () -> assertEquals(20, signedRectPicture1.getTopLeft().getY()),
                () -> assertEquals(69, signedRectPicture1.getBottomRight().getX()),
                () -> assertEquals(99, signedRectPicture1.getBottomRight().getY()),
                () -> assertEquals(60, signedRectPicture1.getWidth()),
                () -> assertEquals(80, signedRectPicture1.getHeight())
        );
        SignedRectPicture signedRectPicture2 = new SignedRectPicture(10, 20, 30, 40, "подпись");
        signedRectPicture2.resize(0.5);
        assertAll(
                () -> assertEquals(10, signedRectPicture2.getTopLeft().getX()),
                () -> assertEquals(20, signedRectPicture2.getTopLeft().getY()),
                () -> assertEquals(24, signedRectPicture2.getBottomRight().getX()),
                () -> assertEquals(39, signedRectPicture2.getBottomRight().getY()),
                () -> assertEquals(15, signedRectPicture2.getWidth()),
                () -> assertEquals(20, signedRectPicture2.getHeight())
        );
        SignedRectPicture signedRectPicture3 = new SignedRectPicture(10, 20, 4, 4, "подпись");
        signedRectPicture3.resize(0.5);
        assertAll(
                () -> assertEquals(10, signedRectPicture3.getTopLeft().getX()),
                () -> assertEquals(20, signedRectPicture3.getTopLeft().getY()),
                () -> assertEquals(11, signedRectPicture3.getBottomRight().getX()),
                () -> assertEquals(21, signedRectPicture3.getBottomRight().getY()),
                () -> assertEquals(2, signedRectPicture3.getWidth()),
                () -> assertEquals(2, signedRectPicture3.getHeight())
        );
        SignedRectPicture signedRectPicture4 = new SignedRectPicture(10, 20, 30, 40, "подпись");
        signedRectPicture4.resize(0.01);
        assertAll(
                () -> assertEquals(10, signedRectPicture4.getTopLeft().getX()),
                () -> assertEquals(20, signedRectPicture4.getTopLeft().getY()),
                () -> assertEquals(10, signedRectPicture4.getBottomRight().getX()),
                () -> assertEquals(20, signedRectPicture4.getBottomRight().getY()),
                () -> assertEquals(1, signedRectPicture4.getWidth()),
                () -> assertEquals(1, signedRectPicture4.getHeight())
        );
    }

    @Test
    public void testIsPointInsideRectPicture1() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        assertAll(
                () -> assertTrue(signedRectPicture.isInside(20, 30)),
                () -> assertTrue(signedRectPicture.isInside(10, 30)),
                () -> assertTrue(signedRectPicture.isInside(30, 30)),
                () -> assertTrue(signedRectPicture.isInside(10, 59)),
                () -> assertFalse(signedRectPicture.isInside(10, 60)),
                () -> assertFalse(signedRectPicture.isInside(0, 0)),
                () -> assertFalse(signedRectPicture.isInside(10, 100)),
                () -> assertFalse(signedRectPicture.isInside(-10, 20)),
                () -> assertFalse(signedRectPicture.isInside(10, -20))
        );
    }

    @Test
    public void testIsPointInsideRectPicture2() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        assertAll(
                () -> assertTrue(signedRectPicture.isInside(new Point(20, 30))),
                () -> assertTrue(signedRectPicture.isInside(new Point(10, 30))),
                () -> assertTrue(signedRectPicture.isInside(new Point(30, 30))),
                () -> assertTrue(signedRectPicture.isInside(new Point(10, 59))),
                () -> assertFalse(signedRectPicture.isInside(new Point(10, 60))),
                () -> assertFalse(signedRectPicture.isInside(new Point(0, 0))),
                () -> assertFalse(signedRectPicture.isInside(new Point(10, 100))),
                () -> assertFalse(signedRectPicture.isInside(new Point(-10, 20))),
                () -> assertFalse(signedRectPicture.isInside(new Point(10, -20)))
        );
    }

    @Test
    public void testIsIntersectsRectPicture() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        assertAll(
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(15, 25, 25, 35, "подпись"))),
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(-10, 20, 30, 40, "подпись"))),
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(10, 20, 50, 40, "подпись"))),
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(-10, 20, 50, 40, "подпись"))),
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(10, -20, 30, 41, "подпись"))),
                () -> assertFalse(signedRectPicture.isIntersects(new SignedRectPicture(10, -20, 30, 40, "подпись"))),
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(10, 20, 30, 60, "подпись"))),
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(-10, -20, 50, 60, "подпись"))),
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(0, 10, 20, 30, "подпись"))),
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(20, 30, 40, 50, "подпись"))),
                () -> assertFalse(signedRectPicture.isIntersects(new SignedRectPicture(-40, 20, -30, 40, "подпись"))),
                () -> assertFalse(signedRectPicture.isIntersects(new SignedRectPicture(110, 120, 30, 40, "подпись"))),
                () -> assertFalse(signedRectPicture.isIntersects(new SignedRectPicture(10, 120, 30, 40, "подпись"))),
                () -> assertFalse(signedRectPicture.isIntersects(new SignedRectPicture(10, -40, 30, 20, "подпись"))),
                () -> assertTrue(signedRectPicture.isIntersects(new SignedRectPicture(15, 15, 25, 50, "подпись")))
        );
    }

    @Test
    public void testIsRectPictureInsideRectPicture() {
        SignedRectPicture signedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        assertAll(
                () -> assertTrue(signedRectPicture.isInside(new SignedRectPicture(15, 25, 25, 35, "подпись"))),
                () -> assertFalse(signedRectPicture.isInside(new SignedRectPicture(-40, 20, 30, 40, "подпись"))),
                () -> assertFalse(signedRectPicture.isInside(new SignedRectPicture(110, 120, 130, 140, "подпись"))),
                () -> assertFalse(signedRectPicture.isInside(new SignedRectPicture(10, 120, 30, 40, "подпись"))),
                () -> assertFalse(signedRectPicture.isInside(new SignedRectPicture(10, -40, 30, 20, "подпись")))
        );
    }

    @Test
    public void testIsFullyVisibleOnDesktop() {
        Desktop desktop = new Desktop();
        assertAll(
                () -> assertTrue(new SignedRectPicture(15, 25, 25, 35, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new SignedRectPicture(0, 0, 639, 479, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new SignedRectPicture(200, 200, 640, 480, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new SignedRectPicture(-200, -200, 640, 480, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new SignedRectPicture(-1200, 700, 1199, 480, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new SignedRectPicture(200, -200, 100, 100, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertTrue(new SignedRectPicture(200, 300, 100, 100, "подпись").isFullyVisibleOnDesktop(desktop)),
                () -> assertFalse(new SignedRectPicture(200, 700, 100, 100, "подпись").isFullyVisibleOnDesktop(desktop))
        );
    }

    @Test
    public void testRectPicturesAreEqual() {
        SignedRectPicture signedRectPicture1 = new SignedRectPicture(10, 20, 30, 40, "подпись");
        SignedRectPicture signedRectPicture2 = new SignedRectPicture(10, 20, 30, 40, "подпись");
        SignedRectPicture signedRectPicture3 = new SignedRectPicture(20, 30, 40, 50, "подпись");
        SignedRectPicture signedRectPicture4 = new SignedRectPicture(20, 30, 40, 50, "Signature");
        assertNotEquals(signedRectPicture1, null);
        assertEquals(signedRectPicture1, signedRectPicture1);
        assertNotEquals(signedRectPicture1, null);
        assertEquals(signedRectPicture1, signedRectPicture2);
        assertNotEquals(signedRectPicture1, signedRectPicture3);
        assertNotEquals(signedRectPicture1, signedRectPicture4);
    }

    @Test
    public void testRectPictureSetText() {
        SignedRectPicture SignedRectPicture = new SignedRectPicture(10, 20, 30, 40, "подпись");
        SignedRectPicture.setSignature("Signature");
        assertEquals("Signature", SignedRectPicture.getSignature());
    }
}
