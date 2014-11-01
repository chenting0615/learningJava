package mutithd_test.thdfactory;

import java.util.concurrent.ThreadFactory;

public class MinPriorityThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thrd = new Thread(r);
		thrd.setPriority(Thread.MIN_PRIORITY);
		return thrd;
	}

}
