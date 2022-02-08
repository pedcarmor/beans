package patronProxy;

import persona.Person;
import proxy.IProxy;

public class PersonaProxy implements IProxy{

	private Person p;
	
	public PersonaProxy(Person p) {
		super();
		this.p = p;
	}

	@Override
	public void operation() {
		System.out.println("Aquí empieza la operación del proxy");
		p.operation();
		System.out.println("Aquí termina la operación del proxy");	
	}

}
