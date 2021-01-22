package net.thumbtack.school.pictures.managers;

import net.thumbtack.school.exceptions.GraphicException;
import net.thumbtack.school.exceptions.v3.GraphicErrorCode;
import net.thumbtack.school.pictures.v3.Picture;

// REVU Manager is a raw type. References to generic type Manager<T> should be parameterized
public class NamedManager <T> extends Manager {
    String name;
    public NamedManager(Picture obj, String name) throws GraphicException {
        super(obj);
        if (obj == null) {
            throw new GraphicException(GraphicErrorCode.NULL_PICTURE);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
