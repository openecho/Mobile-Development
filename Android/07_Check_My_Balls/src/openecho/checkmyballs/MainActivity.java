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
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;

/**
 * Android Implementation for challenge 07
 * 
 * @author openecho
 */
public class MainActivity extends Activity {

	private static final int MENU_START_STOP = 1;

	private static final int MENU_REVERSE = 2;
	
	private static final int MENU_RESET = 3;

	public MainView mMainView;
	
	public MainActivity() {
		super();
		mMainView = null;
	}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		mMainView = new MainView(this);
		setContentView(mMainView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, MENU_START_STOP, 0, R.string.menu_stop);
		menu.add(0, MENU_REVERSE, 0, R.string.menu_reverse);
		menu.add(0, MENU_RESET, 0, R.string.menu_reset);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == MENU_START_STOP) {
			mMainView.onPause();
		} else if (item.getItemId() == MENU_RESET) {
			mMainView.onReset();
		}
		return super.onOptionsItemSelected(item);
	}

}
