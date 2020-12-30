package com.springRestGuide.demo.controller;

import com.springRestGuide.demo.models.Order;
import com.springRestGuide.demo.models.Status;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {
    @Override
    public EntityModel<Order> toModel(Order order) {
        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel());
                linkTo(methodOn(OrderController.class).all()).withRel("order");

                if(order.getStatus() == Status.IN_PROGRESS){
                    orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
                    orderModel.add(linkTo(methodOn(OrderController.class).completed(order.getId())).withRel("completed"));
                }

                return orderModel;

    }
}
