package bitchanger.gui.scenes;

import java.util.HashMap;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public interface Controllable {
	
	public HashMap<String, TextField> getTextFields();
	public HashMap<String, Button> getButtons();

}