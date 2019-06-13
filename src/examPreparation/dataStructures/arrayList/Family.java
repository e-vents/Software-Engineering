package examPreparation.dataStructures.arrayList;

import java.util.ArrayList;

public class Family {

	private ArrayList<Person> members;
	
	public Family() {
		this.members = new ArrayList<>();
	}
	
	public int size() {
		return this.members.size();
	}
	
	public void add(Person p) {
		this.members.add(p);
	}
	
	public Person getTallest() {
		Person tallest = null;
		for(Person p : members) {
			if(tallest == null || p != null && p.getHeight() > tallest.getHeight())
				tallest = p;
		}
		return tallest;
	}
	
	public boolean isMember(Person p) {
		boolean isMember = false;
		for(Person member : members) {
			if(p.equals(member))
				isMember = true;
		}
		return isMember;
	}
}
