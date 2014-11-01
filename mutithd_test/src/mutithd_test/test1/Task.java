package mutithd_test.test1;

public class Task implements Runnable {
	
	volatile boolean stop=false;
	
	private int runCount = 0;
	
	private int taskId;
	
	public Task(int taskId)
	{
		this.taskId = taskId;
		System.out.println("Create Task: "+ this.taskId);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!stop){
			try {
				Thread.sleep(10);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Task Interrupted...");
			}
			
			if(++runCount == 3)
				stop = true;
			
			System.out.println(""+Thread.currentThread().toString()+
					"\t\t\t\t execute Task-" +taskId +" 's "+runCount
					+"th run");
		}

	}

}
