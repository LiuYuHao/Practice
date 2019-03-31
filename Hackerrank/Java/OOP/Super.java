import java.util.*;
import java.io.*;
/*
Task: use super keyword to get the fucntion that overridden by the subclass
*/

class BiCycle{
	String define_me(){
		return "a vehicle with pedals.";
	}
}

class MotorCycle extends BiCycle{
	String define_me(){
		return "a cycle with an engine.";
	}

	MotorCycle(){
		System.out.println("Hello I am a motorcycle, I am "+ define_me());

		String temp=super.define_me(); //Fix this line

		System.out.println("My ancestor is a cycle who is "+ temp );
	}

}
class Super{
	public static void main(String []args){
		MotorCycle M=new MotorCycle();
	}
}
