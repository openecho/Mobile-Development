package openecho.checkmyballs;

public class GlobalRegistry {

	public BallWorld ballWorld = null;
	
	public static final GlobalRegistry sSingleton;
	
	static {
		sSingleton = new GlobalRegistry();
	}
}
