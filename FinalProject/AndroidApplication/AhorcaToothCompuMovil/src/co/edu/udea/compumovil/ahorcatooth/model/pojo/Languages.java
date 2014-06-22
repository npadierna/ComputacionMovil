package co.edu.udea.compumovil.ahorcatooth.model.pojo;

import java.io.Serializable;

public class Languages implements Serializable {

	private static final long serialVersionUID = 1880614879702762208L;

	private String isoCode;

	private String tongue;

	private String description;
	private Category category;

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

	public Category getCategory() {

		return (this.category);
	}

	public void setCategory(Category category) {
		this.category = category;
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

		return ("co.edu.udea.compumovil.ahorcatooth.model.entity.Languages[ isoCode="
				+ this.getIsoCode() + " ]");
	}
}