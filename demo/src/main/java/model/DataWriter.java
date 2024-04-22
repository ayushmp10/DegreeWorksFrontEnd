package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    // store everything into HashMaps and then write them as objects
    public static void saveDegrees(ArrayList<Degree> degrees) {
        JSONArray degreesArray = new JSONArray();
        for (Degree degree : degrees) {
            HashMap<String, Object> degreeObject = new HashMap<String, Object>();
            // fill in generic degree information
            degreeObject.put(DEGREE_UUID, degree.getUUID().toString());
            degreeObject.put(DEGREE_TOTAL_REQ_CREDIT, degree.getTotalCreditsRequired());
            degreeObject.put(DEGREE_MAJOR_COURSE, createCoursePrefSemObject(degree.getMajorCourses()));
            degreeObject.put(DEGREE_SUBJECT_NAME, degree.getSubject());
            // get all electives relating to degree
            JSONArray electivesArray = new JSONArray();
            ArrayList<Elective> electives = degree.getElectives();
            for (Elective elective : electives) {
                electivesArray.add(createElectiveObject(elective));
            }
            degreeObject.put(DEGREE_ELECTIVES, electives);
            degreesArray.add(degreeObject);
        }

        // write to the file
        writeData(DEGREE_FILE_NAME, degreesArray);
    }

    // save user
    public static void saveUsers(ArrayList<User> allUsers) {
        // separate objects for students, advisors, and guardians
        JSONArray allStudentsArray = new JSONArray();
        JSONArray allAdvisorsArray = new JSONArray();
        JSONArray allGuardiansArray = new JSONArray();
        for (User user : allUsers) {
            // generic user information
            HashMap<String, Object> userObject = new HashMap<String, Object>();
            userObject.put(USER_UUID, user.getID().toString());
            userObject.put(USER_USERNAME, user.getUsername());
            userObject.put(USER_PASSWORD, user.getPassword());
            userObject.put(USER_PHONE_NUMBER, user.getPhoneNumber());
            userObject.put(USER_FIRST_NAME, user.getFirstName());
            userObject.put(USER_LAST_NAME, user.getLastName());
            // get specific information for students, advisors and guardians
            if (user instanceof Student) {
                getStudentInformation(userObject, (Student) user);
                allStudentsArray.add(new JSONObject(userObject));
            } else if (user instanceof Advisor) {
                getAdvisorInformation(userObject, (Advisor) user);
                allAdvisorsArray.add(new JSONObject(userObject));
            } else if (user instanceof Guardian) {
                getGuardianInformation(userObject, (Guardian) user);
                allGuardiansArray.add(new JSONObject(userObject));
            }
        }

        writeData(STUDENT_FILE_NAME, allStudentsArray);
        writeData(ADVISOR_FILE_NAME, allAdvisorsArray);
        writeData(PARENT_FILE_NAME, allGuardiansArray);
    }

    private static void getStudentInformation(HashMap<String, Object> studentMap, Student student) {
        studentMap.put("type", "Student");
        studentMap.put(STUDENT_USC_ID, student.getUSCID());
        studentMap.put(STUDENT_YEAR, student.getYear());
        // assign an advisor to a student if they don't have one
        if (student.getAdvisor() != null) {
            studentMap.put(STUDENT_ADVISOR, student.getAdvisor().toString());
        } else {
            studentMap.put(STUDENT_ADVISOR, "none");
        }
        // get the advisor notes for the student
        JSONArray notes = new JSONArray();
        notes.add(student.getAdvisorNotes());
        studentMap.put(STUDENT_ADVISING_NOTES, notes);

        if (student.getDegree() != null) {
            studentMap.put(STUDENT_DEGREE_ID, student.getDegree().getUUID().toString());
        } else {
            studentMap.put(STUDENT_DEGREE_ID, UUID.randomUUID().toString());
        }

        studentMap.put(STUDENT_GPA, student.getGPA());
        studentMap.put(STUDENT_COMPLETED_COURSES, createCompletedCoursesObject(student.getCompletedCourses()));
        studentMap.put(STUDENT_COMPLETED_CREDITS, student.getCompletedCredits());
        studentMap.put(STUDENT_ALL_SEMESTERS, createAllSemestersObject(student.getAllSemesters()));
        studentMap.put(STUDENT_CURRENT_SEMESTER, createSemesterObject(student.getCurrSemester()));
    }

    private static void getAdvisorInformation(HashMap<String, Object> advisorMap, Advisor advisor) {
        advisorMap.put(ADVISOR_BUILDING, advisor.getBuilding());
        advisorMap.put(ADVISOR_ROOM_NUMBER, advisor.getRoomNumber());
        // store all of the advisor's students
        ArrayList<Student> advisorStudentList = advisor.getStudents();
        JSONArray studentsArray = new JSONArray();
        for (Student student : advisorStudentList) {
            studentsArray.add(student.getID().toString());
        }
        advisorMap.put(ADVISOR_ASSIGNED_STUDENTS, studentsArray);
    }

    private static void getGuardianInformation(HashMap<String, Object> guardianMap, Guardian guardian) {
        // need implementation
    }

    private static JSONObject createCoursePrefSemObject(HashMap<Course, Integer> coursePrefSem) {
        if (coursePrefSem == null) {
            return new JSONObject();
        }

        JSONObject coursePrefSemObject = new JSONObject();
        coursePrefSem.forEach((Course, prefSemester) -> {
            coursePrefSemObject.put(Course.getUUID().toString(), prefSemester);
        });
        return coursePrefSemObject;
    }

    private static JSONObject createElectiveObject(Elective elective) {
        HashMap<String, Object> electiveObject = new HashMap<String, Object>();
        electiveObject.put(ELECTIVE_TYPE, elective.getType());
        electiveObject.put(ELECTIVE_CREDIT_REQ, elective.getReqCredits());
        electiveObject.put(ELECTIVE_COURSE_OPTIONS, createCoursePrefSemObject(elective.getCourseOptions()));
        return new JSONObject(electiveObject);
    }

    private static void writeData(String file, JSONArray jsonArray) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject createCompletedCoursesObject(HashMap<Course, String> completedCourses) {
        if (completedCourses == null) {
            return new JSONObject();
        }

        HashMap<String, String> completedCoursesUUID = new HashMap<String, String>();
        // get each entry in the hashmap while holding the course and the grade together
        for (Map.Entry<Course, String> completedCourse : completedCourses.entrySet()) {
            String courseUUID = completedCourse.getKey().getUUID().toString();
            String grade = completedCourse.getValue();
            completedCoursesUUID.put(courseUUID, grade);
        }
        return new JSONObject(completedCoursesUUID);
    }

    private static JSONArray createAllSemestersObject(ArrayList<Semester> allSemesters) {
        if (allSemesters == null) {
            return new JSONArray();
        }

        JSONArray allSemestersArray = new JSONArray();
        for (Semester semester : allSemesters) {
            allSemestersArray.add(createSemesterObject(semester));
        }
        return allSemestersArray;
    }

    private static JSONObject createSemesterObject(Semester semester) {
        if (semester != null) {
            LinkedHashMap<String, Object> semesterMap = new LinkedHashMap<String, Object>();
            semesterMap.put(SEMESTER_SEASON, semester.getSeason().toString());
            semesterMap.put(SEMESTER_YEAR, semester.getYear());
            semesterMap.put(SEMESTER_LIMIT, semester.getCreditLimit());
            JSONArray coursesArray = new JSONArray();
            ArrayList<Course> semesterCourses = semester.getCourses();
            for (Course course : semesterCourses) {
                coursesArray.add(course.getUUID().toString());
            }
            semesterMap.put(SEMESTER_COURSES, coursesArray);
            return new JSONObject(semesterMap);
        }
        return new JSONObject();
    }
    // writing courses
    public static void saveCourses(ArrayList<Course> allCourses) {
        if (allCourses == null) {
            return;
        }

        JSONArray allCoursesArray = new JSONArray();
        for (Course course : allCourses) {
            // get all relevant course information for each course
            // map it to the hashmap
            HashMap<String, Object> courseObject = new HashMap<String, Object>();
            courseObject.put(COURSE_SET_UUID, course.getUUID().toString());
            courseObject.put(COURSE_SET_SUBJECT, course.getSubject());
            courseObject.put(COURSE_NUMBER, course.getNumber());
            courseObject.put(COURSE_DESCRIPTION, course.getDescription());
            courseObject.put(COURSE_CREDIT_HOURS, course.getCredits());
            // get semester offering information
            JSONArray semestersOfferedArray = new JSONArray();
            ArrayList<Season> semestersOffered = course.getSemestersOffered();
            for (Season season : semestersOffered) {
                semestersOfferedArray.add(season.toString());
            }
            courseObject.put(COURSE_SEMESTER_OFFERED, semestersOfferedArray);
            // get all prerequisite information
            JSONArray prereqArray = new JSONArray();
            ArrayList<Prerequisites> prereqs = course.getPrerequisites();
            for (Prerequisites prereq : prereqs) {
                prereqArray.add(createPrerequisiteObject(prereq));
            }
            courseObject.put(COURSE_PREREQUISITES, prereqArray);
            allCoursesArray.add(new JSONObject(courseObject));
        }
        writeData("./jsonfiles/Course.java", allCoursesArray);
    }

    private static JSONObject createPrerequisiteObject(Prerequisites prereqs) {
        if (prereqs == null) {
            return new JSONObject();
        }

        HashMap<String, Object> prereqMap = new HashMap<String, Object>();
        prereqMap.put(COURSE_PREREQUISITES_COURSE_OPTION, prereqs.getChoices());
        prereqMap.put(COURSE_PREREQUISITES_MIN_GRADE, prereqs.getMinGrade());
        // load all the possible course options
        JSONArray courseOptionsArray = new JSONArray();
        ArrayList<Course> courseOptions = prereqs.getCourseOptions();
        for (Course course : courseOptions) {
            courseOptionsArray.add(course.getUUID().toString());
        }
        prereqMap.put(COURSE_PREREQUISITES_COURSE_OPTION, courseOptionsArray);
        return new JSONObject(prereqMap);
    }

    // public static void saveUsers() {
    // UserList users = UserList.getInstance();
    // ArrayList<User> userList = users.getUsers();
    // JSONArray jsonUsers = new JSONArray();

    // //creating all the json objects
    // for(int i=0; i< userList.size(); i++) {
    // jsonUsers.add(getUserJSON(userList.get(i)));
    // }
    // //Write JSON file
    // try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {

    // file.write(jsonUsers.toJSONString());
    // file.flush();

    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    // public static void saveStudents() {
    // UserList userList = UserList.getInstance();
    // ArrayList<Student> studentList = userList.getStudents();
    // JSONArray jsonStudents = new JSONArray();
    // for (int i = 0; i < studentList.size(); i++) {
    // jsonStudents.add(getUserJSON(studentList.get(i)));
    // }
    // try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {
    // file.write(jsonStudents.toJSONString());
    // file.flush();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    // public static void saveAdvisors() {
    // UserList userList = UserList.getInstance();
    // ArrayList<Advisor> advisorList = userList.getAdvisors();// make sure this
    // method is created in UserList
    // JSONArray jsonAdvisors = new JSONArray();
    // for (int i = 0; i < advisorList.size(); i++) {
    // jsonAdvisors.add(getUserJSON(advisorList.get(i)));
    // }
    // try (FileWriter file = new FileWriter(ADVISOR_FILE_NAME)) {
    // file.write(jsonAdvisors.toJSONString());
    // file.flush();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    // public static void saveGuardians() {
    // UserList userList = UserList.getInstance();
    // ArrayList<Guardian> guardianList = userList.getGuardians();// make sure this
    // method is created in UserList
    // JSONArray jsonGuardians = new JSONArray();
    // for (int i = 0; i < guardianList.size(); i++) {
    // jsonGuardians.add(getUserJSON(guardianList.get(i)));
    // }
    // try (FileWriter file = new FileWriter(PARENT_FILE_NAME, true)) {
    // file.write(jsonGuardians.toJSONString());
    // file.flush();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    // public static JSONObject getUserJSON(User user) {
    // JSONObject userDetails = new JSONObject();
    // userDetails.put(USER_UUID, user.getID().toString());
    // userDetails.put(USER_USERNAME, user.getUsername());
    // userDetails.put(USER_FIRST_NAME, user.getFirstName());
    // userDetails.put(USER_LAST_NAME, user.getLastName());
    // userDetails.put(USER_PASSWORD, user.getPassword());
    // userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
    // if (user instanceof Student) {
    // Student student = (Student) user;
    // userDetails.put(STUDENT_COMPLETED_COURSES, student.getCompletedCourses());
    // userDetails.put(STUDENT_YEAR, student.getYear());
    // userDetails.put(STUDENT_MAJOR, student.getMajor());
    // userDetails.put(STUDENT_COMPLETED_CREDITS, student.getCompletedCredits());
    // userDetails.put(STUDENT_TOTAL_CREDITS, student.getTotalCredits());
    // userDetails.put(STUDENT_ADVISOR, student.getAdvisor().toString());
    // userDetails.put(STUDENT_GUARDIAN, student.getGuardian().toString());
    // userDetails.put(STUDENT_APPLICATION_AREA, student.getApplicationArea());
    // userDetails.put(STUDENT_USC_ID, student.getUSCID());
    // userDetails.put(STUDENT_ADVISING_NOTES, student.getAdvisorNotes());
    // }
    // else if (user instanceof Advisor) {
    // Advisor advisor = (Advisor) user;
    // // userDetails.put(ADVISOR_ASSIGNED_STUDENTS, advisor.getStudents());
    // userDetails.put(ADVISOR_BUILDING, advisor.getBuilding());
    // userDetails.put(ADVISOR_ROOM_NUMBER, advisor.getRoomNumber());
    // }

    // return userDetails;
    // }
}

