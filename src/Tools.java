
public abstract class Tools {
	private String name;
	private String function;
	
	/**
	 * constructor
	 * pre: none
	 * post: Tool is created with tool name and it's function
	 */
	public Tools(String tName, String func) {
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
	abstract String functionSound();
	
	public String toString() {
		String info;
		info = "Tool: " + name + "\nFunction: " + function;
		return info;
	}
	
}
