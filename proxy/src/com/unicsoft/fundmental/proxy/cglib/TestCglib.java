package com.unicsoft.fundmental.proxy.cglib;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestCglib {
	
	public static void main(String[] args)
	{
		BookFacadeProxy cglib = new BookFacadeProxy();
		BookFacadeImpl bookcglib = (BookFacadeImpl)cglib.getInstance(new BookFacadeImpl());
		bookcglib.addBook();
	}

}
