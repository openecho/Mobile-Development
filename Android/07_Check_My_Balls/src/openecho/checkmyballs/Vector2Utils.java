package openecho.checkmyballs;

public class Vector2Utils {
	
	public static final double QUAD2 = Math.PI/2D;
	public static final double QUAD3 = Math.PI;
	public static final double QUAD4 = QUAD3 + QUAD2;
	
	public static double getAngle(Vector2D vector) {
		double angle = 0;
		if(vector.x > 0 && vector.y > 0) {
			angle = Math.atan(vector.y / vector.x);
		} else if(vector.x < 0 && vector.y > 0) {
			angle = Math.atan(vector.y / vector.x) + QUAD2;
		} else if(vector.x < 0 && vector.y < 0) {
			angle = Math.atan(vector.y / vector.x) + QUAD3;
		} else if(vector.x > 0 && vector.y < 0) {
			angle = Math.atan(vector.y / vector.x) + QUAD4;
		}
		return angle;
	}
	
	public static void reduceMagnitude(Vector2D vector, double loss) {
		if(vector.x == 0 || vector.y == 0) {
			return;
		}
		double ratio = 0;
		if(vector.x < 0 && vector.y < 0) {
			ratio = vector.y/vector.x;
		} else if(vector.x < 0 && vector.y > 0) {
			ratio = vector.x/vector.y;
		} else if(vector.x > 0 && vector.y < 0) {
			ratio = vector.y/vector.x;
		} else if(vector.x > 0 && vector.y > 0) {
			ratio = vector.y/vector.x;
		}
		double a = Math.atan(ratio);
		double h = vector.magnitude();
		double g = h - loss;
		if(g <= 0) {
			vector.zero();
		} else {
			if(vector.x < 0 && vector.y < 0) {
				vector.x = (Math.cos(a) * g) * -1;
				vector.y = (Math.sin(a) * g) * -1;
			} else if(vector.x < 0 && vector.y > 0) {
				vector.y = (Math.cos(a) * g);
				vector.x = (Math.sin(a) * g);
			} else if(vector.x > 0 && vector.y < 0) {
				vector.x = (Math.cos(a) * g);
				vector.y = (Math.sin(a) * g);
			} else if(vector.x > 0 && vector.y > 0) {
				vector.x = (Math.cos(a) * g);
				vector.y = (Math.sin(a) * g);
			}
		}
	}
}
