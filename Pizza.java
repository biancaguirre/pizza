import java.util.*;
public class Pizza{
   //Class Variables
   public static int SMALL =10;
   public static int MEDIUM =12;
   public static int LARGE = 16;
   public static int SAUCE = 2;
   public static int TOPPING_PRICE = 2; 
   
   //Instance Variables
   private String size;
   private int numberOfToppings;
   private boolean delivery;
   private String deliveryOption;
   private double toppingPrice;
   private int numberOfSauces;
   private double saucePrice;
   private String toppings = "";
   
   public Pizza(String s, int toppings, int numSauce,String d){
      size = s;
      numberOfToppings = toppings;
      numberOfSauces = numSauce;
      deliveryOption = d;
      if(deliveryOption.contains("yes")){
         delivery = true;
      }
   
   }

public double getPrice(double taxRate){
   Double price = 0.0;
   
   if(size.contains("small")){
      price= price + SMALL;
   }
   if(size.contains("medium")){
      price = price + MEDIUM;
   }
   if(size.contains("large")){
      price = price + LARGE;
   }
   
   price = price + (numberOfToppings*TOPPING_PRICE);
   price = price + (numberOfSauces*SAUCE);
   if(taxRate > 1){
      taxRate = taxRate/100;
      price = (taxRate+1)*price;
   }
   else{
      taxRate = taxRate+1;
      price = price*taxRate;
   }
   
   return Math.round(price);
}

//Calculate Delivery Amount
public int delivery(int distance){
   int deliveryPrice = 0;
   int deliveryRate=5;
   if(distance > 5){
      distance = distance/5;
      deliveryPrice = (distance)*deliveryRate;
       
   }
   else{
      deliveryPrice = deliveryRate; 
   }
   return deliveryPrice;
}

// Dislplay toppings
public void displayToppings(){
}

//Display pizza
public String toString(){
   String info = "";
   info = info + "Pizza Size: " + size;
   info = info + "\nNumber of Toppings: " + numberOfToppings;
   info = info + "\nNumber of sauces: " + numberOfSauces;
   info = info + "\nDelivery: " + deliveryOption;
   return info;
}

//Allow customer to change size
public void changeSize(String newSize){
   String validSize =("small, medium, large");
   if(validSize.contains(newSize)){
      size=newSize;
   }
   
}

// Allow customer to change Toppings
public void changeToppings(int numToppings){
   String validToppings = "Bacon, Chicken, Beef, Chorizo, Ham, Pepperoni, Salami, Sausage \nArtichoke, Tomatoes, Peppers, Mushrooms, Onions, Olives, Spinach, Zucchini";
   System.out.print(validToppings);                   
}

//Choose Toppings
public void addToppings(){
   Scanner kb = new Scanner(System.in);
   String validToppings = "bacon, chicken, beef, chorizo, ham, pepperoni, salami, sausage \nartichoke, tomatoes, peppers, mushrooms, onions, olives, spinach, zucchini";
   System.out.println();
   System.out.println("Topping List: \n" + validToppings); 
   System.out.println("You get " + numberOfToppings + " toppings, what would you like?");
   for(int i=0; i<numberOfToppings; i++){
      System.out.print("Topping " + (i+1) + ": ");
      toppings = toppings + kb.nextLine()  + ", " ;
         while(!validToppings.contains(toppings)){
            System.out.println("I'm sorry but that is not a topping. Please choose from the list above.");
            toppings = toppings+ kb.nextLine()  + " " ;
         }
   }
}      

// Allow customer to change Delivery option
public boolean changeDelivery(String d){
   String validDelivery =("yes, no");
   if(validDelivery.contains(d)){
      if(d.contains("yes")){
         delivery = true;
      }
      else{
         delivery = false;
      }
   }
   return delivery;
}
}