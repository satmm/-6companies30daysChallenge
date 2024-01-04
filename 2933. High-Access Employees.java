class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
    List<String> ans = new ArrayList<>();
    HashMap<String, List<Integer>> hm=new HashMap<>();
    for(List<String> a : access_times){
        hm.putIfAbsent(a.get(0), new ArrayList<>());
        hm.get(a.get(0)).add(Integer.valueOf(a.get(1)));
    }
    for(String key: hm.keySet()){
        List<Integer> l = hm.get(key);
        if(l.size()>=3){
            Collections.sort(l);
            for(int i=0; i<l.size()-2; i++){
                int time1 = l.get(i);
                int time2 = l.get(i+2);
                int hour_diff = time2 / 100 - time1 / 100 - 1;
                int min_diff = time2 % 100 + (60 - time1 % 100);
                if(min_diff >= 60) {
                    hour_diff++;
                    min_diff = min_diff - 60;
                }
                if(hour_diff==0){
                    if(!ans.contains(key)){
                        ans.add(key);
                    }
                }
            }
        }
    }
    return ans;

    }
}
