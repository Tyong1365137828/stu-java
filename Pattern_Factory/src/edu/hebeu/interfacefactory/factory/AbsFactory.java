package edu.hebeu.interfacefactory.factory;

import edu.hebeu.interfacefactory.pizza.Pizza;

public interface AbsFactory {

	Pizza createPizza(String name);
}
