package com.rajeshkawali.designpattern.abstractfactorypattern;

import java.io.File;
import java.util.List;

public interface Parser {
    List<String> parse(File file);
}
/*
In the context of parsing different file formats, the Abstract Factory Pattern could be used to encapsulate 
the creation of different parsers for each file format, where each factory would correspond to a 
specific type of file format. This would allow for easy extensibility in the future, where new file 
formats could be added by simply adding a new factory implementation.
*/


/*

*/


