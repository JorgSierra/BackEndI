package Classes;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Reserve> reserves;
    private List<Station> stations;

    public Company() {
        this.reserves = new ArrayList<>();
        this.stations = new ArrayList<>();
    }

    public void addReserve(Reserve re){
        this.reserves.add(re);
    }

    public void addStation(Station st){
        this.stations.add(st);
    }

    public void addStation(Station st, String where){
        if (where.equals("BEG")){
            this.stations.add(0,st);
        }
        else{
            int index;
            for (index = 0; index < this.stations.size(); index++){
                if(this.stations.get(index).getName() == where){
                    break;
                }
            }
            if (index < this.stations.size()){
                this.stations.add(index, st);
            }
        }
    }

    public void printStations() {
        for (Station st:
             this.stations) {
            System.out.println(st.getName());
        }
    }

    public void printReserves() {
        for (Reserve rv:
                this.reserves) {
            System.out.println("Reserve code: " + rv.getCode() + " From: " + rv.getDeparture() + " To: " + rv.getDestiny() + " Pass: " + rv.getPassengers() + " Cost: " + rv.getCost(this.stations));
        }
    }
}
