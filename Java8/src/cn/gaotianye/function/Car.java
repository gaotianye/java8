package cn.gaotianye.function;

import java.util.function.Supplier;

public class Car {
	private String name;
	private Double price;
	private Double height;
	
    @Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + ", height=" + height + "]";
	}
    
	public Car() {
		super();
	}

	public Car(String name, Double price, Double height) {
		super();
		this.name = name;
		this.price = price;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
//=======================================================================
	public static Car create( final Supplier< Car > supplier ) {
        return supplier.get();
    }              
         
    public static void collide( final Car car ) {
        System.out.println( "Collided " + car.toString() );
    }
         
    public void follow( final Car another ) {
        System.out.println( "Following the " + another.toString() );
    }
         
    public void repair() {   
        System.out.println( "Repaired " + this.toString() );
    }
    
}
