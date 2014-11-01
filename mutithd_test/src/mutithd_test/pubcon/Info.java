package mutithd_test.pubcon;

public class Info {
	
	private String name = "Rollen";
	private int age = 20;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public synchronized void set(String name, int age){
        this.name=name;
        try{
            Thread.sleep(100);
        }catch (Exception e) {
            e.printStackTrace();
        }
        this.age=age;
    }
     
    public synchronized void get(){
        try{
            Thread.sleep(100);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"<===>"+this.getAge());
    }
	
	

}
