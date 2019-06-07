class Dog {
  // we need to create a constructor, initial the object
  // public and same name as class
  // instance variable
  // the thing need to remember that there are public, private.
  // use the word extends to access the parent.
  int age;
  // constructor parameter
  public Dog(int age) {
    this.age = age;
  }
  // the method,
  public void bark(){
    System.out.print("method1");
  }
  // we can add arugment int method
  public void run(int feet) {
    System.out.print(feet);
  }
}
