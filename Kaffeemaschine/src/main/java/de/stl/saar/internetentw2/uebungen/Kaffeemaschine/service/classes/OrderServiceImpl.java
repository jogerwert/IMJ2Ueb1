package de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.classes.OrderEntity;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Cocoa;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Coffee;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Customer;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Order;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.entities.interfaces.Tea;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.repositories.OrderRepository;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CocoaService;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.CoffeeService;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.OrderService;
import de.stl.saar.internetentw2.uebungen.Kaffeemaschine.service.interfaces.TeaService;

/**
 * Service-Klasse, welche das Bestellung-Repository kapselt.
 * Es werden ausgewaehlte Methoden zum Laden/Speichern/Loeschen
 * von Objekten der Datenbank zur Verfuegung gestellt.
 * 
 * @author Dominik Goedicke, Michelle Blau, Johannes Gerwert
 *
 */

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private TeaService teaService;
	
	@Autowired
	private CoffeeService coffeeService;
	
	@Autowired
	private CocoaService cocoaService;
	
	@Override
	public Order createEmptyOrder(Customer customer) {
		
		List<Tea> teaList = new ArrayList<Tea>();
		List<Coffee> coffeeList = new ArrayList<Coffee>();
		List<Cocoa> cocoaList = new ArrayList<Cocoa>();
		
		Calendar date = new GregorianCalendar();
		
		Order order = new OrderEntity(date, customer, teaList, 
				coffeeList, cocoaList);
		
		return order;
	}

	@Override
	public List<Order> findAllOrders() {
		List<Order> orderList = new ArrayList<Order>();	
		for (Order order : orderRepository.findAll()) {
			orderList.add(order);
		}
		
		return orderList;
	}

	
	/**
	 * Diese Methode speichert/ueberschreibt Bestellung-Objekte in der Datenbank.
	 * Im Falle der Speicherung wird das Bestellung-Objekt mit einer Id ausgestattet.
	 * Die Id ist der Primaerschluessel.
	 * @param order - Bestellung-Objekt, dessen orderId veraendert wird, sofern es nicht in der DB existiert.
	 */
	@Override
	public void saveOrder(Order order) {
		orderRepository.save((OrderEntity)order);
		
	}

	/**
	 * Loescht ein uebergebenes Bestellung-Objekt aus der Datenbank.
	 * @param order - Bestellung-Objekt
	 */
	@Override
	public void deleteOrder(Order order) {
		orderRepository.delete((OrderEntity)order);
		
	}

	@Override
	public Order findOrderById(long orderId) {
		return orderRepository.findByOrderId(orderId);
	}

	@Override
	public List<Order> findOrdersByCustomer(Customer customer) {
		return orderRepository.findByCustomer(customer);
	}


	/**
	 * Erstellt eine Liste von Listen, die Zusammenfassungen der Elemente der Bestellung
	 * beinhalten.
	 * @param order - Bestellungs-Objekt, das zusammengefasst werden soll
	 */
	@Override
	public List<List<String>> summarizeOrder(Order order){
		List<Tea> teaList = order.getTeaList();
		List<Coffee> coffeeList = order.getCoffeeList();
		List<Cocoa> cocoaList = order.getCocoaList();
		
		List<String> teaSummaryList = new ArrayList<String>();
		List<String> coffeeSummaryList = new ArrayList<String>();
		List<String> cocoaSummaryList = new ArrayList<String>();
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		for(Tea tea : teaList) {
			teaSummaryList.add(teaService.summarizeTea(tea));
		}
		
		for(Coffee coffee : coffeeList) {
			coffeeSummaryList.add(coffeeService.summarizeCoffee(coffee));
		}
		
		for(Cocoa cocoa : cocoaList) {
			cocoaSummaryList.add(cocoaService.summarizeCocoa(cocoa));
		}
		
		result.add(teaSummaryList);
		result.add(coffeeSummaryList);
		result.add(cocoaSummaryList);
		
		return result;
	}
	
	

}
