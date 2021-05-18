package com.example.restservice.controller;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.restservice.bean.*;

@RestController
public class ProblemsController {

	@RequestMapping("/createProduct")
	@ResponseBody
	public ResponseEntity<String> problem5(@RequestBody Product input) throws JsonProcessingException {
		List<Product> products = new ArrayList<Product>();
		ProductOutput output = new ProductOutput();
		ObjectMapper mapper = new ObjectMapper();

		products.add(new Product("Prod1","Shirt","EACH"));
		products.add(new Product("Prod2","Trousers","EACH") );
		products.add(new Product("Prod3","Tie","EACH"));

		Product filteredProduct = products.stream()
				.filter(x -> x.getProductName().equals(input.getProductName()) && x.getProductName().equalsIgnoreCase(input.getProductName()) &&
						x.getUnitOfMeasure().equalsIgnoreCase(input.getUnitOfMeasure()))
				.findFirst()
				.orElse(null);
		if(null != filteredProduct) {
			input.setStatus("Exists");
		} else {
			input.setStatus("Created");
		}
		output.setProductName(input.getProductName());
		output.setProductId(input.getProductId());
		output.setUnitOfMeasure(input.getUnitOfMeasure());

		String result = mapper.writeValueAsString(input);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	@RequestMapping("/sortProducts")
	@ResponseBody
	public ResponseEntity<String> sortProducts(@RequestBody Problem2 input) throws JsonProcessingException, ParseException {
		ObjectMapper mapper = new ObjectMapper();

		Collections.sort(input.getProductList(), new ProdIdSorter()
				.thenComparing(new launchDateSorter()));

		String result = mapper.writeValueAsString(input);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}


	@RequestMapping("/getOrderDetails")
	@ResponseBody
	public ResponseEntity<String> getOrderDetails(@RequestBody OrderInput input) throws JsonProcessingException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		List<Order> orders = new ArrayList<Order>();
		List<Shipment> shipments = new ArrayList<Shipment>();
		OrderOutput output = new OrderOutput();
		boolean productExits = false;

		orders.add(new Order ("Order1", "Prod1", 2.0));
		shipments.add(new Shipment ("Order1", "Ship1", "Prod1", new Date (2021 - 02 - 19), 2.0));


		Order filteredOrder = orders.stream()
				.filter(x -> x.getOrderId().equals(input.getOrderId()))
				.findFirst()
				.orElse(null);
		List<Shipment> filteredShipment = shipments.stream()
				.filter(shipment -> shipment.getProductId().equalsIgnoreCase(filteredOrder.getProductId()))
				.collect(Collectors.toList());

		output.setOrder(filteredOrder);
		output.setShipment(filteredShipment);

		String result = mapper.writeValueAsString(output);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

	public class ProdIdSorter implements Comparator<OrdersWithLaunchDate>
	{
		public int compare(OrdersWithLaunchDate o1, OrdersWithLaunchDate o2)
		{
			return o2.getProductId().compareTo(o1.getProductId());
		}
	}
	public class launchDateSorter implements Comparator<OrdersWithLaunchDate>
	{
		public int compare(OrdersWithLaunchDate o1, OrdersWithLaunchDate o2)
		{
			return o1.getLaunchDate().compareTo(o2.getLaunchDate());
		}
	}


}
