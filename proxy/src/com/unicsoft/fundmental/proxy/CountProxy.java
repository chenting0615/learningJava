package com.unicsoft.fundmental.proxy;

public class CountProxy implements Count {
	
	private CountImpl countImpl;
	
	public CountProxy(CountImpl countImpl)
	{
		this.countImpl = countImpl;
	}
	

	@Override
	public void queryCount() {
		// TODO Auto-generated method stub
		System.out.println("before transaction....");
		countImpl.queryCount();
		System.out.println("after transaction ...");
		
	}

	@Override
	public void updateCount() {
		// TODO Auto-generated method stub
		System.out.println("before transaction update...");
		countImpl.updateCount();
		System.out.println("after transaction update....");
		

	}

}
