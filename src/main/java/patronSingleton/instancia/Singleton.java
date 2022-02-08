package patronSingleton.instancia;

import persona.Person;

//SE UTILIZA PARA CREAR SIEMPRE EL MISMO OBJETO AL INICIO DE LA EJECUCIÓN
public class Singleton {

	private static Person instancia;
	private String nombre;
	
	private Singleton(String nombre) {
		this.nombre=nombre;
		System.out.println("Mi nombre es "+this.nombre);
	}
	

	public static Person getInstancia() {
		if(instancia==null) {
			instancia=new Person();
		}
		return instancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
