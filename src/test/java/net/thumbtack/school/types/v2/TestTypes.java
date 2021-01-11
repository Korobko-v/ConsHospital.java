package net.thumbtack.school.types.v2;

import net.thumbtack.school.iface.v2.Movable;
import net.thumbtack.school.pictures.v2.*;
import net.thumbtack.school.winobjects.v2.Cursor;
import net.thumbtack.school.iface.v2.Resizable;
import net.thumbtack.school.iface.v2.Signed;
import net.thumbtack.school.winobjects.v2.Icon;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class TestTypes {

    private boolean isAbstract(Class<?> clazz) {
        return (clazz.getModifiers() & Modifier.ABSTRACT) != 0;
    }

    @Test
    public void testTypes() throws NoSuchMethodException {
        assertTrue(Movable.class.isInterface());
        assertTrue(Resizable.class.isInterface());
        assertTrue(Signed.class.isInterface());
        assertTrue(Movable.class.isAssignableFrom(Picture.class));
        assertTrue(Resizable.class.isAssignableFrom(Picture.class));
        assertTrue(Movable.class.isAssignableFrom(Cursor.class));
        assertFalse(Resizable.class.isAssignableFrom(Cursor.class));
        assertTrue(Movable.class.isAssignableFrom(Icon.class));
        assertTrue(Signed.class.isAssignableFrom(Icon.class));
        assertFalse(Resizable.class.isAssignableFrom(Icon.class));
        assertTrue(Signed.class.isAssignableFrom(SignedRectPicture.class));
        assertTrue(Signed.class.isAssignableFrom(SignedRoundPicture.class));
        assertEquals(0, (Movable.class.getMethod("moveTo", Point.class).getModifiers() & Modifier.ABSTRACT));
        assertTrue(isAbstract(Picture.class));
        assertFalse(isAbstract(RectPicture.class));
        assertFalse(isAbstract(RoundPicture.class));
    }
}
