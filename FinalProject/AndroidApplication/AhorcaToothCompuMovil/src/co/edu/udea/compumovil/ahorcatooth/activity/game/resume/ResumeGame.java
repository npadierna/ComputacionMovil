package co.edu.udea.compumovil.ahorcatooth.activity.game.resume;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public final class ResumeGame implements Parcelable, Serializable {

	private static final long serialVersionUID = 3390331134986238607L;

	private boolean won;
	private long finalScore;
	private long finalTime;
	private String hangmanWord;

	public ResumeGame(Parcel parcel) {
		this((Boolean) parcel.readValue(Boolean.class.getClassLoader()), parcel
				.readLong(), parcel.readLong(), parcel.readString());
	}

	public ResumeGame(boolean won, long finalScore, long finalTime,
			String hangmanWord) {
		this.setFinalScore(finalScore);
		this.setFinalTime(finalTime);
		this.setHangmanWord(hangmanWord);
		this.setWon(won);
	}

	public boolean isWon() {

		return (this.won);
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public long getFinalScore() {

		return (this.finalScore);
	}

	public void setFinalScore(long finalScore) {
		this.finalScore = finalScore;
	}

	public long getFinalTime() {

		return (this.finalTime);
	}

	public void setFinalTime(long finalTime) {
		this.finalTime = finalTime;
	}

	public String getHangmanWord() {

		return (this.hangmanWord);
	}

	public void setHangmanWord(String hangmanWord) {
		this.hangmanWord = hangmanWord;
	}

	@Override()
	public int describeContents() {

		return (0);
	}

	@Override()
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(Boolean.valueOf(this.isWon()));
		dest.writeLong(this.getFinalScore());
		dest.writeLong(this.getFinalTime());
		dest.writeString(this.getHangmanWord());
	}

	public static final Parcelable.Creator<ResumeGame> CREATOR = new Parcelable.Creator<ResumeGame>() {

		@Override()
		public ResumeGame createFromParcel(Parcel source) {

			return (new ResumeGame(source));
		}

		@Override()
		public ResumeGame[] newArray(int size) {

			return (new ResumeGame[size]);
		}
	};
}