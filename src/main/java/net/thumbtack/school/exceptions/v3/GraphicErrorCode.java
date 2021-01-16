package net.thumbtack.school.exceptions.v3;

public enum GraphicErrorCode {
    WRONG_PICTURE_FORMAT("Неверный формат картинки"),
    NULL_PICTURE_FORMAT("Недопустимый формат картинки (null)"),
    NULL_SIGNATURE("Недопустимая подпись (null)");
    private String errorString;

    private GraphicErrorCode(String errorString){

        this.errorString = errorString;
    }

    private String getErrorString() {
        return errorString;
    }
}
