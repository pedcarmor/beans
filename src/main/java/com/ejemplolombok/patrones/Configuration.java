package com.ejemplolombok.patrones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import persona.Person;

@org.springframework.context.annotation.Configuration
public class Configuration {

	//Crear un bean y devuelve una persona con los valores. 
	@Bean(name="personPrototype")
	@Scope("prototype")
	public Person personPrototype() {
		Person p = Person.builder().age(10).name("Manolo").build();
		return p;
	}
	
	@Bean(name="personSingleton") 
	@Scope("singleton") //POR DEFECTO LOS BEANS SON SINGLETON, SI SE QUITA EL SCOPE TE LO CREA SINGLETON
	public Person personSingleton() {
		Person p = Person.builder().age(10).name("Manolo").build();
		return p;
	}
}
