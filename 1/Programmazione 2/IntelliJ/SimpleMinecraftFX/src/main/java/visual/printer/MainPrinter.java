package visual.printer;

public class MainPrinter implements TextPrinter {
    private MapPrinter map;
    private FurnacePrinter furnace;
    private InventoryPrinter inventory;

    public MainPrinter() {}

    public void display_on_out() {
        this.map.display_on_out();
        this.furnace.display_on_out();
        this.inventory.display_on_out();
    }

    public void update(MapPrinter map, FurnacePrinter furnace, InventoryPrinter inventory) {
        this.map = map;
        this.furnace = furnace;
        this.inventory = inventory;
    }
}
