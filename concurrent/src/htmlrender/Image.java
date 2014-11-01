package htmlrender;

public class Image {
	private String info;

	public Image(String info) {
		this.info = info;
	}

	public void download() {
		try {
			System.out.println("Downloading image...."+info);
			Thread.sleep(1000);
		} catch (InterruptedException ignored) {
		}
	}
	
	
}
