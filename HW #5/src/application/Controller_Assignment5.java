package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javax.xml.bind.JAXB;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class Controller_Assignment5 {
	
/**
 * Enum constants which defines the size of the pen i.e small, medium, large, xlarge
 * Constants defined such as the size of small(2pts), medium (6pts), large(10pts), xlarge(14pts)
 * Methods are non-default constructors
 */
    private enum PenSize {
        SMALL(2),
        MEDIUM(6),
        LARGE(10),
        XLARGE(14);
    	
        final int radius;
        PenSize(int radius) { // constructor 
            this.radius = radius;
        }
    }
/**
 * Enum constants which sets the color of the pen i.e black, red, green, blue, brown
 * Constants are the colors, black, red, green, blue, brown
 * Methods are non-default constructors 
*/
    private enum DrawColor {
        BLACK(Color.BLACK),
        RED(Color.RED),
        GREEN(Color.GREEN),
        BLUE(Color.BLUE),
        BROWN(Color.BROWN);
    	
        final Color color;
        DrawColor(Color color) { // constructor 
            this.color = color;
        }
    }
    /**
     * instance variables for managing Painter state
    */
    private PenSize penSize = PenSize.MEDIUM; // radius of circle
    private DrawColor drawColor = DrawColor.BLACK; // drawing color 
    /**
     * instance variable that refer to GUI components
    */
    @FXML
    private RadioButton rbBlack;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private ToggleGroup tgColor;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private RadioButton rbGreen;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private RadioButton rbRed;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private RadioButton rbBlue;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private RadioButton rbBrown;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private RadioButton rbSmall;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private ToggleGroup tgPenSize;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private RadioButton rbMed;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private RadioButton rbLarge;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private RadioButton rbXLarg;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private Button btnSerial;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private Button btnUndo;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private Button btnClear;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private Pane panelDraw;
    /**
     * instance variables that refer to GUI components
    */
    @FXML
    private Slider Blue;
   
    /**
     * @param event - takes in one parameter of type event
     * This method will draw a circle in the specified color and size for each mouse-dragged event.
     * Handle's drawing area onMouseDragged MouseEvent
     */
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	
        panelDraw.getChildren().add(new Circle(event.getX(), event.getY(), penSize.radius, drawColor.color));

    }
    /**
     * @param event - takes in one parameter of type event
     * @radio button - when Drawing Color radio button is pressed it changes the color of the text
     * i.e. when the color black is selected, the drawColor is set to the color black
     */
    @FXML
    void colorChangeEventHandler(ActionEvent event) {
        if (rbBlack.isSelected())
            drawColor = DrawColor.BLACK;
        else if (rbGreen.isSelected())
            drawColor = DrawColor.GREEN;
        else if (rbRed.isSelected())
            drawColor = DrawColor.RED;
        else if (rbBlue.isSelected())
            drawColor = DrawColor.BLUE;
        else
        	drawColor = DrawColor.BROWN;
    }
    
    /**
     * @param event - takes in one parameter of type event
     * @radio button - when pensize radio button is pressed it changes the pensize
     * i.e. when medium.isSelected(), it sets the pens size to medium
     */
    @FXML
    void penSizeChangeEventHandler(ActionEvent event) {

        if (rbSmall.isSelected())
            penSize = PenSize.SMALL;
        else if (rbMed.isSelected())
            penSize = PenSize.MEDIUM;
        else if (rbLarge.isSelected())
            penSize = PenSize.LARGE;
        else 
        	penSize = PenSize.XLARGE;
    }
    
    /**
     * @param event - takes in one parameter of type event
     * @undo button - when undo button is pressed it undo's the last step
     * Handle's undo button's ActionEvent
     */
    @FXML
    void undoButtonEventHandler(ActionEvent event) {
        panelDraw.getChildren().remove(panelDraw.getChildren().size() - 1);
    }
    
    /**
     * @param event - takes in one parameter of type event
     * @clear button - when clear button is pressed it clears the whole screen
     * Handle's clear button's ActionEvent
     */
    @FXML
    void clearButtonEventHandler(ActionEvent event) {
        panelDraw.getChildren().clear();
    }
    
    /**
     * @param event - takes in one parameter of type event
     * @radio button - when Serialized to XML radio button is pressed it serializes to XML
     * When the button is clicked it will allow for the selection of an XML file
     * Serializes all drawn circles into the selected XML file
     */    
    @FXML
    void SerialButtonEventHandler(ActionEvent event) {
    		FileChooser fc = new FileChooser();
    		fc.setTitle("Save new file to");
    		fc.getExtensionFilters().addAll(new ExtensionFilter("XML_File"," .XML"));
    		File file= fc.showSaveDialog(null);
    		ListA5Shape list = new ListA5Shape();
    		for (int i = panelDraw.getChildren().size()-1;i >= 0 ; i--) {
    			Circle circle = (Circle) panelDraw.getChildren().get(i);
    			A5Shape shape = new A5Shape(circle.getCenterX(),circle.getCenterY(),circle.getRadius());
    			list.getShapeLists().add(shape);
    		}
    		try {
    			BufferedWriter output = Files.newBufferedWriter(Paths.get(file.getName()));
    			JAXB.marshal(list, output);
    			output.close();
    		}
    		catch (IOException ex) {
    			System.out.println ("Failed to open file");
    		}	
    	}
    
    /**
     * @assert statement is declared to  to find an expected boolean condition in the program
     * the assert statements are checked during the run time of the program.
     * When the slider is dragged to the right the drawing panel’s background gets a higher blue construction
     * Values are changed from integer to hexadecimal using Integer.toHexString
     */

    @FXML
    void initialize() {
    	assert rbBlack != null : "fx:id=\"rbBlack\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgColor != null : "fx:id=\"tgColor\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbGreen != null : "fx:id=\"rbGreen\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbRed != null : "fx:id=\"rbRed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbBlue != null : "fx:id=\"rbBlue\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbBrown != null : "fx:id=\"rbBrown\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbSmall != null : "fx:id=\"rbSmall\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert tgPenSize != null : "fx:id=\"tgPenSize\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbMed != null : "fx:id=\"rbMed\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbLarge != null : "fx:id=\"rbLarge\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert rbXLarg != null : "fx:id=\"rbXLarg\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnSerial != null : "fx:id=\"btnSerial\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnUndo != null : "fx:id=\"btnUndo\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert panelDraw != null : "fx:id=\"panelDraw\" was not injected: check your FXML file 'Assignment5.fxml'.";
        assert Blue != null : "fx:id=\"Blue\" was not injected: check your FXML file 'Assignment5.fxml'.";
        
       // listener for changes to Blue's value (Ch 12 slide 94)
       Blue.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				String first_id = Integer.toHexString(15 - newValue.intValue()/16); // hexadecimal is base 16
				String second_id =  Integer.toHexString(15 - newValue.intValue()%16);
				String color = "-fx-background-color: #"+first_id+second_id+first_id+second_id+"FF"; // outputs a hexadecimal color value for the background color.
				panelDraw.setStyle(color);
			}
        }); 
    }
}
