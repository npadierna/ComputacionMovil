package co.edu.udea.compumovil.ahorcatooth.activity.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.category.CategoryDashboardActivity;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages;
import co.edu.udea.compumovil.ahorcatooth.process.ILanguagesProcess;
import co.edu.udea.compumovil.ahorcatooth.process.impl.LanguagesProcessImpl;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);

		ILanguagesProcess languagesProcess = new LanguagesProcessImpl(
				super.getApplicationContext());

		Languages languages = new Languages("en", "English");
		languages
				.setDescription("[EN] Language family: Indo-European. ISO 639-2/T: eng. ISO 639-2/B: eng. ISO 639-3: eng. ISO 639-6: engs.");

		languagesProcess.saveLanguages(languages);
	}

	public void onSinglePlayerGamge(View view) {
		Log.i(TAG, "onsinglePlayerGame(View):void");

		super.startActivity(new Intent(super.getApplicationContext(),
				CategoryDashboardActivity.class));
	}

	public void onTwoPlayersGame(View view) {
		Log.i(TAG, "onTwoPlayersGame(View):void");
	}
}