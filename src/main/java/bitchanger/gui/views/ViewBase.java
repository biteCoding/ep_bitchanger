/*
 * Copyright (c) 2020 - Tim Muehle und Moritz Wolter
 * 
 * Entwicklungsprojekt im Auftrag von Professorin K. Brabender und Herrn A. Koch
 * Entwickelt fuer das AID-Labor der Hochschule Bochum
 * 
 */

package bitchanger.gui.views;

import java.util.HashMap;
import java.util.Map;

import bitchanger.gui.controller.Controller;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**	<!-- $LANGUAGE=DE -->
 * 
 * Basis-Klasse f\u00FCr alle View-Klassen, die das Interface {@code Viewable} implementieren und mit einem
 * Controller eine Funktion erhalten.
 * <p>
 * Die grundlegenden Methoden der Schnittstellen {@code Viewable} und {@code Controllable} sind bereits implementiert.
 * Die dazugeh\u00F6rigen Attribute sind mit protected gesch\u00FCtzt, damit diese direkt in Unterklassen verwendet werden k\u00F6nnen.
 * </p>
 * <p>
 * Es werden abstrakte Methoden definiert, die zur Erstellung des Scenegraphens ben\u00F6tigt werden.
 * </p>
 * 
 * @param <T> Typ des Wurzelknotens im Scenegraphen
 * 
 * @author Tim M\u00FChle
 * 
 * @since Bitchanger 0.1.0
 * @version 0.1.8
 *
 */
//TODO JavaDoc EN
public abstract class ViewBase<T extends Parent> implements Viewable {
	
//	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
//  #																																 #
// 	#	Fields			   																											 #
//  #																																 #
//  ##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##

// protected	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
	
	/** <!-- $LANGUAGE=DE --> Szene, die von der View repr\u00E4sentiert wird */
	// TODO JavaDoc EN
	protected final Scene scene;
	
	/** <!-- $LANGUAGE=DE --> Wurzelknoten im Scenegraph */
	// TODO JavaDoc EN
	protected final T root;
	
	/** <!-- $LANGUAGE=DE --> 
	 * Controller, der die Funktion zu den Bedienelementen hinzuf\u00FCgt. 
	 */
	// TODO JavaDoc EN
	protected Controller controller;
	
	/** <!-- $LANGUAGE=DE --> MenuBar des Scenegraphen */
	// TODO JavaDoc EN
	protected MenuBar menubar;
	
	/** <!-- $LANGUAGE=DE --> Property f\u00FCr die maximale H\u00F6he der Buttons in dieser View */
	// TODO JavaDoc EN
	protected final DoubleProperty maxHeightProperty;

	/** <!-- $LANGUAGE=DE --> Property f\u00FCr die minimale H\u00F6he der Buttons in dieser View */
	// TODO JavaDoc EN
	protected final DoubleProperty minHeightProperty;

	/** <!-- $LANGUAGE=DE --> Property f\u00FCr die maximale Breite der Buttons in dieser View */
	// TODO JavaDoc EN
	protected final DoubleProperty maxWidthProperty;

	/** <!-- $LANGUAGE=DE --> Property f\u00FCr die minimale Breite der Buttons in dieser View */
	// TODO JavaDoc EN
	protected final DoubleProperty minWidthProperty;
	
	
// private	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##

	/** <!-- $LANGUAGE=DE -->
	 * {@code Map}, in die alle vom Controller ben\u00F6tigten Textfelder der View 
	 * mit einem eindeutigen Schl\u00FCssel abgelegt werden */
	// TODO JavaDoc EN
	private final Map<String, TextField> tfMap;	// Hiermit koennen die entsprechenden TFs direkt gesucht werden -> hilfreich fuer Actions!
	
	/** <!-- $LANGUAGE=DE --> 
	 * {@code Map}, in die alle vom Controller ben\u00F6tigten Buttons der View mit 
	 * einem eindeutigen Schl\u00FCssel abgelegt werden */
	// TODO JavaDoc EN
	private final Map<String, Button> btnMap;
	
