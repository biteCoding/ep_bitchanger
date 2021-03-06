/*
 * Copyright (c) 2020 - Tim Muehle und Moritz Wolter
 * 
 * Entwicklungsprojekt im Auftrag von Professorin K. Brabender und Herrn A. Koch
 * Entwickelt fuer das AID-Labor der Hochschule Bochum
 * 
 */

package bitchanger.gui.controls;

import java.util.Objects;

import bitchanger.gui.controller.ControllableApplication;
import bitchanger.gui.controller.Controller;
import bitchanger.gui.controller.ConverterMenuController;
import bitchanger.preferences.Preferences;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;

//TODO JavaDoc
/**	<!-- $LANGUAGE=DE -->
 * 
 * @author Tim M\u00FChle
 * 
 * @since Bitchanger 0.1.4
 * @version 0.1.6
 * 
 */
public class ConverterMenuBar extends BasicMenuBar {

	/** <!-- $LANGUAGE=DE -->	Schl\u00FCsselwort, mit dem das CheckMenuItem "abgeschnittene Nachkommastellen kennzeichnen" in der Map {@link #menuItemMap} abgelegt ist */
	/* <!-- $LANGUAGE=EN -->	Key with which the CheckMenuItem "abgeschnittene Nachkommastellen kennzeichnen" is associated in the Map {@link #menuItemMap} */
	public static final String OPTIONS_INDICATE_FRACTIONAL_INACCURACY_CHECK_ITEM_KEY = "modus-indicate-fractional-inaccuracy-item";
	
	
	
//	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
//  #																																 #
// 	#	class initialization																										 #
//  #																																 #
//  ##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##

	static {
		// Controller Klasse zuordnen
		Controller.register(ConverterMenuBar.class, ConverterMenuController.class);
	}
	
	
	
//	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
//  #																																 #
// 	#	Instances   																												 #
//  #																																 #
//  ##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##

//	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
//  #																																 #
// 	#	Constructors	   																											 #
//  #																																 #
//  ##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
	
	
	// TODO JavaDoc
	public ConverterMenuBar() {
		super();

		addItems();
	}
	
	
	// TODO JavaDoc
	public ConverterMenuBar(ControllableApplication controllableApp) throws NullPointerException {
		this();
		Objects.requireNonNull(controllableApp);
		
		Controller controller = new ConverterMenuController(this, controllableApp);
		controller.setActions();
	}

	
	
//	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
//  #																																 #
// 	#	private Methods   																											 #
//  #																																 #
//  ##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
	
	
	// TODO JavaDoc
	private void addItems() {
		CheckMenuItem indicateFractionalInaccuracy = new CheckMenuItem("abgeschnittene Nachkommastellen kennzeichnen");
		indicateFractionalInaccuracy.setSelected(Preferences.getPrefs().indicateFractionalPrecision());
		
		this.menuItemMap.put(OPTIONS_INDICATE_FRACTIONAL_INACCURACY_CHECK_ITEM_KEY, indicateFractionalInaccuracy);
		((Menu) this.menuItemMap.get(BasicMenuBar.OPTIONS_MENU_KEY)).getItems().add(indicateFractionalInaccuracy);
	}

}










