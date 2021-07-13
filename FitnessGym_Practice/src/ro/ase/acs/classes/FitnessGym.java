package ro.ase.acs.classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FitnessGym implements Cloneable, Runnable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String gymName = "";
	List<Member> members = null;

	public FitnessGym(String gymName, List<Member> members) {
		super();
		this.gymName = gymName;
		this.members = members;
	}

	public void setGymName(String name) {
		gymName = name;
	}

	public String getGymName() {
		return gymName;
	}

	public List<Member> getMembers() {

		return this.members;
	}

	public void setMembers(List<Member> members) {
		this.members = new ArrayList<>();
		for (Member mb : members) {
			this.members.add(mb);
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		FitnessGym copy = (FitnessGym) super.clone();
		copy.gymName = this.gymName;
		copy.setMembers(this.members);
		return copy;
	}

	public float calculateAvgWeight() {
		float sum = 0;
		for (Member person : members) {
			sum += person.weight;
		}
		return Math.round(sum / members.size());
	}

	public static float calculateStaticAvgWeight(FitnessGym gym) {
		float sum = 0;
		for (Member person : gym.members) {
			sum += person.weight;
		}
		return Math.round(sum / gym.members.size());
	}

	@Override
	public void run() {
		System.out.println(calculateAvgWeight());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Gym name: ");
		builder.append(this.gymName);
		builder.append("Members: ");
		for (Member mb : members) {
			builder.append(mb.name);
			builder.append(" ");
		}
		return builder.toString();
	}

	public void serialize() throws IOException {
		FileOutputStream stream = new FileOutputStream("gym.data");
		ObjectOutputStream oos = new ObjectOutputStream(stream);
		oos.writeObject(this);
		oos.close();
	}

	public void deserialize() throws IOException, ClassNotFoundException {
		FileInputStream stream = new FileInputStream("gym.data");
		ObjectInputStream ois = new ObjectInputStream(stream);
		FitnessGym gym = (FitnessGym)ois.readObject();
		this.gymName = gym.gymName;
		this.setMembers(gym.members);
		ois.close();
	}

}










