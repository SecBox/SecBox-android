package com.security.secbox;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.os.Vibrator;

public class MainActivity extends Activity {
	
	private boolean detectEnabled;
	private Button buttonToggleDetect;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonToggleDetect = (Button) findViewById(R.id.buttonDetectToggle);
        buttonToggleDetect.setOnClickListener(new OnClickListener() {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
			@Override
			public void onClick(View v) {
				setDetectEnabled(!detectEnabled);
				if(v==buttonToggleDetect){ 
        			vibrator.vibrate(300);           
        		}
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void setDetectEnabled(boolean enable) {
    	detectEnabled = enable;
    	
        Intent intent = new Intent(this, CallDetectService.class);
    	if (enable) {
            startService(intent);
            buttonToggleDetect.setBackgroundResource(R.drawable.actived);
            Toast.makeText(this, "Verification mode enabled", Toast.LENGTH_LONG).show();
    	}
    	else {
    		stopService(intent);
    		buttonToggleDetect.setBackgroundResource(R.drawable.activedno);
    		Toast.makeText(this, "Verification mode disabled", Toast.LENGTH_LONG).show();
    	}
    }

}
