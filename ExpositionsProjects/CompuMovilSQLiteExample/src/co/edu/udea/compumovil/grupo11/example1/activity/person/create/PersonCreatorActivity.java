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
import co.edu.udea.compumovil.grupo11.example1.activity.person.create.util.MessageAlertDialog;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;
import co.edu.udea.compumovil.grupo11.example1.process.impl.PersonProcessImpl;

public class PersonCreatorActivity extends FragmentActivity {

	private static final String TAG = PersonCreatorActivity.class
			.getSimpleName();

	private IPersonProcess personProcess;

	private Spinner documentTypeSpinner;
	private EditText documentNumberEditText;
	private EditText firstNameEditText;
	private EditText lastNameEditText;
	private EditText eMailEditText;
	private EditText phoneNumberEditText;
	private EditText heighEditText;
	private EditText weightEditText;
	private Date birthdayDate;

	private String documentType;
	private String documentNumber;
	private String firstNames;
	private String lastNames;
	private String eMail;
	private String phoneNumber;
	private float height;
	private short weight;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_person_creator);

		if (savedInstanceState == null) {
			this.personProcess = new PersonProcessImpl(
					super.getApplicationContext());
		}

		this.createElements();
	}

	public void showDatePickerDialog(View v) {
		DialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
		datePickerDialogFragment.show(super.getSupportFragmentManager(),
				"datePicker");
	}

	public void createElements() {
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

		this.documentNumberEditText = (EditText) super
				.findViewById(R.id.document_number_edittext);
		this.eMailEditText = (EditText) super
				.findViewById(R.id.e_mail_edittext);
		this.firstNameEditText = (EditText) super
				.findViewById(R.id.first_name_edittext);
		this.lastNameEditText = (EditText) super
				.findViewById(R.id.last_names_edit_text);
		this.phoneNumberEditText = (EditText) super
				.findViewById(R.id.phone_number_edittext);
		this.weightEditText = (EditText) super
				.findViewById(R.id.weight_edittext);
		this.heighEditText = (EditText) super
				.findViewById(R.id.height_edittext);

	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public void onCreatePerson(View view) {
		Log.i(TAG, "onCreatePerson(View):void");

		this.documentNumber = this.documentNumberEditText.getText().toString();

		PersonPK personPK = new PersonPK(
				DocumentTypeEnum
						.findDocumentTypeEmunByDocumentType(this.documentType),
				documentNumber);

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

		this.clearField();

		this.personProcess.savePerson(person);

		AlertDialog.Builder messageAlertDialog = new MessageAlertDialog(this)
				.createAlertDialog("Confirmación", person.getFirstNames()
						+ " fue creado exitosamente");
		messageAlertDialog.setPositiveButton("Aceptar",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		(messageAlertDialog.create()).show();

	}

	private void clearField() {
		this.documentNumberEditText.setText("");
		this.firstNameEditText.setText("");
		this.lastNameEditText.setText("");
		this.eMailEditText.setText("");
		this.phoneNumberEditText.setText("");
		this.heighEditText.setText("");
		this.weightEditText.setText("");
	}
}