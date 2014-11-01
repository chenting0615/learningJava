package mutithd_test.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//创建固定线程数目的线程池，以共享的无界队列方式来运行这些线程
			ExecutorService executorService = Executors.newFixedThreadPool(2);
			
			for(int i=1;i<=4;i++)
			{
				executorService.execute(new Task(i));
			}
			executorService.shutdown();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
