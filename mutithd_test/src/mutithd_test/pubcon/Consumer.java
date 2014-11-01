package mutithd_test.pubcon;

public class Consumer implements Runnable {
	
	private Info info = null;
	public Consumer(Info info){
		this.info =info;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<25;i++)
		{
			try{
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println(this.info.getName()+" is: "+ this.info.getAge());
		}

	}

}
