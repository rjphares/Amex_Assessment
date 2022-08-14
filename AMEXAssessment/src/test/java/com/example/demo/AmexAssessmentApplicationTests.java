package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.GoodsRepository;
import com.example.demo.model.OrderSummary;
import com.example.demo.model.Goods;

@SpringBootTest
class AmexAssessmentApplicationTests {
	
	@Autowired
	GoodsRepository goodsRepository;
	
	@Test
	void appleId() {
		Goods apple = new Goods(1L,"apple",0.6);
		assertEquals(goodsRepository.findAll().get(0).getId(), 
				apple.getId());
	}
	
	@Test
	void appleName() {
		Goods apple = new Goods(1L,"apple",0.6);
		assertEquals(goodsRepository.findAll().get(0).getName(), 
				apple.getName());
	}
	
	@Test
	void applePrice() {
		Goods apple = new Goods(1L,"apple",0.6);
		assertEquals(goodsRepository.findAll().get(0).getPrice(), 
				apple.getPrice());
	}
	
	@Test
	void orangeId() {
		Goods orange = new Goods(2L,"orange",0.25);
		assertEquals(goodsRepository.findAll().get(1).getId(), 
				orange.getId());
	}
	
	@Test
	void orangeName() {
		Goods orange = new Goods(2L,"orange",0.25);
		assertEquals(goodsRepository.findAll().get(1).getName(), 
				orange.getName());
	}
	
	@Test
	void orangePrice() {
		Goods orange = new Goods(2L,"orange",0.25);
		assertEquals(goodsRepository.findAll().get(1).getPrice(), 
				orange.getPrice());
	}
	
	@Test 
	void totalCostOneOfEach() {
		OrderSummary orderSummary = new OrderSummary(1,0.6,1,0.25);
		assertEquals(orderSummary.getTotalCost(),0.85);
	}

	@Test 
	void totalCostMultipleApples() {
		OrderSummary orderSummary = new OrderSummary(3,0.6,1,0.25);
		assertEquals(orderSummary.getTotalCost(),2.05);
	}
	
	@Test 
	void totalCostMultipleOranges() {
		OrderSummary orderSummary = new OrderSummary(1,0.6,3,0.25);
		assertEquals(orderSummary.getTotalCost(),1.35);
	}
	
	@Test 
	void totalCostMultipleApplesAndOranges() {
		OrderSummary orderSummary = new OrderSummary(5,0.6,10,0.25);
		assertEquals(orderSummary.getTotalCost(),5.5);
	}
}
