package pbo.f01;

import java.util.*;
import java.util.stream.Collectors;

/*
 * 12S22016 Desri Stevie Natalie Dabukke
 * 12S22035 Brain Wonderson
 */

import pbo.f01.model.Dorm;
import pbo.f01.model.Student;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Dorm> dorms = new ArrayList<>();
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            String input = scanner.nextLine().trim();
            String[] parts = input.split("#");
            String command = parts[0];

            switch (command.toLowerCase()) {
                case "dorm-add":
                    addDorm(parts);
                    break;
                case "student-add":
                    addStudent(parts);
                    break;
                case "assign":
                    assignStudent(parts);
                    break;
                case "display-all":
                    displayAll();
                    break;
                case "---":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addDorm(String[] parts) {
        try {
            String name = parts[1].trim();
            int capacity = Integer.parseInt(parts[2]);
            String gender = parts[3].trim();
            Dorm dorm = new Dorm(name, capacity, gender);
            dorm.setStudents(new ArrayList<>());
            dorms.add(dorm);
        } catch (Exception e) {
            System.out.println("Error: Invalid dormitory data format. Please try again.");
        }
    }

    private static void addStudent(String[] parts) {
        try {
            String id = parts[1].trim();
            String name = parts[2].trim();
            int entranceYear = Integer.parseInt(parts[3]);
            String gender = parts[4].trim();
            Student student = new Student(id, name, entranceYear, gender);
            students.add(student);
        } catch (Exception e) {
            System.out.println("Error: Invalid student data format. Please try again.");
        }
    }

    private static void assignStudent(String[] parts) {
        try {
            String studentId = parts[1].trim();
            String dormName = parts[2].trim();
            Student student = findStudentById(studentId);
            Dorm dorm = findDormByName(dormName);
            if (student == null || dorm == null || !student.getGender().equals(dorm.getGender()) || dorm.getStudents().size() >= dorm.getCapacity()) {
               // System.out.println("Error: Unable to assign student to dormitory.");
                return;
            }
            student.setDorm(dorm);
            dorm.getStudents().add(student);
        } catch (Exception e) {
            System.out.println("Error: Invalid data format. Please try again.");
        }
    }

    private static void displayAll() {
        try {
            List<Dorm> sortedDorms = dorms.stream().sorted(Comparator.comparing(Dorm::getName)).collect(Collectors.toList());

            for (Dorm dorm : sortedDorms) {
                System.out.println(dorm.getName() + "|" + dorm.getGender() + "|" + dorm.getCapacity() + "|" + dorm.getStudents().size());

                List<Student> sortedStudents = dorm.getStudents().stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());

                for (Student student : sortedStudents) {
                    System.out.println(student.getId() + "|" + student.getName() + "|" + student.getEntranceYear());
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Unable to display dormitory information.");
        }
    }

    private static Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private static Dorm findDormByName(String name) {
        for (Dorm dorm : dorms) {
            if (dorm.getName().equals(name)) {
                return dorm;
            }
        }
        return null;
    }
}
