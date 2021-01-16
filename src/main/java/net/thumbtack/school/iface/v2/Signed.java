package net.thumbtack.school.iface.v2;

import net.thumbtack.school.exceptions.GraphicException;

public interface Signed {
    String getSignature();
    void setSignature(String signature) throws GraphicException;
}