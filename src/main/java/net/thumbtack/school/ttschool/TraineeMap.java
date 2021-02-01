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
    	// REVU не нужно containsKey, putIdAbsent сама скажет
        if (this.traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);
        }
        traineeMap.put(trainee,institute);
    }

    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
    	// REVU то же
        if (!traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
            this.traineeMap.replace(trainee, traineeMap.get(trainee), institute);
    }

    public void removeTraineeInfo(Trainee trainee) throws TrainingException {

    	// REVU то же
        if (!traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
            traineeMap.remove(trainee);

    }

    public int getTraineesCount() {
        return this.traineeMap.size();
    }

    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
    	// REVU то же
        if (!traineeMap.containsKey(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
            return this.traineeMap.get(trainee);
    }

    public Set<Trainee> getAllTrainees() {
        return this.traineeMap.keySet();
    }

    public Set<String> getAllInstitutes() {
    	// REVU в одну строчку!
        Set<String> institutes = new HashSet<>(traineeMap.values());
        return institutes;
    }

    public boolean isAnyFromInstitute(String institute) {
    	// REVU не пишите this, если нет необходимости
        return this.traineeMap.containsValue(institute);
    }
}
