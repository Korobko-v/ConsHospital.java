package net.thumbtack.school.ttschool;

import java.util.*;

public class School implements Comparator<Group> {
    private String name;
    private int year;
    private TreeSet<Group> groups;

    public School(String name, int year) throws TrainingException  {
    	this.setName(name);
    	this.setYear(year);
        groups = new TreeSet<Group>((o1, o2) -> o1.getName().compareTo(o2.getName()));
    }

    public String getName() {

        return name;
    }

    public void setName(String name) throws TrainingException {
        if (name == null || name.equals("")) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
            this.name = name;

    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
            this.year = year;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void  addGroup(Group group) throws TrainingException {
        if (containsGroup(group)) {
            throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
        }
        groups.add(group);
    }

    public void  removeGroup(Group group) throws TrainingException {
        if (!containsGroup(group)) {
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

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }


    @Override
    public int compare(Group o1, Group o2) {
        return o1.getName().compareTo(o2.getName());
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
