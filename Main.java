package cz.app.main;

public class Main {
    public static final String[] productNames = {"Mliko", "Chleba", "Houska", "Rohlik", "Kava", "Vodka", "Slivovice", "Syr"};
    public static final int[] productPrices = {18, 30, 3, 2, 150, 190, 180, 20};

    public static void main(String[] args) {
        //List of products in array of objects, consisting of name and price
        Product[] arrOfItems = new Product[8];
        for (int i = 0; i < arrOfItems.length; i++) {
            arrOfItems[i] = new Product(productNames[i], productPrices[i]);
        }

        //Ends the program if there is no argument given
        if(args[0].length == 0){
            System.out.println("Type: help to get help");
            System.exit(1);
        }

        //If "help" is given as argument, prints out the item list with prices
        if (args[0].equals("help")) {
            for (int i = 0; i < arrOfItems.length; i++) {
                System.out.println(i + ". " + arrOfItems[i].name + " " + arrOfItems[i].price);
            }
            System.exit(1);
        }

        int[] order = new int[args.length];
        int totalPrice = 0;
        StringBuilder items = new StringBuilder();

        //Converts input args to numbers as to use them later on as indexes for array
        for (int i = 0; i < order.length; i++) {
            order[i] = Integer.parseInt(args[i]);
        }

        //Gets the name and price from array by the input number
        //Add them into 2 variables, ArrayList would probably be better, but it is what it is
        for (int j : order) {
            totalPrice += arrOfItems[j].price;
            items.append(arrOfItems[j].name).append(", ");
        }

        System.out.println("Total price: " + totalPrice + " for these items: " + items);
    }
}
