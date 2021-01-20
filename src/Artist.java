
public class Artist {
	private String name;;
	
	public Artist() {
		name = "Default Artist" ;
	}
	
	public Artist(String n) {
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
