package mutithd_test.waitnotify;

public class TestThread extends Thread {
	
	private static Object obj = new Object();
	
	public void run()
	{
		System.out.println(getName()+" Before wait...");
		
		//获取锁，并等待...
		synchronized (obj) {
			try {
				obj.wait();
				//调用等待，则放弃了锁。。。
				//wait/notify必须与synchronized一起使用
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(getName()+" Test Thread interrupted...");
			}
			
		}
		
		System.out.println(getName()+" After wait...");
		
	}
	
	public void resumeByNotify()
	{
		synchronized (obj) {
			obj.notify();
			
		}
	}
	
	public void resumeByNotifyAll()
	{
		synchronized (obj) {
			obj.notifyAll();
			
		}
	}

}
