package mutithd_test.pubcon;

public class Consumer2 implements Runnable {
	
	private Info2 info = null;
	public Consumer2(Info2 info){
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
			this.info.get();
		}

	}

}
