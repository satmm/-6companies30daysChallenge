class Solution {
    
    class Pair{
        int x;
        int y;
        int cost;
        Pair(int x,int y,int cost){
            this.x=x;
            this.y=y;
            this.cost=cost;
        }
    }
    
    
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int m=specialRoads.length;
        int n=specialRoads[0].length;
        HashMap<Integer,HashSet<Integer>>map=new HashMap<>();
        
        
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.cost-b.cost);;
        
        
        int fx=target[0],fy=target[1];
        int x1=start[0],y1=start[1];
        
        
        pq.add(new Pair(x1,y1,0));
        
        while(pq.size()!=0){

              Pair rem=pq.remove();
            x1=rem.x;
            y1=rem.y;

             if(map.containsKey(x1)&&map.get(x1).contains(y1)){
                        continue;
               }

          
            
            if(map.containsKey(x1)==false){
                map.put(x1,new HashSet<Integer>());
            }
            map.get(x1).add(y1);
            
            
            if(rem.x==fx&&rem.y==fy){
                return rem.cost;
            }
            
            pq.add(new Pair(fx,fy,rem.cost+Math.abs(x1-fx)+Math.abs(y1-fy)));
            
            for(int i=0;i<specialRoads.length;i++){
                
                int x=specialRoads[i][0];
                int y=specialRoads[i][1];
                int x2=specialRoads[i][2];
                int y2=specialRoads[i][3];
                int ct=specialRoads[i][4];
                
               
                    if(map.containsKey(x2)&&map.get(x2).contains(y2)){
                        continue;
                    }
                    pq.add(new Pair(x2,y2,rem.cost+ct+Math.abs(x1-x)+Math.abs(y1-y)));
                    
                
                
            }
            
           
            
            
        }
        
        return -1;
        
        
        
        
        
    }
}