	/** <!-- $LANGUAGE=DE --> 
	 * {@code Map}, in die alle vom Controller ben\u00F6tigten Elemente der View mit einem 
	 * eindeutigen Schl\u00FCssel abgelegt werden, die keine Buttons oder Textfelder sind */
	// TODO JavaDoc EN
	private final Map<String, Node> nodeMap;
	
	
	
//	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
//  #																																 #
// 	#	Constructors	   																											 #
//  #																																 #
//  ##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##

	
	/** <!-- $LANGUAGE=DE -->
	 * Erzeugt eine neue View, die eine neue {@code Scene} mit dem \u00FCbergebenen Wurzelknoten {@code root} kapselt.
	 * <p>
	 * Nach der Initialisierung der Attribute werden nacheinander die Methoden {@link #init()} und {@link #createScenegraph()} 
	 * aufgerufen, um den Scenegraphen zu konstruieren und im Anschluss wird mit Hilfe eines Controllers die Funktion der Bedienelemente 
	 * hinzugef\u00FCgt, wenn ein passender Controller registriert wurde.
	 * </p>
	 * 
	 * @param root	Wurzelknoten des Scenegraphen
	 * 
	 * @see #init()
	 * @see #createScenegraph()
	 * @see #buildScenegraph()
	 */
	// TODO JavaDoc EN
	public ViewBase(T root) {
		this(root, true);
	}
	
// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*

	/** <!-- $LANGUAGE=DE -->
	 * Erzeugt eine neue View, die eine neue {@code Scene} mit dem \u00FCbergebenen Wurzelknoten {@code root} kapselt.
	 * <p>
	 * Nach der Initialisierung der Attribute werden nacheinander die Methoden {@link #init()} und ggf. {@link #buildScenegraph()} 
	 * aufgerufen, um den Scenegraphen zu konstruieren und im Anschluss wird mit Hilfe eines Controllers die Funktion der Bedienelemente 
	 * hinzugef\u00FCgt, wenn ein passender Controller registriert wurde.
	 * </p>
	 * 
	 * @param root				Wurzelknoten des Scenegraphen
	 * @param buildScenegraph	{@code true}, wenn der Scenegraph mit der Methode {@link #buildScenegraph()} erstellt und ein Controller
	 * 							erzeugt werden soll, sonst {@code false}
	 * 
	 * @see #buildScenegraph()
	 */
	// TODO JavaDoc EN
	public ViewBase(T root, boolean buildScenegraph) {
		this.root = root;
		this.scene = new Scene(this.root);
		
		this.tfMap = new HashMap<String, TextField>();
		this.btnMap = new HashMap<String, Button>();
		this.nodeMap = new HashMap<String, Node>();
		
		this.minHeightProperty = new SimpleDoubleProperty();
		this.maxHeightProperty = new SimpleDoubleProperty();
		this.minWidthProperty = new SimpleDoubleProperty();
		this.maxWidthProperty = new SimpleDoubleProperty();
		
		init();
		
		if(buildScenegraph) {
			buildScenegraph();
		}
	}

	
	
//	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
//  #																																 #
// 	#	Getter and Setter																											 #
//  #																																 #
//  ##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##

	
	/** {@inheritDoc} */
	@Override
	public final Scene getScene() {
		return scene;
	}
	
// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*

	/** {@inheritDoc} */
	@Override
	public final Map<String, TextField> getTextFieldMap() {
		return tfMap;
	}

// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*

	/** {@inheritDoc} */
	@Override
	public final Map<String, Button> getButtonMap() {
		return btnMap;
	}
	
// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*

	/** {@inheritDoc} */
	@Override
	public final Map<String, Node> getNodeMap() {
		return nodeMap;
	}
	
// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*

