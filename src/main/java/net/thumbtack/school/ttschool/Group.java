package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    private String name;
    private String room;
    private List<Trainee> trainees;

    public Group(String name, String room) throws TrainingException {
    	this.setName(name);
        this.setRoom(room);
        this.trainees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
            this.room = room;
    }

    public List<Trainee> getTrainees() {

        return trainees;
    }

    public void addTrainee(Trainee trainee) {
            this.trainees.add(trainee);
    }

    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
            trainees.remove(trainee);
    }

    public void removeTrainee(int index) throws TrainingException {
        if (index < 0 || index >= this.trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        this.trainees.remove(index);
    }


    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for (Trainee trainee : this.trainees) {
            if (trainee.getFirstName().equals(firstName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public Trainee  getTraineeByFullName(String fullName) throws TrainingException {
        for (Trainee trainee : this.trainees) {
            if (trainee.getFullName().equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        Collections.sort(trainees, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
    }

    public void sortTraineeListByRatingDescendant() {
        Collections.sort(trainees, (o1, o2) -> o2.getRating() - o1.getRating());
    }

    public void  reverseTraineeList() {

        Collections.reverse(this.trainees);
    }

    public void  rotateTraineeList(int positions) {
        Collections.rotate(this.trainees, positions);
        }



    public List<Trainee>  getTraineesWithMaxRating() throws TrainingException {
        if (this.trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        sortTraineeListByRatingDescendant();
        List<Trainee> traineesWithMaxRating = new ArrayList<>();
        for (int i = 0; i < trainees.size(); i++) {
            if (trainees.get(i).getRating() == trainees.get(0).getRating()) {
                traineesWithMaxRating.add(trainees.get(i));
            }
            else {
                break;
            }
        }
        return traineesWithMaxRating;
    }

    public boolean  hasDuplicates() {
        return (this.trainees.size() != new HashSet<>(trainees).size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}
