
package srclib.huyanwei.display;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.text.method.ScrollingMovementMethod;

import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.os.Build;
import android.os.SystemProperties;

import android.util.DisplayMetrics;

public class DisplayResolution extends Activity {	

    private String TAG = "srclib.huyanwei.display";	
	
    private TextView m_width_value; 
    private TextView m_height_value;

    private int res = -1 ;
    private int width  = 0 ; 
    private int height = 0 ;

    private int android_width  = 0 ; 
    private int android_height = 0 ;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState);        
        requestWindowFeature(Window.FEATURE_NO_TITLE);        
        setContentView(R.layout.main);                     
        m_width_value = (TextView)findViewById(R.id.lcm_width_value);
        m_height_value = (TextView)findViewById(R.id.lcm_height_value);

	DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
	android_width = dm.widthPixels;
	android_height = dm.heightPixels;
    }
    
	/* (non-Javadoc)
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}	
	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub		
        
        res = DisplayNative.get_framebuffer_info_init();

	if(res == 0)
	{
		//res = DisplayNative.get_framebuffer_info(width, height);
		width = DisplayNative.get_framebuffer_info_width();
		height = DisplayNative.get_framebuffer_info_height();
	}
	res = DisplayNative.get_framebuffer_info_deinit();
        
        //m_width_value.setText(width.toString());
        //m_height_value.setText(height.toString());

	if(width > 0)
	        m_width_value.setText(Integer.toString(width)+"("+Integer.toString(android_width)+")");
	else
		m_width_value.setText(this.getResources().getString(R.string.unknown)+"("+Integer.toString(android_width)+")");

	if(height > 0)
		m_height_value.setText(Integer.toString(height)+"("+Integer.toString(android_height)+")");
	else
		m_height_value.setText(this.getResources().getString(R.string.unknown)+"("+Integer.toString(android_height)+")");
       
		super.onResume();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
    
	/* (non-Javadoc)
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();		
	}
}
