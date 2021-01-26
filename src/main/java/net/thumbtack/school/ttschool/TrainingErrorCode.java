package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Неверное имя"),
    TRAINEE_WRONG_LASTNAME("Неверная фамилия"),
    TRAINEE_WRONG_RATING("Неверная оценка");

    private String errorString;

    private TrainingErrorCode(String errorString){

        this.errorString = errorString;
    }

    private String getErrorString() {

        return errorString;
    }
}
