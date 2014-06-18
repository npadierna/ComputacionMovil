package co.edu.udea.compumovil.grupo11.example1.activity.person.find;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.activity.list.PersonExpandableListActivity;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;
import co.edu.udea.compumovil.grupo11.example1.process.impl.PersonProcessImpl;

public class PersonDocumentTypeFinderActivity extends Activity {

	private static final String TAG = PersonDocumentTypeFinderActivity.class
			.getSimpleName();

	private IPersonProcess personProcess;

	private Spinner documentTypeSpinner;
	private String documentType;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_person_document_type_finder);

		this.createComponents();
	}

	private void createComponents() {
		SpinnerAdapter documentTypeSpinnerAdapter = new ArrayAdapter<String>(
				super.getApplicationContext(),
				android.R.layout.simple_spinner_item,
				DocumentTypeEnum.obtainDocumentsTypesList());

		this.documentTypeSpinner = (Spinner) super
				.findViewById(R.id.document_type_spinner);
		this.documentTypeSpinner.setAdapter(documentTypeSpinnerAdapter);
		this.documentTypeSpinner
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override()
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						Log.i(TAG,
								"onItemSelected(AdapterView<?>, View, int, long):void");

						documentType = DocumentTypeEnum
								.obtainDocumentsTypesList().get(position);
					}

					@Override()
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

		this.personProcess = new PersonProcessImpl(
				super.getApplicationContext());
	}

	private void findPersonsByDocumentType(String documentType) {
		Log.i(TAG, "findPersonsByDocumentType(String):void");

		List<Person> personsFoundList = this.personProcess
				.findPersonsByDocumentTypeEnum(DocumentTypeEnum
						.findDocumentTypeEmunByDocumentType(documentType));
		Intent intent = new Intent(super.getApplicationContext(),
				PersonExpandableListActivity.class);
		intent.putParcelableArrayListExtra(
				PersonExpandableListActivity.PERSONS_LIST_KEY,
				(ArrayList<? extends Parcelable>) personsFoundList);

		super.startActivity(intent);
		super.finish();
	}

	public void onCancelFinder(View view) {
		Log.i(TAG, "onCancelFinder(View):void");

		super.finish();
	}

	public void onStartFinder(View view) {
		Log.i(TAG, "onStartFinder(View):void");
		findPersonsByDocumentType(documentType);

	}
}