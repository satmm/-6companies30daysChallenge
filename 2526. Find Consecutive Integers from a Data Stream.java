class DataStream {
Queue<Integer> q;
private int value,k;
    public DataStream(int value, int k) {
        q=new LinkedList<>();
        this.value=value;
        this.k=k;
    }
    
    public boolean consec(int num) {
     return check(num);   
    }
     boolean check(int num)
    {
          if(num==value)
            q.add(num);
        else
        q=new LinkedList<>();
            
       
        return q.size()>=k;
         

    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
