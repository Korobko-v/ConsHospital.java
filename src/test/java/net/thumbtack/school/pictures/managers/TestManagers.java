package net.thumbtack.school.pictures.managers;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.pictures.v3.*;
import net.thumbtack.school.winobjects.v3.Cursor;
import net.thumbtack.school.winobjects.v3.CursorForm;
import net.thumbtack.school.winobjects.v3.Desktop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestManagers {

    @Test
    public void testRectPictureManager() throws GraphicException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectPicture rectPicture = new RectPicture(topLeft, bottomRight, "GIF");
        Manager<RectPicture> rectPictureManager = new Manager<>(rectPicture);
        assertEquals(10, rectPictureManager.getPicture().getTopLeft().getX());
        assertEquals(20, rectPictureManager.getPicture().getTopLeft().getY());
        assertEquals(30, rectPictureManager.getPicture().getBottomRight().getX());
        assertEquals(40, rectPictureManager.getPicture().getBottomRight().getY());
        assertEquals(PictureFormat.GIF, rectPictureManager.getPicture().getFormat());
    }

    @Test
    public void testRectPictureManagerMoveTo1() throws GraphicException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectPicture rectPicture = new RectPicture(topLeft, bottomRight, "GIF");
        Manager<RectPicture> rectPictureManager = new Manager<>(rectPicture);
        rectPictureManager.moveTo(100, 200);
        assertEquals(PictureFormat.GIF, rectPictureManager.getPicture().getFormat());
        assertEquals(100, rectPictureManager.getPicture().getTopLeft().getX());
        assertEquals(200, rectPictureManager.getPicture().getTopLeft().getY());
        assertEquals(120, rectPictureManager.getPicture().getBottomRight().getX());
        assertEquals(220, rectPictureManager.getPicture().getBottomRight().getY());
        assertEquals(21, rectPictureManager.getPicture().getHeight());
        assertEquals(21, rectPictureManager.getPicture().getWidth());
    }

    @Test
    public void testRectPictureManagerMoveTo2() throws GraphicException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        RectPicture rectPicture = new RectPicture(topLeft, bottomRight, "GIF");
        Manager<RectPicture> rectPictureManager = new Manager<>(rectPicture);
        rectPictureManager.moveTo(new Point(100, 200));
        assertEquals(PictureFormat.GIF, rectPictureManager.getPicture().getFormat());
        assertEquals(100, rectPictureManager.getPicture().getTopLeft().getX());
        assertEquals(200, rectPictureManager.getPicture().getTopLeft().getY());
        assertEquals(120, rectPictureManager.getPicture().getBottomRight().getX());
        assertEquals(220, rectPictureManager.getPicture().getBottomRight().getY());
        assertEquals(21, rectPictureManager.getPicture().getHeight());
        assertEquals(21, rectPictureManager.getPicture().getWidth());
    }

    @Test
    public void testSignedRoundPictureManager() throws GraphicException {
        Point center = new Point(10, 20);
        SignedRoundPicture roundPicture = new SignedRoundPicture(center, 10, PictureFormat.GIF, "подпись");
        Manager<SignedRoundPicture> roundPictureManager = new Manager<>(roundPicture);
        assertEquals(PictureFormat.GIF, roundPictureManager.getPicture().getFormat());
        assertEquals(10, roundPictureManager.getPicture().getCenter().getX());
        assertEquals(20, roundPictureManager.getPicture().getCenter().getY());
        assertEquals(10, roundPictureManager.getPicture().getRadius());
        assertEquals("подпись", roundPictureManager.getPicture().getSignature());
    }

    @Test
    public void testSignedRoundPictureManagerMoveTo() throws GraphicException {
        Point center = new Point(10, 20);
        SignedRoundPicture roundPicture = new SignedRoundPicture(center, 10, PictureFormat.GIF, "подпись");
        Manager<SignedRoundPicture> roundPictureManager = new Manager<>(roundPicture);
        roundPictureManager.moveTo(100, 200);
        assertEquals(PictureFormat.GIF, roundPictureManager.getPicture().getFormat());
        assertEquals(100, roundPictureManager.getPicture().getCenter().getX());
        assertEquals(200, roundPictureManager.getPicture().getCenter().getY());
        assertEquals(10, roundPictureManager.getPicture().getRadius());
        assertEquals("подпись", roundPictureManager.getPicture().getSignature());
    }

    @Test
    public void testPictureManager() throws GraphicException {
        Point center = new Point(10, 20);
        Picture picture = new SignedRoundPicture(center, 10, PictureFormat.GIF, "подпись");
        Manager<Picture> pictureManager = new Manager<>(picture);
        assertEquals(PictureFormat.GIF, pictureManager.getPicture().getFormat());
    }

    @Test
    public void testNullPictureManager() {
        try {
            Manager<Picture> pictureManager = new Manager<>(null);
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE, ex.getGraphicErrorCode());
        }
    }

    @Test
    public void testRectPictureArrayManager() throws GraphicException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 60);
        RectPicture rectPicture1 = new RectPicture(topLeft1, bottomRight1, "GIF");
        Point topLeft2 = new Point(20, 10);
        Point bottomRight2 = new Point(60, 30);
        RectPicture rectPicture2 = new RectPicture(topLeft2, bottomRight2, "GIF");
        RectPicture[] rects1 = new RectPicture[]{rectPicture1, rectPicture2};
        ArrayManager<RectPicture> rectPictureArrayManager1 = new ArrayManager<>(rects1);
        RectPicture[] rects2 = new RectPicture[]{rectPicture2, rectPicture1};
        ArrayManager<RectPicture> rectPictureArrayManager2 = new ArrayManager<>(rects2);
        assertTrue(rectPictureArrayManager1.isSameSize(rectPictureArrayManager2));
        assertEquals(rectPicture1, rectPictureArrayManager1.getPicture(0));
        assertEquals(rectPicture2, rectPictureArrayManager1.getPicture(1));
        assertEquals(rectPicture2, rectPictureArrayManager2.getPicture(0));
        assertEquals(rectPicture1, rectPictureArrayManager2.getPicture(1));
        rectPictureArrayManager2.setPicture(rectPicture1, 0);
        rectPictureArrayManager2.setPicture(rectPicture2, 1);
        assertEquals(rectPicture1, rectPictureArrayManager2.getPicture(0));
        assertEquals(rectPicture2, rectPictureArrayManager2.getPicture(1));
    }

    @SuppressWarnings("unused")
    @Test
    public void testNullPictureArrayManager() throws GraphicException {
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 60);
        RectPicture rectPicture = new RectPicture(topLeft, bottomRight, "GIF");
        RectPicture[] rects2 = new RectPicture[]{rectPicture, null};
        try {
            ArrayManager<RectPicture> rectPictureArrayManager2 = new ArrayManager<>(rects2);
            fail();
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE, ex.getGraphicErrorCode());
        }
    }

    @Test
    public void testRectPictureSignedRoundPictureArrayManager() throws GraphicException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectPicture rectPicture1 = new RectPicture(topLeft1, bottomRight1, "GIF");
        Point topLeft2 = new Point(110, 120);
        Point bottomRight2 = new Point(130, 140);
        RectPicture rectPicture2 = new RectPicture(topLeft2, bottomRight2, "GIF");
        RectPicture[] rects = new RectPicture[]{rectPicture1, rectPicture2};
        ArrayManager<RectPicture> rectPictureArrayManager = new ArrayManager<>(rects);
        Point center1 = new Point(10, 20);
        SignedRoundPicture roundPicture1 = new SignedRoundPicture(center1, 10, PictureFormat.GIF, "подпись");
        Point center2 = new Point(110, 120);
        SignedRoundPicture roundPicture2 = new SignedRoundPicture(center2, 10, PictureFormat.GIF, "подпись");
        SignedRoundPicture[] rounds = new SignedRoundPicture[]{roundPicture1, roundPicture2};
        ArrayManager<SignedRoundPicture> roundPictureArrayManager = new ArrayManager<>(rounds);
        assertTrue(rectPictureArrayManager.isSameSize(roundPictureArrayManager));
    }

    @Test
    public void testMixedPicturesArrayManager() throws GraphicException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        Picture rectPicture1 = new RectPicture(topLeft1, bottomRight1, "GIF");
        Point topLeft2 = new Point(110, 120);
        Point bottomRight2 = new Point(130, 140);
        Picture rectPicture2 = new RectPicture(topLeft2, bottomRight2, "GIF");
        Point center1 = new Point(10, 20);
        SignedRoundPicture roundPicture1 = new SignedRoundPicture(center1, 10, PictureFormat.GIF, "подпись");
        Point center2 = new Point(1000, 120);
        SignedRoundPicture roundPicture2 = new SignedRoundPicture(center2, 10, PictureFormat.GIF, "подпись");
        Picture[] pictures1 = new Picture[]{rectPicture1, roundPicture1};
        Picture[] pictures2 = new Picture[]{rectPicture2, roundPicture2};
        ArrayManager<Picture> arrayManager1 = new ArrayManager<>(pictures1);
        ArrayManager<Picture> arrayManager2 = new ArrayManager<>(pictures2);
        assertTrue(arrayManager1.isSameSize(arrayManager2));
        Desktop desktop = new Desktop();
        assertTrue(arrayManager1.allPicturesFullyVisibleOnDesktop(desktop));
        assertFalse(arrayManager2.allPicturesFullyVisibleOnDesktop(desktop));
        assertTrue(arrayManager2.anyPictureFullyVisibleOnDesktop(desktop));
        assertEquals(roundPicture1, arrayManager1.getFirstPictureFromCursor(new Cursor(3, 13, CursorForm.ARROW)));
        assertNull(arrayManager1.getFirstPictureFromCursor(new Cursor(-10, 20, CursorForm.ARROW)));
    }

    @Test
    public void testPairManager1() throws GraphicException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectPicture rectPicture1 = new RectPicture(topLeft1, bottomRight1, "GIF");
        Point center1 = new Point(10, 20);
        SignedRoundPicture roundPicture1 = new SignedRoundPicture(center1, 10, PictureFormat.GIF, "подпись");
        PairManager<RectPicture, SignedRoundPicture> pairManager1 = new PairManager<>(rectPicture1, roundPicture1);
        Point topLeft2 = new Point(110, 120);
        Point bottomRight2 = new Point(130, 140);
        RectPicture rectPicture2 = new RectPicture(topLeft2, bottomRight2, "GIF");
        Point center2 = new Point(110, 120);
        SignedRoundPicture roundPicture2 = new SignedRoundPicture(center2, 10, PictureFormat.GIF, "подпись");
        PairManager<RectPicture, SignedRoundPicture> pairManager2 = new PairManager<>(rectPicture2, roundPicture2);
        Desktop desktop = new Desktop();
        assertTrue(pairManager1.allPicturesFullyVisibleOnDesktop(pairManager2, desktop));
        assertTrue(PairManager.allPicturesFullyVisibleOnDesktop(pairManager1, pairManager2, desktop));
    }

    @Test
    public void testPairManager2() throws GraphicException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        Picture rectPicture1 = new RectPicture(topLeft1, bottomRight1, "GIF");
        Point center1 = new Point(10, 20);
        Picture roundPicture1 = new SignedRoundPicture(center1, 10, PictureFormat.GIF, "подпись");
        PairManager<Picture, Picture> pairManager1 = new PairManager<>(rectPicture1, roundPicture1);
        Point topLeft2 = new Point(110, 120);
        Point bottomRight2 = new Point(130, 140);
        Picture rectPicture2 = new RectPicture(topLeft2, bottomRight2, "GIF");
        Point center2 = new Point(110, 120);
        Picture roundPicture2 = new SignedRoundPicture(center2, 10, PictureFormat.GIF, "подпись");
        PairManager<Picture, Picture> pairManager2 = new PairManager<>(rectPicture2, roundPicture2);
        Desktop desktop = new Desktop();
        assertTrue(pairManager1.allPicturesFullyVisibleOnDesktop(pairManager2, desktop));
        assertTrue(PairManager.allPicturesFullyVisibleOnDesktop(pairManager1, pairManager2, desktop));
    }

    @Test
    public void testPairManager3() throws GraphicException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectPicture rectPicture1 = new RectPicture(topLeft1, bottomRight1, "GIF");
        Point topLeft2 = new Point(100, 200);
        Point bottomRight2 = new Point(300, 400);
        RectPicture rectPicture2 = new RectPicture(topLeft2, bottomRight2, "GIF");
        Point center1 = new Point(10, 20);
        SignedRoundPicture roundPicture1 = new SignedRoundPicture(center1, 10, PictureFormat.GIF, "подпись");
        PairManager<RectPicture, SignedRoundPicture> pairManager1 = new PairManager<>(rectPicture1, roundPicture1);
        Point center2 = new Point(100, 200);
        SignedRoundPicture roundPicture2 = new SignedRoundPicture(center2, 10, PictureFormat.GIF, "подпись");
        PairManager<RectPicture, SignedRoundPicture> pairManager2 = new PairManager<>(rectPicture2, roundPicture2);
        Desktop desktop = new Desktop();
        assertTrue(pairManager1.allPicturesFullyVisibleOnDesktop(pairManager2, desktop));
        assertTrue(PairManager.allPicturesFullyVisibleOnDesktop(pairManager1, pairManager2, desktop));
    }

    @Test
    public void testNullPicturePairManager() throws GraphicException {
        boolean failed = false;
        Point topLeft = new Point(10, 20);
        Point bottomRight = new Point(30, 40);
        Picture rectPicture = new RectPicture(topLeft, bottomRight, "GIF");
        try {
            new PairManager<>(rectPicture, null);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE, ex.getGraphicErrorCode());
        }
        try {
            new PairManager<>(null, rectPicture);
            failed = true;
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE, ex.getGraphicErrorCode());
        }
        if (failed) {
            fail();
        }

    }

    @Test
    public void testRectPictureNamedManager1() throws GraphicException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectPicture rectPicture1 = new RectPicture(topLeft1, bottomRight1, "GIF");
        NamedManager<RectPicture> rectPictureNamedManager = new NamedManager<>(rectPicture1, "Manager1");
        assertEquals("Manager1", rectPictureNamedManager.getName());
    }

    @Test
    public void testRectPictureNamedManager2() throws GraphicException {
        Point topLeft1 = new Point(10, 20);
        Point bottomRight1 = new Point(30, 40);
        RectPicture rectPicture1 = new RectPicture(topLeft1, bottomRight1, "GIF");
        NamedManager<Picture> rectPictureNamedManager = new NamedManager<>(rectPicture1, "Manager1");
        assertEquals("Manager1", rectPictureNamedManager.getName());
    }

    @Test
    public void testNullPictureNamedManager() throws GraphicException {
        try {
            NamedManager<Picture> pictureManager = new NamedManager<>(null, "GIF");
        } catch (GraphicException ex) {
            assertEquals(GraphicErrorCode.NULL_PICTURE, ex.getGraphicErrorCode());
        }
    }

/* 	@Test
	public void testMustNotBeCompiled() {
		Manager<String> stringManager = new Manager<String>("My String");
	}
*/
}


