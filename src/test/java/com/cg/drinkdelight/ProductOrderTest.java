package com.cg.drinkdelight;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.drinkdelight.dao.ProductOrderDao;
import com.cg.drinkdelight.entity.DeliveryStatus;
import com.cg.drinkdelight.entity.ProductOrderEntity;
import com.cg.drinkdelight.exception.ProductOrderException;
import com.cg.drinkdelight.service.ProductOrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductOrderTest {
	@Autowired
	private ProductOrderService prodService;
	@MockBean
	private ProductOrderDao productRepo;

	@Test
	public void trackProductOrder() throws ProductOrderException {
		long id = 114;
		DeliveryStatus deliveryStatus = DeliveryStatus.CANCELLED;
		when(productRepo.findByOrderId(id)).thenReturn(
				Stream.of(new ProductOrderEntity(114, 112, "MangoJuice", 1101, 2, LocalDate.parse("2020-10-06"),
						LocalDate.parse("2020-10-16"), 50, 100, deliveryStatus)).collect(Collectors.toList()));
		assertEquals(1, prodService.trackProductOrder(id).size());
	}

	@Test
	public void trackProductOrderGettingNoRecord() throws ProductOrderException {
		long id = 114;

		Exception exception = assertThrows(ProductOrderException.class, () -> prodService.trackProductOrder(id));

		assertEquals("No order found with this order Id", exception.getMessage());
	}

}
