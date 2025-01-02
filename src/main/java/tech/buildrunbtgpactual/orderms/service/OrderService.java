package tech.buildrunbtgpactual.orderms.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import tech.buildrunbtgpactual.orderms.entity.OrderEntity;
import tech.buildrunbtgpactual.orderms.entity.OrderItem;
import tech.buildrunbtgpactual.orderms.listener.OrderCreatedEvent;
import tech.buildrunbtgpactual.orderms.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(OrderCreatedEvent event) {
        var entity = new OrderEntity();
        entity.setOrderId(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());
        entity.setItens(getOrderItems(event));
        entity.setTotal(getTotal(event));

        orderRepository.save(entity);
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(i -> new OrderItem(i.produdo(), i.quantidade(), i.preco()))
                .toList();
    }
}
