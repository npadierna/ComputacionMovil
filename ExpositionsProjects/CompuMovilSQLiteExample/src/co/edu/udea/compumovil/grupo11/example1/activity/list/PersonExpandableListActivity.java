package co.edu.udea.compumovil.grupo11.example1.activity.list;

import java.util.ArrayList;
import java.util.List;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;

public class PersonExpandableListActivity extends ExpandableListActivity {

	private static final String TAG = PersonExpandableListActivity.class
			.getSimpleName();

	public static final String PERSONS_LIST_KEY = "Persons List Key";

	private List<Person> personsList;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.expandable_list_activity_person);

		this.extractPersonsList(super.getIntent());
		this.loadViews();
	}

	private void extractPersonsList(Intent intent) {
		Log.i(TAG, "extractPersonsList(Intent):void");

		if (intent.hasExtra(PERSONS_LIST_KEY)) {
			this.personsList = intent
					.getParcelableArrayListExtra(PERSONS_LIST_KEY);
		} else {
			Log.d(TAG, "The Intent does not contain any data for List.");

			this.personsList = new ArrayList<Person>();
		}
	}

	private void loadViews() {
		if (!this.personsList.isEmpty()) {
			super.findViewById(android.R.id.list).setVisibility(View.VISIBLE);

			ExpandableListAdapter personExpandableListAdapter = new PersonExpandableListAdapter(
					super.getApplicationContext(), this.personsList);

			super.setListAdapter(personExpandableListAdapter);
		} else {
			super.findViewById(R.id.empty_persons_list_text_view)
					.setVisibility(View.VISIBLE);
		}
	}
}