package co.edu.udea.compumovil.ahorcatooth.activity.category;

import java.util.HashMap;
import java.util.Map;

import co.edu.udea.compumovil.ahorcatooth.R;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
final class CategoryImage {

	private Map<String, Integer> categoryImagesMap;
	private static CategoryImage instance;

	private CategoryImage() {
		super();

		this.createMapForImages();
	}

	public synchronized static CategoryImage getInstance() {
		if (instance == null) {
			instance = new CategoryImage();
		}

		return (instance);
	}

	public int getDrawableByCategoryImageName(String categoryImageName) {

		return (this.categoryImagesMap.get(categoryImageName).intValue());
	}

	private void createMapForImages() {
		this.categoryImagesMap = new HashMap<String, Integer>();

		this.categoryImagesMap.put("ic_foods_category.png",
				Integer.valueOf(R.drawable.ic_foods_category));
		this.categoryImagesMap.put("ic_geography_category.png",
				Integer.valueOf(R.drawable.ic_geography_category));
		this.categoryImagesMap.put("ic_leisure_category.png",
				Integer.valueOf(R.drawable.ic_leisure_category));
		this.categoryImagesMap.put("ic_music_category.png",
				Integer.valueOf(R.drawable.ic_music_category));
		this.categoryImagesMap.put("ic_nature_category.png",
				Integer.valueOf(R.drawable.ic_nature_category));
		this.categoryImagesMap.put("ic_religions_category.png",
				Integer.valueOf(R.drawable.ic_religions_category));
		this.categoryImagesMap.put("ic_sports_category.png",
				Integer.valueOf(R.drawable.ic_sports_category));
		this.categoryImagesMap.put("ic_technology_category.png",
				Integer.valueOf(R.drawable.ic_technology_category));
		this.categoryImagesMap.put("ic_verbs_category.png",
				Integer.valueOf(R.drawable.ic_verbs_category));
	}
}