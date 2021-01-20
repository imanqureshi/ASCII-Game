
public class Designer {
	private String name;;
	
	public Designer() {
		name = "Default Artist" ;
	}
	
	public Designer(String n) {
		name  = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}
	
	public String toString() {
		String info;
		info = "Artist Name: " + name;
		return info;
	}
}
