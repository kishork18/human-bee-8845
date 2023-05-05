package com.masai;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Administrator admin = new Administrator();
			Student student = new Student();
			System.out.println("                                                         ");
			System.out.println("*******************************************************");
			System.out.println(" Welcome to the Automated Student Registration System! ");
			System.out.println("********************************************************");

			while (true) {
				System.out.println("================================");
				System.out.println(" Please select an option:    ");
				System.out.println(" 1. Administrator login       ");
				System.out.println(" 2. Student login             ");
				System.out.println(" 3. Student SignUp            ");
				System.out.println(" 4. Exit                      ");
				System.out.println("================================");
				System.out.println("                                ");

				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter username:");
					String adminUsername = scanner.nextLine();
					System.out.println("Enter password:");
					String adminPassword = scanner.nextLine();
					if (adminUsername.equals("admin") && adminPassword.equals("admin")) {
						// administrator menu
						System.out.println("Administrator login successful.");
						boolean isAdminMenuActive = true;
						while (isAdminMenuActive) {
							System.out.println("                                ");
							System.out.println("*******************************");
							System.out.println(" Please select an option:     ");
							System.out.println(" 1. Add new course            ");
							System.out.println(" 2. Delete course             ");
							System.out.println(" 3. Add batch                 ");
							System.out.println(" 4. Delete batch              ");
							System.out.println(" 5. Delete student            ");
							System.out.println(" 6. View all courses          ");
							System.out.println(" 7. View all batches          ");
							System.out.println(" 8. View all students         ");
							System.out.println(" 0. Exit                      ");
							System.out.println("*******************************");
							System.out.println("                                ");

							choice = scanner.nextInt();
							scanner.nextLine();
							switch (choice) {
							case 1:
								// Add course
								System.out.println("                                ");
								System.out.println("Enter course name:");
								String courseName = scanner.nextLine();
								System.out.println("Enter course duration(weeks):");
								int courseDuration = scanner.nextInt();
								scanner.nextLine();
								System.out.println("Enter course fees:");
								double courseFees = scanner.nextDouble();
								scanner.nextLine();
								Course course = new Course(courseName, courseDuration, courseFees);
								admin.addCourse(course);
								System.out.println("Course added successfully.");
								break;
							case 2:
								// Delete course
								System.out.println("                                ");
								System.out.println("Enter course name:");
								String courseNameToDelete = scanner.nextLine();
								Course courseToDelete = admin.getCourseByName(courseNameToDelete);
								if (courseToDelete == null) {
									System.out.println("Course not found.");
								} else {
									admin.getCourses().remove(courseToDelete);
									System.out.println("Course deleted successfully.");
								}
								break;
							case 3:
								// Add batch
								System.out.println("                                ");
								System.out.println("Enter course name:");
								String courseNameToAddBatch = scanner.nextLine();
								Course courseToAddBatch = admin.getCourseByName(courseNameToAddBatch);
								if (courseToAddBatch == null) {
									System.out.println("Course not found.");
								} else {
									System.out.println("Enter batch name:");
									String batchName = scanner.nextLine();
									System.out.println("Enter batch start date:(DD/MM/YYYY)");
									String startDate = scanner.nextLine();
									System.out.println("Enter batch end date:(DD/MM/YYYY)");
									String endDate = scanner.nextLine();
									System.out.println("Enter batch available seats:");
									int availableSeats = scanner.nextInt();
									Batch batch = new Batch(batchName, startDate, endDate, availableSeats,
											courseToAddBatch);
									admin.getBatches().add(batch);
									System.out.println("Batch added successfully.");
								}
								break;
							case 4:
								// Delete batch
								System.out.println("                                ");
								System.out.println("Enter batch name:");
								String batchNameToDelete = scanner.nextLine();
								Batch batchToDelete = null;
								for (Batch batch : admin.getBatches()) {
									if (batch.getName().equals(batchNameToDelete)) {
										batchToDelete = batch;
										break;
									}
								}
								if (batchToDelete == null) {
									System.out.println("Batch not found.");
								} else {
									admin.getBatches().remove(batchToDelete);
									System.out.println("Batch deleted successfully.");
								}
								break;
							case 5:
								// Delete student
								System.out.println("                                ");
								System.out.println("Enter student email:");
								String emailToDelete = scanner.nextLine();
								Student studentToDelete = null;
								for (Student s : admin.getStudents()) {
									if (s.getEmail().equals(emailToDelete)) {
										studentToDelete = s;
										break;
									}
								}
								if (studentToDelete == null) {
									System.out.println("Student not found.");
								} else {
									admin.getStudents().remove(studentToDelete);
									System.out.println("Student deleted successfully.");
								}
								break;
							case 6:
								// View all courses
								System.out.println("                                ");
								System.out.println("List of courses:");
								for (Course c : admin.getCourses()) {
									System.out.println("Batch: " + c.getName() + ", Duration: " + c.getDuration()
											+ ", Fees: " + c.getFee());
								}
								break;
							case 7:
								// View all batches
								System.out.println("                                ");
								System.out.println("List of batches:");
								for (Batch b : admin.getBatches()) {
									System.out.println(b.getBatchName() + "(" + b.getCourse().getName()
											+ ") -> Start Date: " + b.getStartDate() + ", End Date: " + b.getEndDate()
											+ ", Seats: " + b.getAvailableSeats());
								}
								break;
							case 8:
								// View all students
								System.out.println("                                ");
								System.out.println("List of students:");
								for (Student s : admin.getStudents()) {
									System.out.println("Name: " + s.getFirstName() + " " + s.getLastName() + ", Email: "
											+ s.getEmail() + ", Address: " + s.getAddress() + ", Mobile: "
											+ s.getMobileNumber());
								}
								break;
							case 0:
								// Exit
								System.out.println("Exiting...");
								isAdminMenuActive = false;
								break;
							default:
								// Invalid choice
								System.out.println("                                ");
								System.out.println("Invalid choice.");
								break;
							}
						}
					} else {
						System.out.println("Invalid Credentials!");
					}
					break;

				case 2:
					// student login
					System.out.println("Enter email:");
					String email = scanner.nextLine();
					System.out.println("Enter password:");
					String password = scanner.nextLine();
					boolean foundStudent = false;
					for (Student stu : admin.getStudents()) {
						if (stu.getEmail().equals(email) && stu.getPassword().equals(password)) {
							// Student menu
							System.out.println("Student login successful.");
							foundStudent = true;
							break;
						}
					}
					if (!foundStudent) {
						System.out.println("Invalid email or password.");
					}
					if (foundStudent) {
						// Student menu
						boolean isAdminMenuActive = true;
						while (isAdminMenuActive) {
							System.out.println("                                ");
							System.out.println("*********************************");
							System.out.println(" Please select an option:     ");
							System.out.println(" 1. Update details            ");
							System.out.println(" 2. Change Password           ");
							System.out.println(" 3. View available course     ");
							System.out.println(" 4. View all batches          ");
							System.out.println(" 5. Register for course       ");
							System.out.println(" 0. Exit                      ");
							System.out.println("********************************");
							System.out.println("                                ");

							choice = scanner.nextInt();
							scanner.nextLine();

							switch (choice) {
							case 1:
								// Update details
								System.out.println("Please select a field to update:");
								System.out.println("1. First name");
								System.out.println("2. Last name");
								System.out.println("3. Address");
								System.out.println("4. Mobile number");
								System.out.println("5. Email");
								int fieldOption = scanner.nextInt();
								scanner.nextLine();
								System.out.println("Please enter the new value:");
								String newValue = scanner.nextLine();
								switch (fieldOption) {
								case 1:
									student.updatePersonalDetails("firstName", newValue);
									break;
								case 2:
									student.updatePersonalDetails("lastName", newValue);
									break;
								case 3:
									student.updatePersonalDetails("address", newValue);
									break;
								case 4:
									student.updatePersonalDetails("mobileNumber", newValue);
									break;
								case 5:
									student.updatePersonalDetails("email", newValue);
									break;
								default:
									System.out.println("Invalid field option. Please try again.");
									break;
								}
								System.out.println("Details updated successfully.");
								break;

							case 2:
								// Change password
								System.out.println("                                ");

								System.out.println("Enter current password:");
								String currentPassword = scanner.nextLine();

								System.out.println("Enter new password:");
								String newPass = scanner.nextLine();
								if (student == null) {
									System.out.println("Student not found. Please try again.");
								} else {
									if (student.getPassword().equals(currentPassword)) {
										student.setPassword(newPass);
										System.out.println("Password changed successfully.");
									} else {
										System.out.println("Invalid password. Please try again.");
									}
								}

								break;

							case 3:
								// View available courses
								System.out.println("                                ");
								System.out.println("List of courses:");
								for (Course c : admin.getCourses()) {
									System.out.println("Batch: " + c.getName() + ", Duration: " + c.getDuration()
											+ ", Fees: " + c.getFee());
								}
								break;

							case 4:
								// View all batches
								System.out.println("                                ");
								System.out.println("List of batches:");
								for (Batch b : admin.getBatches()) {
									System.out.println(b.getBatchName() + "(" + b.getCourse().getName()
											+ ") -> Start Date: " + b.getStartDate() + ", End Date: " + b.getEndDate()
											+ ", Seats: " + b.getAvailableSeats());
								}
								break;

							case 5:
								// Register for course
								System.out.println("                                ");
								System.out.println("Enter course name:");
								String courseName = scanner.nextLine();

								List<Course> course = new ArrayList<>();
								for (Course c : admin.getCourses()) {
									if (c.getName().equals(courseName)) {
										course.add(c);
										break;
									}
								}

								if (course.isEmpty()) {
									System.out.println("Course not found. Please try again");
								} else {
									student.registerCourse(course);
									System.out.println("Course successfully registered.");
								}
								break;
							case 0:
								// Exit
								System.out.println("                                ");
								System.out.println("Exiting program...");
								isAdminMenuActive = false;
								break;
							default:
								// Invalid choice
								System.out.println("                                ");
								System.out.println("Invalid choice.");
								break;

							}
						}
					}
					break;
				case 3:
					// SignUp
					System.out.println("                                ");
					System.out.println("Enter student first name:");
					String firstName = scanner.nextLine();
					System.out.println("Enter student last name:");
					String lastName = scanner.nextLine();
					System.out.println("Enter student address:");
					String address = scanner.nextLine();
					System.out.println("Enter student mobile number:");
					String mobile = scanner.nextLine();
					System.out.println("Enter student email:");
					String email1 = scanner.nextLine();
					System.out.println("Enter student password:");
					String password1 = scanner.nextLine();
					Student students = new Student(firstName, lastName, address, mobile, email1, password1);
					admin.getStudents().add(students);
					System.out.println("Student added successfully.");
					break;
				case 4:
					System.out.println("Successfully Exit!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice.");
					break;
				}
			}
		}
	}
}
