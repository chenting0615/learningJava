package mutithd_test.thdfactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import mutithd_test.test1.Task;

public class ThreadFactoryExecutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ExecutorService defaultExeService = Executors.newCachedThreadPool();
			ExecutorService daemonEService = Executors.newCachedThreadPool(new DaemonThreadFactory());
			ExecutorService maxPriService = Executors.newCachedThreadPool(new MaxPriorityThreadFactory());
			ExecutorService minExecutorService = Executors.newCachedThreadPool(new MinPriorityThreadFactory());
			
			//用守护线程执行任务
			for(int i=1;i<10;i++)
			{
				daemonEService.execute(new Task(i));
			}
			//用其他线程执行任务
			for(int j=10;j<=20;j++)
			{
				if(j==10)
					maxPriService.execute(new Task(j));
				else if(j==11)
					minExecutorService.execute(new Task(j));
				else {
					defaultExeService.execute(new Task(j));
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
