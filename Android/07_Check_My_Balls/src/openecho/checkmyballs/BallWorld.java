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
package openecho.checkmyballs;

import openecho.checkmyballs.R;

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
public class BallWorld extends GameObject {
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
		this.mBalls = null;
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
			createWorld(canvas);
			mWorldLoop.mRunning = true;
			mWorldLoop.start();
			mWorldLoop.mInitialized = true;
		}
	}
	
	public void createWorld(Canvas canvas) {
		int w = canvas.getWidth();
		int h = canvas.getHeight();
		mBalls = new Ball[1];
		Ball ball = new Ball(this, ((BitmapDrawable) mContext.getResources().getDrawable(R.drawable.mobile_ball)).getBitmap());
		ball.mLocation.set(w/2,h/2);
		ball.generateRandomDirection();
		ball.addComponent(new BallMover());
		mBalls[0] = ball;
		addComponent(ball);
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
	
	public void onReset() {
		Ball ball = mBalls[0];
		ball.mLocation.set(mWidth/2,mHeight/2);
		ball.generateRandomDirection();
	}

	public void requestExitAndWait() {
		Log.i("trace", "requestExitAndWait()");
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawColor(Color.GRAY);
		super.draw(canvas);
	}

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
					draw(canvas);
					profiler.stop(ProfileRecorder.PROFILE_DRAW);

					profiler.start(ProfileRecorder.PROFILE_PAGE_FLIP);
					mHolder.unlockCanvasAndPost(canvas);
					profiler.stop(ProfileRecorder.PROFILE_PAGE_FLIP);
				}
				if (++mLoopCount % 1000 == 0) {
				}
			}
		}

		public void wake() {
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
			long currentTime = System.nanoTime();
			while (mRunning) {
				profiler.start(ProfileRecorder.PROFILE_WORLD);
				update(currentTime, null);
				profiler.stop(ProfileRecorder.PROFILE_WORLD);
				try {
					Thread.sleep(33);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
