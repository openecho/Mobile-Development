/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package openecho.showusyourballs;

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

    BallWorld ballWorld;

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        SurfaceHolder sh = getHolder();
        ballWorld = new BallWorld(sh, context);
        sh.addCallback(this);
        setFocusable(true);
    }

    public void surfaceCreated(SurfaceHolder sh) {
        ballWorld.create();
    }

    public void surfaceChanged(SurfaceHolder sh, int format, int width, int height) {
    }

    public void surfaceDestroyed(SurfaceHolder sh) {
        ballWorld.destroy();
    }
}
