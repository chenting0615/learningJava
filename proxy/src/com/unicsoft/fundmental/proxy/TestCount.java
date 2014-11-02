package com.unicsoft.fundmental.proxy;

public class TestCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountImpl countImpl = new CountImpl();
		CountProxy countProxy = new CountProxy(countImpl);
		countProxy.updateCount();
		countProxy.queryCount();

	}

}
