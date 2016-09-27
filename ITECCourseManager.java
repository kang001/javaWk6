package com.Kara;

public class ITECCourseManager {

    public static void main(String[] args) {

        ITECCourse maintenance = new ITECCourse("Microcomputer Systems Maintenance",
                1310, 20);

        maintenance.addStudent("Clara");
        maintenance.addStudent("Bob");

        //maintenance.writeCourseInfo();

        ITECCourse comm = new ITECCourse("Data Communications",
                5020, 30);

        comm.addStudent("Po");
        comm.addStudent("LaLa");

        //comm.writeCourseInfo();

        ITECCourse java = new ITECCourse("Java Programming", 2545, 2);
        java.addStudent("Gus");
        java.addStudent("Harry");

        java.addStudent("Lizzy");

        //java.writeCourseInfo();

        //java.removeStudent("Gus");
    }
}
