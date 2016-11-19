import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person>,Serializable {
	
	private static final long serialVersionUID = 1L;

	public  static final Comparator<Person> AGE = new AgeComparator();
	
	private int age;
	private String name;
	private long salary;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	Person(int age, String name, long salary) {
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", salary=" + salary + "]";
	}
	
	@Override
	public int compareTo(Person p) {
		if(this.name.compareTo(p.getName()) == 0) return 0;
		else if(this.name.compareTo(p.getName()) < 0) return -1;
		else return 1;	
	}
	
	static class AgeComparator implements Comparator<Person> {

		@Override
		public int compare(Person o1, Person o2) {
			if(o1.getAge() == o2.getAge()) return 0;
			else if(o1.getAge() > o2.getAge()) return 1; 
			else return -1;
		}
		
	}
	
	public static Comparator<Person> SalaryComparator() {
		return new Comparator<Person> () {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.salary == o2.salary) return 0;
				else if( o1.salary < o2.salary) return -1;
				else return 1;
			}
			
		};
	}
	
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person> () ;
		
		list.add(new Person(13, "ross", 2300));
		list.add(new Person(34,"aoss", 9000));
		list.add(new Person(23, "coss", 4500));
		
		System.out.println(list);
		
		Collections.sort(list, Person.SalaryComparator());
		Collections.sort(list, Person.AGE);
		System.out.println(list);
		
		
	}
}
