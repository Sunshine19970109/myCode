package oo.day05;

public interface Inter11 {
	double PI = 3.1415926;
	void show();
}

class Test{
	public static void main(String[] args) {
		Inter44 o1 = new Inter44() {
			
			@Override
			public void c() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void e() {
				// TODO Auto-generated method stub
				
			}
		};
		Inter44 o2 = new Nooo();
		Inter44 o3 = new Nooo();
	}
}

interface Inter22{
	void a();
	void b();
}

interface Inter44 extends Inter33{
	void e();
}

class Nooo implements Inter44{

	@Override
	public void c() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void e() {
		// TODO Auto-generated method stub
		
	}
	
}

abstract class Looo{
	abstract void d();
}
class Mooo extends Looo implements Inter22,Inter33{

	@Override
	public void c() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void d() {
		// TODO Auto-generated method stub
		
	}
	
}

class Joo implements Inter22{

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}
	
}
interface Inter33{
	void c();
}
class Kooo implements Inter33,Inter22{

	@Override
	public void c() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}
	
}