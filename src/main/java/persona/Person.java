package persona;

import patronDecorador.IPersona;
import proxy.IProxy;

public class Person implements IProxy, IPersona{

	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	private Person(PersonBuilder personBuilder) {
		this.name = personBuilder.name;
		this.age = personBuilder.age;
	}

	public Person() {
		
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
	
	
	//Para crear el clone le pasamos el objeto con el constructor y nos crea un objeto diferente con los mismo valores
//	@Override
//	public Person clonar() {
//		return new Person(this.name,this.age);
//	}
	
	
	//El builder es una clase anidada
	public static class PersonBuilder{
		private String name;
		private int age;
		
		public PersonBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public PersonBuilder age(int age) {
			this.age=age;
			return this;
		}
		
		public Person build() {
			return new Person(this.name, this.age);
		}
	}

	public static PersonBuilder builder() {
		return new PersonBuilder();
	}

	@Override
	public void operation() {
		System.out.println("Esta es la operación de persona");
		
	}
}
