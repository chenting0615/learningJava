package mutithd_test.schedule;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Executor executor = Executors.newFixedThreadPool(10);  
		Runnable task = new Runnable() {  
			    @Override  
			    public void run() {  
			        System.out.println("task over"+new Date());  
			    }  
			};  
		executor.execute(task);  
			  
		executor = Executors.newScheduledThreadPool(10);  
		ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;  
		System.out.println(new Date());
		scheduler.scheduleAtFixedRate(task, 10, 10, TimeUnit.SECONDS);

		

	}

}
