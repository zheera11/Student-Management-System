import java.util.HashMap;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentManager2 {

	HashMap<Integer, Student> students = new HashMap<>();
	
	ArrayList<Student> list = new ArrayList<>(students.values());
	
	
	public void addStudent(Student student) {
		
		if(students.containsKey(student.getId())) {
			System.out.println("Student id already exist");
			return;
		}
		
		students.put(student.getId(), student);
		System.out.println("Student added successfully");
		
	}
	
	public Student findStudentById(int id) {
		
		return students.get(id);
		
	}
	
	public void removeStudent(int id) {
		
		if(students.containsKey(id)) {
			students.remove(id);
//			saveFile();
			System.out.println("Student removed successfully");
		}else {
			System.out.println("Student not found");
		}
		
	}
	
	public void displayStudents() {
		
		if(students.isEmpty()) {
			System.out.println("No students available");
			return;
		}
		
		for(Student s : students.values()) {
			s.displayStudentInfo();
		}
		
	}
	
	public void searchStudent(int id) {
		
		Student s = students.get(id);
		
		if(s != null) {
			s.displayStudentInfo();
		}else {
			System.out.println("Student not found");
		}
		
	}
	
	public void countStudent() {
		
		System.out.println("total students: " + students.size());
		
	}
	
	public void updateStudentId(int id, int newId) {
		
		Student s = findStudentById(id);
		
		if(s != null) {
			s.setId(newId);
			System.out.println("Student id update succesfully");
		}else {
			System.out.println("Student not found");
		}
		
	}
	
	public void updateStudentByName(int id, String newName) {
		
		Student s = findStudentById(id);
		
		if(s != null) {
			s.setName(newName);
			System.out.println("Student name update succesfully");
		}else {
			System.out.println("Student not found");
		}
		
	}
	
public void updateStudentAge(int id, int newAge) {
		
		Student s = findStudentById(id);
		
		if(s != null) {
			s.setAge(newAge);
			System.out.println("Student age update succesfully");
		}else {
			System.out.println("Student not found");
		}
		
	}
	
	public void updateStudentGrade(int id, char newGrade) {
		
		Student s = findStudentById(id);
		
		if(s != null) {
			s.setGrade(newGrade);
			System.out.println("Student grade update succesfully");
		}else {
			System.out.println("Student not found");
		}
		
	}
	
	public void updateStudentMajor(int id, String newMajor) {
		
		Student s = findStudentById(id);
		
		if(s != null) {
			s.setMajor(newMajor);
			System.out.println("Student major update succesfully");
		}else {
			System.out.println("Student not found");
		}
		
	}
	
	public void updateStudentGraduate(int id, boolean newGraduate) {
		
		Student s = findStudentById(id);
		
		if(s != null) {
			s.setIsGraduated(newGraduate);
			System.out.println("Student graduate update succesfully");
		}else {
			System.out.println("Student not found");	
		}
			
	}
	
	public void showGraduatedtudents() {
		
		boolean found = false;
		
		for(Student s : students.values()) {
			if(s.GetIsGraduated()) {
				s.displayStudentInfo();
			found = true;
			}
		}
		
		if(!found) {
			System.out.println("Student not found");
		}
		
	}
	
	public void showNonGraduateStudents() {
		
		boolean found = false;
		
		for(Student s : students.values()) {
			if(!s.GetIsGraduated()) {
				s.displayStudentInfo();
				found = true;
			}
		}
		
		if(!found) {
			System.out.println("Student not found");
		}
		
	}
	
	public void sortById() {
		
	Collections.sort(list, Comparator.comparingInt(Student::getId));
	
	System.out.println("Students sorted by ID:\n");

	for(Student s : list) {
		s.displayStudentInfo();
 	}
		
	}
	
	
	public void sortByName() {
		
		Collections.sort(list, Comparator.comparing(Student::getName));
		
		System.out.println("Students sorted by name:\n");
		
		for(Student s : list) {
			s.displayStudentInfo();
		}
		
	}
	
	public void sortByGrade() {
		
		Collections.sort(list, Comparator.comparingInt(Student::getGrade));
		
		System.out.println("Students sorted by grade:\n");
		
		for(Student s : list) {
			s.displayStudentInfo();
		}

	}
	
	public void numberOfGraduatedStudents() {
		int GraduatedStudent = 0;
		for(Student s : students.values()) {
			if(s.GetIsGraduated()) {
				GraduatedStudent++;
			}
		}
		System.out.println("Graduated Students: "+GraduatedStudent);
	}
	
	public void numberOfNonGraduatedStudents() {
		int student = 0;
		for(Student s : students.values()) {
			if(!s.GetIsGraduated()) {
				student++;
			}
		}
		System.out.println("Non-Graduated Students: "+student);
	}
	
	public void averageAge() {
		double box = 0;
		double average = 0 ;
		for(Student s : students.values()) {
			box+=s.GetAge();
		}
		
		if(students.size() == 0) {
			System.out.println("No students available");
		}else {
			average = box / students.size(); 
		}
		
		System.out.println("Average age: "+average);
	}
	
	public void gradesStudents() {
		int gradeA = 0;
		int gradeB = 0;
		int gradeC = 0;
		int gradeD = 0;
		int gradeE = 0;
		int gradeF = 0;
		
		for(Student s : students.values()) {
			
			if(s.getGrade() == 'A') {
				gradeA++;
			}else if(s.getGrade() == 'B') {
				gradeB++;
			}else if(s.getGrade() == 'C') {
				gradeC++;
			}else if(s.getGrade() == 'D') {
				gradeD++;
			}else if(s.getGrade() == 'E') {
				gradeE++;
			}else {
				gradeF++;
			}
		}
		
		System.out.println("Students with grade A: "+gradeA +"\n"
				+ "Students with grade B: "+gradeB +"\n"
				+ "Students with grade C: "+gradeC +"\n"
				+ "Students with grade D: "+gradeD +"\n"
				+ "Students with grade E: "+gradeE +"\n"
				+ "Students with grade F: "+gradeF + "\n");
		
	}
	
	public void staticts() {
		
		System.out.println("======== Student statistics ========\n");
		
		countStudent();
		numberOfGraduatedStudents();
		numberOfNonGraduatedStudents();
		averageAge();
		gradesStudents();
		
	}
	
	public void saveFile() {
		
		try {
			
			FileWriter writer = new FileWriter("Students.txt");
			
			for(Student s : students.values()) {
				
				writer.write(s.toFileString() + "\n");
				
			}
			
			writer.close();
			
		}catch(IOException e) {
			System.out.println("Error file saving.");
		}
		
	}
	
	public void loadFile() {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("Students.txt"));
			
			String line;
			
			while( (line = reader.readLine()) !=null ) {
				
				String[] data = line.split(",");
				
				Student student = null;
				
				int id = Integer.parseInt(data[0]);
				String name = data[1];
				int age = Integer.parseInt(data[2]);
				char grade = data[3].charAt(0);
				String major = data[4];
				boolean isGraduated = Boolean.parseBoolean(data[5]);
				
				student = new Student(id, name, age, grade, major);
				
				if(student != null) {
					student.setIsGraduated(isGraduated);
					students.put(id, student);
				}
				
			}
			
			reader.close();
			System.out.println("Loading student data...\nStudents loaded successfully.\n");

			
		}catch(IOException e) {
			System.out.println("Error loading file.");
		}
		
	}
	
	
	
}
