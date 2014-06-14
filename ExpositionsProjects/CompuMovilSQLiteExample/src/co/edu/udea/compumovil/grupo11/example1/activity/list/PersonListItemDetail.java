package co.edu.udea.compumovil.grupo11.example1.activity.list;

import android.widget.TextView;

class PersonListItemDetail {

	private TextView heightTextView;
	private TextView weightTextView;
	private TextView eMailTextView;
	private TextView birthdayTextView;
	private TextView phoneNumberTextView;

	public PersonListItemDetail() {
		super();
	}

	public TextView getHeightTextView() {
		return heightTextView;
	}

	public void setHeightTextView(TextView heightTextView) {
		this.heightTextView = heightTextView;
	}

	public TextView getWeightTextView() {

		return (this.weightTextView);
	}

	public void setWeightTextView(TextView weightTextView) {
		this.weightTextView = weightTextView;
	}

	public TextView getEMailTextView() {

		return (this.eMailTextView);
	}

	public void setEMailTextView(TextView eMailTextView) {
		this.eMailTextView = eMailTextView;
	}

	public TextView getBirthdayTextView() {

		return (this.birthdayTextView);
	}

	public void setBirthdayTextView(TextView birthdayTextView) {
		this.birthdayTextView = birthdayTextView;
	}

	public TextView getPhoneNumberTextView() {

		return (this.phoneNumberTextView);
	}

	public void setPhoneNumberTextView(TextView phoneNumberTextView) {
		this.phoneNumberTextView = phoneNumberTextView;
	}
}