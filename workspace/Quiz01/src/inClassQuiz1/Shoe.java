package inClassQuiz1;

import java.awt.Color;

public class Shoe {
	private int productID,cumstomerReviewCount;
	private char gender;
	private String shoeName, make, model, width, type, last;
	private double size, weight, currentDistanceOnShoe, cost,
				   reviewRating;
	private Color color;
	
	public Shoe() {
		this(0,"","","",0.0,"",0.0,'M',"","");
	}
	public Shoe(int productID, String shoeName, String make, String model, double size
			,String width, double weight, char gender, String type, String last) {
		this(productID,shoeName,make,model,size,width,weight,gender,type,last,0,0,0,0,Color.RED);
	}
	public Shoe(int productID, String shoeName, String make, String model, double size
			,String width, double weight, char gender, String type, String last, 
			double currentDistanceOnShoe, double cost, int customerReviewCount, 
			double reviewRating, Color color) {
		super();
		setProductID(productID);
		setShoeName(shoeName);
		setMake(make);
		setModel(model);
		setSize(size);
		setWidth(width);
		setWeight(weight);
		setGender(gender);
		setType(type);
		setLast(last);
		setReviewRating(reviewRating);
		setColor(color);
	}
	
	
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getCumstomerReviewCount() {
		return cumstomerReviewCount;
	}
	public void setCumstomerReviewCount(int cumstomerReviewCount) {
		this.cumstomerReviewCount = cumstomerReviewCount;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getShoeName() {
		return shoeName;
	}
	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getCurrentDistanceOnShoe() {
		return currentDistanceOnShoe;
	}
	public void setCurrentDistanceOnShoe(double currentDistanceOnShoe) {
		this.currentDistanceOnShoe = currentDistanceOnShoe;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getReviewRating() {
		return reviewRating;
	}
	public void setReviewRating(double reviewRating) {
		this.reviewRating = reviewRating;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n", shoeName,make,model,width,weight,
				currentDistanceOnShoe,color);
	}
	
	
	
	
	
	
}
