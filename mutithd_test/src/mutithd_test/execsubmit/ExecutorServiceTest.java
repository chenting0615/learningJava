package mutithd_test.execsubmit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ExecutorServiceTest {
	
	public static void main(String[] args)
	{
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<String>> resultList = new ArrayList<Future<String>>();
		
		for(int i=0;i<10;i++)
		{
			Future<String> future = executorService.submit(new TaskWithResult(i));
			resultList.add(future);			
		}
		executorService.shutdown();
		
		//遍历任务的结果
		for(Future<String> fs:resultList)
		{
			try {
				System.out.println(fs.get());
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}

}
