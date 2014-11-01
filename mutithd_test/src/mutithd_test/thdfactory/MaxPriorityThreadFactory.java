package mutithd_test.thdfactory;

import java.util.concurrent.ThreadFactory;

public class MaxPriorityThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thrd = new Thread(r);
		thrd.setPriority(Thread.MAX_PRIORITY);
		return thrd;
	}

}
