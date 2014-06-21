package co.edu.udea.compumovil.ahorcatooth.activity.category;

import android.widget.TextView;

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