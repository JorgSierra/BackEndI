import Classes.*;

public class Main {
    public static void main(String[] args) {

        Company company = new Company();
        company.addStation(new Station("Buenos Aires"));
        company.addStation(new Station("Luján"));
        company.addStation(new Station("Mercedes"));
        company.addStation(new Station("Suipacha"));
        company.addStation(new Station("Chivilcoy"));
        company.addStation(new Station("Alberti"));
        company.addStation(new Station("Bragado"));
        company.addReserve(new Reserve("XXA256", "Buenos Aires", "Bragado",10));
        company.addReserve(new Reserve("XXA256", "Luján", "Chivilcoy",4));
        company.addReserve(new Reserve("XXA256", "Luján", "Mercedes",3));
        company.addReserve(new Reserve("XXA256", "Alberti", "Bragado",5));

        company.printReserves();

    }
}