package net.thumbtack.school.pictures.managers;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.winobjects.v3.Desktop;
import net.thumbtack.school.pictures.v3.Picture;

public class PairManager <A extends Picture, B extends Picture> {
    private A firstPicture;
    private B secondPicture;

    public PairManager(A firstPicture, B secondPicture) throws GraphicException {
        if (firstPicture == null || secondPicture == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
        this.firstPicture = firstPicture;
        this.secondPicture = secondPicture;
    }

    public A getFirstPicture() {

        return firstPicture;
    }

    public void setFirstPicture(A firstPicture) throws GraphicException {
        if (firstPicture == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
        this.firstPicture = firstPicture;
    }

    public B getSecondPicture() throws GraphicException {
        return secondPicture;
    }

    public void setSecondPicture(B secondPicture) throws GraphicException {
        if (secondPicture == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }
        this.secondPicture = secondPicture;
    }

    boolean allPicturesFullyVisibleOnDesktop(PairManager<? extends Picture,? extends Picture> anotherPairManager, Desktop desktop) throws GraphicException {
        return (allPicturesFullyVisibleOnDesktop(new PairManager<Picture, Picture>(this.firstPicture, this.secondPicture), anotherPairManager, desktop));
    }

    static boolean allPicturesFullyVisibleOnDesktop(PairManager<?, ?> firstManager, PairManager<?, ?> anotherPairManager, Desktop desktop) {
        if (firstManager.firstPicture.isFullyVisibleOnDesktop(desktop) && firstManager.secondPicture.isFullyVisibleOnDesktop(desktop)
                && anotherPairManager.firstPicture.isFullyVisibleOnDesktop(desktop) && anotherPairManager.secondPicture.isFullyVisibleOnDesktop(desktop)) {
            return true;
        }
        return false;
    }

}
