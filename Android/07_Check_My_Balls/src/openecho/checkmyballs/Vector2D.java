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

public final class Vector2D extends ReferenceChecker {
	public double x;
	public double y;

	public static final Vector2D ZERO = new Vector2D(0, 0);

	public Vector2D() {
		super();
	}

	public Vector2D(double xValue, double yValue) {
		set(xValue, yValue);
	}

	public Vector2D(Vector2D v) {
		set(v);
	}

	public final void add(Vector2D v) {
		x += v.x;
		y += v.y;
	}

	public final void add(float vX, float vY) {
		x += vX;
		y += vY;
	}

	public final void subtract(Vector2D v) {
		x -= v.x;
		y -= v.y;
	}

	public final void scale(double magnitude) {
		x *= magnitude;
		y *= magnitude;
	}

	public final void multiply(Vector2D v) {
		x *= v.x;
		y *= v.y;
	}

	public final void divide(double magnitude) {
		if (magnitude != 0.0f) {
			x /= magnitude;
			y /= magnitude;
		}
	}

	public final void set(Vector2D v) {
		x = v.x;
		y = v.y;
	}

	public final void set(double vX, double vY) {
		x = vX;
		y = vY;
	}
	
	public final double dot(Vector2D v) {
		return (x * v.x) + (y * v.y);
	}

	public final double magnitude() {
		return Math.sqrt((x * x) + (y * y));
	}
	
	public final void zero() {
		set(0.0f, 0.0f);
	}

	public final void reverseX() {
		x = -x;
	}
	
	public final void reverseX(double aboutWidth) {
		x = (aboutWidth - x);
	}
	
	public final void reverseY() {
		y = -y;
	}

	public final void reverseY(float aboutHeight) {
		y = (aboutHeight - y);
	}
}