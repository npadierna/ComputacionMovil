package co.edu.udea.compumovil.grupo11.example1.activity.person.update;

import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;
import android.app.Activity;
import android.os.Bundle;

public class PersonUpdaterActivity extends Activity {

	private static final String TAG = PersonUpdaterActivity.class
			.getSimpleName();

	private IPersonProcess personProcess;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_person_updater);

		if (savedInstanceState == null) {

		}
	}
}