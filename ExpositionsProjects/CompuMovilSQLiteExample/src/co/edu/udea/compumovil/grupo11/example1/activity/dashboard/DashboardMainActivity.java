package co.edu.udea.compumovil.grupo11.example1.activity.dashboard;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;
import co.edu.udea.compumovil.grupo11.example1.process.impl.PersonProcessImpl;

public class DashboardMainActivity extends Activity {

	private static final String TAG = DashboardMainActivity.class
			.getSimpleName();

	private IPersonProcess personProcess;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_dashboard_main);

		this.personProcess = new PersonProcessImpl(
				super.getApplicationContext());
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

			// Invocation to a Window or fragment to display information about
			// us.

			return (true);

		case (R.id.find_by_height_range_menu):
			Log.i(TAG,
					String.format("Selected Item: \"%s\"", "Find by Age range"));

			this.findPersonsByAgeRange();

			return (true);

		case (R.id.find_by_document_type_menu):
			Log.i(TAG, String.format("Selected Item: \"%s\"",
					"Find by Document Type"));

			this.findPersonsByDocumentType();

			return (true);

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void onCreatePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onCreatePerson(View):void"));

		// Person neiber = new Person(new PersonPK(
		// DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1022095657"),
		// "Neiber de Jes�s", "Padierna P�rez", new Date());
		// neiber.setEMail("npadierna@gmail.com");
		// neiber.setHeight(1.75F);
		// neiber.setPhoneNumber("+(123) 456 78 90");
		// neiber.setWeight((short) 12);
		//
		// Person yefry = new Person(new PersonPK(
		// DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1020448936"),
		// "Yefry Alexis", "Calder�n Yepes", new Date());
		//
		// Person p = this.personProcess.savePerson(neiber);
		// p = this.personProcess.savePerson(yefry);
	}

	public void onDeletePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onDeletePerson(View):void"));

		// Person neiber = new Person(new PersonPK(
		// DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1022095657"),
		// "Neiber de Jes�s", "Padierna P�rez", new Date());
		// neiber.setEMail("npadierna@gmail.com");
		// neiber.setHeight(1.75F);
		// neiber.setPhoneNumber("+(123) 123 45 67");
		// neiber.setWeight((short) 12);
		//
		// int affectedRows = this.personProcess.deletePerson(neiber);
	}

	public void onRetrievePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onRetrievePerson(View):void"));

		// Person person = this.personProcess.findPerson(new PersonPK(
		// DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1020448936"));
	}

	public void onUpdatePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onUpdatePerson(View):void"));

		// Person yefry = new Person(new PersonPK(
		// DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1020448936"),
		// "Yefry Alexis", "Calder�n Yepes", new Date());
		// yefry.setEMail("alexis.cal.y@gmail.com");
		// yefry.setHeight(1.70F);
		// yefry.setPhoneNumber("+(987) 654 32 10");
		// yefry.setWeight((short) 34);
		//
		// Person person = this.personProcess.updatePerson(yefry);
	}

	private void findPersonsByAgeRange() {
		Log.i(TAG, String.format("Selected Menu Item Method: %s",
				"findPersonsByAgeRange():void"));

		// FIXME: Here, we must create a DialogFrament or call a Activity to
		// request the data for searching. Later, we can remove these surce code
		// lines.

		int personsFoundListSize = this.personProcess.findPersonsByHeightRange(
				1.0F, 1.9F).size();
	}

	private void findPersonsByDocumentType() {
		Log.i(TAG, String.format("Selected Menu Item Method: %s",
				"findPersonsByDocumentType():void"));

		// FIXME: Here, we must create a DialogFrament or call a Activity to
		// request the data for searching. Later, we can remove these surce code
		// lines.

		int personsFoundListSize1 = this.personProcess
				.findPersonsByDocumentTypeEnum(
						DocumentTypeEnum.CEDULA_DE_CIUDADANIA).size();
		int personsFoundListSize2 = this.personProcess
				.findPersonsByDocumentTypeEnum(
						DocumentTypeEnum.TARJETA_DE_IDENTIDAD).size();
	}
}