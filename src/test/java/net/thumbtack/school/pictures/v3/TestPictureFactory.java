package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPictureFactory {

    @Test
    @SuppressWarnings("unused")
    public void testPictureFactory() throws GraphicException {
        RectPicture rectPicture1 = PictureFactory.createRectPicture(new Point(10, 20), new Point(30, 40), PictureFormat.GIF);
        RectPicture rectPicture2 = PictureFactory.createRectPicture(new Point(110, 120), new Point(130, 140), PictureFormat.GIF);
        RoundPicture roundPicture1 = PictureFactory.createRoundPicture(new Point(10, 20), 10, PictureFormat.GIF);
        RoundPicture roundPicture2 = PictureFactory.createRoundPicture(new Point(110, 120), 10, PictureFormat.GIF);
        RoundPicture roundPicture3 = PictureFactory.createRoundPicture(new Point(210, 220), 10, PictureFormat.GIF);
        assertEquals(2, PictureFactory.getRectPictureCount());
        assertEquals(3, PictureFactory.getRoundPictureCount());
        assertEquals(5, PictureFactory.getPictureCount());
        PictureFactory.reset();
        assertEquals(0, PictureFactory.getPictureCount());
    }

}
