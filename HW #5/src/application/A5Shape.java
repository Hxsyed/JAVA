
package application;


public class A5Shape {
	
	private double x_values;
	private double y_values;
	private double r_values;
	
	public A5Shape (double x_values, double y_values, double r_values) {
		this.x_values = x_values;
		this.y_values = y_values;
		this.r_values = r_values;
	}
	
	
	public void setx_values(double x_values ) {
		this.x_values = x_values	;
	}
	
	

	public double getx_values() {
		return x_values;
	}
	
	
	
	
	public void sety_values(double y_values ) {
		this.y_values = y_values	;
	}
	
	
	public double gety_values() {
		return y_values;
	}
	
	
	public void setr(double r_values ) {
		this.r_values = r_values	;
	}
	
	
	public double getr() {
		return r_values;
	}

}
