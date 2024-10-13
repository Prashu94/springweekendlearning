package io.spring.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/orders", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderApiController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderApiController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping(produces = "application/json")
    public Iterable<TacoOrder> allOrders(){
        return orderRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TacoOrder postOrder(TacoOrder tacoOrder){
        return orderRepository.save(tacoOrder);
    }

    @PutMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder putOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder tacoOrder){
        tacoOrder.setId(orderId);
        return orderRepository.save(tacoOrder);
    }

    @PatchMapping(path = "/{orderId}", consumes = "application/json")
    public TacoOrder patchOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder tacoOrder) {
        TacoOrder order = orderRepository.findById(orderId).get();
        if (tacoOrder.getDeliveryName() != null) {
            order.setDeliveryName(tacoOrder.getDeliveryName());
        }
        if (tacoOrder.getDeliveryStreet() != null) {
            order.setDeliveryStreet(tacoOrder.getDeliveryStreet());
        }
        if (tacoOrder.getDeliveryCity() != null) {
            order.setDeliveryCity(tacoOrder.getDeliveryCity());
        }
        if (tacoOrder.getDeliveryState() != null) {
            order.setDeliveryState(tacoOrder.getDeliveryState());
        }
        if (tacoOrder.getDeliveryZip() != null) {
            order.setDeliveryZip(tacoOrder.getDeliveryState());
        }
        if (tacoOrder.getCcNumber() != null) {
            order.setCcNumber(tacoOrder.getCcNumber());
        }
        if (tacoOrder.getCcExpiration() != null) {
            order.setCcExpiration(tacoOrder.getCcExpiration());
        }
        if (tacoOrder.getCcCVV() != null) {
            order.setCcCVV(tacoOrder.getCcCVV());
        }
        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            orderRepository.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {}
    }
}
