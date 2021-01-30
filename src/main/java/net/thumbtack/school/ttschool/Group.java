package net.thumbtack.school.ttschool;

import java.util.*;

public class Group {
    String name;
    String room;
    List<Trainee> trainees;

    public Group(String name, String room) throws TrainingException {
        if (name == null || name.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        }
            this.name = name;
        if (room == null || room.equals("")) {
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        }
            this.room = room;
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
        if (!this.trainees.contains(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
            this.trainees.remove(trainee);



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

    public void sortTraineeListByFirstNameAscendant() throws TrainingException {
        String[] names = new String[this.trainees.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = this.trainees.get(i).getFirstName();
        }
        Arrays.parallelSort(names);
        List<Trainee> sortedList = new ArrayList<>();
        for (String s : names) {
            sortedList.add(getTraineeByFirstName(s));
            this.trainees.remove(getTraineeByFirstName(s));
        }
        this.trainees = sortedList;
    }

    public void sortTraineeListByRatingDescendant() throws TrainingException {
        Integer[] rates = new Integer[this.trainees.size()];
        for (int i = 0; i < rates.length; i++) {
            rates[i] = this.trainees.get(i).getRating();
        }
        Arrays.parallelSort(rates, Collections.reverseOrder());
        List<Trainee> sortedList = new ArrayList<>();
        for (int s : rates) {
           for (Trainee t : this.trainees) {
               if (t.getRating() == s) {
                   sortedList.add(t);
               }
        }

        }
        this.trainees = sortedList;
    }

    public void  reverseTraineeList() {

        Collections.reverse(this.trainees);
    }

    public void  rotateTraineeList(int positions) {
        Collections.rotate(this.trainees, positions);
        }



    public List<Trainee>  getTraineesWithMaxRating() throws TrainingException {
        int maxRating = Integer.MIN_VALUE;
        if (this.trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        List<Trainee> traineesWithMaxRating = new ArrayList<>();
        for (Trainee t : this.trainees) {
            maxRating = Math.max(maxRating, t.getRating());
        }
        for (Trainee t : this.trainees) {
            if (t.getRating() == maxRating) {
                traineesWithMaxRating.add(t);
            }
        }
        return traineesWithMaxRating;
    }

    public boolean  hasDuplicates() {
        Set<Trainee> set = new HashSet<>();
        set.addAll(this.trainees);
        return (this.trainees.size() != set.size());
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
