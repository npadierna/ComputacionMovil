package co.edu.udea.compumovil.ahorcatooth.activity.category;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.activity.game.HangmanBoardActivity;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord;
import co.edu.udea.compumovil.ahorcatooth.process.business.ICategoryProcess;
import co.edu.udea.compumovil.ahorcatooth.process.business.IHangmanWordProcess;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.CategoryProcessImpl;
import co.edu.udea.compumovil.ahorcatooth.process.business.impl.HangmanWordProcessImpl;
import co.edu.udea.compumovil.ahorcatooth.process.exception.AhorcaToothBusinessException;

public class CategoryDashboardActivity extends Activity {

	private static final String TAG = CategoryDashboardActivity.class
			.getSimpleName();

	private ICategoryProcess categoryProcess;
	private IHangmanWordProcess hangmanWordProcess;

	private List<Category> categoriesList;

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_category_dashboard);

		this.findCategories();
		this.createViewComponents();
	}

	private void createViewComponents() {
		Log.i(TAG, "createComponents():void");

		ArrayAdapter<Category> arrayAdapter = new CategoryArrayAdapter(this,
				android.R.layout.simple_list_item_1, this.categoriesList);

		GridView gridView = (GridView) super
				.findViewById(R.id.categories_grid_view);
		gridView.setAdapter(arrayAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override()
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Log.i(TAG, "onItemClick(AdapterView<?>, View, int, long):void");

				startHangmanGame(categoriesList.get(position));
			}
		});
	}

	private void findCategories() {
		Log.i(TAG, "findCategories():void");

		this.categoryProcess = new CategoryProcessImpl(
				super.getApplicationContext());
		this.hangmanWordProcess = new HangmanWordProcessImpl(
				super.getApplicationContext());

		try {
			this.categoriesList = this.categoryProcess
					.findByLanguageIsoCode(Locale.getDefault()
							.getISO3Language());
		} catch (AhorcaToothBusinessException e) {
			e.printStackTrace();

			// FIXME: What have we do?
		}
	}

	private void startHangmanGame(Category category) {
		Log.i(TAG, "startHangmanGame(Category):void");
		Log.i(TAG, String.format("Selected Category: %s", category
				.getCategoryPK().getCategoryName()));

		HangmanWord hangmanWord = null;
		try {
			hangmanWord = this.hangmanWordProcess
					.findOneByCategoryNameAndLanguageIsoCode(category
							.getCategoryPK().getCategoryName(), category
							.getCategoryPK().getLanguagesIsoCode());
		} catch (AhorcaToothBusinessException e) {
			e.printStackTrace();

			// FIXME: What have we do?
		}

		Intent intent = new Intent(super.getApplicationContext(),
				HangmanBoardActivity.class);

		if (hangmanWord != null) {
			Bundle bundle = new Bundle();
			bundle.putString(HangmanBoardActivity.HANGMAN_WORD_NAME_SELECTED,
					hangmanWord.getWordName());

			intent.putExtras(bundle);
		}

		super.startActivity(intent);
	}
}