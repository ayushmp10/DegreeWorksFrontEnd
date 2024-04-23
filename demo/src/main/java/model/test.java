package model;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<User> allUsers = DataLoader.loadUser();
        // DegreeList degreelist = DegreeList.getInstance();
        // Degree degree = degreelist.getDegree(UUID.fromString("dfa84645-4278-44a3-8b3b-c6b4fc6257c5"));
        // HashMap<Course, Integer> majorCourses = degree.getMajorCourses();
        // for (Map.Entry<Course, Integer> majorCourse : majorCourses.entrySet()) {
        //     System.out.println(majorCourse.getKey().toString() + " " +  majorCourse.getValue());
        // }
        
        // for (User user : allUsers) {
        //     if (user instanceof Student) {
        //         Student tempStudent = (Student) user;
        //         if (tempStudent.getDegree() != null)
        //             ArrayList<Semester> eightSemesterPlan = tempStudent.getEightSemesterPlan();
        //     }
        // }
    }
}
