package openecho.checkmyballs;

import android.util.Log;

public class BallMover extends GameObject {
	
	public static final double WALL_BALL_LOSS = 2.0D;
	
	public static final double BALL_BALL_LOSS = 0.2D;
	
	@Override
	public void update(long time, GameObject parent) {
		super.update(time, this);
		Ball ball = (Ball) parent;
		
		GlobalRegistry gr = GlobalRegistry.sSingleton;
		BallWorld mBallWorld = gr.ballWorld;
		if(mBallWorld == null) {
			Log.e("registry", "BallWorld Does Not Exist.");
			return;
		}
		
		Vector2D mCurrentLocation = ball.mLocation;
		Vector2D mDirection = ball.mDirection;
		int mHeight = mBallWorld.mHeight;
		int mWidth = mBallWorld.mWidth;
		
		Vector2D mWorkingLocation = new Vector2D(mCurrentLocation);
		mWorkingLocation.add(mDirection);
		
		boolean hit = false;
		if(mWorkingLocation.x-ball.mRadius < 0) {
			//mDirection.flipHorizontal(Math.abs(mCurrentLocation.x)-ball.mRadius);
			mDirection.reverseX();
			hit = true;
		} else if(mWorkingLocation.x+ball.mRadius > mWidth) {
			//mDirection.flipHorizontal(mWidth-Math.abs(mWorkingLocation.x)+ball.mRadius);
			mDirection.reverseX();
			hit = true;
		}
			
	
		if(mWorkingLocation.y-ball.mRadius < 0) {
			//mDirection.flipVertical(Math.abs(mCurrentLocation.y)-ball.mRadius);
			mDirection.reverseY();
			hit = true;
		} else if(mWorkingLocation.y+ball.mRadius > mHeight) {
			//mDirection.flipVertical(mHeight-Math.abs(mWorkingLocation.y)+ball.mRadius);
			mDirection.reverseY();
			hit = true;
		}
		
		
		if(hit != true) {
			mCurrentLocation.set(mWorkingLocation);
		} else {
			Vector2Utils.reduceMagnitude(ball.mDirection, WALL_BALL_LOSS);
			
			// TODO: Need to set the location based on bounce.
			
			mBallWorld.mScreenFlash = 5;
		}
	}
}
