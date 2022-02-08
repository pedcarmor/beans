package chainresponsibility;

public class Unidad {

	private String nombre;
	private Unidad subordinado;
	
	
	public Unidad(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Unidad getSubordinado() {
		return subordinado;
	}
	public void setSubordinado(Unidad subordinado) {
		this.subordinado = subordinado;
	}
	
	public void ejecutarOrden() {
		if(subordinado!=null) {
			System.out.println("Le paso la orden a: "+subordinado.getNombre());
			subordinado.ejecutarOrden();
		}else {
			System.out.println("Le toca pringar a soldado");
		}
	}
}
