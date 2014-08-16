package co.edu.udea.compumovil.ahorcatooth.activity.category;

import android.widget.TextView;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
class CategoryViewHolder {

	private TextView categoryTextView;

	public CategoryViewHolder() {
		super();
	}

	public TextView getCategoryTextView() {

		return (this.categoryTextView);
	}

	public void setCategoryTextView(TextView categoryTextView) {
		this.categoryTextView = categoryTextView;
	}
}