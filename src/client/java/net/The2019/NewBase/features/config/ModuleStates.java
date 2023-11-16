package net.The2019.NewBase.features.config;

public class ModuleStates {

    public static boolean fpsDisplayState = true;
    public static boolean biomDisplayState = true;
    public static boolean coordinatesDisplayState = true;

    public static String isEnabled(Boolean module){
        if(module){
            return "§aEnabled";
        }else {
            return"§4Disabled";
        }
    }
}