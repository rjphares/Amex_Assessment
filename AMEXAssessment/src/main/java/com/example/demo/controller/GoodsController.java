package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Goods;
import com.example.demo.model.GoodsRepository;
import com.example.demo.model.OrderSummary;

@RestController
public class GoodsController {	
	@Autowired
	private GoodsRepository goodsRepository;
	
	@Autowired 
	SessionFactory sessionfactory;
	
	@GetMapping("/findall") 
	public List<Goods> getAllGoods() {
	    return goodsRepository.findAll();
	}
	
	@GetMapping("/ordersummary")
	@ResponseBody
	public OrderSummary getSummary(@RequestParam int totalApples, @RequestParam int totalOranges) {
		Session session = sessionfactory.openSession();
		Query query = session.createQuery("select price from Goods where id=1");
		double priceApple = (double) query.list().get(0);
		query = session.createQuery("select price from Goods where id=2");
		double priceOrange = (double) query.list().get(0);
		return new OrderSummary(totalApples, priceApple, totalOranges, priceOrange);
	}
}