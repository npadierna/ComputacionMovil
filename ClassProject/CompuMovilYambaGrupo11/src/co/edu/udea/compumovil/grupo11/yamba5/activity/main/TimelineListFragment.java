package co.edu.udea.compumovil.grupo11.yamba5.activity.main;

import android.app.ListFragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorAdapter.ViewBinder;
import android.widget.TextView;
import co.edu.udea.compumovil.grupo11.yamba5.R;
import co.edu.udea.compumovil.grupo11.yamba5.activity.main.detail.DetailsActivity;
import co.edu.udea.compumovil.grupo11.yamba5.activity.main.detail.DetailsFragment;
import co.edu.udea.compumovil.grupo11.yamba5.database.contract.StatusContract;

public class TimelineListFragment extends ListFragment implements
		LoaderCallbacks<Cursor> {

	private static final String TAG = TimelineListFragment.class
			.getSimpleName();

	private static final String[] FROM = { StatusContract.Column.USER,
			StatusContract.Column.MESSAGE, StatusContract.Column.CREATED_AT };
	private static final int[] TO = { R.id.yamba_list_item_text_user,
			R.id.yamba_list_item_text_message,
			R.id.yamba_list_item_text_created_at };
	private static final int LOADER_ID = 42;

	private SimpleCursorAdapter simpleCursorAdapter;

	@Override()
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		this.simpleCursorAdapter = new SimpleCursorAdapter(super.getActivity(),
				R.layout.yamba_list_item, null, FROM, TO,
				CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		this.simpleCursorAdapter.setViewBinder(new TimelineViewBinder());

		super.setListAdapter(this.simpleCursorAdapter);
		super.getLoaderManager().initLoader(LOADER_ID, null, this);
	}

	@Override()
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		if (id != LOADER_ID) {

			return (null);
		}

		Log.d(TAG, "onCreateLoader");

		return (new CursorLoader(super.getActivity(),
				StatusContract.CONTENT_URI, null, null, null,
				StatusContract.DEFAULT_SORT));
	}

	@Override()
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		DetailsFragment detailsFragment = (DetailsFragment) super
				.getFragmentManager().findFragmentById(R.id.fragment_details);

		if ((detailsFragment != null) && (detailsFragment.isVisible())
				&& (cursor.getCount() == 0)) {
			detailsFragment.updateView(-1);
		}

		this.simpleCursorAdapter.swapCursor(cursor);
	}

	@Override()
	public void onLoaderReset(Loader<Cursor> loader) {
		this.simpleCursorAdapter.swapCursor(null);
	}

	public void onListItemClick(ListView l, View v, int position, long id) {
		DetailsFragment fragment = (DetailsFragment) getFragmentManager()
				.findFragmentById(R.id.fragment_details);

		if (fragment != null && fragment.isVisible()) {
			fragment.updateView(id);
		} else {
			super.startActivity(new Intent(getActivity(), DetailsActivity.class)
					.putExtra(StatusContract.Column.ID, id));
		}
	}

	class TimelineViewBinder implements ViewBinder {

		@Override()
		public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
			if (view.getId() != R.id.yamba_list_item_text_created_at) {

				return (false);
			}

			long timestamp = cursor.getLong(columnIndex);
			CharSequence relativeTime = DateUtils
					.getRelativeTimeSpanString(timestamp);
			((TextView) view).setText(relativeTime);

			return (true);
		}
	}
}