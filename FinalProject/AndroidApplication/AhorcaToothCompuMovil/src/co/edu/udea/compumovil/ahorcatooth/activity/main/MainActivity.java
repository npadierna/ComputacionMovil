package co.edu.udea.compumovil.ahorcatooth.activity.main;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.bluetooth.BluetoothMultiplayerActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.category.CategoryDashboardActivity;
import co.edu.udea.compumovil.ahorcatooth.activity.preference.WebServicePreferenceActivity;
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

public class MainActivity extends FragmentActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private ICategoryProcess categoryProcess;
	private IHangmanWordProcess hangmanWordProcess;
	private ILanguagesProcess languagesProcess;

	private ProgressDialog progressDialog;

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

		this.progressDialog = new ProgressDialog(MainActivity.this);
		this.progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		this.progressDialog.setTitle(null);
		this.progressDialog.setMessage(super
				.getString(R.string.updating_languages_message_spinner));
		this.progressDialog.setCancelable(false);
		this.progressDialog.setIndeterminate(true);
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

			return (true);
		}

		return (false);
	}

	public void onSinglePlayerGamge(View view) {
		Log.i(TAG, "onsinglePlayerGame(View):void");

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

		ProgressDialog progressDialog = (new ProgressBarCustomized(
				MainActivity.this)).createProgressDialog(null,
				super.getString(R.string.updating_languages_message_spinner),
				false);

//		DialogFragment progressDialogFragment = ProgressDialogFragment
//				.newInstance();
//		progressDialogFragment.show(super.getSupportFragmentManager(),
//				"Progress Dialog Fragment");

		LanguagesWSProcess languagesWSProcess = new LanguagesWSProcess(
				super.getApplicationContext(), progressDialog);
		CategoryWSProcess categoryWSProcess = new CategoryWSProcess(
				super.getApplicationContext(), progressDialog);
		HangmanWordWSProcess hangmanWordWSProcess = new HangmanWordWSProcess(
				super.getApplicationContext(), progressDialog);

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
//		progressDialogFragment.dismiss();
	}
}