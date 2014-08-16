package co.edu.udea.compumovil.ahorcatooth.model.pojo;

import java.io.Serializable;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public class Category implements Parcelable, Serializable {

	private static final long serialVersionUID = 2350741601449118720L;

	private static final String CATEGORY_PK = "categoryPK";
	private static final String IMAGE_NAME = "imageName";
	private static final String DESCRIPTION = "description";

	protected CategoryPK categoryPK;
	private String imageName;
	private String description;
	private Languages languages;
	private List<HangmanWord> hangmanWordList;

	public Category() {
		super();
	}

	public Category(JSONObject jsonObject) throws JSONException {
		this.setCategoryPK(new CategoryPK(jsonObject.getJSONObject(CATEGORY_PK)));
		this.setImageName(jsonObject.getString(IMAGE_NAME));

		if (jsonObject.has(DESCRIPTION)) {
			this.setDescription(jsonObject.getString(DESCRIPTION));
		}
	}

	public Category(Parcel parcel) {
		this.setCategoryPK((CategoryPK) parcel.readParcelable(CategoryPK.class
				.getClassLoader()));
		this.setImageName(parcel.readString());
		this.setDescription(parcel.readString());
	}

	public Category(CategoryPK categoryPK, String imageName) {
		this.categoryPK = categoryPK;
		this.imageName = imageName;
	}

	public Category(String categoryName, String languagesIsoCode,
			String imageName) {
		this.categoryPK = new CategoryPK(categoryName, languagesIsoCode);
		this.imageName = imageName;
	}

	public CategoryPK getCategoryPK() {

		return (this.categoryPK);
	}

	public void setCategoryPK(CategoryPK categoryPK) {
		this.categoryPK = categoryPK;
	}

	public String getImageName() {

		return (this.imageName);
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getDescription() {

		return (this.description);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Languages getLanguages() {

		return (this.languages);
	}

	public void setLanguages(Languages languages) {
		this.languages = languages;
	}

	public List<HangmanWord> getHangmanWordList() {

		return (this.hangmanWordList);
	}

	public void setHangmanWordList(List<HangmanWord> hangmanWordList) {
		this.hangmanWordList = hangmanWordList;
	}

	@Override()
	public int describeContents() {

		return (0);
	}

	@Override()
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(this.getCategoryPK(), 0);
		dest.writeString(this.getImageName());
		dest.writeString(this.getDescription());
	}

	@Override()
	public int hashCode() {
		int hash = 0;

		hash += ((this.getCategoryPK() != null) ? this.getCategoryPK()
				.hashCode() : 0);

		return (hash);
	}

	@Override()
	public boolean equals(Object object) {
		if (!(object instanceof Category)) {

			return (false);
		}

		Category other = (Category) object;
		if (((this.getCategoryPK() == null) && (other.getCategoryPK() != null))
				|| ((this.getCategoryPK() != null) && !(this.getCategoryPK()
						.equals(other.getCategoryPK())))) {

			return (false);
		}

		return (true);
	}

	@Override()
	public String toString() {

		return ("co.edu.udea.compumovil.ahorcatooth.model.pojo.Category[ categoryPK="
				+ this.getCategoryPK() + " ]");
	}

	public static final Parcelable.Creator<Category> CREATOR = new Parcelable.Creator<Category>() {

		@Override()
		public Category createFromParcel(Parcel source) {

			return (new Category(source));
		}

		@Override()
		public Category[] newArray(int size) {

			return (new Category[size]);
		}
	};
}