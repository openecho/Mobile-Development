package openecho.checkmyballs;

public class GlobalRegistry {

	public static final GlobalRegistry sSingleton;
	
	static {
		sSingleton = new GlobalRegistry();
	}
}
