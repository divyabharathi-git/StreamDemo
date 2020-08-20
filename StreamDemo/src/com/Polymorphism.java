package com;

 class TestSuperClass{
	 
	 static int a =10;
	
	 public void show() {
		  
		 System.out.println("Show method ==> Super class");
		 System.out.println("this keyword" + this.a);
		 
	 }
	 
	 public static void display() {
		 
		 System.out.println("Display method ==> Super class");
	 }

}

 class TestSubClass extends TestSuperClass{
	 
	 public void show() {
		 
		 System.out.println("Show method ==> Sub class");
	 }
	 
	 public static void display() {
		 
		 System.out.println("Display method ==> Sub class");
		 
	 }
}

public class Polymorphism {
	
	
	public int add(int x,int y) {
		
		TestSuperClass.a = 10;
		
		return  x+y;
		
	}

	
	public static int staticadd(int x,int y) {
		
		return  x+y;
		
	}
	

	
	
	public int add(int x,int y,int z) {
		
		return  x+y+z;
		
	}
	
	public static int staticadd(int x,int y,int z) {
		return  x+y+z;
		
	}
	
	public static void main(String[] args) {
		
		//parent-parent 
		TestSuperClass parent = new TestSuperClass();
		//child-child
		TestSubClass child = new TestSubClass();
		//parent-child
		TestSuperClass aparent = new TestSubClass();
		//child-parent
		//TestSubClass achild = new TestSuperClass();
		//main
		Polymorphism main = new Polymorphism();
		
		System.out.println("*********method overiding**********");
		
		System.out.println("--------calling Non static method-----------");
		//System.out.println("parent-parent");
		parent.show();
		//System.out.println("child-child");
		//child.show();
		System.out.println("parent-child");
		aparent.show();
		
		System.out.println("*********method hiding**********");
		
		System.out.println("---------calling  static method----------");
		//System.out.println("parent-parent");
		//TestSuperClass.display();
		//System.out.println("child-child");
		//TestSubClass.display();
		System.out.println("parent-child");
		aparent.display();
		
		System.out.println("*********method overloading**********");
		
		System.out.println("--------calling Non static method-----------");
		System.out.println("adding two = "+main.add(1, 2));
		System.out.println("adding three = "+main.add(1, 2, 3));
		
		System.out.println("---------calling  static method----------");
		System.out.println("adding two = "+Polymorphism.staticadd(1, 2));
		System.out.println("adding three = "+Polymorphism.staticadd(1, 2, 3));
		
		
		Polymorphism p = new Polymorphism();
		parent.a = 10 + 10;
		
		System.out.println("a is = "+parent.a);
		
		TestSuperClass.a = 50;
		
		System.out.println("a is = "+TestSuperClass.a);
		
	
	}
	

}




