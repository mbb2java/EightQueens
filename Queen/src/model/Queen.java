package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Queen {
		private Location local;
		private Chesser cr;
		public Queen(){
			
		}
		public Integer[] getScope(int col){
				int c=local.getCol();
				int p=local.getPols();
				Integer scopes[]=new Integer[]{p-(c-col),p,p+c-col};
				return scopes;
			
		}
		public Location getLocal() {
			return local;
		}
		public String toString(){
			return local.getCol()+"|"+local.getPols();
		}
		public void step(Integer[] ps,int n,int col){
			/*int start=1;
			if(ps!=null){
				List<Integer> sum=new ArrayList<>();
				List<Integer> sub=new ArrayList<>();
				for(int l=1;l<=n;l++){
					sum.add(l);
				}
				Collections.addAll(sub,ps);
				sum.removeAll(sub);
				if(sum.size()>0)
				start=sum.get(0);
			}*/
			for(int i=1;i<=n;i++){
				if(this.local==null){
					for(int k=1;k<=n;k++){
						if(check(ps,k)){
							local=new Location(col,k);
							cr.doNext(this);
							//System.out.println(local.getCol()+" "+local.getPols());
						}
					}
				}else{
					boolean toNull=true;
					for(int k=local.getPols()+1;k<=n;k++){
						if(check(ps,k)){
							local.setPols(k);
							cr.doNext(this);
							toNull=false;
						}
					}
					if(toNull){
						this.local=null;
						break;
					}
					
				}
			}
		}
		private boolean check(Integer[] ps, int i) {
			if(ps==null){
				return true;
			}
			for(int p:ps){
				if(p==i) return false;
			}
			return true;
		}
		public void setLocal(Location local) {
			this.local = local;
		}
		public void setChesser(Chesser chesser) {
			this.cr=chesser;
			
		}
		
}
