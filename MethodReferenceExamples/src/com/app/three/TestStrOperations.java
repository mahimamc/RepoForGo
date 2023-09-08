package com.app.three;

public class TestStrOperations {

	public static void main(String[] args) {


			
			StringOperations opr=(s1,s2)->s1.concat(s2);
			System.out.println(opr.doOperations("Hello ", " Mahima"));
			
			StringOperations opr1=String::concat;
			System.out.println(opr1.doOperations("Mahima", "Hello"));
		
		
	}

}
