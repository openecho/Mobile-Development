/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openecho.showusyourballs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

/**
 * Ball World Implementation
 *
 * @author openecho
 */
public class BallWorld {

    SurfaceHolder sh;
    Context ctx;
    Ball ball;
    BallWorldLoop loop;

    public BallWorld(SurfaceHolder sh, Context ctx) {
        this.sh = sh;
        this.ctx = ctx;
        this.ball = null;
        this.loop = null;
    }

    void create() {
        ball = new Ball(ctx.getResources().getDrawable(R.drawable.mobile_ball));
        loop = new BallWorldLoop();
        loop.start();
    }

    void destroy() {
        loop.setRunning(false);
    }

    void pulse() {
        Canvas canvas = null;
        try {
            canvas = sh.lockCanvas(null);
            synchronized (sh) {
                drawWorld(canvas);
            }
        } finally {
            if (canvas != null) {
                sh.unlockCanvasAndPost(canvas);
            }
        }
    }

    void drawWorld(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
        ball.draw(canvas);
    }

    class BallWorldLoop extends Thread {

        boolean running;

        public BallWorldLoop() {
            running = false;
        }

        boolean isRunning() {
            return running;
        }

        void setRunning(boolean running) {
            this.running = running;
        }

        @Override
        public void start() {
            running = true;
            super.start();
        }

        @Override
        public void run() {
            while (running) {
                pulse();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    continue;
                }
            }
        }
    }
}
