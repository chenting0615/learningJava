package com.unicsoft.fundmental.proxy.dynamic;

import java.lang.reflect.Method;

public class TestProxy {
	
	public static void main(String[] args)
	{
		BookFacadeProxy proxy = new BookFacadeProxy();  
		//动态返回一个proxyInstance(跟bookfacade是一个接口)
		BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());  
		bookProxy.addBook();  
		System.out.println(bookProxy.getClass().getName());	//输出Proxy0
		Method[] methods = bookProxy.getClass().getMethods();
		for(Method method:methods)
		System.out.println(method.getName()+" , "+method.getReturnType().getCanonicalName());

	}

}
