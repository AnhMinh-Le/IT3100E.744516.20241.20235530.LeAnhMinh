package AimsPackage;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

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

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

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

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". DVD - " + disc.getTitle() + " - " + disc.getCategory() + " - " +
                    disc.getDirector() + " - " + disc.getLength() + ": " + disc.getCost() + " $");
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("DVD found: " + itemsOrdered[i].getTitle());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD with ID " + id + " found in the cart.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("DVD found: " + itemsOrdered[i].getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD with title \"" + title + "\" found in the cart.");
        }
    }
}
