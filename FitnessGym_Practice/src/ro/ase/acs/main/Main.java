package ro.ase.acs.main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import ro.ase.acs.classes.FitnessGym;
import ro.ase.acs.classes.Member;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Member member1 = new Member("Serban", 26, 68); 
		Member member2 = new Member("Mihnea", 26, 75); 
		Member member3 = new Member("Silvian", 24, 60);
		
		List<Member> persons = new ArrayList<>();
		persons.add(member1);
		persons.add(member2);
		persons.add(member3);
		FitnessGym gym = new FitnessGym("EliteGym", persons);
		System.out.println(gym.calculateAvgWeight());
		
		
		try {
			FitnessGym gym2 = (FitnessGym) gym.clone();
			
			List<Member> memb = gym2.getMembers();
			memb.set(2, new Member("Radu", 27, 80));
			gym2.setGymName("Gema Fitness");
			gym2.setMembers(memb);
//			List<Member> persons2 = new ArrayList<>();
//			Member member4 = new Member("Diana", 25, 60);
//			Member member5 = new Member("Diana", 25, 60);
//			Member member6 = new Member("Vlad", 25, 75);
//			persons2.add(member4);
//			persons2.add(member5);
//			persons2.add(member6);
//			gym2.setMembers(persons2);
			gym2.calculateAvgWeight();
			
			System.out.println(gym.toString());
			System.out.println();
			System.out.println(gym2.toString());
			
			
			long count1 = gym.getMembers().stream().filter(x -> x.getWeight() > 60).count();
			long count2 = gym2.getMembers().stream().filter(x -> x.getWeight() > 60).count();
			
			System.out.println("Average weight for gym1");
			System.out.println(count1);
			
			System.out.println("Average weight for gym2");
			System.out.println(count2);
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(gym).start();
		
		Runnable r = () -> System.out.println(FitnessGym.calculateStaticAvgWeight(gym));
		new Thread(r).start();
		
		
		new Thread(()->{
			try(Socket socket = new Socket("localhost", 7777)){
				OutputStream outputStream = socket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				objectOutputStream.writeObject(gym);
				
		}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		).start();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Runnable r1 = () -> {
			try {
				gym.serialize();
				FitnessGym newDeserializedGym = new FitnessGym(null, null);
				newDeserializedGym.deserialize();
				System.out.println(newDeserializedGym.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		new Thread(r1).start();
		
		
		gym.getMembers();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
























