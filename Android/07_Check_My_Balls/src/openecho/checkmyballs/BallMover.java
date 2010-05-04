package openecho.checkmyballs;

import android.util.Log;

public class BallMover extends GameObject {
	
	@Override
	public void update(long time, GameObject parent) {
		super.update(time, this);
		Ball ball = (Ball) parent;
		ball.mLocation.add(ball.mDirection);
		Log.i("ball", "Location: " + ball.mLocation.x + "," + ball.mLocation.y);
	}
}
