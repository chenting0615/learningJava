package mutithd_test.pubcon;

public class Info2 {
	
	private String name = "Rollen";
	private int age = 20;
	private boolean flag = false;
	
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
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
		if(!flag){
			try{
				super.wait();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		//一直等到flag等于true
		this.name = name;
		try{
			Thread.sleep(100);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//为什么要等待100ms?????
		this.age =age;
		flag = false;
		//通知
		super.notify();
    }
     
    public synchronized void get(){
       if(flag){
    	   try{
    		   super.wait();
    	   }catch(Exception e){
    		   e.printStackTrace();
    	   }
       }
       try {
    	   Thread.sleep(100);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
       System.out.println(this.getName()+" is :" +this.getAge());
       flag=true;
       super.notify();
    }
	
	

}
