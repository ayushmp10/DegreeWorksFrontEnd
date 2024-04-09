public abstract class DataConstants {
	protected static final String ADVISOR_FILE_NAME = "jsonfiles/Advisor.json";
	protected static final String PARENT_FILE_NAME = "jsonfiles/Guardian.json";
	protected static final String STUDENT_FILE_NAME = "jsonfiles/Student.json";
	protected static final String COURSE_FILE_NAME = "jsonfiles/Course.json";
	protected static final String REQUIREMENT_FILE_NAME = "json/requirement.json";
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
	protected static final String PARENT_PENDING_ACCESS_REQUESTS = "pending_access_requests";
	protected static final String STUDENT_USC_ID = "usc_id";
	protected static final String STUDENT_YEAR = "year";
	protected static final String STUDENT_ADVISOR = "advisor";
	protected static final String STUDENT_GUARDIAN = "guardian";
	protected static final String STUDENT_COMPLETED_CREDITS = "creditsCompleted";
	protected static final String STUDENT_COMPLETED_COURSES = "completed_courses";
	protected static final String STUDENT_TOTAL_CREDITS = "creditsToComplete";
	protected static final String STUDENT_ADVISING_NOTES = "advising_notes";
	protected static final String STUDENT_APPLICATION_AREA = "application_area";
	protected static final String STUDENT_MAJOR = "major";
	protected static final String ADVISING_NOTE_NOTE = "note";
	protected static final String ADVISING_NOTE_AUTHOR = "author";
	protected static final String ADVISING_NOTE_TIME = "time";
	protected static final String STUDENT_SCHOLARSHIPS = "scholarships";
	protected static final String SCHOLARSHIP_NAME = "name";
	protected static final String SCHOLARSHIP_MIN_GPA = "min_gpa";
	protected static final String SCHOLARSHIP_MIN_CREDIT_HOURS = "min_credit_hours";
	protected static final String STUDENT_GRADUATION_PLAN = "graduation_plan";
	protected static final String GRADUATION_PLAN_REQUIREMENT_SETS = "requirement_sets";
	protected static final String GRADUATION_PLAN_PREFERRED_GRADUATION_YEAR = "preferred_graduation_year";
	protected static final String GRADUATION_PLAN_PREFERRED_GRADUATION_SEMESTER = "preferred_graduation_semester";
	protected static final String GRADUATION_PLAN_MIN_CREDIT_HOURS = "preferred_min_credit_hours";
	protected static final String GRADUATION_PLAN_MAX_CREDIT_HOURS = "preferred_max_credit_hours";
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
	// TODO figure out what the object is that stores the prerequisites in the scraped file
	// 	Potentially hashmap with the course saved as an array of UUIDs
	protected static final String COURSE_PREREQUISITES = "prerequisites";
	protected static final String COURSE_COREQUISITES = "corequisites";
	// Do we need this?
	protected static final String COURSE_CORE_CATEGORIES = "core_categories";
}