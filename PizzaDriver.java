import java.util.*;
public class PizzaDriver{
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);

  		System.out.println("Hello, lets get this order placed");		
		System.out.println("Would you like delivery? yes, or no");
      String deliveryOption= kb.nextLine();
		System.out.print("How many pizzas would you like to order?");
		int count = kb.nextInt();
		kb.nextLine();



		Pizza[] p = new Pizza[count];
		// for loop for order
		for(int i =0; i<count;i++){
      	System.out.println("What size would you like: Small, Medium, or Large. ");
      	String size = kb.nextLine();
      	System.out.println("How many toppings would you like? ");
      	int numberOfToppings= kb.nextInt();
      	kb.nextLine();
      	System.out.println("How many sauces would you like? ");
      	int numberOfSauces = kb.nextInt();
			kb.nextLine();
     		for(int x =i; x== i; x++){  
     		 	Pizza p1 = new Pizza(size, numberOfToppings, numberOfSauces, deliveryOption);
				p[i] = p1;
			}
      }
      System.out.println("what is the tax rate for your area?");
      double taxRate = kb.nextDouble();
  		double totalPrice = 0.0;    
		for(int i = 0; i<count; i ++){
			System.out.println("Pizza " + (i+1) +":");
			System.out.print(p[i].toString());
			System.out.println();
			totalPrice = (totalPrice + p[i].getPrice(taxRate));
		}
      //Delivery amount
      if(deliveryOption.contains("yes")){
         System.out.print("How far away do you live in miles?");
         int distance = kb.nextInt();
         System.out.print("Delivery Cost: $" + p[0].delivery(distance));
         System.out.println("\nTotal Cost: $"+(p[0].delivery(distance)+totalPrice));
      }
		else{
			System.out.print("Total price including tax: $" + totalPrice);
		}
   }
}