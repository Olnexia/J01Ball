package com.epam.task1.observer;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Sphere;
import java.util.ArrayList;
import java.util.List;

public class ObservableSphere extends Sphere implements Observable {
    private List<Observer> observers;

    public ObservableSphere(double radius, Point center){
        super(radius,center);
        observers= new ArrayList <>();
    }

    @Override
    public void setRadius(double radius){
       super.setRadius(radius);
       notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(this);
        }
    }
}
