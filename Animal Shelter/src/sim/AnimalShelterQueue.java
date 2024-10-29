package sim;

//import java.util.Queue;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AnimalShelterQueue {
	private int timestamp;
	private LinkedList<Dog> dogs;
	private LinkedList<Cat> cats;
	
	public AnimalShelterQueue() {
		dogs = new LinkedList<Dog>();
		cats = new LinkedList<Cat>();
	}
	
	public void add(Animal a) {
		if(a instanceof Cat) {
			cats.addLast((Cat) a);
		}else {
			dogs.addLast((Dog) a);
		}
	}
	
	public Animal adoptAnyAnimal() {
		if(dogs.isEmpty())
			return adoptCat();
		else if(cats.isEmpty())
			return adoptDog();
		else {
			Dog dog = dogs.getFirst();
			Cat cat = cats.getFirst();
			if(dog.isOlderThan(cat)) 
				return adoptDog();
			else
				return adoptCat();	
		}
	}
	
	public Cat adoptCat() {
		if(cats.size()!=0) 
			return cats.removeFirst();
		
		throw new NoSuchElementException();
	}

	public Dog adoptDog() {
		if(dogs.size()!=0) 
			return dogs.removeFirst();		
		throw new NoSuchElementException();
	}
	
	public int animalCount() {
		return dogs.size()+cats.size();
	}
	
	public String toString() {
		return dogs.toString()+cats.toString();
	}
}
