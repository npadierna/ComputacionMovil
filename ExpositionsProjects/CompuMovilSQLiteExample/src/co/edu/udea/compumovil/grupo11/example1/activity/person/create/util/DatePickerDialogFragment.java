package co.edu.udea.compumovil.grupo11.example1.activity.person.create.util;

import java.util.Calendar;

import co.edu.udea.compumovil.grupo11.example1.activity.person.create.PersonCreatorActivity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

public class DatePickerDialogFragment extends DialogFragment implements
		OnDateSetListener {

	public DatePickerDialogFragment() {
		super();
	}

	@Override()
	public void onDateSet(DatePicker view, int year, int monthOfYear,
			int dayMonth) {
		PersonCreatorActivity createPersonActivity = (PersonCreatorActivity) super
				.getActivity();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, monthOfYear, dayMonth);
		createPersonActivity.setBirthdayDate(calendar.getTime());
	}

	@Override()
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		return (new DatePickerDialog(super.getActivity(), this, year, month,
				day));
	}
}