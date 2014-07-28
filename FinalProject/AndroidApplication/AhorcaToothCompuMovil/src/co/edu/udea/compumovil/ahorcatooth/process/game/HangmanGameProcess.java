package co.edu.udea.compumovil.ahorcatooth.process.game;

public class HangmanGameProcess {

	public long score;

	private String hangmanWordName;
	private String mask;

	private GameStatusEnum gameStatusEnum;

	public HangmanGameProcess(long score, String hangmanWordName, String mask) {
		this.setScore(score);
		this.setHangmanWordName(hangmanWordName);
		this.setMask(mask);
		this.setGameStatusEnum(GameStatusEnum.STARTED_GAME);
	}

	public long getScore() {

		return (this.score);
	}

	public void setScore(long score) {
		this.score = score;
	}

	public String getHangmanWordName() {

		return (this.hangmanWordName);
	}

	public void setHangmanWordName(String hangmanWordName) {
		this.hangmanWordName = hangmanWordName;
	}

	public String getMask() {

		return (this.mask);
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public GameStatusEnum getGameStatusEnum() {

		return (this.gameStatusEnum);
	}

	public void setGameStatusEnum(GameStatusEnum gameStatusEnum) {
		this.gameStatusEnum = gameStatusEnum;
	}

	public String maskWord() {
		StringBuilder stringBuilder = new StringBuilder(
				this.getHangmanWordName());

		for (int i = 0; i < this.getHangmanWordName().length(); i++) {
			stringBuilder.setCharAt(i, this.getMask().charAt(0));
		}

		return (stringBuilder.toString());
	}

	public String revealLetter(String currentHangmanWordStatus, char letter) {
		StringBuilder wordStringBuilder = new StringBuilder(
				currentHangmanWordStatus);

		boolean wasIn = false;
		int index = this.getHangmanWordName().indexOf(letter, 0);
		while (index != -1) {
			wordStringBuilder.setCharAt(index, letter);
			index = this.getHangmanWordName().indexOf(letter, (index + 1));
			wasIn = true;
		}

		if (!wasIn) {
			this.setGameStatusEnum(GameStatusEnum.findNextHangmanStatus(this
					.getGameStatusEnum()));
		} else {
			if (wordStringBuilder.indexOf(this.getMask()) == -1) {
				this.setGameStatusEnum(GameStatusEnum.FINISHED_GAME);
			}
		}

		return (wordStringBuilder.toString());
	}
}