package mutithd_test;

public class SynDemo {
	
	public void synMethod1()
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
	
	public void synMethod2()
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
