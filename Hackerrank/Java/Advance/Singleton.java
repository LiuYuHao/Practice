import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
/*
Task: Create Singleton class, where singleton mean:
      The singleton pattern is a design pattern that restricts the instantiation of a class to one object.
      This is useful when exactly one object is needed to coordinate actions across the system.
*/

class Singleton{
    public String str;
    private Singleton() {}
    private static Singleton singleton= new Singleton();
    // this is static function that return singleton => it return the same object.
    public static Singleton getSingleInstance(){
        return singleton;
    }
}
