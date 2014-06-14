package co.edu.udea.compumovil.grupo11.example1.activity.list;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import co.edu.udea.compumovil.grupo11.example1.R;
import co.edu.udea.compumovil.grupo11.example1.model.entity.Person;

public class PersonExpandableListAdapter extends BaseExpandableListAdapter {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"dd/MM/yyyy", Locale.getDefault());

	private Context context;
	private List<Person> personsList;

	public PersonExpandableListAdapter(Context context, List<Person> personsList) {
		super();

		this.context = context;
		this.personsList = personsList;
	}

	@Override()
	public int getGroupCount() {

		return (this.personsList.size());
	}

	@Override()
	public int getChildrenCount(int groupPosition) {

		return (1);
	}

	@Override()
	public Object getGroup(int groupPosition) {

		return (this.personsList.get(groupPosition));
	}

	@Override()
	public Object getChild(int groupPosition, int childPosition) {

		return (this.personsList.get(groupPosition));
	}

	@Override()
	public long getGroupId(int groupPosition) {

		return (groupPosition);
	}

	@Override()
	public long getChildId(int groupPosition, int childPosition) {

		return (childPosition);
	}

	@Override()
	public boolean hasStableIds() {

		return (false);
	}

	@Override()
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		PersonListItemHeader personListItemHeader;

		if (convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			convertView = layoutInflater.inflate(
					R.layout.person_list_item_header, null);

			personListItemHeader = new PersonListItemHeader();
			personListItemHeader.setDocumentTypeTextView((TextView) convertView
					.findViewById(R.id.document_type_text_view));
			personListItemHeader.setFistNamesTextView((TextView) convertView
					.findViewById(R.id.first_names_text_view));
			personListItemHeader.setIdNumTextView((TextView) convertView
					.findViewById(R.id.id_number_text_view));
			personListItemHeader.setLastNamesTextView((TextView) convertView
					.findViewById(R.id.last_names_text_view));

			convertView.setTag(personListItemHeader);
		} else {
			personListItemHeader = (PersonListItemHeader) convertView.getTag();
		}

		this.fillGroupHeader(groupPosition, personListItemHeader);

		return (convertView);
	}

	@Override()
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		PersonListItemDetail personListItemDetail;

		if (convertView == null) {
			LayoutInflater layoutInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = layoutInflater.inflate(
					R.layout.person_list_item_detail, null);

			personListItemDetail = new PersonListItemDetail();
			personListItemDetail.setHeightTextView((TextView) convertView
					.findViewById(R.id.height_text_view));
			personListItemDetail.setWeightTextView((TextView) convertView
					.findViewById(R.id.weight_text_view));
			personListItemDetail.setEMailTextView((TextView) convertView
					.findViewById(R.id.e_mail_text_view));
			personListItemDetail.setBirthdayTextView((TextView) convertView
					.findViewById(R.id.birthday_text_view));
			personListItemDetail.setPhoneNumberTextView((TextView) convertView
					.findViewById(R.id.phone_number_text_view));

			convertView.setTag(personListItemDetail);
		} else {
			personListItemDetail = (PersonListItemDetail) convertView.getTag();
		}

		this.fillGroupDetails(groupPosition, personListItemDetail);

		return (convertView);
	}

	@Override()
	public boolean isChildSelectable(int groupPosition, int childPosition) {

		return (false);
	}

	private void fillGroupHeader(int groupPosition,
			PersonListItemHeader personListItemHeader) {
		Person person = (Person) this.getGroup(groupPosition);

		personListItemHeader.getDocumentTypeTextView().setText(
				person.getPersonPK().getDocumentTypeEnum().getDocumentType());
		personListItemHeader.getFistNamesTextView().setText(
				person.getFirstNames());
		personListItemHeader.getIdNumTextView().setText(
				person.getPersonPK().getIdNumber());
		personListItemHeader.getLastNamesTextView().setText(
				person.getLastNames());
	}

	private void fillGroupDetails(int groupPosition,
			PersonListItemDetail personListItemDetail) {
		Person person = (Person) this.getGroup(groupPosition);

		personListItemDetail.getBirthdayTextView().setText(
				DATE_FORMAT.format(person.getBirthday()));
		personListItemDetail.getEMailTextView().setText(person.getEMail());
		personListItemDetail.getHeightTextView().setText(
				(person.getHeight() != 0.0F) ? String.valueOf(person
						.getHeight()) : "");
		personListItemDetail.getPhoneNumberTextView().setText(
				person.getPhoneNumber());
		personListItemDetail.getWeightTextView().setText(
				(person.getWeight() != (short) 0) ? String.valueOf(person
						.getWeight()) : "");
	}
}