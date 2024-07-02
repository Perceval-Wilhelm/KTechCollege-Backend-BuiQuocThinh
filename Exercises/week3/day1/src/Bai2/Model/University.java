package Bai2.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class University {
    // Init variables
    public static Scanner sc = new Scanner(System.in);
    private ArrayList<ClassRoom> classRooms;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private Map<String, String> droppedStudents = new HashMap<>();

    // Constructor
    public University() {
        this.classRooms = new ArrayList<>();
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.droppedStudents = new HashMap<>();
    }

    // Getters and Setters
    public ArrayList<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(ArrayList<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    // Methods

    // Add ClassRoom to University
    public void addClassRoomToUniversity() {
        try {
            System.out.println("Add ClassRoom to University");
            System.out.println("Enter ClassRoom ID: ");
            String classRoomId = sc.nextLine();
            System.out.println("Enter ClassRoom Name: ");
            String classRoomName = sc.nextLine();
            System.out.println();
            if (classRooms.size() <= 3) {
                ClassRoom newClassRoom = new ClassRoom(classRoomId, classRoomName);
                classRooms.add(newClassRoom);
                System.out.println("ClassRoom added successfully.");
            }
            else {
                System.out.println("University is full");
            }
        }
        catch (Exception e) {
            System.err.println("Invalid input, please try again");
        }
    }

    // Add Student to University
    public void addStudentToUniversity() {
        try {
            System.out.println("Add Student to University");
            System.out.println("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.println("Enter Student Date of Birth (YYYY-MM-DD): ");
            LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());
            System.out.println("Enter ID: ");
            int ID = Integer.parseInt(sc.nextLine());

            if (dateOfBirth.isBefore(LocalDate.now().minusYears(18)) && dateOfBirth.isAfter(LocalDate.now().minusYears(20))) {
                Student newStudent = new Student(name, dateOfBirth, ID);
                students.add(newStudent);
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Student must be between 18 and 20 years old to register.");
            }
        } catch (Exception e) {
            System.err.println("Invalid input, please try again.");
        }
    }

    // Add Teacher to University
    public void addTeacherToUniversity() {
        try {
            System.out.println("Add Teacher to University");
            System.out.println("Enter Teacher Name: ");
            String name = sc.nextLine();
            System.out.println("Enter Teacher Date of Birth (YYYY-MM-DD): ");
            LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());
            System.out.println("Enter Teacher ID: ");
            int ID = Integer.parseInt(sc.nextLine());
            System.out.println("Enter Teacher Unique ID: ");
            int teacherId = Integer.parseInt(sc.nextLine());

            Teacher newTeacher = new Teacher(name, ID, dateOfBirth, teacherId);

            // Assign classes to teacher
            System.out.println("Enter the IDs of the classes the teacher will teach (comma separated): ");
            String[] classIds = sc.nextLine().split(",");
            ArrayList<Integer> teacherClassIds = new ArrayList<>();
            for (String classId : classIds) {
                teacherClassIds.add(Integer.parseInt(classId.trim()));
            }
            newTeacher.setClassIds(teacherClassIds);

            teachers.add(newTeacher);
            System.out.println("Teacher added successfully.");
        } catch (Exception e) {
            System.err.println("Invalid input, please try again.");
        }
    }

    // Find ClassRoom by ID
    public ClassRoom findClassRoomById(String classRoomId) {
        for (ClassRoom classRoom : classRooms) {
            if (classRoomId.equals(classRoom.getClassId())) {
                return classRoom;
            }
        }
        return null;
    }

    // Find Student by Student ID
    public Student findStudentByStudentId(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    // Find Student by ID
    public Student findStudentById(int Id) {
        for (Student student : students) {
            if (student.getID()==Id) {
                return student;
            }
        }
        return null;
    }

    // Add Student to ClassRoom
    public void addStudentToClassRoom() {
        try {
            System.out.println("Enter class room ID ");
            String classRoomId = sc.nextLine();
            ClassRoom classRoom1 = findClassRoomById(classRoomId);
            if (classRoom1 == null) {
                System.out.println("ClassRoom does not exist");
            } else if (classRoom1.getStudentIds().size()>=10) {
                System.out.println("ClassRoom already is full");
            } else {
                System.out.println("Enter ID ");
                int Id = sc.nextInt();
                Student newStudent = findStudentById(Id);
                if (newStudent == null) {
                    System.out.println("Student does not exist");
                    System.out.println("Student cannot register class due to miss of information");
                }
                else {
                    if (newStudent.getDateofBirth()==null || newStudent.getName()==null) {
                        System.out.println("Date of birth missing. Therefore, cannot register class due to miss of information");
                    }
                    else {
                        newStudent.setStudentId(newStudent.getID() + "_" + classRoom1.getClassId());
                        newStudent.setStatus(true);
                        classRoom1.addStudentId(newStudent.getStudentId());
                        System.out.println("Student added to ClassRoom successfully.");
                        if (classRoom1.getStudentIds().size()==10) {
                            classRoom1.setClassStart(LocalDate.now());
                            System.out.println("ClassRoom is now full and has started.");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Invalid input, please try again");
        }
    }

    // Show Student List in ClassRoom
    public void showStudentListInClassRoom() {
        try {
            System.out.println("Enter ClassRoom ID: ");
            String classRoomId = sc.nextLine();
            ClassRoom classRoom = findClassRoomById(classRoomId);
            if (classRoom == null) {
                System.out.println("ClassRoom does not exist.");
            } else {
                System.out.println("All students in class room:");
                for (String studentId : classRoom.getStudentIds()) {
                    Student student = findStudentByStudentId(studentId);
                    if (student != null) {
                        student.show();
                    } else {
                        System.out.println("Student does not exist.");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Invalid input, please try again.");
        }
    }

    // Update Student Information
    public void updateStudentInformation() {
        try {
            System.out.println("Enter Student ID to update: ");
            String studentId = sc.nextLine();
            Student student = findStudentByStudentId(studentId);
            if (student == null) {
                System.out.println("Student does not exist.");
            } else {
                System.out.println("Enter new name (leave blank to keep current): ");
                String newName = sc.nextLine();
                if (!newName.isEmpty()) {
                    student.setName(newName);
                }
                System.out.println("Enter new Date of Birth (YYYY-MM-DD, leave blank to keep current): ");
                String newDob = sc.nextLine();
                if (!newDob.isEmpty()) {
                    student.setDateofBirth(LocalDate.parse(newDob));
                }
                System.out.println("Student information updated successfully.");
            }
        } catch (Exception e) {
            System.err.println("Invalid input, please try again.");
        }
    }

    // Track Students who Drop Out
    public void studentDropsOut() {
        try {
            System.out.println("Enter Student ID who is dropping out: ");
            String studentId = sc.nextLine();
            Student student = findStudentByStudentId(studentId);
            if (student == null) {
                System.out.println("Student does not exist.");
            } else {
                System.out.println("Enter reason for dropping out: ");
                String reason = sc.nextLine();
                droppedStudents.put(studentId, reason);
                students.remove(student);
                // Remove student from class
                for (ClassRoom classRoom : classRooms) {
                    classRoom.getStudentIds().remove(student.getStudentId());
                }
                System.out.println("Student dropped out successfully.");
            }
        } catch (Exception e) {
            System.err.println("Invalid input, please try again.");
        }
    }

    // Show Dropped Students List
    public void showDroppedStudentsList() {
        System.out.println("List of students who dropped out:");
        for (Map.Entry<String, String> entry : droppedStudents.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + ", Reason: " + entry.getValue());
        }
    }

    // Display Students for Each Teacher (optional optimization)
    public void showStudentsForTeacher(int teacherId) {
        try {
            Teacher teacher = null;
            for (Teacher t : teachers) {
                if (t.getTeacherId() == teacherId) {
                    teacher = t;
                    break;
                }
            }
            if (teacher == null) {
                System.out.println("Teacher does not exist.");
                return;
            }

            System.out.println("Students for teacher with ID " + teacherId + ":");
            for (int classId : teacher.getClassIds()) {
                ClassRoom classRoom = findClassRoomById(String.valueOf(classId));
                if (classRoom != null) {
                    System.out.println("ClassRoom ID: " + classRoom.getClassId() + ", ClassRoom Name: " + classRoom.getClassName());
                    for (String studentId : classRoom.getStudentIds()) {
                        Student student = findStudentByStudentId(studentId);
                        if (student != null) {
                            student.show();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Invalid input, please try again.");
        }
    }
}
