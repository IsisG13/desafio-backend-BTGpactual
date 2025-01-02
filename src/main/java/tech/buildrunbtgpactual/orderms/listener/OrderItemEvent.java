package tech.buildrunbtgpactual.orderms.listener;

import java.math.BigDecimal;

public record OrderItemEvent(
        String produdo,
        Integer quantidade,
        BigDecimal preco) {

}
