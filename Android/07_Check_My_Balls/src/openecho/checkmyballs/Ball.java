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

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Ball Implementation
 * 
 * @author openecho
 */
public class Ball extends GameObject {
	public static final double MIN_BALL_START_SPEED;
	public static final double MAX_BALL_START_SPEED;
	
	public int mRadius;
	public int mDiameter;
	public Vector mLocation;
	public Vector mDirection;

	public Bitmap mBallBitmap;

	static {
		MIN_BALL_START_SPEED = 2D;
		MAX_BALL_START_SPEED = 20D;
	}
	
	public Ball(BallWorld world, Bitmap ballBitmap) {
		super();
		mRadius = 25;
		mDiameter = mRadius * 2;
		mLocation = new Vector();
		mDirection = new Vector();
		mBallBitmap = ballBitmap;
	}

	public void init(Canvas canvas) {
		mLocation.zero();
		mDirection.zero();
	}

	public void draw(Canvas canvas) {
		canvas.drawBitmap(mBallBitmap, mLocation.x - mRadius, canvas.getHeight() - mLocation.y - mRadius, null);
	}
	
	public void generateRandomDirection() {
		double direction = (Math.random()*360.0D);
		double speed = (Math.random()*MAX_BALL_START_SPEED-MIN_BALL_START_SPEED) + MIN_BALL_START_SPEED;
		mDirection.x = (float) (Math.cos(direction) * speed);
		mDirection.y = (float) (Math.sin(direction) * speed);
	}
}
