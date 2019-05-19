package be.springPressOrder.services;

import be.springPressOrder.domain.Juice;
import be.springPressOrder.domain.Order;

public interface JuiceServiceInt {

    Iterable<Juice> listAllJuices();
}
