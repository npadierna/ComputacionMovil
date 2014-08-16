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
public class Languages implements Parcelable, Serializable {

	private static final long serialVersionUID = 1880614879702762208L;

	private static final String ISO_CODE = "isoCode";
	private static final String TONGUE = "tongue";
	private static final String DESCRIPTION = "description";

	private String isoCode;
	private String tongue;
	private String description;
	private List<Category> categoryList;

	public Languages() {
		super();
	}

	public Languages(JSONObject jsonObject) throws JSONException {
		this.setIsoCode(jsonObject.getString(ISO_CODE));
		this.setTongue(jsonObject.getString(TONGUE));

		if (jsonObject.has(DESCRIPTION)) {
			this.setDescription(jsonObject.getString(DESCRIPTION));
		}
	}

	public Languages(Parcel parcel) {
		this.setIsoCode(parcel.readString());
		this.setTongue(parcel.readString());
		this.setDescription(parcel.readString());
	}

	public Languages(String isoCode, String tongue) {
		this.isoCode = isoCode;
		this.tongue = tongue;
	}

	public String getIsoCode() {

		return (this.isoCode);
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getTongue() {

		return (this.tongue);
	}

	public void setTongue(String tongue) {
		this.tongue = tongue;
	}

	public String getDescription() {

		return (this.description);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getCategoryList() {

		return (this.categoryList);
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	@Override()
	public int describeContents() {

		return (0);
	}

	@Override()
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.getIsoCode());
		dest.writeString(this.getTongue());
		dest.writeString(this.getDescription());
	}

	@Override()
	public int hashCode() {
		int hash = 0;

		hash += ((this.getIsoCode() != null) ? this.getIsoCode().hashCode() : 0);

		return (hash);
	}

	@Override()
	public boolean equals(Object object) {
		if (!(object instanceof Languages)) {

			return (false);
		}

		Languages other = (Languages) object;
		if (((this.getIsoCode() == null) && (other.getIsoCode() != null))
				|| ((this.getIsoCode() != null) && !(this.getIsoCode()
						.equals(other.getIsoCode())))) {

			return (false);
		}

		return (true);
	}

	@Override()
	public String toString() {

		return ("co.edu.udea.compumovil.ahorcatooth.model.pojo.Languages[ isoCode="
				+ this.getIsoCode() + " ]");
	}

	public static final Parcelable.Creator<Languages> CREATOR = new Parcelable.Creator<Languages>() {

		@Override()
		public Languages createFromParcel(Parcel source) {

			return (new Languages(source));
		}

		@Override()
		public Languages[] newArray(int size) {

			return (new Languages[size]);
		}
	};
}