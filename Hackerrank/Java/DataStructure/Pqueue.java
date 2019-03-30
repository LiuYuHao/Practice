import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/*
Task: use the knowledge of PriorityQueue to solve the problem of order of student to be served
Input: n -> amount of events
      evetn -> if enter event it come with student (name, cgpa, id)
               if served event, based on the Comparator on name,cgpa and id the higher rank of student will be served and remove from Pqueue.
Output: print the list of name that is not be served
*/
/*
 * Create the Student and Priorities classes here.
 */
// class for priorities
class Priorities {
  // the function that deal with events
    public List<Student> getStudents(List<String> events) {
      // create a PriorityQueue to handle the order of student to be served with customed comparator
        PriorityQueue<Student> pqueue = new PriorityQueue<>(new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        if (s1.getCgpa() > s2.getCgpa()) {
                            return -1;
                        }
                        else if (s1.getCgpa() < s2.getCgpa()) {
                            return 1;
                        }
                        else {
                            if (!s1.getName().equals(s2.getName())) {
                                return s1.getName().compareTo(s2.getName());
                            }
                        }
                        return s1.getId() - s2.getId();
                    }
                });
        // loop the events
        for (int i = 0; i < events.size(); i++) {
            String[] event = events.get(i).split(" ");
            // if enter event, create a student object and save to pqueue
            if (event[0].equals("ENTER")) {
                Student s = new Student(Integer.parseInt(event[3]), event[1], Double.parseDouble(event[2]));
                pqueue.add(s);
            }
            // else it is served therefore, we remove the higher order of pqueue
            else {
                pqueue.poll();
            }
        }
        // due to return type we need to convert to list object
        List<Student> list = new ArrayList<>();
        // get the constant size of queue
        int size = pqueue.size();
        // we need to add to list with the order
        for (int i = 0; i <size;i++) {
            list.add(pqueue.poll());
        }
        // we return list
        return list;
    }
}
// create student class with basic requriment.
class Student {
    private double cgpa;
    private int id;
    private String name;
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public double getCgpa() {
        return this.cgpa;
    }
}

public class Pqueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
