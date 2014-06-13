package co.edu.udea.compumovil.grupo11.yamba.activity.main.detail;

import android.app.Fragment;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import co.edu.udea.compumovil.grupo11.yamba.R;
import co.edu.udea.compumovil.grupo11.yamba.database.contract.StatusContract;

public class DetailsFragment extends Fragment {

	private TextView textUserTextView;
	private TextView textMessageTextView;
	private TextView textCreatedAtTextView;

	@Override()
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.yamba_list_item, null, false);

		this.textUserTextView = (TextView) view
				.findViewById(R.id.yamba_list_item_text_user);
		this.textMessageTextView = (TextView) view
				.findViewById(R.id.yamba_list_item_text_message);
		this.textCreatedAtTextView = (TextView) view
				.findViewById(R.id.yamba_list_item_text_created_at);

		return (view);
	}

	@Override
	public void onResume() {
		super.onResume();

		long id = super.getActivity().getIntent()
				.getLongExtra(StatusContract.Column.ID, -1);

		this.updateView(id);
	}

	public void updateView(long id) {
		if (id == -1) {
			this.textUserTextView.setText("");
			this.textMessageTextView.setText("");
			this.textCreatedAtTextView.setText("");

			return;
		}

		Uri uri = ContentUris.withAppendedId(StatusContract.CONTENT_URI, id);
		Cursor cursor = super.getActivity().getContentResolver()
				.query(uri, null, null, null, null);

		if (!cursor.moveToFirst()) {

			return;
		}

		String user = cursor.getString(cursor
				.getColumnIndex(StatusContract.Column.USER));
		String message = cursor.getString(cursor
				.getColumnIndex(StatusContract.Column.MESSAGE));
		long createdAt = cursor.getLong(cursor
				.getColumnIndex(StatusContract.Column.CREATED_AT));

		this.textUserTextView.setText(user);
		this.textMessageTextView.setText(message);
		this.textCreatedAtTextView.setText(DateUtils
				.getRelativeTimeSpanString(createdAt));
	}
}