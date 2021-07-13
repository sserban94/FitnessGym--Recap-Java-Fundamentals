package ro.ase.acs.classes;

import java.io.Serializable;
import java.util.Comparator;

public class Member implements Cloneable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int age;
	float weight;
	
	
	public Member(String name, int age, float weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setWeight(float weight)
	{
		this.weight = weight;
	}
	
	public float getWeight()
	{
		return weight;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Member copy = (Member) super.clone();
		copy.age = this.age;
		copy.name = this.name;
		copy.weight = this.weight;
		return copy;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
