package co.edu.udea.compumovil.grupo11;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class StatusActivity extends Activity {

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_status);
	}

	@Override()
	public boolean onCreateOptionsMenu(Menu menu) {
		super.getMenuInflater().inflate(R.menu.status, menu);
		
		return (true);
	}

}
