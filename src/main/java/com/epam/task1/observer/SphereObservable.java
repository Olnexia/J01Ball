package com.epam.task1.observer;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Sphere;
import java.util.ArrayList;
import java.util.List;

public class SphereObservable extends Sphere implements Observable {
    private List<Observer> observers = new ArrayList <>();

    public SphereObservable(double radius, Point center){
        super(radius,center);
    }

    @Override
    public void setRadius(double radius){
       super.setRadius(radius);
       notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
            observer.update(this);
        }
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

    public List <Observer> getObservers() {
        return observers;
    }
}
