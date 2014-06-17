package co.edu.udea.compumovil.grupo11.example1.activity.person.delete;

import android.app.Activity;
import android.os.Bundle;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;

public class PersonDeleterActivity extends Activity {

	private static final String TAG = PersonDeleterActivity.class
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