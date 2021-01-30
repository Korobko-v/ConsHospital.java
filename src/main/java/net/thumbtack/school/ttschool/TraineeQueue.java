package net.thumbtack.school.ttschool;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TraineeQueue {
    Queue<Trainee> traineeQueue;

    public TraineeQueue() {
        traineeQueue = new LinkedList<>();
    }

    public void addTrainee(Trainee trainee) {
        this.traineeQueue.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        if (traineeQueue == null) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        if (traineeQueue.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
            return this.traineeQueue.poll();
    }

    public boolean isEmpty() {
        return this.traineeQueue.isEmpty();
    }
}
