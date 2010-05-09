package openecho.checkmyballs;

import android.util.Log;

public class BallMover extends GameObject {
	
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
		//ball.mLocation.add(ball.mDirection);
		Vector mCurrentLocation = ball.mLocation;
		Vector mDirection = ball.mDirection;
		int mHeight = mBallWorld.mHeight;
		int mWidth = mBallWorld.mWidth;
		
		Vector mWorkingLocation = new Vector(mCurrentLocation);
		mWorkingLocation.add(mDirection);
		if(mWorkingLocation.x-ball.mRadius < 0 || mWorkingLocation.x+ball.mRadius > mWidth) {
			mDirection.flipHorizontal(0);
			mBallWorld.mScreenFlash = 8;
		}
		if(mWorkingLocation.y-ball.mRadius < 0 || mWorkingLocation.y+ball.mRadius > mHeight) {
			mDirection.flipVertical(0);
			mBallWorld.mScreenFlash = 8;
		}
		mCurrentLocation.set(mWorkingLocation);
	}
}
