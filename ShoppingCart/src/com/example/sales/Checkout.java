package com.example.sales;

public class Checkout {

	int totalCost,totalCostAmount, noOfApples, noOfOranges, newQuantityOfApples, newQuantityOfOranges, num = 0;

	Item apples, oranges;

	public Checkout(int noOfApples, int noOfOranges) {

		apples = new Item("Apple", 1, 60);
		oranges = new Item("Orange", 1, 25);

		apples.setQuantity(noOfApples);
		oranges.setQuantity(noOfOranges);

	}

	public int calcTotalCostWithOutDiscount() {

		 totalCostAmount= ((apples.getPrice()) * apples.getQuantity()) + ((oranges.getPrice()) * oranges.getQuantity());

		System.out.println("Total Cost without Discount " + totalCostAmount);

		return totalCostAmount;
	}

	public int calcTotalCostWithDiscount() {

		Checkout bill2 = new Checkout(6, 7);
		totalCost = ((apples.getPrice()) * bill2.BuyOneGetFreeApple())
				+ ((oranges.getPrice()) * bill2.BuyThreeForTwoOranges());

		System.out.println("Total Cost with Discount " + totalCost);

		return totalCost;
	}

	public int BuyOneGetFreeApple() {

		if (apples.getQuantity() % 2 == 0) {

			newQuantityOfApples = apples.getQuantity() / 2;
			System.out.println(newQuantityOfApples);
		} else {
			num = apples.getQuantity();
			num = num / 2;
			newQuantityOfApples = num;
			System.out.println(newQuantityOfApples);
		}

		return newQuantityOfApples;
	}

	public int BuyThreeForTwoOranges() {

		if (oranges.getQuantity() > 2) {
			newQuantityOfOranges = oranges.getQuantity() - (oranges.getQuantity() / 3);
			System.out.println(newQuantityOfOranges);
		}

		return newQuantityOfOranges;
	}

	public void totalSavings()
	{
		
	 int savingsAmount = totalCostAmount-totalCost;
	
	 System.out.println("Total Savings are "+ savingsAmount);
	}
	
	public static void main(String[] args) {

		Checkout bill = new Checkout(6, 7);

		bill.calcTotalCostWithOutDiscount();
		bill.calcTotalCostWithDiscount();

		bill.totalSavings();
		
	
	
	}
}
