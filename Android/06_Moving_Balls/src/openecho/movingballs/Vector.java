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

public final class Vector extends ReferenceChecker {
	public float x;
	public float y;

	public static final Vector ZERO = new Vector(0, 0);

	public Vector() {
		super();
	}

	public Vector(float xValue, float yValue) {
		set(xValue, yValue);
	}

	public Vector(Vector other) {
		set(other);
	}

	public final void add(Vector other) {
		x += other.x;
		y += other.y;
	}

	public final void add(float otherX, float otherY) {
		x += otherX;
		y += otherY;
	}

	public final void subtract(Vector other) {
		x -= other.x;
		y -= other.y;
	}

	public final void multiply(float magnitude) {
		x *= magnitude;
		y *= magnitude;
	}

	public final void multiply(Vector other) {
		x *= other.x;
		y *= other.y;
	}

	public final void divide(float magnitude) {
		if (magnitude != 0.0f) {
			x /= magnitude;
			y /= magnitude;
		}
	}

	public final void set(Vector other) {
		x = other.x;
		y = other.y;
	}

	public final void set(float xValue, float yValue) {
		x = xValue;
		y = yValue;
	}
	
	public final float dot(Vector other) {
		return (x * other.x) + (y * other.y);
	}

	public final float length() {
		return (float) Math.sqrt(length2());
	}

	public final float length2() {
		return (x * x) + (y * y);
	}

	public final float distance2(Vector other) {
		float dx = x - other.x;
		float dy = y - other.y;
		return (dx * dx) + (dy * dy);
	}

	public final float normalize() {
		final float magnitude = length();
		if (magnitude != 0.0f) {
			x /= magnitude;
			y /= magnitude;
		}
		return magnitude;
	}

	public final void zero() {
		set(0.0f, 0.0f);
	}

	public final void flipHorizontal(float aboutWidth) {
		x = (aboutWidth - x);
	}

	public final void flipVertical(float aboutHeight) {
		y = (aboutHeight - y);
	}
}