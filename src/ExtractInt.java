import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtractInt {
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		List<Person> section = new ArrayList<>();
		
		section.add(new Person(12,"Zyan",123456));
		section.add(new Person(6, "Mary", 41623474));
		section.add(new Person(76,"Suzzane", 35161));
		
		//System.out.println(section);
		
		Collections.sort(section);
		
		//System.out.println(section);
		
		Collections.sort(section, Person.AGE);
		
		//System.out.println(section);

		ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("person.txt")));
		out.writeObject(section);
		
		ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get("person.txt")));
		
		List<Person> sec = (List<Person>) in.readObject();
		
		System.out.println(sec);
	}

}
