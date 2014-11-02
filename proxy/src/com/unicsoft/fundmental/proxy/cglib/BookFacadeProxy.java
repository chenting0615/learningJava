package com.unicsoft.fundmental.proxy.cglib;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 使用cglib动态代理
 * @author baobinxia
 *
 */
public class BookFacadeProxy implements MethodInterceptor {
	
	private Object target;
	
	public Object getInstance(Object target)
	{
		this.target = target;
		Enhancer enhancer = new Enhancer();
		//将这个类设置成父类，实际上是新生成一个子类覆盖这个类来完成
		enhancer.setSuperclass(this.target.getClass());
		
		//设置回调
		enhancer.setCallback(this);
		
		//创建代理对象
		return enhancer.create();
		
	}
	

	//回调方法?
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("transaction begins...");
		arg3.invokeSuper(arg0, arg2);
		System.out.println("transaction ends....");
		
		
		return null;
	}
	
	

}
