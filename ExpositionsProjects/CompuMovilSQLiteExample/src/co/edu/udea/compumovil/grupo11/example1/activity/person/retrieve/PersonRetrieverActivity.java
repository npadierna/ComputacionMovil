package co.edu.udea.compumovil.grupo11.example1.activity.person.retrieve;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.activity.list.PersonExpandableListActivity;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;
import co.edu.udea.compumovil.grupo11.example1.process.impl.PersonProcessImpl;

public class PersonRetrieverActivity extends Activity {

	private static final String TAG = PersonRetrieverActivity.class
			.getSimpleName();

	private IPersonProcess personProcess;

	private String documentType;

	private EditText idNumberEditText;
	private Spinner documentTypeSpinner;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_person_retiever);

		this.createComponents();
	}

	private void createComponents() {
		SpinnerAdapter documentTypeSpinnerAdapter = new ArrayAdapter<String>(
				super.getApplicationContext(),
				android.R.layout.simple_spinner_item,
				DocumentTypeEnum.obtainDocumentsTypesList());

		this.documentTypeSpinner = (Spinner) super
				.findViewById(R.id.person_finder_document_type_spinner);
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

		this.idNumberEditText = (EditText) super
				.findViewById(R.id.person_finder_id_number_edit_text);

		this.personProcess = new PersonProcessImpl(
				super.getApplicationContext());
	}

	private void findPerson() {
		String idNumber = this.idNumberEditText.getText().toString();
		if (!TextUtils.isEmpty(idNumber)) {
			Person person = this.personProcess
					.findPerson(new PersonPK(
							DocumentTypeEnum
									.findDocumentTypeEmunByDocumentType(this.documentType),
							idNumber));

			Intent intent = new Intent(super.getApplicationContext(),
					PersonExpandableListActivity.class);
			if (person != null) {
				List<Person> personsFoundList = new ArrayList<Person>();
				personsFoundList.add(person);

				intent.putParcelableArrayListExtra(
						PersonExpandableListActivity.PERSONS_LIST_KEY,
						(ArrayList<? extends Parcelable>) personsFoundList);
			}

			super.startActivity(intent);
			super.finish();
		}
	}

	public void onNegativeButtonClick(View view) {
		Log.i(TAG, "onNegativeButtonClick(View):void");

		super.finish();
	}

	public void onPossitiveButtonClick(View view) {
		Log.i(TAG, "onPossitiveButtonClick(View):void");

		this.findPerson();
	}
}