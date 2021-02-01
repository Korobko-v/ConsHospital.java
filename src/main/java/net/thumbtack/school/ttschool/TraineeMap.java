package net.thumbtack.school.ttschool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TraineeMap {
    Map<Trainee, String> traineeMap;
    public TraineeMap() {
        this.traineeMap = new HashMap<>();
    }

    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {

            if (traineeMap.putIfAbsent(trainee,institute) != null) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
            }
        traineeMap.putIfAbsent(trainee,institute);

    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (traineeMap.putIfAbsent(trainee,institute) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
            this.traineeMap.replace(trainee, traineeMap.get(trainee), institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {

        if (traineeMap.putIfAbsent(trainee, traineeMap.get(trainee)) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
            traineeMap.remove(trainee);

    }

    public int getTraineesCount() {
        return this.traineeMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (traineeMap.putIfAbsent(trainee, traineeMap.get(trainee)) == null) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
            return this.traineeMap.get(trainee);
    }

    public Set<Trainee> getAllTrainees() {
        return this.traineeMap.keySet();
    }

    public Set<String> getAllInstitutes() {
        return new HashSet<>(traineeMap.values());
    }

    public boolean isAnyFromInstitute(String institute) {
        return traineeMap.containsValue(institute);
    }
}
