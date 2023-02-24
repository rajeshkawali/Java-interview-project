package com.rajeshkawali.designpattern.flyweightpattern;

import java.util.HashMap;

public class ShapeFactory {
	private static final HashMap<String, Shape> circleMap = new HashMap<String, Shape>();

	public static Shape getCircle(String color) {
		ShapeCircle circle = (ShapeCircle) circleMap.get(color);

		if (circle == null) {
			circle = new ShapeCircle(color);
			circleMap.put(color, circle);
			System.out.println("Creating circle of color : " + color);
		}
		return circle;
	}
}