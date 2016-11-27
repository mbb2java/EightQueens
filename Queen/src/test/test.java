package test;

import java.util.ArrayList;

import model.Chesser;
import model.Queen;

public class test {
	public static void main(String[] args) {
		Chesser c=new Chesser();
		for(int i=0;i<8;i++){
			c.add(new Queen());
		}
		c.doNext(null);
		ArrayList<ArrayList<Queen>> plans=c.getPlans();
		
		System.out.println(plans.size());
		
	}
}
