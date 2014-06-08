package co.edu.udea.compumovil.grupo11.example1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class DashboardMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dashboard_main, menu);
		return true;
	}

}
