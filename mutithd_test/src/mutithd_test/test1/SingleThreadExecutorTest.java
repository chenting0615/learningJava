package mutithd_test.test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			 // 创建一个单线程执行程序  
			ExecutorService executorService = Executors.newSingleThreadExecutor();
			for(int i=1;i<=3;i++){
				executorService.execute(new Task(i));
			}
			executorService.shutdown();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
