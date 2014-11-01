package mutithd_test.waitnotify;

public class WaitNofityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread t1=new TestThread();
		TestThread t2=new TestThread();
		TestThread t3=new TestThread();
		
		t1.start();
		t2.start();
		t3.start();
		
		//主线程等待
		try {
			Thread.sleep(1000*5);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Main Thread Interrupted...");
		}
		
		System.out.println("Resume by Notify");
		
		//通过线程1来Notify(线程1的run实际上在等待)
		t1.resumeByNotify();
		
		try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted");
        }
        
        System.out.println("Resume By NotifyAll");
        
        //实际上是在主线程里面调用t2这个对象的同步
        t1.resumeByNotifyAll();

	}

}
