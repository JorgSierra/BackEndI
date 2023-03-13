package Classes;

import java.util.List;

public class Reserve {
    private String code;
    private String departure;
    private String destiny;
    private int passengers;

    public Reserve(String code, String departure, String destiny, int passengers) {
        this.code = code;
        this.departure = departure;
        this.destiny = destiny;
        this.passengers = passengers;
    }

    public double getCost(List<Station> stationList){
        double cost = 0;
        if ((stationList.get(0).getName().equals(this.departure) || stationList.get(0).getName().equals(this.destiny)) && (stationList.get(stationList.size() - 1).getName().equals(this.departure) || stationList.get(stationList.size() - 1).getName().equals(this.destiny))){
            cost = (50 * this.passengers) * .8;
        }
        else {
            cost = 50 * this.passengers;
        }
        return cost;
    }

    public String getCode() {
        return code;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestiny() {
        return destiny;
    }

    public int getPassengers() {
        return passengers;
    }
}
