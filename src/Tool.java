/**
 * Iman Qureshi
 * Jan 26 2021
 * ICS4U
 * This program outlines the properties of a general tool object
 */
public abstract class Tool {
	private String name;
	private String function;
	
	/**
	 * constructor
	 * pre: none
	 * post: Tool is created with tool name and it's function
	 */
	public Tool(String tName, String func) {
		name = tName;
		function = func;
	}
	/**
	 * returns tool name
	 * pre: none
	 * post: tool name is returned. 
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets tool name 
	 * pre: none
	 * post: tool name is set. 
	 */
	public void setName(String n) {
		name = n;
	}
	/**
	 * returns tool function
	 * pre: none
	 * post: tool function is returned. 
	 */
	public String getFunction() {
		return function;
	}
	/**
	 * sets tool function
	 * pre: none
	 * post: tool function is set. 
	 */
	public void setFunction(String func) {
		function = func;
	}

	/**
	 * defines the sound behaviour all tools have.
	 */
	abstract String toolSound();
	
	/**
	 * checks if a character exists in an array
	 * pre: none
	 * post: returns true if character exists. else, returns false. 
	 */
	public boolean charExists(char[][] arr, char c) {
		boolean check = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (c == arr[i][j]) {
					check = true;
					break;
				}
			}
		}
		return check;
	}

	/**
	 * prints information about tools
	 * pre: none 
	 * post:tool info is returned.
	 */
	public String toString() {
		String info;
		info = "The " + getName() + " (" + getFunction() + ")";
		return info;
	}
}
