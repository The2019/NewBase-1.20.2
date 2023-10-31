package net.The2019.NewBase.utils;

public class DisplayElements {
    private final String name;
    private final int color;
    private final DisplayTextSupplier textSupplier;
    private boolean active;

    public DisplayElements(String name, int color, DisplayTextSupplier textSupplier) {
        this.name = name;
        this.color = color;
        this.textSupplier = textSupplier;
        this.active = true; // Elements are active by default
    }

    public String getText() {
        return textSupplier.getDisplayText();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}

