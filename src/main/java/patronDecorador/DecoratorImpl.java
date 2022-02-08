package patronDecorador;

import lombok.Builder;
import persona.Person;

@Builder
public class DecoratorImpl implements IPersona{

	private Person person;
	
	public Person setPerson(Person p) {
		return this.person=p;
	}
	
	@Override
	public String getName() {
		return person.getName()+" 'el crack'";
	}

	@Override
	public int getAge() {
		return person.getAge() + 5;
	}
}
