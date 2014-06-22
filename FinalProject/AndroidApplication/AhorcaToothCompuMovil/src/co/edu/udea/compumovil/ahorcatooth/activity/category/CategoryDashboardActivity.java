package co.edu.udea.compumovil.ahorcatooth.activity.category;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import co.edu.udea.compumovil.ahorcatooth.R;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK;

public class CategoryDashboardActivity extends Activity {

	private static final String TAG = CategoryDashboardActivity.class
			.getSimpleName();

	@Override()
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_category_dashboard);

		this.createComponents();
	}

	private void createComponents() {
		Log.i(TAG, "createComponents():void");

		List<Category> categoriesList = new ArrayList<Category>();
		categoriesList.add(new Category(new CategoryPK("Category #1", "es"),
				"image.png"));

		GridView gridView = (GridView) super
				.findViewById(R.id.categories_grid_view);
		ArrayAdapter<Category> arrayAdapter = new CategoryArrayAdapter(this,
				android.R.layout.simple_list_item_1, categoriesList);

		gridView.setAdapter(arrayAdapter);
	}
}