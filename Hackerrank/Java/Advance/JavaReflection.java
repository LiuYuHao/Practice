/*
Task:using reflection (class object and method object) to print the order of method that the student had.
Output: the method name in nature order.
*/
class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod(){  }
}
public class JavaReflection {

        public static void main(String[] args){
          // this is the way to get the class object of a class
            Class student = Student.class;
            // get all declared methods return array of method
            Method[] methods = student.getDeclaredMethods();

            ArrayList<String> methodList = new ArrayList<>();
            for(int i = 0; i< methods.length; i++){
                methodList.add(methods[i].getName());
            }
            Collections.sort(methodList);
            for(String name: methodList){
                System.out.println(name);
            }
        }

    }
