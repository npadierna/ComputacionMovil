package co.edu.udea.compumovil.ahorcatooth.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.bluetooth.BluetoothMultiplayerActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.category.CategoryDashboardActivity;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
	}

	private void startMultiplayerGame() {
		super.startActivity(new Intent(super.getApplicationContext(),
				BluetoothMultiplayerActivity.class));
	}

	private void startSinglePlayerGame() {
		super.startActivity(new Intent(super.getApplicationContext(),
				CategoryDashboardActivity.class));
	}

	public void onSinglePlayerGamge(View view) {
		Log.i(TAG, "onsinglePlayerGame(View):void");

		this.startSinglePlayerGame();
	}

	public void onTwoPlayersGame(View view) {
		Log.i(TAG, "onTwoPlayersGame(View):void");

		this.startMultiplayerGame();
	}
}