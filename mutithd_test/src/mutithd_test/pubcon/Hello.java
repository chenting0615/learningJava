package mutithd_test.pubcon;


public class Hello {
	public static void main(String[] args){
		Info info = new Info();
		Producer producer = new Producer(info);
		Consumer consumer = new Consumer(info);
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
