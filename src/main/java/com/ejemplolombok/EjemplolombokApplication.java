package com.ejemplolombok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import chainresponsibility.Unidad;
import patronDecorador.DecoratorImpl;
import patronProxy.PersonaProxy;
import persona.Person;

@SpringBootApplication
public class EjemplolombokApplication implements CommandLineRunner{

	//Inyectamos un bean, el contexto de la aplicacion y podemos obtener otros beans
	@Autowired
	private ApplicationContext context;
	
	
	public static void main(String[] args) {
		SpringApplication.run(EjemplolombokApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		//PATRON PROTOTYPE CLONE
		Person p1 = new Person("Pepe",10);
		System.out.println("Edad: "+p1.getAge()+", Nombre: "+p1.getName()+", Objeto: "+p1.hashCode());
		//Person p2 = p1.clonar();
		//System.out.println("Edad: "+p2.getAge()+", Nombre: "+p2.getName()+", Objeto: "+p2.hashCode());
				
//		if(p1==p2) {
//			System.out.println("Son iguales los objetos");
//		}else {
//			System.out.println("No son iguales los objetos");
//		}
				
		Person pbuilder = Person.builder().age(43).name("Ale").build();
		System.out.println(pbuilder.getAge());
		System.out.println(pbuilder.getName());
				
		//Crea beans distintos
		System.out.println(context.getBean("personPrototype").hashCode());
		System.out.println(context.getBean("personPrototype").hashCode());
		System.out.println(context.getBean("personPrototype").hashCode());
		
		//Crea el mismo bean
		System.out.println(context.getBean("personSingleton").hashCode());
		System.out.println(context.getBean("personSingleton").hashCode());
		System.out.println(context.getBean("personSingleton").hashCode());
		
		DecoratorImpl dec2 = DecoratorImpl.builder().person(Person.builder().name("Pepe").age(15).build()).build();
		System.out.println(dec2.getAge());
		System.out.println(dec2.getName());
		Person p = new Person("Juan",10);
		PersonaProxy pr = new PersonaProxy(p);
		pr.operation();
		
		Unidad sargento = new Unidad("Sargento");
		Unidad soldado = new Unidad("Soldado");
		sargento.setSubordinado(soldado);
		Unidad capitan = new Unidad("Capitan");
		capitan.setSubordinado(sargento);
		
		capitan.ejecutarOrden();
	}
}
