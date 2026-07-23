/*
class UndergroundSystem {
    HashMap<Integer,List<String>>mp1;
    HashMap<String,Integer>mp2;
    public UndergroundSystem() {
        mp1=new HashMap<>();
        mp2=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        List<String>l=new ArrayList<>();
        l.add(stationName);
        l.add(t);
        mp1.put(id,l);
    }
    
    public void checkOut(int id, String stationName, int t) {
        List<String>l=mp1.get(id);
        int val =Integer.parseInt(mp.getOrDefault(l.get(0),0));
        mp2.put(l.get(0),Integer.parseInt(l.get(1))-val);

    }
    
    public double getAverageTime(String startStation, String endStation) {
        
    }
}

the map2 is keeping tracking of only like waterlooo->22-4...okay it ending station..how do we know what is startiing sttaion like many combination/paasenger can be there who started from several diferent station and checkedout on waterloo...hence we needd to stroe like leyton->waterloo , or canbride->waterloo

*/


class UndergroundSystem {
    HashMap<Integer,List<String>>mp1;
    HashMap<String,List<Integer>>mp2;
    public UndergroundSystem() {
        mp1=new HashMap<>();
        mp2=new HashMap<>();        
    }
    
    public void checkIn(int id, String stationName, int t) {
        List<String>l=new ArrayList<>();
        l.add(stationName);
        l.add(t+"");
        mp1.put(id,l); 
    }
    
    public void checkOut(int id, String stationName, int t) {
        List<String>l=mp1.get(id);
        String s =l.get(0);
        String full=s+"->"+stationName;
        int t1=Integer.parseInt(l.get(1));
        int travelTime=t-t1;
        List<Integer>l2=mp2.get(full);
        if(l2==null){
        l2=new ArrayList<>();
        l2.add(travelTime);
        l2.add(1);
        mp2.put(full,l2);
        }
        else{
            l2.set(0,l2.get(0)+travelTime);
            l2.set(1,l2.get(1)+1);
            // mp2.put(full,l2);
        }
        mp1.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String station = startStation+"->"+endStation;
        List<Integer>l =mp2.get(station);
        return (double)l.get(0)/l.get(1);

    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */