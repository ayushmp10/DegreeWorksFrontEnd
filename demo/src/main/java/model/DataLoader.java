package model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends DataConstants{
	
	public static ArrayList<Student> loadStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			FileReader reader = new FileReader(STUDENT_FILE_NAME);
			JSONParser parser = new JSONParser();	
			JSONArray studentJSONArray = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < studentJSONArray.size(); i++) {
				JSONObject studentJSON = (JSONObject)studentJSONArray.get(i);
				UUID id = UUID.fromString((String)studentJSON.get(USER_UUID));
				String username = (String)studentJSON.get(USER_USERNAME);
				String password = (String)studentJSON.get(USER_PASSWORD);
				String firstName = (String)studentJSON.get(USER_FIRST_NAME);
				String lastName = (String)studentJSON.get(USER_LAST_NAME);
				String phoneNumber = (String)studentJSON.get(USER_PHONE_NUMBER);
				String year = (String)studentJSON.get(STUDENT_YEAR);
				String uscID = (String)studentJSON.get(STUDENT_USC_ID);
				String major = (String)studentJSON.get(STUDENT_MAJOR);
				ArrayList<String> completedCourses = (ArrayList<String>)studentJSON.get(STUDENT_COMPLETED_COURSES);
				Long completedCredits = (Long)studentJSON.get(STUDENT_COMPLETED_CREDITS);
				Long totalCredits = (Long)studentJSON.get(STUDENT_TOTAL_CREDITS);
				UUID advisorId = UUID.fromString((String)studentJSON.get(STUDENT_ADVISOR));
				// TODO create an advisor based on the uuid given
				UUID guardianId = UUID.fromString((String)studentJSON.get(STUDENT_GUARDIAN));
				// TODO create a guardian based on the uuid given
				String applicationArea = (String)studentJSON.get(STUDENT_APPLICATION_AREA);
				String advisorNotes = (String)studentJSON.get(STUDENT_ADVISING_NOTES);
				// need to figure out how completed courses are stored with their grades TODO update student class
				students.add(new Student(id, username, password, firstName, lastName, completedCourses,
											year, major, completedCredits, totalCredits, phoneNumber, advisorId,
											guardianId, uscID, applicationArea, advisorNotes));
			}
			
			return students;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static ArrayList<Advisor> getAdvisors() {
		ArrayList<Advisor> advisors = new ArrayList<Advisor>();

		try {
			FileReader reader = new FileReader(ADVISOR_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray advisorJSONArray = (JSONArray)new JSONParser().parse(reader);

			for (int i = 0; i < advisorJSONArray.size(); i++) {
				JSONObject advisorJSON = (JSONObject)advisorJSONArray.get(i);
				UUID id = UUID.fromString((String)advisorJSON.get(USER_UUID));
				String username = (String)advisorJSON.get(USER_USERNAME);
				String password = (String)advisorJSON.get(USER_PASSWORD);
				String firstName = (String)advisorJSON.get(USER_FIRST_NAME);
				String lastName = (String)advisorJSON.get(USER_LAST_NAME);
				// figure out how to store all the stuednts the advisor has
				// the json file will store them with their uuids
				// needs to be converted to students instead of uuids
				// 	or keep it as uuids and get the data when required 
				// 	to do this would need to create a getStudent method where the JSON file is searched for the specific UUID
				ArrayList<String> students = (ArrayList<String>)advisorJSON.get(ADVISOR_ASSIGNED_STUDENTS);
				String phoneNumber = (String)advisorJSON.get(USER_PHONE_NUMBER);
				String building = (String)advisorJSON.get(ADVISOR_BUILDING);
				String roomNumber = (String)advisorJSON.get(ADVISOR_ROOM_NUMBER);
				advisors.add(new Advisor(id, username, password, firstName, lastName, students, phoneNumber, building, roomNumber));
			}
			return advisors;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// Don't need this for scenarios 1 and 2 can implement later
	public static ArrayList<Guardian> getGuardians() {
		ArrayList<Guardian> guardians = new ArrayList<Guardian>();

		try {
			FileReader reader = new FileReader(PARENT_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray guardianJSONArray = (JSONArray)new JSONParser().parse(reader);

			for (int i = 0; i < guardianJSONArray.size(); i++) {
				JSONObject guardianJSON = (JSONObject)guardianJSONArray.get(i);
				UUID id = UUID.fromString((String)guardianJSON.get(USER_UUID));
				String username = (String)guardianJSON.get(USER_USERNAME);
				String password = (String)guardianJSON.get(USER_PASSWORD);
				String firstName = (String)guardianJSON.get(USER_FIRST_NAME);
				String lastName = (String)guardianJSON.get(USER_LAST_NAME);
				// figure out how to store all the stuednts the advisor has
				// the json file will store them with their uuids
				// needs to be converted to students instead of uuids
				// 	or keep it as uuids and get the data when required 
				// 	to do this would need to create a getStudent method where the JSON file is searched for the specific UUID
				UUID student = UUID.fromString((String)guardianJSON.get(PARENT_CHILDREN));
				String phoneNumber = (String)guardianJSON.get(USER_PHONE_NUMBER);
				guardians.add(new Guardian(id, username, password, firstName, lastName, phoneNumber, student, true));
			}
			return guardians;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static ArrayList<Course> getCourses() {
		ArrayList<Course> courses = new ArrayList<Course>();

		try {
			FileReader reader = new FileReader(COURSE_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray courseJSONArray = (JSONArray) new JSONParser().parse(reader);

			for (int i = 0; i < courseJSONArray.size(); i++) {
				JSONObject courseJSON = (JSONObject)courseJSONArray.get(i);
				UUID id = UUID.fromString((String)courseJSON.get(COURSE_SET_UUID));
				String subject = (String)courseJSON.get(COURSE_SET_SUBJECT);
				String number = (String)courseJSON.get(COURSE_NUMBER);
				String name = (String)courseJSON.get(COURSE_NAME);
				String description = (String)courseJSON.get(COURSE_DESCRIPTION);
				String credits = (String)courseJSON.get(COURSE_CREDIT_HOURS);
				// TODO check if this is a valid way of reading an array from the json file
				ArrayList<String> semestersOffered = (ArrayList<String>)courseJSON.get(COURSE_SEMESTER_OFFERED);
				// the array list type needs to be determined (don't know what object is used to store the information in the scraped file)
				// temporarily we are saving it as course but it isn't that
				ArrayList<String> prerequisites = (ArrayList<String>)courseJSON.get(COURSE_PREREQUISITES);
				ArrayList<String> corequisites = (ArrayList<String>)courseJSON.get(COURSE_COREQUISITES);
				ArrayList<String> courseCoreCategories = (ArrayList<String>)courseJSON.get(COURSE_CORE_CATEGORIES);

				courses.add(new Course(id, subject, number, name, description, credits, 
							 semestersOffered, prerequisites, corequisites, courseCoreCategories));
			}
			return courses;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
