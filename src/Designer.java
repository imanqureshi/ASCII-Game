/**
 * Iman Qureshi 
 * January 26 2021
 * ICS4U
 * This program outlines the features of the designer of the art created in Graphics Jam.
 */
public class Designer {
	private String name;
	
	/*constructor*/
	public Designer() {
		name = "Default Artist" ;
	}
	
	/*constuctor overload*/
	public Designer(String n) {
		name  = n;
	}
	
	/**
	 * gets name of designer
	 * pre: none
	 * post: name of designer is returned. 
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets name of designer to a new name
	 * pre: none
	 * post: designer name is set
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * prints information about the designer
	 * pre: none
	 * post: information about designer is returned. 
	 */
	public String toString() {
		String info;
		info = "Artist Name: " + name;
		return info;
	}
}
