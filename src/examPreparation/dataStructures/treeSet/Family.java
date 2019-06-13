package examPreparation.dataStructures.treeSet;

import java.util.TreeSet;

public class Family {
	private TreeSet<Person> members;
	
	public Family() {
		this.members = new TreeSet<>();
	}
	
	public int size() {
		return members.size();
	}
	
	public void add(Person p) {
		members.add(p);
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
		for(Person member : members) {
			if(member.equals(p))
				return true;
		}
		return false;
	}
}
