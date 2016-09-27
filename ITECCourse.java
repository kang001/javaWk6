package com.Kara;

import java.util.ArrayList;

public class ITECCourse {

    private String name;
    private int code;
    private ArrayList<String> students = new ArrayList<String>();
    private int maxStudents;

    public int getMaxStudents(int maxStudents){
        return maxStudents;
    }
    public void setMaxStudents(int maxStudents){
        this.maxStudents = maxStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ITECCourse(String courseName, int courseCode, int courseMaxStudents){
        this.name = courseName;
        this.code = courseCode;
        this.students = new ArrayList<String>();
        this.maxStudents = courseMaxStudents;
    }
    public void addStudent(String studentName){
        if (students.size() == maxStudents){
            System.out.println("The course is full - cannot enroll " + studentName);
        } else {
            students.add(studentName);
        }
        students.add(studentName);
    }
    void removeStudent(String studentName){
        if (students.contains(studentName)){
            students.remove(studentName);
            System.out.println(studentName + " was un-enrolled from " +this.name);
        } else {
            System.out.println(studentName + " was not found in " + this.name);
        }
    }
    int getNumberOfStudents(){
        return this.students.size();
    }

    void writeCourseInfo(){
        System.out.println("Course Name " + name);
        System.out.println("Course Code " + code);
        System.out.println("Students Enrolled");
        for (String student : students){
            System.out.println(student);
        }
        System.out.println("There are " + getNumberOfStudents() + " students enrolled");
        System.out.println("The max number of students for this course is " + maxStudents);
    }
}
