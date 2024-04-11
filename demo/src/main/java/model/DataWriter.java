package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	
	// public static void saveUsers() {
	// 	UserList users = UserList.getInstance();
	// 	ArrayList<User> userList = users.getUsers();
	// 	JSONArray jsonUsers = new JSONArray();
		
	// 	//creating all the json objects
	// 	for(int i=0; i< userList.size(); i++) {
	// 		jsonUsers.add(getUserJSON(userList.get(i)));
	// 	}
	// 	//Write JSON file
    //     try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {
 
    //         file.write(jsonUsers.toJSONString());
    //         file.flush();
 
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
	// }

    public static void saveStudents() {
        UserList userList = UserList.getInstance();
        ArrayList<Student> studentList = userList.getStudents();
        JSONArray jsonStudents = new JSONArray();
        for (int i = 0; i < studentList.size(); i++) {
            jsonStudents.add(getUserJSON(studentList.get(i)));
        }
        try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {
            file.write(jsonStudents.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveAdvisors() {
        UserList userList = UserList.getInstance();
        ArrayList<Advisor> advisorList = userList.getAdvisors();// make sure this method is created in UserList
        JSONArray jsonAdvisors = new JSONArray();
        for (int i = 0; i < advisorList.size(); i++) {
            jsonAdvisors.add(getUserJSON(advisorList.get(i)));
        }
        try (FileWriter file = new FileWriter(ADVISOR_FILE_NAME)) {
            file.write(jsonAdvisors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveGuardians() {
        UserList userList = UserList.getInstance();
        ArrayList<Guardian> guardianList = userList.getGuardians();// make sure this method is created in UserList
        JSONArray jsonGuardians = new JSONArray();
        for (int i = 0; i < guardianList.size(); i++) {
            jsonGuardians.add(getUserJSON(guardianList.get(i)));
        }
        try (FileWriter file = new FileWriter(PARENT_FILE_NAME)) {
            file.write(jsonGuardians.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_UUID, user.getID().toString());
        userDetails.put(USER_USERNAME, user.getUsername());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_PASSWORD, user.getPassword());
		userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
        if (user instanceof Student) {
            Student student = (Student) user;
            userDetails.put(STUDENT_COMPLETED_COURSES, student.getCompletedCourses());
            userDetails.put(STUDENT_YEAR, student.getYear());
            userDetails.put(STUDENT_MAJOR, student.getMajor());
            userDetails.put(STUDENT_COMPLETED_CREDITS, student.getCompletedCredits());
            userDetails.put(STUDENT_TOTAL_CREDITS, student.getTotalCredits());
            userDetails.put(STUDENT_ADVISOR, student.getAdvisor().toString());
            userDetails.put(STUDENT_GUARDIAN, student.getGuardian().toString());
            userDetails.put(STUDENT_APPLICATION_AREA, student.getApplicationArea());
            userDetails.put(STUDENT_USC_ID, student.getUSCID());
            userDetails.put(STUDENT_ADVISING_NOTES, student.getAdvisorNotes());
        }
        else if (user instanceof Advisor) {
            Advisor advisor = (Advisor) user;
            // userDetails.put(ADVISOR_ASSIGNED_STUDENTS, advisor.getStudents());
            userDetails.put(ADVISOR_BUILDING, advisor.getBuilding());
            userDetails.put(ADVISOR_ROOM_NUMBER, advisor.getRoomNumber());
        }
        
        return userDetails;
	}
}
