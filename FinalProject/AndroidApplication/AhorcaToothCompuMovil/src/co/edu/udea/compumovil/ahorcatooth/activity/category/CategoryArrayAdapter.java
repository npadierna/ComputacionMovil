package co.edu.udea.compumovil.ahorcatooth.activity.category;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import co.edu.udea.compumovil.ahorcatooth.model.pojo.Category;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
class CategoryArrayAdapter extends ArrayAdapter<Category> {

	private int resource;

	private Activity activity;
	private List<Category> categoriesList;

	public CategoryArrayAdapter(Activity activity, int resource,
			List<Category> categoriesList) {
		super(activity.getApplicationContext(), resource, categoriesList);

		this.resource = resource;
		this.activity = activity;
		this.categoriesList = categoriesList;
	}

	@Override()
	public View getView(int position, View convertView, ViewGroup parent) {
		CategoryViewHolder categoryViewHolder;

		if (convertView == null) {
			LayoutInflater layoutInflater = this.activity.getLayoutInflater();

			convertView = layoutInflater.inflate(this.resource, null);

			categoryViewHolder = new CategoryViewHolder();
			categoryViewHolder.setCategoryTextView((TextView) convertView);

			convertView.setTag(categoryViewHolder);
		} else {
			categoryViewHolder = (CategoryViewHolder) convertView.getTag();
		}

		this.fillCategoryData(position, categoryViewHolder);

		return (convertView);
	}

	public List<Category> getCategories() {
		return (this.categoriesList);
	}

	private void fillCategoryData(int position,
			CategoryViewHolder categoryViewHolder) {
		// FIXME: We need to attach the Category's image.
		Category category = this.getCategories().get(position);
		CategoryImage categoryImage = CategoryImage.getInstance();
		categoryViewHolder.getCategoryTextView()
				.setCompoundDrawablesWithIntrinsicBounds(
						0,
						categoryImage.getDrawableByCategoryImageName(category
								.getImageName()), 0, 0);
		categoryViewHolder.getCategoryTextView().setText(
				category.getCategoryPK().getCategoryName());
	}
}