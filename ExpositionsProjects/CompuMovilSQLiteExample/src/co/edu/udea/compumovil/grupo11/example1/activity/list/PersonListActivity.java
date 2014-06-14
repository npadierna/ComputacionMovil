package co.edu.udea.compumovil.grupo11.example1.activity.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;
import co.edu.udea.compumovil.grupo11.example1.model.entity.PersonPK;
import co.edu.udea.compumovil.grupo11.example1.model.enums.DocumentTypeEnum;

public class PersonListActivity extends ExpandableListActivity {

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.expandable_list_activity_person);

		List<Person> personsList = new ArrayList<Person>();
		Person neiber = new Person(new PersonPK(
				DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1022095657"),
				"Neiber de Jesús", "Padierna Pérez", new Date());
		neiber.setEMail("npadierna@gmail.com");
		neiber.setHeight(1.75F);
		neiber.setPhoneNumber("+(123) 123 45 67");
		neiber.setWeight((short) 12);

		Person yefry = new Person(new PersonPK(
				DocumentTypeEnum.CEDULA_DE_CIUDADANIA, "1020448936"),
				"Yefry Alexis", "Calderón Yepes", new Date());
		// yefry.setEMail("alexis.cal.y@gmail.com");
		// yefry.setHeight(1.75F);
		// yefry.setPhoneNumber("+(123) 123 45 67");
		// yefry.setWeight((short) 12);

		Person neiber2 = new Person(new PersonPK(
				DocumentTypeEnum.NUMERO_IDENTIFICACION_PERSONAL, "1022095657"),
				"Neiber de Jesús", "Padierna Pérez", new Date());
		neiber2.setEMail("npadierna@gmail.com");
		neiber2.setHeight(1.75F);
		neiber2.setPhoneNumber("+(123) 123 45 67");
		neiber2.setWeight((short) 12);
		
		personsList.add(neiber);
		personsList.add(yefry);
		personsList.add(neiber2);

		PersonExpandableListAdapter personExpandableListAdapter = new PersonExpandableListAdapter(
				super.getApplicationContext(), personsList);

		super.setListAdapter(personExpandableListAdapter);
	}
}