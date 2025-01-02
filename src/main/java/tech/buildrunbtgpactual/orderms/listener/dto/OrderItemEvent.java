package tech.buildrunbtgpactual.orderms.listener.dto;

import java.math.BigDecimal;

public record OrderItemEvent(
                String produdo,
                Integer quantidade,
                BigDecimal preco) {

}
