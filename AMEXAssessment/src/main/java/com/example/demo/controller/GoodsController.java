package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Goods;
import com.example.demo.model.GoodsRepository;
import com.example.demo.model.OrderSummary;
import com.example.demo.model.OrderSummaryRepository;

@RestController
public class GoodsController {	
	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired
	private OrderSummaryRepository orderSummaryRepository;
	
	@Autowired 
	SessionFactory sessionfactory;
	
	@GetMapping("/findall") 
	public List<Goods> getAllGoods() {
	    return goodsRepository.findAll();
	}
	
	@GetMapping("/findallordersummary")
	public List<OrderSummary> getAllOrderSummary() {
		return orderSummaryRepository.findAll();
	}
	
	@GetMapping("/ordersummary")
	@ResponseBody
	public OrderSummary getSummary(@RequestParam int totalApples, @RequestParam int totalOranges) {
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("select price from Goods where id=1");
		double priceApple = (double) query.list().get(0);
		query = session.createQuery("select price from Goods where id=2");
		double priceOrange = (double) query.list().get(0);
		OrderSummary orderSummary = new OrderSummary(totalApples, priceApple, totalOranges, priceOrange);
		orderSummaryRepository.save(orderSummary);
		return orderSummary;
	}
	
	@GetMapping("/ordersummary/{id}")
	public OrderSummary retrieveOrderSummary(@PathVariable Long id) {
		Optional<OrderSummary> orderSummary = orderSummaryRepository.findById(id);
		return orderSummary.get();
	}
}