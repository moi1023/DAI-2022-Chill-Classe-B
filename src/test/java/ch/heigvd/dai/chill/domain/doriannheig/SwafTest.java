package ch.heigvd.dai.chill.domain.doriannheig;

import ch.heigvd.dai.chill.domain.Bartender;
import ch.heigvd.dai.chill.protocol.OrderRequest;
import ch.heigvd.dai.chill.protocol.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SwafTest {

  @Test
  void thePriceAndNameForSwafShouldBeCorrect() {
    Swaf beer = new Swaf();
    assertEquals(beer.getName(), Swaf.NAME);
    assertEquals(beer.getPrice(), Swaf.PRICE);
  }

  @Test
  void aBartenderShouldAcceptAnOrderForSwaf() {
    Bartender jane = new Bartender();
    String productName = "ch.heigvd.dai.chill.domain.doriannheig.Swaf";
    OrderRequest request = new OrderRequest(3, productName);
    OrderResponse response = jane.order(request);
    BigDecimal expectedTotalPrice = Swaf.PRICE.multiply(new BigDecimal(3));
    assertEquals(expectedTotalPrice, response.getTotalPrice());
  }

}
