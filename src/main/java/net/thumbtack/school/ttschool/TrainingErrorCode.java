package net.thumbtack.school.ttschool;

public enum TrainingErrorCode {
    TRAINEE_WRONG_FIRSTNAME("Неверное имя"),
    TRAINEE_WRONG_LASTNAME("Неверная фамилия"),
    TRAINEE_WRONG_RATING("Неверная оценка"),
    TRAINEE_NOT_FOUND("Студент не найден"),
    GROUP_WRONG_NAME("Неверное название"),
    DUPLICATE_GROUP_NAME("Группа уже существует"),
    GROUP_NOT_FOUND("Такой группы нет"),
    DUPLICATE_TRAINEE("Студент уже в списке"),
    SCHOOL_WRONG_NAME("Неверное название"),
    SCHOOL_WRONG_YEAR("Неверный формат"),
    EMPTY_TRAINEE_QUEUE("Пустая очередь"),
    GROUP_WRONG_ROOM("Неверная аудитория");

    private String errorString;

    private TrainingErrorCode(String errorString){

        this.errorString = errorString;
    }

    private String getErrorString() {

        return errorString;
    }
}
