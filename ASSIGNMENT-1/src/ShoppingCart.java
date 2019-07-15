import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;


public class ShoppingCart {
	/*
	 * ShoppingCart contain some items
	 * items can add in cart
	 * update item quantity
	 */

	public static void main(String[] args) {
		List<Item> itemList=new ArrayList<Item>();
		List<Item> cartList=new ArrayList<Item>();
		itemList.add(new Item("bat",200,10,1));
		itemList.add(new Item("ball",30,10,2));
		itemList.add(new Item("dress",1000,10,3));
		itemList.add(new Item("shoes",500,10,4));
		for(int i=0;i<itemList.size();i++){
			System.out.println(i+1+"\t"+itemList.get(i).getItemName()+"\t"+itemList.get(i).getItemPrice());
		}
		int task=0;
		do{
			System.out.print("1.add 2.showcart 3.update 4.generate bill 5.Exit"+"\nwhat you want to do : ");
			Scanner scanner=new Scanner(System.in);
			try {
				task=scanner.nextInt();
			} catch (Exception e) {
				//System.out.println("invalid action");
			}
			switch (task) {
			//actions for cart
			case 1:
				add(itemList,cartList);
				break;
			case 2:
				showCart(cartList);
				break;
			case 3:
				update(cartList);
				break;	
			case 4:
				generateBill(cartList);
				break;	
			default:
				System.out.println("invalid action");
				break;
			}
		}while(task!=5);


	}


	public static void add(List<Item> itemList, List<Item> cartList){
		//add item into cart
		System.out.print("\nïtem name : ");
		Scanner scanner=new Scanner(System.in);
		String itemName=scanner.nextLine();
		double itemPrice=0;
		int i=0;
		for(i=0;i<itemList.size();i++){
			//check item validation
			if(itemName.equals(itemList.get(i).getItemName())){
				itemPrice=itemList.get(i).getItemPrice();
				break;
			}
		}
		if(i<itemList.size()){
			System.out.print("quantity : ");
			try {
				int itemQuantity=scanner.nextInt();
				cartList.add(new Item(itemName,itemPrice,itemQuantity,cartList.size()+1));
			} catch (Exception e) {
				System.out.println("please enter a valid number");
			}
		}else
			System.out.println("invalid item name");
	}

	private static void showCart(List<Item> cartList) {
		//show items in cart
		System.out.println("\nSr No\tItem Name\tItem Price\tQuantity\n");
		for(int i=0;i<cartList.size();i++){
			System.out.println(i+1+"\t"+cartList.get(i).getItemName()+"\t\t"+cartList.get(i).getItemPrice()+"\t\t"+cartList.get(i).getItemQuantity());
		}
	}

	private static void update(List<Item> cartList) {
		//update quantity of item
		if(cartList.size()!=0){
			System.out.print("\nïtem name : ");
			Scanner scanner=new Scanner(System.in);
			String itemName=scanner.nextLine();
			int i=0;
			for(i=0;i<cartList.size();i++){
				//check item is in cart or not
				if(itemName.equals(cartList.get(i).getItemName()))
					break;	
			}
			if(i<cartList.size()){
				System.out.print("update quantity : ");
				try {
					int itemQuantity=scanner.nextInt();
					cartList.get(i).setItemQuantity(itemQuantity);
				} catch (Exception e) {
					System.out.println("please enter a valid number");
				}
			}else
				System.out.println("item is not exit in cart");
		}else
			System.out.println("cart is empty");
	}


	private static void generateBill(List<Item> cartList) {
		//generate bill for total purchase
		System.out.println("\nSr No\tItem Name\tItem Price\tQuantity\tAmount\n");
		double total=0;
		for(int i=0;i<cartList.size();i++){
			System.out.println(i+1+"\t"+cartList.get(i).getItemName()+"\t\t"+cartList.get(i).getItemPrice()+"\t\t"+cartList.get(i).getItemQuantity()+"\t\t"+cartList.get(i).getItemPrice()*cartList.get(i).getItemQuantity());
			total+=cartList.get(i).getItemPrice()*cartList.get(i).getItemQuantity();
		}
		System.out.println("Total Amount :\t\t\t\t\t\t"+total);
	}


}
