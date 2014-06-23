package co.edu.udea.compumovil.ahorcatooth.activity.game;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

class KeyboardKeyArrayAdapter extends ArrayAdapter<String> {

	private int resource;

	private Activity activity;
	private String[] keyboardTextsArray;

	public KeyboardKeyArrayAdapter(Activity activity, int resource,
			String[] keyboardTextsArray) {
		super(activity.getApplicationContext(), resource, keyboardTextsArray);

		this.resource = resource;
		this.activity = activity;
		this.keyboardTextsArray = keyboardTextsArray;
	}

	@Override()
	public View getView(int position, View convertView, ViewGroup parent) {
		KeyboardKeyViewHolder keyboardKeyViewHolder;

		if (convertView == null) {
			LayoutInflater layoutInflater = this.activity.getLayoutInflater();

			convertView = layoutInflater.inflate(this.resource, null);

			keyboardKeyViewHolder = new KeyboardKeyViewHolder();
			keyboardKeyViewHolder.setKeyboardKeyButton((Button) convertView);

			convertView.setTag(keyboardKeyViewHolder);
		} else {
			keyboardKeyViewHolder = (KeyboardKeyViewHolder) convertView
					.getTag();
		}

		this.fillKeyboardKey(this.keyboardTextsArray[position],
				keyboardKeyViewHolder);

		return (convertView);
	}

	private void fillKeyboardKey(String keyText,
			KeyboardKeyViewHolder keyboardKeyViewHolder) {
		keyboardKeyViewHolder.getKeyboardKeyButton().setText(keyText);
	}
}