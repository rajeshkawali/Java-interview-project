package com.rajeshkawali.designpattern.commandpattern;
/**
 * 
 * @author Rajesh_Kawali
 *
 */
public class SwitchOnCommand implements Command {
    private Light light;

    public SwitchOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOn();
    }
}
