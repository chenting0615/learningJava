package mutithd_test.thdfactory;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		// TODO Auto-generated method stub
		Thread thd = new Thread(r);
		thd.setDaemon(true);
		return thd;
	}

}
