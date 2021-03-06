package mutithd_test.execsubmit;

import java.util.Random;
import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {

	private int id;
	
	public TaskWithResult(int id)
	{
		this.id = id;
	}
	/*任务的具体过程，一旦过程传给ExecutorService的submit方法，则方法自动在
	 * 一个线程上执行
	 * 
	 * (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("call()方法被自动调用，干活....."+Thread.currentThread().getName());
		
		if(new Random().nextBoolean())
			throw new TaskException("Meet error in task. "+Thread.currentThread().getName());
		
		for(int i=99999999;i>0;i--)
			;
		return "call()方法被自动调用，任务结果是："+id+"  "+Thread.currentThread().getName();
		
		
		
		//return null;
	}
	
	public class TaskException extends Exception
	{
		public TaskException(String message)
		{
			super(message);
		}
	}

}
