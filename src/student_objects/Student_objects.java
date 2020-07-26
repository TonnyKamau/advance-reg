/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_objects;
import java.util.*;
/**
 *
 * @author 
 */


public class Student_objects {

    int index;
    String[] subjects = new String[4];
    String name;
    double average;
    int[] marks = new int[subjects.length];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of the student entries");

        //handle inputs at theis point.
        int n = 0;
        boolean flag = false;
        //Handling exceptions in the inputs.
        while (!flag) {
            try {
                n = input.nextInt();
                flag = true;
                if (n < 0) {
                    System.out.println("Enter an integer greater than zero as index");
                    flag = false;

                }

            } catch (InputMismatchException e) {
                System.out.println("Enter a valid Index");
                input.next();
                flag = false;

            }
        }
        Student_objects[] entries = new Student_objects[n];

        for (int i = 0; i < entries.length; i++) {
            //this method calls the constructor in a loop.
            //assigning the index to the student.
            entries[i] = new Student_objects();
            entries[i].index = i + 1;
            entries[i].average = entries[i].avg(entries[i].marks);//avarage score of each student is calculated and stored.
        }

        System.out.println("************************STUDENTS REPORT**************************");
        for (Student_objects a : entries) {

            a.display();
            System.out.println("\n");
        }
        System.out.println("******************************************************************\n\n");

//        sorting the array alphabetically according to the first name.
        System.out.println("-----------------------------------------Sorted According to First Name------------------------------------------------------------");
        for (int i = 0; i < entries.length; i++) {

            if (entries[i].name.contains(" ") == true) {

                entries[i].name = entries[i].name.split(" ")[0];//split the object name attribute if it contains more than two names for the purpose of comparison.

            }
            for (int j = i + 1; j < entries.length; j++) {
                //checking if the name string of the object contains a white space and delimit it ,thereafter take the first word.
                if (entries[j].name.contains(" ") == true) {
                    entries[j].name = entries[j].name.split(" ")[0];
                }
                if ((entries[i].name.compareTo(entries[j].name)) > 0) {
                    //meaning the preceeding elements in the entries list should be swapped.

                    //swap the two student_objects in the entries array of type question 1 using a third variable of type Question1.
                    Student_objects temp = entries[i];
                    entries[i] = entries[j];
                    entries[j] = temp;

                }

            }

        }
        //this displays details of all the students registered by calling the display method in a loop.

        for (Student_objects a : entries) {

            a.display();
            System.out.println("\n");
        }

        System.out.println("---------------------------------------Finding Best And Worst Students---------------------------------------------------");

        //FINDING  THE WORST STUDENT:
        String best = entries[0].name;
        double best_points = entries[0].average;
        String worst = entries[0].name;
        double worst_points = entries[0].average;

        for (int i = 0; i < entries.length; i++) {

            if (entries[i].average < worst_points) {
                worst = entries[i].name;
                worst_points = entries[i].average;
            }

        }

        //FINDING THE BEST STUDENT:
        for (int i = 0; i < entries.length; i++) {

            if (entries[i].average > best_points) {
                best = entries[i].name;
                best_points = entries[i].average;
            }

        }

        System.out.println("--------------------BEST & WORST------------------------------------");

        //PRINTING THE BEST AND THE WORST STUDENTS.
        System.out.printf("BEST STUDENT---> NAME:%s    POINTS:%f\n", best, best_points);
        System.out.printf("WORST STUDENT---> NAME:%s   POINTS:%f\n", worst, worst_points);
        System.out.println("-------------------------------------------------------------------");
    }

    public Student_objects() {
        Scanner read = new Scanner(System.in);
        //this is the constructor object that initializes our class.
        //allows you to enter the name of the student.

        System.out.println("\nEnter the name of student");
        this.name = read.nextLine();
        //Below loop to allow entry of subject taken and the corresponding marks
        for (int i = 0; i < this.subjects.length; i++) {
            System.out.printf("Enter subject %d  ", i + 1);
            //handle inputs at this points
            this.subjects[i] = read.next();
            System.out.printf("Enter Marks for  %s  ", this.subjects[i]);
            boolean flag = false;
            while (!flag) {
                try {
                    this.marks[i] = read.nextInt();
                    flag = true;
                    if (this.marks[i] < 0 || this.marks[i] > 100) {
                        System.out.printf("Mark out or Range..Re-enter marks for %s ", this.subjects[i]);
                        flag = false;
                    }

                } catch (InputMismatchException e) {
                    System.out.printf("Invalid mark!! Re-enter mark for %s ", this.subjects[i]);
                    read.next();
                    flag = false;

                }
            }

        }

    }

    public void display() {
        System.out.printf("Name:%s Index:%d\n", this.name, this.index);
        for (int i = 0; i < this.subjects.length; i++) {
            System.out.printf("SUBJECT %d-->%s   Points=%d\n", i+1, this.subjects[i], this.marks[i]);
        }
        System.out.printf("AVERAGE POINTS:%f\n", this.average);
    }

    public double avg(int[] marks) {
        //method is used to return the avarage of a given student
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];

        }
        return ((double) sum / marks.length);
    }

}

