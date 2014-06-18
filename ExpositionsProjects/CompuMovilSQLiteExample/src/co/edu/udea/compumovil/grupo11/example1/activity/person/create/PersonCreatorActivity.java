package co.edu.udea.compumovil.grupo11.example1.activity.person.create;

import java.util.Date;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.activity.person.create.util.DatePickerDialogFragment;
import co.edu.udea.compumovil.grupo11.example1.activity.util.MessageAlertDialog;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;
import co.edu.udea.compumovil.grupo11.example1.process.impl.PersonProcessImpl;

public class PersonCreatorActivity extends FragmentActivity {

	private static final String TAG = PersonCreatorActivity.class
			.getSimpleName();

	private IPersonProcess personProcess;

	private EditText eMailEditText;
	private EditText firstNameEditText;
	private EditText heighEditText;
	private EditText idNumberEditText;
	private EditText lastNameEditText;
	private EditText phoneNumberEditText;
	private EditText weightEditText;
	private Spinner documentTypeSpinner;

	private float height;
	private short weight;
	private Date birthdayDate;
	private String documentType;
	private String eMail;
	private String firstNames;
	private String idNumber;
	private String lastNames;
	private String phoneNumber;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_person_creator);

		if (savedInstanceState == null) {
			this.personProcess = new PersonProcessImpl(
					super.getApplicationContext());
		}

		this.createComponents();
	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	private void clearWidgetsFields() {
		this.idNumberEditText.setText("");
		this.firstNameEditText.setText("");
		this.lastNameEditText.setText("");
		this.eMailEditText.setText("");
		this.phoneNumberEditText.setText("");
		this.heighEditText.setText("");
		this.weightEditText.setText("");
	}

	private void createComponents() {
		final List<String> documentTypes = DocumentTypeEnum
				.obtainDocumentsTypesList();

		this.documentTypeSpinner = (Spinner) super
				.findViewById(R.id.document_type_spinner);

		SpinnerAdapter documentTypeSpinnerAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item,
				DocumentTypeEnum.obtainDocumentsTypesList());
		this.documentTypeSpinner.setAdapter(documentTypeSpinnerAdapter);
		this.documentTypeSpinner
				.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

					@Override()
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						documentType = documentTypes.get(position);
					}

					@Override()
					public void onNothingSelected(AdapterView<?> parent) {
					}
				});

		this.idNumberEditText = (EditText) super
				.findViewById(R.id.document_number_edit_text);
		this.eMailEditText = (EditText) super
				.findViewById(R.id.e_mail_edit_text);
		this.firstNameEditText = (EditText) super
				.findViewById(R.id.first_name_edit_text);
		this.lastNameEditText = (EditText) super
				.findViewById(R.id.last_names_edit_text);
		this.phoneNumberEditText = (EditText) super
				.findViewById(R.id.phone_number_edit_text);
		this.weightEditText = (EditText) super
				.findViewById(R.id.weight_edit_text);
		this.heighEditText = (EditText) super
				.findViewById(R.id.height_edit_text);
	}

	private void savePerson() {
		this.idNumber = this.idNumberEditText.getText().toString();

		PersonPK personPK = new PersonPK(
				DocumentTypeEnum
						.findDocumentTypeEmunByDocumentType(this.documentType),
				idNumber);

		this.firstNames = this.firstNameEditText.getText().toString();
		this.lastNames = this.lastNameEditText.getText().toString();
		this.eMail = this.eMailEditText.getText().toString();
		this.phoneNumber = this.phoneNumberEditText.getText().toString();
		this.weight = Short
				.parseShort(this.weightEditText.getText().toString());
		this.height = Float.parseFloat(this.heighEditText.getText().toString());

		Person person = new Person(personPK, this.firstNames, this.lastNames,
				this.birthdayDate);
		person.setEMail(this.eMail);
		person.setHeight(this.height);
		person.setWeight(this.weight);
		person.setPhoneNumber(this.phoneNumber);

		this.clearWidgetsFields();

		this.personProcess.savePerson(person);

		AlertDialog.Builder messageAlertDialog = new MessageAlertDialog(this)
				.createAlertDialog(
						super.getResources().getString(
								R.string.person_creator_title_dialog),
						super.getResources().getString(
								R.string.person_creator_text_dialog));
		messageAlertDialog.setPositiveButton("Aceptar",
				new DialogInterface.OnClickListener() {

					@Override()
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		(messageAlertDialog.create()).show();
	}

	public void onCreatePerson(View view) {
		Log.i(TAG, "onCreatePerson(View):void");

		this.savePerson();
	}

	public void onShowDatePickerDialog(View view) {
		DialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
		datePickerDialogFragment.show(super.getSupportFragmentManager(),
				"datePicker");
	}
}