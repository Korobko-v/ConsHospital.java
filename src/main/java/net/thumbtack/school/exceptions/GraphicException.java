package net.thumbtack.school.exceptions;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;

public class GraphicException extends Exception {

    private GraphicErrorCode graphicErrorCode;

    public GraphicException(GraphicErrorCode graphicErrorCode) {
        this.graphicErrorCode = graphicErrorCode;
    }

    public GraphicErrorCode getGraphicErrorCode() {
        return graphicErrorCode;
    }
}
