package net.thumbtack.school.pictures.v3;

import net.thumbtack.school.exceptions.GraphicException;

public class PictureApp {
    public static void main(String[] args) throws GraphicException {
        RectPicture rp = new RectPicture(new Point(2,5), new Point(3,6), "STR");
        System.out.println(rp.getFormat());
    }
}
