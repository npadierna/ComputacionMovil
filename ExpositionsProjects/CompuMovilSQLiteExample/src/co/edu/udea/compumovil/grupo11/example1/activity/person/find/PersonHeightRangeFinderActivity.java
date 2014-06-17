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
import co.edu.udea.compumovil.grupo11.example1.process.IPersonProcess;
import co.edu.udea.compumovil.grupo11.example1.process.impl.PersonProcessImpl;

public class PersonHeightRangeFinderActivity extends Activity {

	private static final String TAG = PersonHeightRangeFinderActivity.class
			.getSimpleName();
	private IPersonProcess personProcess;

	// FIXME: Read from the integers.xml
	private static final short MAX_HEIGHT = (short) 99;
	private static final Float[] HEIGHT_RAGE = new Float[MAX_HEIGHT];
	static {
		for (short height = 1; height <= MAX_HEIGHT; height++) {
			HEIGHT_RAGE[height - 1] = Float.valueOf(height);
		}
	}

	private float lowerHeightRange;
	private float upperHeightRange;

	private Spinner lowerHeightRangeSpinner;
	private Spinner upperHeightRangeSpinner;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_person_height_range_finder);

		if (savedInstanceState == null) {
			this.createElements();
		}
	}

	public void onCancelFinder(View view) {
		Log.i(TAG, "onCancelFinder(View):void");

		super.finish();
	}

	public void onStartFinder(View view) {
		Log.i(TAG, "onStartFinder(View):void");

		this.findPersonsByHeightRange(this.lowerHeightRange,
				this.upperHeightRange);
	}

	private void createElements() {
		SpinnerAdapter ageRangeSpinnerAdapter = new ArrayAdapter<Float>(
				super.getApplicationContext(),
				android.R.layout.simple_spinner_item, HEIGHT_RAGE);

		this.lowerHeightRangeSpinner = (Spinner) super
				.findViewById(R.id.lower_age_range_spinner);
		this.lowerHeightRangeSpinner.setAdapter(ageRangeSpinnerAdapter);
		this.lowerHeightRangeSpinner
				.setOnItemSelectedListener(this.onItemSelectedListener);

		this.upperHeightRangeSpinner = (Spinner) super
				.findViewById(R.id.upper_age_range_spinner);
		this.upperHeightRangeSpinner.setAdapter(ageRangeSpinnerAdapter);
		this.upperHeightRangeSpinner
				.setOnItemSelectedListener(this.onItemSelectedListener);

		this.personProcess = new PersonProcessImpl(
				super.getApplicationContext());
	}

	private final OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {

		@Override()
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			Log.i(TAG, "onItemSelected(AdapterView<?>, View, int, long):void");

			switch (parent.getId()) {
			case (R.id.lower_age_range_spinner):
				Log.i(TAG, "Lower Height Range Spinner");

				lowerHeightRange = HEIGHT_RAGE[position];
				break;

			case (R.id.upper_age_range_spinner):
				Log.i(TAG, "Upper Age Range Spinner");

				upperHeightRange = HEIGHT_RAGE[position];
				break;
			}
		}

		@Override()
		public void onNothingSelected(AdapterView<?> parent) {
		}
	};

	private void findPersonsByHeightRange(float lowerHeight, float upperHeight) {
		Log.i(TAG, "findPersonsByHeightRange(short, short):void");

		if (upperHeight >= lowerHeight) {
			List<Person> personsFoundList = this.personProcess
					.findPersonsByHeightRange(lowerHeight, upperHeight);

			Intent intent = new Intent(super.getApplicationContext(),
					PersonExpandableListActivity.class);
			intent.putParcelableArrayListExtra(
					PersonExpandableListActivity.PERSONS_LIST_KEY,
					(ArrayList<? extends Parcelable>) personsFoundList);

			super.startActivity(intent);
		}
	}
}