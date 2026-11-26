import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		StudentManager student = new StudentManager();
		
			loadFile(student);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		clearScreen();
			
			showMenu();
			
			int choise;
			
			try {
				System.out.print("Choose an option: ");
				choise = sc.nextInt();
				sc.nextLine();
				System.out.println();
			}catch(Exception e) {
				System.out.println("Invalid input. Please enter a number");
				sc.nextLine();
				continue;
			}
			
			switch(choise) {
			
			case 1:
				addStudent(student , sc);
				pause(sc);
				break;
				
			case 2:
				showStudents(student);
				pause(sc);
				break;
				
			case 3:
				searchStudent(student, sc);
				break;
			
			case 4:
				updateStudentInfo(student, sc);
				break;
				
			case 5:
				removeStudent(student, sc);
				pause(sc);
				break;
				
			case 6:
				statics(student);
				pause(sc);
				break;
				
			case 7:
				showGraduatedStudents(student);
				pause(sc);
				break;
				
			case 8:
				showNonGraduatedStudents(student);
				pause(sc);
				break;
				
			case 9:
				sortStudents(student, sc);
				break;
				
			case 10:
				bestStudents(student);
				pause(sc);
				break;
				
			case 11:
				reportStudents(student);
				pause(sc);
				break;
				
			case 0:
				exit(student);
				break;
					
			}
			
			if(choise == 0) {
				break;
			}
		}

	}
	
	public static void showMenu() {
		
		System.out.println("========== Student Management System ==========\n");
		System.out.println("1 Add Student\n2 Show Students\n3 Search Student\n4 Update student info\n"
		 		+ "5 Remove Student\n6 Student Statistics\n7 Show Graduated Students\n8 Show Non-Graduate Students\n9 Sort Students\n10 Best Students\n11 Export Statistics Report\n0 Exit\n");
	}
	
	public static void addStudent(StudentManager student, Scanner sc) {
		int id;
		String name;
		int age;
		char grade;
		String major;
		
		while(true) {
			
			try {
			System.out.print("Enter student id: ");
			id = sc.nextInt();
			sc.nextLine();
			break;
			}catch(Exception e) {
				System.out.println("Invalid input. Please enter a number");
				sc.nextLine();
				continue;
			}
			
		}
		
		while(true) {
			
			System.out.print("Enter student name: ");
			name = sc.nextLine();
			if( !name.matches("[a-zA-Z ]+") || name.trim().isEmpty() ) {
				System.out.println("Invalid input. Please enter a name");
				continue;
			}else {
				break;
			}
			
		}
		
		while(true) {
			
			try {
			System.out.print("Enter student age: ");
			age = sc.nextInt();
			sc.nextLine();
			break;
			}catch(Exception e) {
				System.out.println("Invalid input. Please enter a number ");
				sc.nextLine();
				continue;
			}
			
		}
		
		while(true) {
			
			System.out.print("Enter student grade: ");
			grade = sc.next().charAt(0);
			sc.nextLine();
			grade =Character.toUpperCase(grade);
			
			if(grade != 'A' && grade != 'B' && grade != 'C' && grade != 'D' && grade != 'E' && grade != 'F') {
				System.out.println("Invalid input. Please inter a correct grade");
			    continue;
			}else {
				break;
			}
			

		}
		
		while(true) {
			
			System.out.print("Enter student major: ");
			major = sc.nextLine();
			
			if( !major.matches("[a-zA-Z ]+") || major.trim().isEmpty() ){
				System.out.println("Invalid input. Please enter correct major");
				continue;
			}else {
				break;
			}
		}
		
		Student s = new Student(id, name, age, grade, major);
		student.addStudent(s);
		
  }
	
	public static void showStudents(StudentManager student) {
		student.displayStudents();
	}
	
	public static void searchStudent(StudentManager student, Scanner sc) {
		int id;
		int input;
		
		while(true) {
			
			System.out.println("1 Search student by ID\n2 Search student by name\n3 Back\n");
			
			try {
				System.out.print("Choose an option: ");
				input = sc.nextInt();
				sc.nextLine();
				System.out.println();
			}catch(Exception e) {
				System.out.println("Invalid input. Please enter a number");
				sc.nextLine();
				continue;
			}
		
			switch(input) {
		
		case 1:
			
		while(true) {
			try {
			System.out.print("Enter student id: ");
			id = sc.nextInt();
			sc.nextLine();
			student.searchStudent(id);
			break;
		}catch(Exception e) {
			System.out.println("Invalid input. Please enter correct id");
			sc.nextLine();
			continue;
			
		}
	}
		pause(sc);
		break;
		
		case 2:
			String name;
			
			while(true) {
				
				System.out.print("Enter student name that you want to find: ");
				name = sc.nextLine().toLowerCase();
				
				if( !name.matches("[a-zA-Z ]+") || name.trim().isEmpty() ) {
					System.out.println("Invalid input. Please enter correct name");
					continue;
				}else {
					student.searchStudentByName(name);
					break;
				}
				
			}
			pause(sc);
			break;
			
		case 3:
			System.out.println("Welcome back to the menu\n");
			break;
			
		
		}
			
			if(input == 3) {
				break;
			}
		
		}
		
	}
	
	
	
	public static void removeStudent(StudentManager student, Scanner sc) {
		int id;
		
		while(true) {
			try {
				System.out.print("Enter student id: ");
				id = sc.nextInt();
				sc.nextLine();
				break;
			}catch(Exception e) {
				System.out.println("Invalid input. Please enter correct id");
				sc.nextLine();
				continue;
			}
			
		}
		
		Student s = student.findStudentById(id);
		
		if(s == null) {
			System.out.println("Student not found");
			return;
		}
		
		
		String choise;
		while(true) {
			
			System.out.print("Are you sure you want to remove this student? (yes/no): ");
			choise = sc.nextLine().toLowerCase();
			
			if( !choise.equals("yes") && !choise.equals("no") ) {
				System.out.println("Invalid input. Please enter yes or no");
				continue;
			}else {
				
				if(choise.equals("yes")) {
					student.removeStudent(id);
					break;
					
				}else {
					System.out.println();
				 break;
				}
				
			}
		}
		
	}

	
	public static void updateStudentInfo(StudentManager student, Scanner sc) {
		
		while(true) {
			
			System.out.println("1 Update student id\n2 Update student name\n3 update student age\n"
					+ "4 Update student grade\n5 Update student major\n6 Update student graduate\n0 Back\n");
			
			int choice;
			try {
			System.out.print("Choose an option: ");	
			choice = sc.nextInt();
			sc.nextLine();
			System.out.println();
			}catch(Exception e) {
				System.out.println("Invalid input. Please enter a number");
				sc.nextLine();
				continue;
			}
			
			switch(choice) {
			
			case 1:
				int id;
				while(true) {
					try {
					System.out.print("Enter student id that you want update info: ");
					id = sc.nextInt();
					sc.nextLine();
					break;
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter correct id");
						sc.nextLine();
						continue;
					}
				}
				
				while(true) {
					try {
						int newId;
						System.out.print("Enter new student id: ");
						newId = sc.nextInt();
						sc.nextLine();
						student.updateStudentId(id, newId);
						break;
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter correct id");
						sc.nextLine();
						continue;
					}
				}
				pause(sc);	
				break;	
				
			case 2:
				
				int Id = 0;
				while(true) {
					try {
					System.out.print("Enter student id that you want update info: ");
					Id = sc.nextInt();
					sc.nextLine();
					break;
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter correct id");
						sc.nextLine();
						continue;
					}
				}
				
				while(true) {
					String newName;
				System.out.print("Enter new Student name: ");
				newName = sc.nextLine();
				if( !newName.matches("[a-zA-Z ]+") || newName.trim().isEmpty() ) {
					System.out.println("Invalid input. Please enter correct name");
					continue;
				}else {
					student.updateStudentByName(Id, newName);
					break;
				}
			}
				pause(sc);
			break;
			
			case 3:
				
				int ID = 0;
				while(true) {
					try {
					System.out.print("Enter student id that you want update info: ");
					ID = sc.nextInt();
					sc.nextLine();
					break;
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter correct id");
						sc.nextLine();
						continue;
					}
				}
				
				while(true) {
					try {
						int newAge;
						System.out.print("Enter new student age: ");
						newAge = sc.nextInt();
						sc.nextLine();
						student.updateStudentAge(ID, newAge);
						break;
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter correct id");
						sc.nextLine();
						continue;
					}
				}
				pause(sc);
					break;
					
			case 4:
				
				int input = 0;
				while(true) {
					try {
					System.out.print("Enter student id that you want update info: ");
					input = sc.nextInt();
					sc.nextLine();
					break;
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter correct id");
						sc.nextLine();
						continue;
					}
				}
				
				char newGrade = '\u0000';
				while(true) {
					System.out.print("Enter new student grade: ");
					newGrade = sc.next().charAt(0);
					sc.nextLine();
					newGrade = Character.toUpperCase(newGrade);
					if( newGrade != 'A' && newGrade != 'B' && newGrade != 'C' && newGrade != 'D' && newGrade != 'E' && newGrade != 'F' ) {
						System.out.println("Invalid input. Please enter correct grade");
						continue;
					}else {
						student.updateStudentGrade(input, newGrade);
						break;
					}
				}
				pause(sc);
				break;
				
			case 5:
				int Input = 0;
				while(true) {
					try {
					System.out.print("Enter student id that you want update info: ");
					Input = sc.nextInt();
					sc.nextLine();
					break;
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter correct id");
						sc.nextLine();
						continue;
					}
				}
				
				while(true) {
					String newMajor;
				System.out.print("Enter new Student major: ");
				newMajor = sc.nextLine();
				if( !newMajor.matches("[a-zA-Z ]+") || newMajor.trim().isEmpty() ) {
					System.out.println("Invalid input. Please enter correct name");
					continue;
				}else {
					student.updateStudentMajor(Input, newMajor);
					break;
				}
			}
			pause(sc);
			break;
			
			case 6:
				int INput = 0;
				while(true) {
					try {
					System.out.print("Enter student id that you want update info: ");
					INput = sc.nextInt();
					sc.nextLine();
					break;
					}catch(Exception e) {
						System.out.println("Invalid input. Please enter correct id");
						sc.nextLine();
						continue;
					}
				}
				
				boolean isGraduated;
				String inpuT;
				while(true) {
					System.out.print("Is the student graduated? (yes/no): ");
					inpuT = sc.nextLine().toLowerCase();
					
					if(inpuT.equals("yes")) {
						isGraduated = true;
						break;
					}else if(inpuT.equals("no")) {
						isGraduated = false;
						break;
					}else {
						System.out.println("Invalid input. Please enter yes or no");
					}
						
				}
				student.updateStudentGraduate(INput, isGraduated);
				pause(sc);
				break; 
				
			case 0:
				System.out.println("Welcome back to the menu\n");
				break;
				
			}
			
			if(choice == 0) {
				break;
			}
			
		}
		
	}
	
	public static void showGraduatedStudents(StudentManager student) {
		student.showGraduatedtudents();
	}
	
	public static void showNonGraduatedStudents(StudentManager student) {
		student.showNonGraduateStudents();
	}
	
	public static void sortStudents(StudentManager student, Scanner sc) {
		int choice;
		while(true) {
			
			try {
			System.out.println("1 Sort by ID\n2 Sort by name\n3 Sort by grade\n4 Back\n");
			
			System.out.print("Choose an option: ");
			choice = sc.nextInt();
			sc.nextLine();
			System.out.println();
			}catch(Exception e) {
				System.out.println("Invalid input. Please enter a number");
				sc.nextLine();
				continue;
			}	
			switch(choice) {
		
		case 1:
			student.sortById();
			pause(sc);
			break;
			
		case 2:
			student.sortByName();
			pause(sc);
			break;
			
		case 3:
			student.sortByGrade();
			pause(sc);
			break;
			
		case 4:
			System.out.println("Welcome back to the menu\n");
			break;
		}
			
			if(choice == 4) {
				break;
			}
		
		}
		
		
	}
	

	
	public static void pause(Scanner sc) {
		System.out.println("\nPress ENTER to continue...");
		sc.nextLine();
	}
	
	public static void clearScreen() {
		for(int i=0; i<30; i++) {
			System.out.println();
		}
	}
	
	public static void statics(StudentManager student) {
		student.staticts();
	}
	
	public static void bestStudents(StudentManager student) {
		student.bestStudents();
	}
	
	public static void reportStudents(StudentManager student)	{
		student.exportstatistics();
		
	}
	
	public static void loadFile(StudentManager student) {
		student.loadFile();
	}
	
	public static void exit(StudentManager student) {
		student.saveFile();
		System.out.println("Thank you for using Student Management System\nGoodBye!");
	}
	
}
