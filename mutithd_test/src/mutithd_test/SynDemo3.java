package mutithd_test;

public class SynDemo3 {
	
	private Object flag1 = new Object();
	private Object flag2 = new Object();
	
	public void synMethod1()
	{
		synchronized (flag1) {
			
		
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
	}
	
	public void synMethod2()
	{
		synchronized (flag2) 
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

}
