/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package openecho.showusyourballs;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

/**
 * Ball Implementation
 *
 * @author openecho
 */
public class Ball {

    int size;
    int x;
    int y;
    Drawable ballDrawable;

    public Ball(Drawable ballDrawable) {
        this.ballDrawable = ballDrawable;
        size = 100;
        x = 0;
        y = 0;
    }

    void draw(Canvas canvas) {
        int xArea = canvas.getWidth() - size;
        int yArea = canvas.getHeight() - size;
        x = (int) (Math.random()*(xArea));
        y = (int) (Math.random()*(yArea));
        ballDrawable.setBounds(x, y, x+size, y+size);
        ballDrawable.draw(canvas);
    }
}
