package com.example.move_in_sync;

public class student {
    int id;
    String Name, Marks, Student_class;
    boolean selected = false;

    public student(int id, String name, String marks, String student_class, boolean selected) {
        this.id = id;
        Name = name;
        Marks = marks;
        Student_class = student_class;
        this.selected = selected;
    }

    public student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMarks() {
        return Marks;
    }

    public void setMarks(String marks) {
        Marks = marks;
    }

    public String getStudent_class() {
        return Student_class;
    }

    public void setStudent_class(String student_class) {
        Student_class = student_class;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
