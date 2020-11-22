package application;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;


public class ListA5Shape {
	@XmlElement (name= "Shape")
	private ArrayList<A5Shape> SL = new ArrayList<>();
	public ArrayList<A5Shape>getShapeLists(){
		return SL;
	}
}
