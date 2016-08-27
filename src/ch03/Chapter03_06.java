package ch03;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by almer on 27/08/16.
 */
public class Chapter03_06 {

    static class Animal {
        // empty
    }

    static class Dog extends Animal {
        // empty
    }

    static class Cat extends Animal {
        // empty
    }

    static class AnimalShelter {

        private List<Animal> animals;

        public AnimalShelter() {
            this.animals = new LinkedList<>();
        }

        void enqueue(Animal a) {
            animals.add(a);
        }

        public Animal dequeueAny() {
            if (animals.isEmpty()) {
                throw new NoSuchElementException();
            }

            Animal animal = animals.get(0);
            animals.remove(0);
            return animal;
        }

        public Dog dequeueDog() {
            if (animals.isEmpty()) {
                throw new NoSuchElementException();
            }

            Dog dog = null;
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i) instanceof Dog) {
                    dog = (Dog) animals.get(i);
                    animals.remove(i);
                    break;
                }
            }

            if (dog == null) {
                throw new NoSuchElementException();
            }
            return dog;
        }

        public Cat dequeueCat() {
            if (animals.isEmpty()) {
                throw new NoSuchElementException();
            }
            Cat cat = null;
            for (int i = 0; i < animals.size(); i++) {
                if (animals.get(i) instanceof Dog) {
                    cat = (Cat) animals.get(i);
                    animals.remove(i);
                    break;
                }
            }

            if (cat == null) {
                throw new NoSuchElementException();
            }
            return cat;
        }
    }
}
