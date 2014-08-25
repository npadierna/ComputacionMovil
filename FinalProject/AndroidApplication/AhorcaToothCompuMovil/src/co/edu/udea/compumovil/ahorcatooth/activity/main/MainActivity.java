package co.edu.udea.compumovil.ahorcatooth.activity.main;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.aboutus.AboutActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.bluetooth.BluetoothMultiplayerActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.category.CategoryDashboardActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.preference.WebServicePreferenceActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.util.MessageAlertDialog;
import co.edu.udea.compumovil.ahorcatooth.activity.util.ProgressBarCustomized;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.business.ICategoryProcess;
import co.edu.udea.compumovil.ahorcatooth.process.business.IHangmanWordProcess;
import co.edu.udea.compumovil.ahorcatooth.process.business.ILanguagesProcess;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.CategoryProcessImpl;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.HangmanWordProcessImpl;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.LanguagesProcessImpl;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.CategoryWSProcess;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.HangmanWordWSProcess;
import co.edu.udea.compumovil.ahorcatooth.process.webservice.LanguagesWSProcess;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private final int NO_INTERNET_MESSAGE = 1;

	private ICategoryProcess categoryProcess;
	private IHangmanWordProcess hangmanWordProcess;
	private ILanguagesProcess languagesProcess;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);

		this.categoryProcess = new CategoryProcessImpl(
				super.getApplicationContext());
		this.hangmanWordProcess = new HangmanWordProcessImpl(
				super.getApplicationContext());
		this.languagesProcess = new LanguagesProcessImpl(
				super.getApplicationContext());
	}

	@Override()
	public boolean onCreateOptionsMenu(Menu menu) {
		super.getMenuInflater().inflate(R.menu.menu_main, menu);

		return (true);
	}

	@Override()
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.menu_action_update_database_preference:
			Log.i(TAG, "Update Database Settings");

			this.updateDatabase();

			break;

		case R.id.menu_action_web_service_preference:
			Log.i(TAG, "Web Service Settings");

			super.startActivity(new Intent(super.getApplicationContext(),
					WebServicePreferenceActivity.class));
			break;
			
		case R.id.menu_action_about_us:
			Log.i(TAG, "About us");

			super.startActivity(new Intent(super.getApplicationContext(),
					AboutActivity.class));

			return (true);
		}

		return (false);
	}

	public void onSinglePlayerGamge(View view) {
		Log.i(TAG, "onsinglePlayerGame(View):void");

		MessageAlertDialog messageAlertDialog = new MessageAlertDialog(this);

		if (!checkConectivity()) {
			messageAlertDialog.createAlertDialog(
					getString(R.string.no_conection_message_title),
					getString(R.string.no_conection_message),
					NO_INTERNET_MESSAGE);

			return;
		}

		super.startActivity(new Intent(super.getApplicationContext(),
				CategoryDashboardActivity.class));
	}

	public void onTwoPlayersGame(View view) {
		Log.i(TAG, "onTwoPlayersGame(View):void");

		super.startActivity(new Intent(super.getApplicationContext(),
				BluetoothMultiplayerActivity.class));
	}

	private void updateDatabase() {
		Log.i(TAG, "updateDatabase():void");

		ProgressDialog progressDialog = (new ProgressBarCustomized(this))
				.createProgressDialog(
						null,
						super.getString(R.string.updating_languages_message_spinner),
						false);
		LanguagesWSProcess languagesWSProcess = new LanguagesWSProcess(
				super.getApplicationContext(), progressDialog);

		progressDialog.setMessage(super
				.getString(R.string.updating_categories_message_spinner));
		CategoryWSProcess categoryWSProcess = new CategoryWSProcess(
				super.getApplicationContext(), progressDialog);

		HangmanWordWSProcess hangmanWordWSProcess = null;

		try {
			List<Languages> languagesFound = languagesWSProcess.findAll();
			for (Languages languages : languagesFound) {
				Log.d(TAG, languages.toString());

				this.languagesProcess.save(languages);
			}

			List<Category> categoriesFound = categoryWSProcess.findAll();
			for (Category category : categoriesFound) {
				Log.d(TAG, category.toString());

				this.categoryProcess.save(category);

				hangmanWordWSProcess = new HangmanWordWSProcess(
						super.getApplicationContext(), null);
				List<HangmanWord> hangmanWordsList = hangmanWordWSProcess
						.findLatestWithLimit(category.getCategoryPK()
								.getCategoryName(), category.getCategoryPK()
								.getLanguagesIsoCode(), 50);
				for (HangmanWord hangmanWord : hangmanWordsList) {
					Log.d(TAG, hangmanWord.toString());

					// FIXME: Do we need delete all Hangman Words?
					this.hangmanWordProcess.save(hangmanWord);
				}
			}
		} catch (AhorcaToothBusinessException e) {
			e.printStackTrace();

			// FIXME: What have we do?
		}
	}

	public boolean checkConectivity() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

		if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
			return true;
		}

		return false;
	}
}