package co.edu.udea.compumovil.ahorcatooth.model.pojo;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryPK implements Parcelable, Serializable {

	private static final long serialVersionUID = 4154606141448857600L;

	private String categoryName;
	private String languagesIsoCode;

	public CategoryPK() {
		super();
	}

	public CategoryPK(Parcel parcel) {
		this.setCategoryName(parcel.readString());
		this.setLanguagesIsoCode(parcel.readString());
	}

	public CategoryPK(String categoryName, String languagesIsoCode) {
		this.categoryName = categoryName;
		this.languagesIsoCode = languagesIsoCode;
	}

	public String getCategoryName() {

		return (this.categoryName);
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getLanguagesIsoCode() {

		return (this.languagesIsoCode);
	}

	public void setLanguagesIsoCode(String languagesIsoCode) {
		this.languagesIsoCode = languagesIsoCode;
	}

	@Override()
	public int describeContents() {

		return (0);
	}

	@Override()
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.getCategoryName());
		dest.writeString(this.getLanguagesIsoCode());
	}

	@Override()
	public int hashCode() {
		int hash = 0;

		hash += ((this.getCategoryName() != null) ? this.getCategoryName()
				.hashCode() : 0);
		hash += ((this.getLanguagesIsoCode() != null) ? this
				.getLanguagesIsoCode().hashCode() : 0);

		return (hash);
	}

	@Override()
	public boolean equals(Object object) {
		if (!(object instanceof CategoryPK)) {

			return (false);
		}

		CategoryPK other = (CategoryPK) object;
		if (((this.getCategoryName() == null) && (other.getCategoryName() != null))
				|| ((this.getCategoryName() != null) && !(this
						.getCategoryName().equals(other.getCategoryName())))) {

			return (false);
		}

		if (((this.getLanguagesIsoCode() == null) && (other
				.getLanguagesIsoCode() != null))
				|| ((this.getLanguagesIsoCode() != null) && !(this
						.getLanguagesIsoCode().equals(other
						.getLanguagesIsoCode())))) {

			return (false);
		}

		return (true);
	}

	@Override()
	public String toString() {

		return ("co.edu.udea.compumovil.ahorcatooth.model.pojo.CategoryPK[ categoryName="
				+ this.getCategoryName()
				+ ", languagesIsoCode="
				+ this.getLanguagesIsoCode() + " ]");
	}

	public static final Parcelable.Creator<CategoryPK> CREATOR = new Parcelable.Creator<CategoryPK>() {

		@Override()
		public CategoryPK createFromParcel(Parcel source) {

			return (new CategoryPK(source));
		}

		@Override()
		public CategoryPK[] newArray(int size) {

			return (new CategoryPK[size]);
		}
	};
}