package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sun.corba.se.impl.orbutil.graph.NodeData;

public class Chesser {
	private ArrayList<Queen> qs=new ArrayList<>();
	private ArrayList<ArrayList<Queen>> plans=new ArrayList<>();
	public ArrayList<ArrayList<Queen>> getPlans() {
		return plans;
	}
	
	public void add(Queen queen){
		qs.add(queen);
		queen.setChesser(this);
	}
	public boolean isAllChessed(){
		for(Queen q:qs){
			if(q.getLocal()==null){
				return false;
			}
		}
		return true;
	}
	public ArrayList<Queen> cloneQs(){
		ArrayList<Queen> qs_clone=new ArrayList<Queen>();
		for(Queen q:qs){
			Queen cQ=new Queen();
			cQ.setLocal(q.getLocal());
			qs_clone.add(cQ);
		}
		return qs_clone;
	}
	public void doNext(Queen q) {
		int index=0;
			if(q!=null){
				index=qs.indexOf(q)+1;
			}
			if(index>=qs.size()&&isAllChessed()){
				if(isAllChessed()){
					plans.add(cloneQs());
				}
				return;
			}
			Set<Integer> ps=new HashSet<>();
			for(int j=0;j<index;j++){
				if(qs.get(j).getLocal()!=null){
					for(Integer i:qs.get(j).getScope(index+1)){
						ps.add(i);
					}
				}
			}
			if(ps.size()!=0){
				Iterator<Integer> element=ps.iterator();
				List<Integer> list=new ArrayList<>();
				while(element.hasNext()){
					Integer e=element.next();
					if(e<0||e>qs.size()){
						list.add(e);
					}
				}
				ps.removeAll(list);
				Integer[] _ps=new Integer[ps.size()];
				
				_ps=ps.toArray(_ps);
				Arrays.sort(_ps);
				
				for(int i:_ps){
					System.out.print(i+" ");
				}
				System.out.println();
				qs.get(index).step(_ps,qs.size(),index+1);
				
			}else{
				qs.get(index).step(null,qs.size(),index+1);
			
			}
			
			
		}
			
}
