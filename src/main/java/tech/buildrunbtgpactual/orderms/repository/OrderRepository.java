package tech.buildrunbtgpactual.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import tech.buildrunbtgpactual.orderms.entity.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {

}
