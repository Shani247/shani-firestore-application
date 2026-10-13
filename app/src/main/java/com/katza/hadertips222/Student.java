package com.katza.hadertips222;

public class Student {
    private String fullName, id;
    private int grade;
    public Student() {
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
    public String getFullName() {
        return fullName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", id='" + id + '\'' +
                ", grade=" + grade +
                '}';
    }
}
