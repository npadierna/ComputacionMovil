package co.edu.udea.compumovil.ahorcatooth.process.bluetooth.enums;

/**
 * 
 * 
 * @author Neiber Padierna P&eacute;rez
 * @author Yefry Alexis Calder&oacute;n Yepes
 */
public enum HangmanBluetoothStateEnum {

	NOTHING(0, "The Bluetooth Hardware is doing nothing."), LISTENING(1,
			"The Bluetooth Hardware is listening for incoming connections."), CONNECTING(
			2, "The Bluetooth Hardware is initiating an outgoing connection."), CONNECTED(
			3,
			"The Bluetooth Hardware is connected to a remote Bluetooth Device.");

	private int state;

	private String description;

	private HangmanBluetoothStateEnum(int state, String description) {
		this.setState(state);
		this.setDescription(description);
	}

	public static HangmanBluetoothStateEnum findByState(int state) {
		for (HangmanBluetoothStateEnum hangmanBluetoothStateEnum : HangmanBluetoothStateEnum
				.values()) {
			if (hangmanBluetoothStateEnum.getState() == state) {

				return (hangmanBluetoothStateEnum);
			}
		}

		return (null);
	}

	public int getState() {

		return (this.state);
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getDescription() {

		return (this.description);
	}

	public void setDescription(String description) {
		this.description = description;
	}
}