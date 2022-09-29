package entities_exercico1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums_exercicio1.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> item = new ArrayList<>();



	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrdemitem() {
		return item;
	}

	public void addItem(OrderItem item) {
		this.item.add(item);
	}

	public void removeItem(OrderItem item) {
		this.item.remove(item);
	}

	public double total() {
		double sum = 0;
		for (OrderItem o : item) {
			sum += o.subTotal();
		}
		return sum;
	}

}
