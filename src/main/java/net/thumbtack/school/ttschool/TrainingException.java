package net.thumbtack.school.ttschool;

import net.thumbtack.school.exceptions.v3.GraphicErrorCode;

public class TrainingException extends Exception {
    private TrainingErrorCode trainingErrorCode;

    public TrainingException(TrainingErrorCode trainingErrorCode) {
        this.trainingErrorCode = trainingErrorCode;
    }

    public TrainingErrorCode getErrorCode() {
        return trainingErrorCode;
    }
}
