package co.edu.udea.compumovil.grupo11.example1.activity.about;

import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.activity.person.find.PersonDocumentTypeFinderActivity;
import android.app.Activity;
import android.os.Bundle;

public class AboutActivity extends Activity {
	
	private static final String TAG = PersonDocumentTypeFinderActivity.class
			.getSimpleName();
	
	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_about_us);

		if (savedInstanceState == null) {
			
		}
	}

}
