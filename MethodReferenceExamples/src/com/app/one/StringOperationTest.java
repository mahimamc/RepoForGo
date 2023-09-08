package com.app.one;

import java.util.Objects;

public class StringOperationTest {

	public static void main(String[] args) {


		StringOperations opr=s->Objects.isNull(s);//Lambda
		System.out.println(opr.doSome("Hello"));
		System.out.println(opr.doSome(null));
		
		StringOperations opr1=Objects::isNull;
		System.out.println(opr1.doSome(null));
		System.out.println(opr1.doSome("Hello Mahima"));
		
		
		
	}

}
