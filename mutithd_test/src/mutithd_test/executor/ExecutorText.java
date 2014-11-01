package mutithd_test.executor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ExecutorText {
	
	@Test
	public void test1() throws InterruptedException, ExecutionException
	{
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		ScheduledFuture<String> scheduledFuture = executorService.schedule(new Callable<String>() {
			
			public String call() throws Exception{
				return "call";
			}
		}, 10, TimeUnit.SECONDS);
		System.out.println(scheduledFuture.get());
		executorService.shutdown();
	}
	
	@Test
	public void test2()
	{
		final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Time is : "+sf.format(new Date()));
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		}, 2, 3, TimeUnit.SECONDS);
		
	}
	
	public void testFixed()
	{
		// TODO Auto-generated method stub
				final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
				System.out.println("Start Time is : "+sf.format(new Date()));
				executorService.scheduleAtFixedRate(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						System.out.println("Time is : "+sf.format(new Date()));
						try {
							//TimeUnit.SECONDS.sleep(5);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						
					}
				}, 2, 3, TimeUnit.SECONDS);
	}

	public static void main(String[] args) {
		
		new ExecutorText().testFixed();

	}

}
