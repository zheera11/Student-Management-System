
public class Student {
	
	private int id;
	private String name;
	private int age;
	private char grade;
	private String major;
	private boolean isGraduated;

	
	public Student(int id, String name, int age, char grade, String major) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.major = major;
		this.isGraduated = false;
			
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int GetAge() {
		return this.age;
	}
	
	
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	public char getGrade() {
		return this.grade;
	}
	
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public void setIsGraduated(boolean graduated) {
		this.isGraduated = graduated;
	}
	
	public boolean GetIsGraduated() {
		return this.isGraduated;
	}
	
	public void displayStudentInfo() {
		String status;
		
		if(isGraduated == false) {
			status = "Not Graduated";
		}else {
			status = "Graduated";
		}
		
		System.out.println("ID: " + this.id
				+ "\nName: " + this.name
				+ "\nAge: " + this.age
				+ "\nGrade: " + this.grade
				+ "\nCollege: " + this.major
				+ "\nStatus: " + status +"\n"
				+ "\n**********************\n");
		
	}
	
	public void graduateStudent() {
		if(isGraduated == true) {
			System.out.println("Student already graduated");
		}else {
			isGraduated = true;
			System.out.println("Student graduate update succesfully");
		}
	}
	
	public String toFileString() {
		return id + "," + name + "," + age + "," + grade + "," + major + "," + isGraduated;
	}
	
}
