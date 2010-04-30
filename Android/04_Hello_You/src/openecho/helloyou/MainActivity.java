/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package openecho.helloyou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Android Implementation for challenge 04
 * 
 * @author jmarsden
 */
public class MainActivity extends Activity implements OnClickListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        Button button = (Button)findViewById(R.id.submit);
        button.setOnClickListener(this);
    }

    public void onClick(View view) {
        EditText input = (EditText)findViewById(R.id.name_input);
        TextView output = (TextView)findViewById(R.id.hello_output);
        output.setText("Hello, " + input.getText() + "!");
        output.setVisibility(View.VISIBLE);
    }
}
