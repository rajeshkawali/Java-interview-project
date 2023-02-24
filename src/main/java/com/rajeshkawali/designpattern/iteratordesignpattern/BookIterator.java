package com.rajeshkawali.designpattern.iteratordesignpattern;


/**
 * 
 * @author Rajesh_Kawali
 *
 */
// Iterator interface defining the iteration protocol
public interface BookIterator {
    public boolean hasNext();
    public Book next();
}