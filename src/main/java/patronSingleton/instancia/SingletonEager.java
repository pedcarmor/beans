package patronSingleton.instancia;

import persona.Person;

//HACER SINGLETON DE FORMA EAGER
public class SingletonEager {

	public static final Person INSTANCE = new Person();
	
	private SingletonEager() {
		
	}
}
