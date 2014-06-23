package co.edu.udea.compumovil.ahorcatooth.model.pojo;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class HangmanWord implements Parcelable, Serializable {

	private static final long serialVersionUID = 6812014168916091904L;

	private Long id;
	private String wordName;
	private String description;
	private Category category;

	public HangmanWord() {
		super();
	}

	public HangmanWord(Parcel parcel) {
		this.setId(parcel.readLong());
		this.setWordName(parcel.readString());
		this.setDescription(parcel.readString());
	}

	public HangmanWord(Long id, String wordName) {
		this.id = id;
		this.wordName = wordName;
	}

	public Long getId() {

		return (this.id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWordName() {

		return (this.wordName);
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public String getDescription() {

		return (this.description);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {

		return (this.category);
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override()
	public int describeContents() {

		return (0);
	}

	@Override()
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeLong(this.getId());
		dest.writeString(this.getWordName());
		dest.writeString(this.getDescription());
	}

	@Override()
	public int hashCode() {
		int hash = 0;

		hash += ((this.getId() != null) ? this.getId().hashCode() : 0);

		return (hash);
	}

	@Override()
	public boolean equals(Object object) {
		if (!(object instanceof HangmanWord)) {

			return (false);
		}

		HangmanWord other = (HangmanWord) object;
		if (((this.getId() == null) && (other.getId() != null))
				|| ((this.getId() != null) && !(this.getId().equals(other
						.getId())))) {

			return (false);
		}

		return (true);
	}

	@Override()
	public String toString() {

		return ("co.edu.udea.compumovil.ahorcatooth.model.pojo.HangmanWord[ id="
				+ this.getId() + " ]");
	}

	public static final Parcelable.Creator<HangmanWord> CREATOR = new Parcelable.Creator<HangmanWord>() {

		@Override()
		public HangmanWord createFromParcel(Parcel source) {

			return (new HangmanWord(source));
		}

		@Override()
		public HangmanWord[] newArray(int size) {

			return (new HangmanWord[size]);
		}
	};
}