package hashtableimplement;

import java.util.Scanner;

//--== CS400 File Header Information ==--
//Name: <Zijing Ma>
//Email: <zma253@wisc.edu>
//Team: <BB>
//TA: <Brianna Cochran>
//Lecturer: <Gary Dahl>
//Notes to Grader: <optional extra notes>
public class Front1 {

	public static void main(String[] args) {
		boolean quit = false;
		String command = null;
		Scanner sc = new Scanner(System.in);
		String prompt = "Please input a command. To see the commands, type c.";
		HashTableMap<String, CourseReading> HashTableMap = null;
		// To choose whether you want to search or input
		System.out.println("Now running Check Your Texts. Would you like "
				+ "create a new database or import the default database?");
		System.out.println("To create a new database, input n, and to use the default database, input d.");
		command = sc.nextLine().toLowerCase().trim();
		boolean pickedDatabase = false;
		while (pickedDatabase == false) {
			if (command.equals("d")) {
				HashTableMap = Wrangle.readCSV("src/textbook_file.csv");
				if (HashTableMap != null) {
					pickedDatabase = true;
				}
				if (HashTableMap == null) {
					System.out.println("Something went wrong. Try another command.");
					command = sc.nextLine().toLowerCase().trim();
				}
			}
			if (command.equals("n")) {
				HashTableMap = new HashTableMap<String, CourseReading>();
				pickedDatabase = true;
			}
			if ((!command.equals("n")) && (!command.equals("d"))) {
				System.out.println("Please input a valid command.");
				command = sc.nextLine().toLowerCase().trim();
			}
		}
		System.out.println("Your database has been initialized.");
		// actual running of program
		while (quit == false) {
			System.out.println(prompt);
			command = sc.nextLine().toLowerCase().trim();
			// outputs information corresponding to the "c" command
			if (command.equals("c")) {
				System.out.println("List of Commands:");
				System.out.println("g = get list of courses from ISBN");
				System.out.println("p = put or add a course to the specified ISBN ");
				System.out.println("rm = check through a list of courses until the course to remove has been found");
				System.out.println("q = quit");
				System.out.println(prompt);
				command = sc.nextLine().toLowerCase().trim();
			}
			// outputs information corresponding to the "g" command
			if (command.equals("g")) {
				System.out.println("You have chosen to get a course from an ISBN. Please input a valid ISBN.");
				String inputISBN = sc.nextLine().trim();
				System.out.println("run the getHashIndex(inputISBN) command");
			}

			// outputs information corresponding to the "p" command
			if (command.equals("p")) {
				System.out.println("You have chosen to put a course into the database. Please input a valid ISBN.");
				String inputISBN = sc.nextLine().trim();
				System.out.println("Please input a valid book title.");
				String inputTitle = sc.nextLine().trim();
				System.out.println("Please input a valid course name.");
				String inputCourseName = sc.nextLine().trim();
				System.out.println("run the insert(inputISBN, inputTitle, inputCourseName) command");
			}
			// outputs information corresponding to the "r" command
			if (command.equals("rm")) {
				System.out.println(
						"You have chosen to remove a course. Please input a valid ISBN to check for the course.");
				String inputISBN = sc.nextLine().trim();
				System.out.println("run the remove(inputISBN) command");
			}
			// outputs information corresponding to the "q" command
			if (command.equals("q")) {
				System.out.println("Quitting the program.");
				quit = true;
			}
			// check for valid command
			if ((!command.equals("c")) && (!command.equals("g")) && (!command.equals("p")) && (!command.equals("r"))
					&& (!command.equals("q"))) {
				System.out.println("Must use valid command.");
			}
		}

	}

}
