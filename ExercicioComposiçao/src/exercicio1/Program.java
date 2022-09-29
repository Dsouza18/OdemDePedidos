package exercicio1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.enums_exercicio1.OrderStatus;
import entities_exercico1.Client;
import entities_exercico1.Order;
import entities_exercico1.OrderItem;
import entities_exercico1.Product;

public class Program {
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yyyy");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		

		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String nameClient = scan.nextLine();
		System.out.print("E-mail: ");
		String email = scan.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf1.parse(scan.next());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String orderStatus = scan.next();
		Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), new Client(nameClient, email, birthDate));
		System.out.print("How many items to this order?");
		int quantityItem = scan.nextInt();

		for (int i = 1; i <= quantityItem; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String nameProduct = scan.next();

			System.out.print("Product price: ");
			double productPrice = scan.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = scan.nextInt();
			OrderItem orderitem = new OrderItem(quantityProduct, productPrice, new Product(nameProduct));
			order.addItem(orderitem);
		}
		System.out.println();
		System.out.println("ORDER SUMARY:");
		System.out.println("Order moment: " + sdf2.format(order.getMoment()));
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + order.getClient());
		
		System.out.println("ORDER ITEMS: ");
		for(OrderItem o: order.getOrdemitem()) {
			System.out.println(o);
		}
		
		System.out.println("Total price: " + order.total());

		scan.close();

	}

}
