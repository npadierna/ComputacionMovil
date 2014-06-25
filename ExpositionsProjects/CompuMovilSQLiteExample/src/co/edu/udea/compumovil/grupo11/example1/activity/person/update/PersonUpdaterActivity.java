package co.edu.udea.compumovil.grupo11.example1.activity.person.update;

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
import co.edu.udea.compumovil.grupo11.example1.activity.person.create.PersonCreatorActivity;
import co.edu.udea.compumovil.grupo11.example1.activity.person.create.util.DatePickerDialogFragment;
import co.edu.udea.compumovil.grupo11.example1.activity.util.MessageAlertDialog;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;
import co.edu.udea.compumovil.grupo11.example1.process.impl.PersonProcessImpl;

public class PersonUpdaterActivity extends FragmentActivity {

	private static final String TAG = PersonUpdaterActivity.class
			.getSimpleName();

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

	private IPersonProcess personProcess;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_person_updater);
		PersonCreatorActivity.activityCall = true;
		if (savedInstanceState == null) {
			this.personProcess = new PersonProcessImpl(
					super.getApplicationContext());
		}

		createComponents();
	}

	private void createComponents() {
		final List<String> documentTypes = DocumentTypeEnum
				.obtainDocumentsTypesList();

		this.documentTypeSpinner = (Spinner) super
				.findViewById(R.id.person_information_document_type_spinner);

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
				.findViewById(R.id.person_information_document_number_edit_text);
		this.eMailEditText = (EditText) super
				.findViewById(R.id.person_information_e_mail_edit_text);
		this.firstNameEditText = (EditText) super
				.findViewById(R.id.person_information_first_name_edit_text);
		this.lastNameEditText = (EditText) super
				.findViewById(R.id.person_information_last_names_edit_text);
		this.phoneNumberEditText = (EditText) super
				.findViewById(R.id.person_information_phone_number_edit_text);
		this.weightEditText = (EditText) super
				.findViewById(R.id.person_information_weight_edit_text);
		this.heighEditText = (EditText) super
				.findViewById(R.id.person_information_height_edit_text);
	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	private void updatePerson() {
		Person temp;
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

		temp = this.personProcess.findPerson(personPK);
		if (temp != null) {
			this.personProcess.updatePerson(person);
		} else {
			AlertDialog.Builder messageBuilder = new MessageAlertDialog(this)
					.createAlertDialog(getString(R.string.fail_update_person_title_text),
							getString(R.string.fail_update_person_message_text));
			messageBuilder.setPositiveButton("Aceptar",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}
					});
			messageBuilder.create().show();
			clearWidgetsFields();
			return;
		}

		AlertDialog.Builder messageAlertDialog = new MessageAlertDialog(this)
				.createAlertDialog(
						super.getResources().getString(
								R.string.update_successful_text),
						super.getResources().getString(
								R.string.successful_update_information_tittle));
		messageAlertDialog.setPositiveButton("Aceptar",
				new DialogInterface.OnClickListener() {

					@Override()
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		(messageAlertDialog.create()).show();
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

	public void onPositiveButton(View view) {
		Log.i(TAG, "onCreatePerson(View):void");

		this.updatePerson();
	}

	public void onShowDatePickerDialog(View view) {
		DialogFragment datePickerDialogFragment = new DatePickerDialogFragment();
		datePickerDialogFragment.show(super.getSupportFragmentManager(),
				"datePicker");
		PersonCreatorActivity.activityCall = false;
	}

}