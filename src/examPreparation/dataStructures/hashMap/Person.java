package examPreparation.dataStructures.hashMap;

import java.util.Objects;

public class Person implements Comparable<Person> {
	private static int nextID = 0;
	
	private int ID;
	private String name;
	private double height;
	private double weight;
	
	private static int getNextID() {
		return nextID++;
	}
	
	public Person(String name, double height, double weight) {
		this.ID = getNextID();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	@Override
	public int compareTo(Person p) {
		return this.ID - p.ID;
	}
	@Override
	public boolean equals(Object o) {
		boolean equals = false;
		if(o != null && this.getClass() == o.getClass()) {
			Person p = (Person) o;
			equals = (this.ID == p.ID);
		}
		return equals;
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(ID);
	}
	
	public double getBMI() {
		return weight / (height * height);
	}

	// Getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getID() {
		return ID;
	}
}