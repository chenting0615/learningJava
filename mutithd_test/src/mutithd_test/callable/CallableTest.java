package mutithd_test.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Callable<Integer> func = new Callable<Integer>(){

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("inside Callable");
				Thread.sleep(1000);
				//返回结果
				return new Integer(8);
			}
		
		};
		
		//创建futuretask,可以得到结果
		FutureTask<Integer> futureTask = new FutureTask<Integer>(func);
		Thread newThread = new Thread(futureTask);
		newThread.start();
		
		try {
			System.out.println("blocking here");
			//如果还没有返回，则暂时阻塞
			Integer resultInteger = futureTask.get();
			System.out.println(resultInteger);
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
