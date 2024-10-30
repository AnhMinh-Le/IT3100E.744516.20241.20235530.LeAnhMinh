package AimsPackage;

public class Cart {
	//EX9
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
}
    
    


