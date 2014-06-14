package co.edu.udea.compumovil.grupo11.example1.activity.list;

import android.widget.TextView;

class PersonListItemHeader {

	private TextView fistNamesTextView;
	private TextView lastNamesTextView;
	private TextView documentTypeTextView;
	private TextView idNumTextView;

	public PersonListItemHeader() {
		super();
	}

	public TextView getFistNamesTextView() {

		return (this.fistNamesTextView);
	}

	public void setFistNamesTextView(TextView fistNamesTextView) {
		this.fistNamesTextView = fistNamesTextView;
	}

	public TextView getLastNamesTextView() {

		return (this.lastNamesTextView);
	}

	public void setLastNamesTextView(TextView lastNamesTextView) {
		this.lastNamesTextView = lastNamesTextView;
	}

	public TextView getDocumentTypeTextView() {

		return (this.documentTypeTextView);
	}

	public void setDocumentTypeTextView(TextView documentTypeTextView) {
		this.documentTypeTextView = documentTypeTextView;
	}

	public TextView getIdNumTextView() {

		return (this.idNumTextView);
	}

	public void setIdNumTextView(TextView idNumTextView) {
		this.idNumTextView = idNumTextView;
	}
}