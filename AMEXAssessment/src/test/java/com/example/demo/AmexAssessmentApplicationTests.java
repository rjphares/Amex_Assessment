package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.GoodsRepository;
import com.example.demo.model.OrderSummary;
import com.example.demo.model.OrderSummaryRepository;
import com.example.demo.model.Goods;

@SpringBootTest
class AmexAssessmentApplicationTests {
	
	@Autowired
	GoodsRepository goodsRepository;
	
	@Autowired
	OrderSummaryRepository orderSummaryRepository;
	
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
	
	/*@Test 
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
	}*/
	
	
	@Test
	void totalCostMultipleOfTwoApplesAndMultipleOfThreeOranges() {
		OrderSummary orderSummary = new OrderSummary(4,0.6,6,0.25);
		assertEquals(orderSummary.getTotalCost(), 2.2);
	}

	@Test
	void orderSummaryId() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findAll().get(1).getId(), 
				orderSummary.getId());
	}
	
	@Test
	void orderSummaryTotalApples() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findAll().get(1).getTotalApples(), 
				orderSummary.getTotalApples());
	}
	
	@Test
	void orderSummaryPriceApple() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findAll().get(1).getPriceApple(), 
				orderSummary.getPriceApple());
	}
	
	@Test
	void orderSummaryTotalOranges() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findAll().get(1).getTotalOranges(), 
				orderSummary.getTotalOranges());
	}
	
	@Test
	void orderSummaryPriceOrange() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findAll().get(1).getPriceOrange(), 
				orderSummary.getPriceOrange());
	}
	
	@Test
	void orderSummaryTotalCost() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findAll().get(1).getTotalCost(), 
				orderSummary.getTotalCost());
	}
	
	@Test
	void orderSummaryIdById() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findById(2L).get().getId(), 
				orderSummary.getId());
	}
	
	@Test
	void orderSummaryTotalApplesById() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findById(2L).get().getTotalApples(), 
				orderSummary.getTotalApples());
	}
	
	@Test
	void orderSummaryPriceAppleById() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findById(2L).get().getPriceApple(), 
				orderSummary.getPriceApple());
	}
	
	@Test
	void orderSummaryTotalOrangesById() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findById(2L).get().getTotalOranges(), 
				orderSummary.getTotalOranges());
	}
	
	@Test
	void orderSummaryPriceOrangeById() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findById(2L).get().getPriceOrange(), 
				orderSummary.getPriceOrange());
	}
	
	@Test
	void orderSummaryTotalCostById() {
		OrderSummary orderSummary = new OrderSummary(2,0.6,6,0.25);
		orderSummary.setId(2L);
		assertEquals(orderSummaryRepository.findById(2L).get().getTotalCost(), 
				orderSummary.getTotalCost());
	}
}
