package model;

public abstract class DataConstants {
	protected static final String ADVISOR_FILE_NAME = "demo/src/main/java/data/Advisor.json";
	protected static final String PARENT_FILE_NAME = "demo/src/main/java/data/Guardian.json";
	protected static final String STUDENT_FILE_NAME = "demo/src/main/java/data/Student.json";
	protected static final String COURSE_FILE_NAME = "demo/src/main/java/data/Course.json";
	protected static final String REQUIREMENT_FILE_NAME = "demo/src/main/java/data/requirement.json";
	protected static final String DEGREE_FILE_NAME = "demo/src/main/java/data/Degree.json";
	protected static final String USER_UUID = "uuid";
	protected static final String USER_USERNAME = "username";
	protected static final String USER_PASSWORD = "password";
	protected static final String USER_FIRST_NAME = "first_name";
	protected static final String USER_LAST_NAME = "last_name";
	protected static final String USER_PREFERRED_NAME = "preferred_name";
	protected static final String USER_EMAIL_ADDRESS = "email_address";
	protected static final String USER_PHONE_NUMBER = "phone";
	protected static final String ADVISOR_APPROVED = "approved";
	protected static final String ADVISOR_ASSIGNED_STUDENTS = "assigned_students";
	protected static final String ADVISOR_BUILDING = "building";
	protected static final String ADVISOR_ROOM_NUMBER = "room_number";
	protected static final String PARENT_CHILDREN = "children";
	protected static final String PARENT_AUTHORIZATION = "authorization";
	protected static final String STUDENT_USC_ID = "usc_id";
	protected static final String STUDENT_YEAR = "year";
	protected static final String STUDENT_ADVISOR = "advisor";
	protected static final String STUDENT_GUARDIAN = "guardian";
	protected static final String STUDENT_COMPLETED_CREDITS = "credits_completed";
	protected static final String STUDENT_COMPLETED_COURSES = "completed_courses";
	protected static final String STUDENT_TOTAL_CREDITS = "total_credits";
	protected static final String STUDENT_ADVISING_NOTES = "advising_notes";
	protected static final String STUDENT_APPLICATION_AREA = "application_area";
	protected static final String STUDENT_MAJOR = "major";
	protected static final String STUDENT_DEGREE_ID = "degree";
	protected static final String STUDENT_GPA = "gpa";
	protected static final String ADVISING_NOTE_NOTE = "note";
	protected static final String ADVISING_NOTE_AUTHOR = "author";
	protected static final String ADVISING_NOTE_TIME = "time";
	protected static final String STUDENT_ALL_SEMESTERS = "all_semesters";
	protected static final String STUDENT_CURRENT_SEMESTER = "current_semester";
	/******  FIXME  ******/
	protected static final String GRADUATION_PLAN_SELECTED_COURSES = "selected_courses";
	protected static final String GRADUATION_PLAN_SEMESTER_SCHEDULE = "semester_schedule";
	/********************/
	protected static final String COURSE_SET_UUID = "uuid";
	protected static final String COURSE_SET_SUBJECT = "subject";
	protected static final String COURSE_NUMBER = "number";
	protected static final String COURSE_NAME = "name";
	protected static final String COURSE_DESCRIPTION = "description";
	protected static final String COURSE_CREDIT_HOURS = "credit_hours";
	protected static final String COURSE_SEMESTER_OFFERED = "semesters_offered";
	// Degree json file
	protected static final String DEGREE_UUID = "uuid";
	protected static final String DEGREE_CREDITS = "total_credit_required";
	protected static final String DEGREE_MAJOR_COURSE = "major_courses";
	protected static final String DEGREE_SUBJECT_NAME = "subject_name";
	protected static final String DEGREE_TOTAL_REQ_CREDIT = "total_credits_required";
	protected static final String DEGREE_ELECTIVES = "elective_list";
	protected static final String DEGREE_ELECTIVE_TYPE = "type";
	protected static final String DEGREE_ELECTIVE_CREDIT_REQ = "credit_required";
	protected static final String DEGREE_ELECTIVE_CHOICES = "course_choice";
	// TODO figure out what the object is that stores the prerequisites in the scraped file
	// 	Potentially hashmap with the course saved as an array of UUIDs
	protected static final String COURSE_PREREQUISITES = "prerequisites";
	protected static final String COURSE_PREREQUISITE_CHOICES = "choices";
	protected static final String COURSE_PREREQUISITES_MIN_GRADE = "min_grade";
	protected static final String COURSE_PREREQUISITES_COURSE_OPTION = "course_options";
	protected static final String COURSE_COREQUISITES = "corequisites";

	protected static final String SEMESTER_SEASON = "season";
	protected static final String SEMESTER_YEAR = "year";
	protected static final String SEMESTER_LIMIT = "credit_limit";
	protected static final String SEMESTER_COURSES = "courses";
	// Do we need this?
	protected static final String COURSE_CORE_CATEGORIES = "core_categories";

	protected static final String ELECTIVE_TYPE = "type";
	protected static final String ELECTIVE_CREDIT_REQ = "credit_required";
	protected static final String ELECTIVE_COURSE_OPTIONS = "course_options";
}