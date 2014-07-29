package co.edu.udea.compumovil.ahorcatooth.process.game;

public enum GameStatusEnum {

	STARTED_GAME((short) 0), HEAD((short) 1), BODY((short) 2), RIGHT_ARM(
			(short) 3), LEFT_ARM((short) 4), RIGHT_LEG((short) 5), LEFT_LEG(
			(short) 6);

	private short statusId;

	private GameStatusEnum(Short statusId) {
		this.setStatusId(statusId);
	}

	public static GameStatusEnum findNextHangmanStatus(
			GameStatusEnum currentGameStatusEnum) {
		switch (currentGameStatusEnum) {
		case STARTED_GAME:
			return (HEAD);

		case HEAD:
			return (BODY);

		case BODY:
			return (RIGHT_ARM);

		case RIGHT_ARM:
			return (LEFT_ARM);

		case LEFT_ARM:
			return (RIGHT_LEG);

		case RIGHT_LEG:
			return (LEFT_LEG);

		default:
			return (null);
		}
	}

	public short getStatusId() {

		return (this.statusId);
	}

	private void setStatusId(short statusId) {
		this.statusId = statusId;
	}
}