package net.thumbtack.school.ttschool;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class School {
	// REVU все private
    String name;
    int year;
    Set<Group> groups;

    public School(String name, int year) throws TrainingException {
    	// REVU вызовите сеттеры, не дублируйте код
        try {
            this.name = name;
            if (name.equals("")) {
                throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
            }
        } catch (NullPointerException e) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
        try {
            this.year = year;
        } catch (Exception e) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_YEAR);
        }
        groups = new HashSet<>();
    }

    public String getName() {

        return name;
    }

    public void setName(String name) throws TrainingException {
    	// REVU не надо ловить NullPointerException. Просто проверьте на null 
        try {
            this.name = name;
            if (name.equals("")) {
                throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
            }
        } catch (NullPointerException e) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) throws TrainingException {

    	// REVU а что Вы тут ловите ? С какой стати при присваивании int в int может возникнуть исключение ?
        try {
            this.year = year;
        } catch (Exception e) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_YEAR);
        }
    }

    public Set<Group> getGroups() {

        return groups;
    }

    public void  addGroup(Group group) throws TrainingException {
    	// REVU Линейный проход для добавления - это плохо, медленно. Подумайте, как сделать, чтобы при формировании Set использовалось только name. Подсказка - кроме HashSet, есть и другой

        for (Group g : groups) {
            if (g.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }
        this.groups.add(group);
    }

    public void  removeGroup(Group group) throws TrainingException {
        if (!groups.contains(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
            this.groups.remove(group);
    }


    public void  removeGroup(String name) throws TrainingException {
        int i = groups.size();
        groups.removeIf(g -> g.getName().equals(name));
        if (groups.size() == i) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public boolean  containsGroup(Group group) {
    	// REVU то же
       for (Group g : groups) {
           if (g.getName().equals(group.getName())) {
               return true;
           }
       }
       return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year &&
                Objects.equals(name, school.name) &&
                Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, groups);
    }
}
