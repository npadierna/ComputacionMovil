package co.edu.udea.compumovil.grupo11.example1.activity.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.activity.about.AboutUsActivity;
import co.edu.udea.compumovil.grupo11.example1.activity.list.PersonExpandableListActivity;
import co.edu.udea.compumovil.grupo11.example1.activity.person.create.PersonCreatorActivity;
import co.edu.udea.compumovil.grupo11.example1.activity.person.delete.PersonDeleterActivity;
import co.edu.udea.compumovil.grupo11.example1.activity.person.find.PersonDocumentTypeFinderActivity;
import co.edu.udea.compumovil.grupo11.example1.activity.person.find.PersonHeightRangeFinderActivity;
import co.edu.udea.compumovil.grupo11.example1.activity.person.retrieve.PersonRetrieverActivity;
import co.edu.udea.compumovil.grupo11.example1.activity.person.update.PersonUpdaterActivity;
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

			super.startActivity(new Intent(super.getApplicationContext(),
					AboutUsActivity.class));

			return (true);

		case (R.id.find_all_menu):
			Log.i(TAG,
					String.format("Selected Item: \"%s\"", "Find all Persons"));

			this.findAllPersons();

			return (true);

		case (R.id.find_by_height_range_menu):
			Log.i(TAG,
					String.format("Selected Item: \"%s\"", "Find by Age range"));

			this.findPersonsByHeightRange();

			return (true);

		case (R.id.find_by_document_type_menu):
			Log.i(TAG, String.format("Selected Item: \"%s\"",
					"Find by Document Type"));

			this.findPersonsByDocumentType();

			return (true);

		default:

			return (super.onOptionsItemSelected(item));
		}
	}

	private void findAllPersons() {
		Log.i(TAG, String.format("Selected Menu Item Method: %s",
				"findAllPersons():void"));

		List<Person> personsFoundList = this.personProcess.findAllPersons();
		Intent intent = new Intent(super.getApplicationContext(),
				PersonExpandableListActivity.class);
		intent.putParcelableArrayListExtra(
				PersonExpandableListActivity.PERSONS_LIST_KEY,
				(ArrayList<? extends Parcelable>) personsFoundList);

		super.startActivity(intent);
	}

	private void findPersonsByHeightRange() {
		Log.i(TAG, String.format("Selected Menu Item Method: %s",
				"findPersonsByHeightRange():void"));

		super.startActivity(new Intent(super.getApplicationContext(),
				PersonHeightRangeFinderActivity.class));
	}

	private void findPersonsByDocumentType() {
		Log.i(TAG, String.format("Selected Menu Item Method: %s",
				"findPersonsByDocumentType():void"));

		super.startActivity(new Intent(super.getApplicationContext(),
				PersonDocumentTypeFinderActivity.class));
	}

	public void onCreatePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onCreatePerson(View):void"));

		Person neiber = new Person(new PersonPK(
				DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1022095657"),
				"Neiber de Jesús", "Padierna Pérez", new Date());
		neiber.setEMail("npadierna@gmail.com");
		neiber.setHeight(1.75F);
		neiber.setPhoneNumber("+(123) 123 45 67");
		neiber.setWeight((short) 12);

		Person yefry = new Person(new PersonPK(
				DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1234567890"), "Yefry",
				"Calderón", new Date());

		this.personProcess.savePerson(yefry);
		this.personProcess.savePerson(neiber);

		super.startActivity(new Intent(super.getApplicationContext(),
				PersonCreatorActivity.class));
	}

	public void onDeletePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onDeletePerson(View):void"));

		super.startActivity(new Intent(super.getApplicationContext(),
				PersonDeleterActivity.class));
	}

	public void onRetrievePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onRetrievePerson(View):void"));

		super.startActivity(new Intent(super.getApplicationContext(),
				PersonRetrieverActivity.class));
	}

	public void onUpdatePerson(View view) {
		Log.i(TAG, String.format("Selected Dashboard Method: %s",
				"onUpdatePerson(View):void"));

		// Person yefry = new Person(new PersonPK(
		// DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1020448936"),
		// "Yefry Alexis", "Calderón Yepes", new Date());
		// yefry.setEMail("alexis.cal.y@gmail.com");
		// yefry.setHeight(1.70F);
		// yefry.setPhoneNumber("+(987) 654 32 10");
		// yefry.setWeight((short) 34);
		//
		// Person person = this.personProcess.updatePerson(yefry);

		// FIXME: Think more about this.
		super.startActivity(new Intent(super.getApplicationContext(),
				PersonUpdaterActivity.class));
	}
}