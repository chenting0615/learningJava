package mutithd_test;

public class SynDemo2 {
	
	public synchronized void synMethod1()
	{
		while(true)
		{
			try
			{
				Thread.sleep(1000);
				System.out.println("synMethod1");
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
			
		
		}
	}
	
	/**
	 * synchronize实际上是以this为lock对象
	 */
	public synchronized void synMethod2()
	{
		while(true)
		{
			try
			{
				Thread.sleep(1000);
				System.out.println("synMethod2");
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
			
		
		}
	}

}
