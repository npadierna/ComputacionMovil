package co.edu.udea.compumovil.grupo11.example1.activity.dashboard;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.database.dao.IPersonDAO;
import co.edu.udea.compumovil.grupo11.example1.database.sqlite.dao.impl.PersonDAOImpl;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;

public class DashboardMainActivity extends Activity {

	private static final String TAG = DashboardMainActivity.class
			.getSimpleName();

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_dashboard_main);
	}

	@Override()
	public boolean onCreateOptionsMenu(Menu menu) {
		super.getMenuInflater().inflate(R.menu.dashboard_main, menu);

		return (true);
	}

	@Override()
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case (R.id.about_us_menu):
			Log.i(TAG, String.format("Selected Item: \"%s\"", "About us"));
			return (true);

		case (R.id.find_by_age_range_menu):
			Log.i(TAG,
					String.format("Selected Item: \"%s\"", "Find by Age range"));
			return (true);

		case (R.id.find_by_document_type_menu):
			Log.i(TAG, String.format("Selected Item: \"%s\"",
					"Find by Document Type"));
			return (true);

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void onCreatePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onCreatePerson(View):void"));

		Person person = new Person(new PersonPK(
				DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1022095657"),
				"Neiber de Jesús", "Padierna Pérez", new Date(), (short) 23);
		person.setEMail("npadierna@gmail.com");
		person.setHeight(1.75F);
		person.setPhoneNumber("+(123) 123 45 67");

		IPersonDAO personDAO = new PersonDAOImpl(super.getApplicationContext());
		Person p = personDAO.savePerson(person);
	}

	public void onDeletePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onDeletePerson(View):void"));
	}

	public void onRetrievePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onRetrievePerson(View):void"));
	}

	public void onUpdatePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onUpdatePerson(View):void"));
	}
}