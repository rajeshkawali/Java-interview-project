package com.rajeshkawali.designpattern.abstractfactorypattern;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class PDFParser implements Parser {
    public List<String> parse(File file) {
        // Implementation for parsing PDF file format
        return Collections.emptyList();
    }
}