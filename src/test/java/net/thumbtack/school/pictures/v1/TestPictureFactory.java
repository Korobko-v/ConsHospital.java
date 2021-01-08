package net.thumbtack.school.pictures.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPictureFactory {

    @Test
    @SuppressWarnings("unused")
    public void testPictureFactory() {
        RectPicture rectPicture1 = PictureFactory.createRectPicture(new Point(10, 20), new Point(30, 40), 1);
        RectPicture rectPicture2 = PictureFactory.createRectPicture(new Point(110, 120), new Point(130, 140), 1);
        RoundPicture roundPicture1 = PictureFactory.createRoundPicture(new Point(10, 20), 10, 1);
        RoundPicture roundPicture2 = PictureFactory.createRoundPicture(new Point(110, 120), 10, 1);
        RoundPicture roundPicture3 = PictureFactory.createRoundPicture(new Point(210, 220), 10, 1);
        assertEquals(2, PictureFactory.getRectPictureCount());
        assertEquals(3, PictureFactory.getRoundPictureCount());
        assertEquals(5, PictureFactory.getPictureCount());
        PictureFactory.reset();
        assertEquals(0, PictureFactory.getPictureCount());
    }

}
