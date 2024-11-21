package AimsPackage;

public class Cart {
    // EX9
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Method 1: Add a single DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Please remove some discs to continue.");
            return;
        }

        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");

        if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
            System.out.println("The cart is almost full.");
        }
    }

    // Method 2: Add multiple DVDs using an array parameter
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (this.qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full. Cannot add \"" + disc.getTitle() + "\".");
                break;
            }
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        }
        if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
            System.out.println("The cart is almost full.");
        }
    }

    // Method 3: Add multiple DVDs using variable arguments
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            if (this.qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full. Cannot add \"" + disc.getTitle() + "\".");
                break;
            }
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
        }
        if (qtyOrdered >= MAX_NUMBERS_ORDERED - 1) {
            System.out.println("The cart is almost full.");
        }
    }

    // Method 4: Add two DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1); // Add first disc
        addDigitalVideoDisc(dvd2); // Add second disc
    }

    // Remove a DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
            return;
        }

        for (int i = 0; i < qtyOrdered; ++i) {
            if (itemsOrdered[i] == disc) {
                System.out.println("The disc with title \"" + disc.getTitle() + "\" has been removed.");
                for (int j = i; j < qtyOrdered - 1; ++j) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                return;
            }
        }
        System.out.println("The disc with title \"" + disc.getTitle() + "\" is not found in the cart.");
    }

    // Calculate total cost
    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
}
