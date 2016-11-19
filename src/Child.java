
public class Child extends Parent {

	int age;
	
	public Child() {
		super("John");
		this.age = 12;
	}
	
	public Child(String name) {
		this();
	}
	
	public float overload(int x) {
		return x;
	}
	
	public int overload(float x) {
		return (int) x;
	}
	
	@Override
	public String toString() {
		return super.toString() + age;
	}
	
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.overload((float)2.3) + " " + c.overload(3));
		System.out.println(new Child().toString());
	}

}
