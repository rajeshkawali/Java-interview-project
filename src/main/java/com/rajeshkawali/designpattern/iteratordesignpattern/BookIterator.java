package com.rajeshkawali.designpattern.iteratordesignpattern;


// Iterator interface defining the iteration protocol
public interface BookIterator {
    public boolean hasNext();
    public Book next();
}