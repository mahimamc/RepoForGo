package com.app.two;

public class StirngOperationTest {

	public static void main(String[] args) {


		StringOperations opr=s->s.toUpperCase();//Lambda
		System.out.println(opr.doSomeOperation("mahima malay chhinchani"));
		
		StringOperations opr1=String::toUpperCase;//Method Ref
		System.out.println(opr1.doSomeOperation("hello mahima"));
	}

}
