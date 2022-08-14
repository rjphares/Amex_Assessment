package com.example.demo.model;

public class OrderSummary {
	
	public OrderSummary(int totalApples, double priceApple, int totalOranges, double priceOrange) {
		this.totalApples = totalApples;
		this.priceApple = priceApple;
		this.totalOranges = totalOranges;
		this.priceOrange = priceOrange;
		
		
		this.totalCost = totalApples*priceApple + totalOranges*priceOrange;
	}
	
	private int totalApples;
	private double priceApple;
	private int totalOranges;
	private double priceOrange;
	private double totalCost;
	
	public int getTotalApples() {
		return totalApples;
	}
	public void setTotalApples(int totalApples) {
		this.totalApples = totalApples;
	}
	public int getTotalOranges() {
		return totalOranges;
	}
	public void setTotalOranges(int totalOranges) {
		this.totalOranges = totalOranges;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public double getPriceApple() {
		return priceApple;
	}
	public void setPriceApple(double priceApple) {
		this.priceApple = priceApple;
	}
	public double getPriceOrange() {
		return priceOrange;
	}
	public void setPriceOrange(double priceOrange) {
		this.priceOrange = priceOrange;
	}
	
	
}
