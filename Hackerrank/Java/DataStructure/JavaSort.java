import java.util.*;
/*
Task: Use comaprable to sort the Student based on the cgpa -> name -> id (-> when they are equal)
Input: a Integer for amount of students, each students has id, name and cgpa
Output: the correct order of name of student
*/
class Student implements Comparable<Student>{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
  // override the compareto
  @Override
  public int compareTo(Student s) {
        // check the cpga first, reverse order
        if (this.cgpa != s.getCgpa()) {
            if (s.getCgpa() > this.cgpa) {
                return 1;
            }
            else if (s.getCgpa() < this.cgpa) {
                return -1;
            }
        }
        // if they are equal
        else {
          // natural order of name
            if (s.getFname().compareTo(this.fname) != 0) {
                return this.fname.compareTo(s.getFname());
            }
        }
        // difference between id
        return this.id - s.getId();
    }
}

//Complete the code
public class JavaSort
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}
        Collections.sort(studentList);
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}
