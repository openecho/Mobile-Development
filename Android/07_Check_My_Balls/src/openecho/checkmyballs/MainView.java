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

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Main View Implementation.
 * 
 * Holds reference to the BallWorld.
 * 
 * @author openecho
 */
public class MainView extends SurfaceView implements SurfaceHolder.Callback {

	SurfaceHolder mHolder;
	BallWorld mBallWorld;

	public MainView(Context context) {
		super(context);
		init(context);
	}

	public MainView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		mHolder = getHolder();
		mHolder.addCallback(this);
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_NORMAL);
		mBallWorld = new BallWorld(mHolder, context);
	}

	public void surfaceCreated(SurfaceHolder holder) {
		mBallWorld.surfaceCreated();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		mBallWorld.surfaceDestroyed();
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
		mBallWorld.onWindowResize(w, h);

	}

	public void onPause() {
		mBallWorld.onPause();
	}

	public void onResume() {
		mBallWorld.onResume();
	}
	
	public void onReset() {
		mBallWorld.onReset();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		mBallWorld.onWindowFocusChanged(hasFocus);
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		mBallWorld.requestExitAndWait();
	}
	
	
}
