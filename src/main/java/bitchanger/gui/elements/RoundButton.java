package bitchanger.gui.elements;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RoundButton extends Button{

	// Konstruktoren	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
	public RoundButton() {
		super();
		initShape();
	}

	public RoundButton(String text, Node graphic) {
		super(text, graphic);
		initShape();
	}

	public RoundButton(String text) {
		super(text);
		initShape();
	}
	
	
	// Methoden	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
	private void initShape() {
		// TODO REMOVE LATER (Nur zu Testzwecken!!!)	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!	!!
		this.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
	
	/*	Ellipse shape = new Ellipse();
		this.setShape(shape);
	*/	
		Rectangle shape = new Rectangle(50, 50);
		shape.setArcHeight(0);
		shape.setArcWidth(0);
		this.setShape(shape);
		setScaleShape(true);
		
	/*	// Rundung an Groesse binden (auskommentieren, um Rundung zu loeschen)
		shape.arcHeightProperty().bind(widthProperty().divide(4));
		shape.arcWidthProperty().bind(heightProperty().divide(4));
	*/
	}
	

}
