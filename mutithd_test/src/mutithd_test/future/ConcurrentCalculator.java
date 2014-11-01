package mutithd_test.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ConcurrentCalculator {
	
	private ExecutorService executorService;
	
	private int cpuCoreNumber;
	
	//任务列表
	private List<Future<Long>> tasks = new ArrayList<Future<Long>>();
	
	//实现
	class SumCalculator implements Callable<Long>{
		private int[] numbers;
		private int start;
		private int end;
		
		public SumCalculator(final int[] numbers, int start, int end){
			this.numbers = numbers;
			this.start= start;
			this.end = end;
		}

		@Override
		public Long call() throws Exception {
			// TODO Auto-generated method stub
			Long sumLong = 0L;
			
			for(int i=start;i<end;i++)
			{
				sumLong+=numbers[i];
			}
			return sumLong;
		}
		
		
	}
	
	public ConcurrentCalculator(){
		cpuCoreNumber = Runtime.getRuntime().availableProcessors();
		executorService =Executors.newFixedThreadPool(cpuCoreNumber);
	}
	
	//并行加法
	public Long sum(final int[] numbers){
		for(int i=0;i<cpuCoreNumber;i++){
			
			int increment = numbers.length/cpuCoreNumber+1;
			int start = increment*i;
			int end = increment*i + increment;
			if(end > numbers.length)
				end = numbers.length;
			
			//创建一个runnable
			SumCalculator subCalculator = new SumCalculator(numbers, start, end);
			
			//创建一个可返回结果的任务
			FutureTask<Long> task = new FutureTask<Long>(subCalculator);
			//加入到任务列表当中
			tasks.add(task);
			
			if(!executorService.isShutdown())
			{
				//通过executorService启动任务
				executorService.submit(task);
			}
			
			
			
		}
		
		return getResult();
	}
	
	public Long getResult()
	{
		Long result = 0L;
		for(Future<Long> task:tasks)
		{
			try {
				//获取某个任务的结果
				Long subSumLong = task.get();
				result+=subSumLong;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void close()
	{
		executorService.shutdown();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		ConcurrentCalculator c = new ConcurrentCalculator();
		Long sum = c.sum(numbers);
		System.out.println(sum);
		c.close();
		

	}

}
