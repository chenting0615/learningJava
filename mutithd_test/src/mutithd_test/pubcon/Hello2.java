package mutithd_test.pubcon;


public class Hello2 {
	public static void main(String[] args){
		Info2 info = new Info2();
		Producer2 producer = new Producer2(info);
		Consumer2 consumer = new Consumer2(info);
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}
