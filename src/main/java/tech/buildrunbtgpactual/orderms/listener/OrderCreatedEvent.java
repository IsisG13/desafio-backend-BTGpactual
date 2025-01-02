package tech.buildrunbtgpactual.orderms.listener;

import java.util.List;

public record OrderCreatedEvent(
        Long codigoPedido,
        Long codigoCliente,
        List<OrderItemEvent> itens) {

}
