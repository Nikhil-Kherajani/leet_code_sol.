import java.util.*;

class Fpair {
    String x;
    int y;

    public Fpair(String x, int y) {
        this.x = x;
        this.y = y;
    }
}

class UndergroundSystem {
    HashMap<Integer, Fpair> idmap;
    HashMap<String, ArrayList<Double>> avgmap;

    public UndergroundSystem() {
        idmap = new HashMap<>();
        avgmap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idmap.put(id, new Fpair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        if (idmap.containsKey(id)) {
            Fpair temp = idmap.get(id);

            if (avgmap.containsKey(temp.x + "to" + stationName)) {

                ArrayList temp2 = avgmap.get(temp.x + "to" + stationName);

                temp2.add((double) t - (double) temp.y);

                avgmap.put(temp.x + "to" + stationName, temp2);

            } else {
                ArrayList newtemp = new ArrayList<>();
                // System.out.println(temp.x + " " + stationName + " " + (double)t + " " +
                // (double)temp.y);

                newtemp.add((double) t - (double) temp.y);
                avgmap.put(temp.x + "to" + stationName, newtemp);
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        ArrayList<Double> temp2 = new ArrayList<>();
        temp2.addAll(avgmap.get(startStation + "to" + endStation));
        double sum = 0d;
        for (int i = 0; i < temp2.size(); i++) {
            sum = sum + temp2.get(i) * 1d;
        }
        // if(startStation + endStation + "" == "aab")
        // sum += t - temp.y;
        int count = temp2.size();

        double avg = sum / (count);
        return avg;

    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */