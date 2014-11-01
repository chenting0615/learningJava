package mutithd_test.pubcon;

public class Producer implements Runnable {
	
	private Info info = null;
	
	Producer(Info info)
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
				this.info.setName("Rollen");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				this.info.setAge(20);
				flag = false;
			}
			else {
				this.info.setName("Chunge");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				this.info.setAge(100);
				flag=true;
			}
		}
		

	}

}
