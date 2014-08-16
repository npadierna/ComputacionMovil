package co.edu.udea.compumovil.ahorcatooth.process.game;

import co.edu.udea.compumovil.ahorcatooth.R;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public enum GameStatusEnum {

	STARTED_GAME(R.drawable.ic_started_game), HEAD(R.drawable.ic_head), BODY(
			R.drawable.ic_chest), RIGHT_ARM(R.drawable.ic_right_arm), LEFT_ARM(
			R.drawable.ic_left_arm), RIGHT_LEG(R.drawable.ic_right_leg), LEFT_LEG(
			R.drawable.ic_left_leg);

	private int resourceId;

	private GameStatusEnum(int statusId) {
		this.setResourceId(statusId);
	}

	public static GameStatusEnum findNextHangmanStatus(
			GameStatusEnum currentGameStatusEnum) {
		switch (currentGameStatusEnum) {
		case STARTED_GAME:
			return (HEAD);

		case HEAD:
			return (BODY);

		case BODY:
			return (LEFT_ARM);

		case RIGHT_ARM:
			return (LEFT_LEG);

		case LEFT_ARM:
			return (RIGHT_ARM);

		case LEFT_LEG:
		case RIGHT_LEG:
			return (RIGHT_LEG);
		}

		return (RIGHT_LEG);
	}

	public int getResouceId() {

		return (this.resourceId);
	}

	private void setResourceId(int resouceId) {
		this.resourceId = resouceId;
	}
}