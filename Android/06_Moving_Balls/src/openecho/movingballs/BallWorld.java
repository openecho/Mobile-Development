/**
 * Copyright (C) 2010 openecho
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package openecho.movingballs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.SurfaceHolder;

/**
 * Ball World Implementation
 * 
 * @author openecho
 */
public class BallWorld {
	int mHeight;
	int mWidth;
	SurfaceHolder mHolder;
	Context mContext;
	Ball[] mBalls;
	BallGraphicsLoop mGraphicsLoop;
	BallWorldLoop mWorldLoop;

	public BallWorld(SurfaceHolder sh, Context ctx) {
		this.mHeight = -1;
		this.mWidth = -1;
		this.mHolder = sh;
		this.mContext = ctx;
		this.mBalls = new Ball[1];
		this.mBalls[0] = new Ball(this, ((BitmapDrawable) ctx.getResources().getDrawable(R.drawable.mobile_ball)).getBitmap());
		this.mGraphicsLoop = new BallGraphicsLoop();
		this.mWorldLoop = new BallWorldLoop();
	}

	public void surfaceCreated() {
		Log.i("trace", "surfaceCreated()");
		Canvas canvas = mHolder.lockCanvas();
		if (canvas != null) {
			this.mHeight = canvas.getHeight();
			this.mWidth = canvas.getWidth();
			mHolder.unlockCanvasAndPost(canvas);
		}
		if (!mGraphicsLoop.mInitialized) {
			mGraphicsLoop.mRunning = true;
			mGraphicsLoop.start();
			mGraphicsLoop.mInitialized = true;
		}
		if (!mWorldLoop.mInitialized) {
			mWorldLoop.mRunning = true;
			mWorldLoop.start();
			mWorldLoop.mInitialized = true;
		}
	}

	public void surfaceDestroyed() {
		Log.i("trace", "surfaceDestroyed()");
		mGraphicsLoop.mPaused = true;
		mGraphicsLoop.wake();
	}

	public void onWindowFocusChanged(boolean hasFocus) {
		Log.i("trace", "onWindowFocusChanged()");
		mGraphicsLoop.mPaused = !hasFocus;
		if (mGraphicsLoop.mPaused != true) {
			mGraphicsLoop.wake();
		}
	}

	public void onWindowResize(int w, int h) {
		Log.i("trace", "onWindowResize()");
		this.mWidth = w;
		this.mHeight = h;
	}

	public void onPause() {
		Log.i("trace", "onPause()");

	}

	public void onResume() {
		Log.i("trace", "onResume()");

	}

	public void requestExitAndWait() {
		Log.i("trace", "requestExitAndWait()");

	}

	//    
	//
	// void create() {
	// ball = new Ball(this, ((BitmapDrawable)
	// ctx.getResources().getDrawable(R.drawable.mobile_ball)).getBitmap());
	// Canvas canvas = null;
	// try {
	// canvas = sh.lockCanvas(null);
	// synchronized (sh) {
	// ball.init(canvas);
	// }
	// } finally {
	// if (canvas != null) {
	// sh.unlockCanvasAndPost(canvas);
	// }
	// }
	// worldLoop = new BallWorldLoop();
	// worldLoop.start();
	// graphicsLoop = new BallGraphicsLoop();
	// graphicsLoop.start();
	// }
	//    
	//    
	//
	// void destroy() {
	// worldLoop.setRunning(false);
	// graphicsLoop.setRunning(false);
	// }

	class BallGraphicsLoop extends Thread {

		boolean mInitialized;
		boolean mRunning;
		boolean mPaused;

		public BallGraphicsLoop() {
			mInitialized = false;
			mRunning = false;
			mPaused = false;
		}

		@Override
		public void run() {
			ProfileRecorder profiler = ProfileRecorder.sSingleton;
			int i;
			int mLoopCount = 0;
			while (mRunning) {
				if (mPaused) {
					Log.i("world", "pause");
					try {
						synchronized (this) {
							this.wait();
						}
					} catch (InterruptedException e) {
					}
				}
				profiler.start(ProfileRecorder.PROFILE_PAGE_FLIP);
				Canvas canvas = mHolder.lockCanvas();
				profiler.start(ProfileRecorder.PROFILE_PAGE_FLIP);

				if (canvas != null) {
					profiler.start(ProfileRecorder.PROFILE_DRAW);
					canvas.drawColor(Color.GRAY);
					for (i = 0; i < mBalls.length; i++) {
						mBalls[i].draw(canvas);
					}
					profiler.stop(ProfileRecorder.PROFILE_DRAW);

					profiler.start(ProfileRecorder.PROFILE_PAGE_FLIP);
					mHolder.unlockCanvasAndPost(canvas);
					profiler.stop(ProfileRecorder.PROFILE_PAGE_FLIP);
				}
				if (++mLoopCount % 1000 == 0) {
				}
			}
		}

		public synchronized void wake() {
			synchronized (this) {
				this.notify();
			}
		}
	}

	class BallWorldLoop extends Thread {

		boolean mInitialized;
		boolean mRunning;

		public BallWorldLoop() {
			mInitialized = false;
			mRunning = false;
		}

		boolean isRunning() {
			return mRunning;
		}

		void setRunning(boolean running) {
			this.mRunning = running;
		}

		@Override
		public void run() {
			ProfileRecorder profiler = ProfileRecorder.sSingleton;
			int mRotationRadius = Math.min(mWidth,mHeight)/4;
			int[] mCentre = new int[] {mWidth/2,mHeight/2};
			int i = 0;
			double mAngle = 0;
			int mLoopCount = 0;
			Vector location = null;
			while (mRunning) {
				profiler.start(ProfileRecorder.PROFILE_WORLD);
				for (i = 0; i < mBalls.length; i++) {
					location = mBalls[i].mLocation;
					location.x = mCentre[0] + (float) Math.cos(mAngle) * mRotationRadius;
					location.y = mCentre[1] + (float) Math.sin(mAngle) * mRotationRadius;
				}
				mAngle=mAngle+0.05;
				if(mAngle>=360) {
					mAngle=mAngle%360.0;
				}
				profiler.stop(ProfileRecorder.PROFILE_WORLD);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				if (++mLoopCount % 10 == 0) {
				}
			}
		}
	}

}
