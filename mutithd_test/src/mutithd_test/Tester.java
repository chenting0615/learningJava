package mutithd_test;

public class Tester {
	
	public static void main(String[] args)
	{
		//final SynDemo synDemo = new SynDemo();
		//final SynDemo2 synDemo = new SynDemo2();
		final SynDemo3 synDemo = new SynDemo3();
		
		Thread thread1 = new Thread()
		{
			public void run()
			{
				super.run();
				synDemo.synMethod1();
			}
		};
		
		Thread thread2 = new Thread()
		{
			public void run()
			{
				super.run();
				synDemo.synMethod2();
			}
		};
		
		thread1.start();
		thread2.start();
		
		while(true)
		{
			try{
				thread1.sleep(1000);
				System.out.println("main");
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