	/**  <!-- $LANGUAGE=DE -->
	 * {@inheritDoc}
	 * 
	 * <p><b>
	 * Wenn der Wurzelknoten dieser View eine Instanz von BorderPane ist, wird
	 * die \u00FCbergebene MenuBar in Top gelegt, ansonsten wird nur die alte MenuBar
	 * entfernt.
	 * </b></p>
	 */
	/*  <!-- $LANGUAGE=EN -->
	 * {@inheritDoc}
	 * 
	 * <p><b>
	 * If root is an instance of BorderPane the MenuBar is placed in Top, 
	 * otherwise only the old MenuBar is removed.
	 * </b></p>
	 */
	@Override
	public <V extends MenuBar> void setMenuBar(V menubar) {
		if(! (root instanceof Pane)) {
			return;
		}
		
		((Pane)root).getChildren().remove(this.menubar);
		this.menubar = menubar;
		
		if(menubar == null) {
			return;
		}
		
		if(root instanceof BorderPane) {
			((BorderPane) root).setTop(menubar);
		}
	}

// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*

	/** {@inheritDoc} */
	@Override
	public DoubleProperty maxHeigthProperty() {
		return this.maxHeightProperty;
	}

// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*

	/** {@inheritDoc} */
	@Override
	public DoubleProperty maxWidthProperty() {
		return this.maxWidthProperty;
	}

// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*

	/** {@inheritDoc} */
	@Override
	public DoubleProperty minHeigthProperty() {
		return this.minHeightProperty;
	}

// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*
	
	/** {@inheritDoc} */
	@Override
	public DoubleProperty minWidthProperty() {
		return this.minWidthProperty;
	}

	
	
//	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
//  #																																 #
// 	#	Methods   																													 #
//  #																																 #
//  ##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
	
	
	/** <!-- $LANGUAGE=DE -->
	 * Initialisierungsmethode. 
	 * <b> Diese Methode wird als erstes vom Konstruktor aufgerufen, nachdem die Attribute initialisiert wurden. </b>
	 * <p>
	 * Unterklassen k\u00F6nnen diese Methode \u00FCberschreiben, um Attribute vor der Konstruktion des Scenegraphen zu initialisieren.
	 * </p>
	 * <p>
	 * Die Implementierung der Methode in dieser Klasse hat keine Anweisungen.
	 * </p>
	 */
	// TODO JavaDoc EN
	protected void init() {
		// nothing to do
	}
	
// 	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*	*

	/** <!-- $LANGUAGE=DE -->
	 * Konstruiert den Scenegraphen mit der Methode {@link #createScenegraph()} und gibt den Bedienelementen mit einem
	 * Controller eine Funktion, falls ein passender Controller mit {@link Controller#register(Class, Class)} registriert
	 * wurde.
	 * 
	 * @see #createScenegraph()
	 */
	// TODO JavaDoc EN
	protected void buildScenegraph() {
		createScenegraph();
		
		this.controller = Controller.of(this);
		
		if(controller != null) {
			controller.setActions();
		}
	}
	
	
	
//	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
//  #																																 #
// 	#	abstract methods   																											 #
//  #																																 #
//  ##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##	##
	
	
	/** <!-- $LANGUAGE=DE -->
	 * Methode, die den Scenegraphen konstruiert. <b> Diese Methode wird aufgerufen, nachdem die init-Methode beendet wurde. </b>
	 * <p>
	 * In dieser Methode m\u00FCssen alle Bedien- und Oberfl\u00E4chenelemente zum Scenegraphen hinzugef\u00FCgt werden. Alle Elemente, die 
	 * auch im Controller ben\u00F6tigt werden, m\u00FCssen zu der entsprechenden Map hinzugef\u00FCgt werden: 
	 * {@link #btnMap}, {@link #tfMap}, {@link #nodeMap}
	 * </p>
	 */
	// TODO JavaDoc EN
	protected abstract void createScenegraph();
	
}









