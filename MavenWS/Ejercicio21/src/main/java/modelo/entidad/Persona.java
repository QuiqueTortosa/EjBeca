package modelo.entidad;

public class Persona {
	
	private int id;
	private String gmail;
	private String name;
	private String password;
	
	
	public Persona() {
		
	}
	
	public Persona(String gmail, String name, String password) {
		this.gmail = gmail;
		this.name = name;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", gmail=" + gmail + ", name=" + name + ", password=" + password + "]";
	}
		
}
