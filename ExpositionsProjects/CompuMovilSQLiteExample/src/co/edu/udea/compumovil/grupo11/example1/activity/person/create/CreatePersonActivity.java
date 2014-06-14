package co.edu.udea.compumovil.grupo11.example1.activity.person.create;

import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.activity.create.util.AlertDialogMessage;
import co.edu.udea.compumovil.grupo11.example1.activity.create.util.DatePickerFragment;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;
import co.edu.udea.compumovil.grupo11.example1.process.impl.PersonProcessImpl;

public class CreatePersonActivity extends FragmentActivity {

	private static final String TAG = CreatePersonActivity.class
			.getSimpleName();

	private IPersonProcess personProcess;

	private Spinner documentTypeSpinner;
	private EditText editTextDocumentNumber;
	private EditText editTextFirstName;
	private EditText editTextLastName;
	private EditText editTextEmail;
	private EditText editTextTelephone;
	private EditText editTextHeigh;
	private EditText editTextWeight;
	private Date birthdayDate;
	private String documentType;

	private String documentNumber;
	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private float height;
	private short weight;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_create_person);

		if (savedInstanceState == null) {
			this.personProcess = new PersonProcessImpl(
					super.getApplicationContext());
		}

		this.createElements();
	}

	public void showDatePickerDialog(View v) {
		DialogFragment datePickerFragmetn = new DatePickerFragment();
		datePickerFragmetn
				.show(super.getSupportFragmentManager(), "datePicker");
	}

	public void createElements() {
		final List<String> documentTypes = DocumentTypeEnum
				.obtainDocumentsTypesList();

		this.documentTypeSpinner = (Spinner) findViewById(R.id.document_type_spinner);

		ArrayAdapter<String> documentTypeAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item,
				DocumentTypeEnum.obtainDocumentsTypesList());
		documentTypeSpinner.setAdapter(documentTypeAdapter);
		documentTypeSpinner
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

		this.editTextDocumentNumber = (EditText) findViewById(R.id.document_number_edittext);
		this.editTextEmail = (EditText) findViewById(R.id.e_mail_edittext);
		this.editTextFirstName = (EditText) findViewById(R.id.first_name_edittext);
		this.editTextLastName = (EditText) findViewById(R.id.last_names_edit_text);
		this.editTextTelephone = (EditText) findViewById(R.id.phone_number_edittext);
		this.editTextWeight = (EditText) findViewById(R.id.weight_edittext);
		this.editTextHeigh = (EditText) findViewById(R.id.height_edittext);

	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	@SuppressLint("ShowToast")
	public void onCreatePerson(View view) {
		this.documentNumber = this.editTextDocumentNumber.getText().toString();

		PersonPK personPK = new PersonPK(
				DocumentTypeEnum
						.findDocumentTypeEmunByDocumentType(this.documentType),
				documentNumber);
		this.firstName = this.editTextFirstName.getText().toString();
		this.lastName = this.editTextLastName.getText().toString();
		this.email = this.editTextEmail.getText().toString();
		this.telephone = this.editTextTelephone.getText().toString();
		this.weight = Short
				.parseShort(this.editTextWeight.getText().toString());
		this.height = Float.parseFloat(this.editTextHeigh.getText().toString());

		Person person = new Person(personPK, firstName, lastName, birthdayDate);
		person.setEMail(email);
		person.setHeight(height);
		person.setWeight(weight);
		person.setPhoneNumber(telephone);

		this.clearField();

		this.personProcess.savePerson(person);

		AlertDialogMessage message = new AlertDialogMessage(this);

		message.createAlertDialog("Confirmación",
				person.getFirstNames() + " fue creado exitosamente")
				.setPositiveButton("Aceptar",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								//FIXME:Determinar que hacer en la actividad
								dialog.cancel();
							}
						}).show();

		// Toast.makeText(super.getApplicationContext(),
		// person.getFirstNames() + " fue creada exitosamente.",
		// Toast.LENGTH_SHORT).show();
	}

	private void clearField() {
		this.editTextDocumentNumber.setText("");
		this.editTextFirstName.setText("");
		this.editTextLastName.setText("");
		this.editTextEmail.setText("");
		this.editTextTelephone.setText("");
		this.editTextHeigh.setText("");
		this.editTextWeight.setText("");
	}
}