package co.edu.udea.compumovil.grupo11.example1.activity.person.retrieve;

import android.app.Activity;
import android.os.Bundle;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;

public class PersonRetrieverActivity extends Activity {

	private static final String TAG = PersonRetrieverActivity.class
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