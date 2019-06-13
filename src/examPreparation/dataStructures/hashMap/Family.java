package examPreparation.dataStructures.hashMap;

import java.util.HashMap;

public class Family {
	
	private HashMap<Integer, Person> members;
	
	public Family() {
		this.members = new HashMap<>();
	}
		
	public int size() {
		return members.size();
	}
		
	public void add(Person p) {
		members.put(p.getID(), p);
	}
		
	public Person getTallest() {
		Person tallest = null;
		for(Integer i : members.keySet()) {
			if(tallest == null || i != null 
					&& members.get(i).getHeight() > tallest.getHeight())
				tallest = members.get(i);
		}
		return tallest;
	}
		
	public boolean isMember(Person p) {
		for(Integer id : members.keySet()) {
			if(id.equals(p.getID()))
				return true;
		}
		return false;
	}
}
