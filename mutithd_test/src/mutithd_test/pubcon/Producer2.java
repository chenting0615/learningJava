package mutithd_test.pubcon;

public class Producer2 implements Runnable {
	
	private Info2 info = null;
	
	Producer2(Info2 info)
	{
		this.info = info;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(int i=0;i<25;i++)
		{
			if(flag)
			{
				this.info.set("Rollen", 20);
				flag = false;
			}
			else {
				this.info.set("Chunge", 100);
				flag=true;
			}
		}
		

	}

}
