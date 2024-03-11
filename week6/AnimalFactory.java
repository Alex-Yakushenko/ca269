interface SafetyRegulation {
    public int getMaxItemsPermitted();
}

abstract class Item implements SafetyRegulation {
    
}

class Duck extends Item {
    public int getMaxItemsPermitted() {
        return 5;
    }
}

class Swan extends Item {
    public int getMaxItemsPermitted() {
        return 2;
    }
}

class Flamingo extends Item {
    public int getMaxItemsPermitted() {
        return 3;
    }
}

class Dog extends Item {
    public int getMaxItemsPermitted() {
        return 20;
    }
}

class Cat extends Item {
    public int getMaxItemsPermitted() {
        return 20;
    }
}

public class AnimalFactory<T extends SafetyRegulation> {
    private int unitsCounter;

    public AnimalFactory() {
        this.unitsCounter = 0;
    }

    public T continueProduction(T item) {
        if (unitsCounter < item.getMaxItemsPermitted()) {
            unitsCounter++;
            return item;
        } else {
            return null;
        }
    }
    public int getCount() {
        return this.unitsCounter;
    }

    public static void main(String[] args) {
        // main() for testing:
        AnimalFactory<Duck> AF_D = new AnimalFactory<>();
        while(AF_D.continueProduction(new Duck()) != null);
        System.out.println("Total Ducks produced: " + AF_D.getCount());

        AnimalFactory<Swan> AF_S = new AnimalFactory<>();
        while(AF_S.continueProduction(new Swan()) != null);
        System.out.println("Total Swans produced: " + AF_S.getCount());

        AnimalFactory<Flamingo> AF_F = new AnimalFactory<>();
        while(AF_F.continueProduction(new Flamingo()) != null);
        System.out.println("Total Flamingos produced: " + AF_F.getCount());

        AnimalFactory<Dog> AF_G = new AnimalFactory<>();
        while(AF_G.continueProduction(new Dog()) != null);
        System.out.println("Total Dogs produced: " + AF_G.getCount());

        AnimalFactory<Cat> AF_C = new AnimalFactory<>();
        while(AF_C.continueProduction(new Cat()) != null);
        System.out.println("Total Cats produced: " + AF_C.getCount());
    }
}