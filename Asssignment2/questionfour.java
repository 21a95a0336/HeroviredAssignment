import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ResidentialSociety {
    private String societyName;
    private String location;
    private String secretaryName;

    public ResidentialSociety(String societyName, String location, String secretaryName) {
        this.societyName = societyName;
        this.location = location;
        this.secretaryName = secretaryName;
    }

    public String getSocietyName() {
        return societyName;
    }

    public String getLocation() {
        return location;
    }

    public String getSecretaryName() {
        return secretaryName;
    }
}

class Building extends ResidentialSociety {
    private String buildingName;
    private int totalNumberOfApartments;

    public Building(String societyName, String location, String secretaryName, String buildingName, int totalNumberOfApartments) {
        super(societyName, location, secretaryName);
        this.buildingName = buildingName;
        this.totalNumberOfApartments = totalNumberOfApartments;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getTotalNumberOfApartments() {
        return totalNumberOfApartments;
    }
}

class Apartment extends Building {
    private int apartmentNumber;
    private String ownerName;
    private String electricMeterNumber;

    public Apartment(String societyName, String location, String secretaryName, String buildingName, int totalNumberOfApartments,
            int apartmentNumber, String ownerName, String electricMeterNumber) {
        super(societyName, location, secretaryName, buildingName, totalNumberOfApartments);
        this.apartmentNumber = apartmentNumber;
        this.ownerName = ownerName;
        this.electricMeterNumber = electricMeterNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getElectricMeterNumber() {
        return electricMeterNumber;
    }
}

public class questionfour {
    public static void main(String[] args) {
        ResidentialSociety society = new ResidentialSociety("Galaxy-Apartment Residential Society", "Banjara Hills, Hyderabad", "John Doe");

        Building buildingA = new Building(society.getSocietyName(), society.getLocation(), society.getSecretaryName(), "A", 10);
        Building buildingB = new Building(society.getSocietyName(), society.getLocation(), society.getSecretaryName(), "B", 10);
        Building buildingC = new Building(society.getSocietyName(), society.getLocation(), society.getSecretaryName(), "C", 10);

        // Read the CSV file and create Apartment objects
        try (BufferedReader br = new BufferedReader(new FileReader("apartments.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int apartmentNumber = Integer.parseInt(parts[0]);
                String buildingName = parts[1];
                String ownerName = parts[2];
                String electricMeterNumber = parts[3];

                if (buildingName.equals("A")) {
                    Apartment apartment = new Apartment(society.getSocietyName(), society.getLocation(), society.getSecretaryName(),
                            buildingA.getBuildingName(), buildingA.getTotalNumberOfApartments(), apartmentNumber, ownerName, electricMeterNumber);
                    buildingA.addApartment(apartment);
                } else if (buildingName.equals("B")) {
                    Apartment apartment = new Apartment(society.getSocietyName(), society.getLocation(), society.getSecretaryName(),
                            buildingB.getBuildingName(), buildingB.getTotalNumberOfApartments(), apartmentNumber, ownerName, electricMeterNumber);
                    buildingB.addApartment(apartment);
                } else if (buildingName.equals("c")){
                    Apartment apartment = new Apartment(society.getSocietyName(), society.getLocation(), society.getSecretaryName(),
                    buildingC.getBuildingName(), buildingC.getTotalNumberOfApartments(), apartmentNumber, ownerName, electricMeterNumber);
            buildingC.addApartment(apartment);
        }
    }
 } catch (IOException e) {
        e.printStackTrace();
    }

    // View apartment details
    System.out.println("Apartment details:");
    for (Building building : new Building[] { buildingA, buildingB, buildingC }) {
        for (Apartment apartment : building.getApartments()) {
            System.out.println("Apartment number: " + apartment.getApartmentNumber());
            System.out.println("Owner name: " + apartment.getOwnerName());
            System.out.println("Electric meter number: " + apartment.getElectricMeterNumber());
            System.out.println("Building name: " + building.getBuildingName());
            System.out.println("Society name: " + society.getSocietyName());
            System.out.println("Location: " + society.getLocation());
            System.out.println("Secretary name: " + society.getSecretaryName());
            System.out.println();
        }
    }

    // View building details
    System.out.println("Building details:");
    for (Building building : new Building[] { buildingA, buildingB, buildingC }) {
        System.out.println("Building name: " + building.getBuildingName());
        System.out.println("Total number of apartments: " + building.getTotalNumberOfApartments());
        System.out.println("Society name: " + society.getSocietyName());
        System.out.println("Location: " + society.getLocation());
        System.out.println("Secretary name: " + society.getSecretaryName());
        System.out.println();
    }

    // View society details
    System.out.println("Society details:");
    System.out.println("Society name: " + society.getSocietyName());
    System.out.println("Location: " + society.getLocation());
    System.out.println("Secretary name: " + society.getSecretaryName());
        }
   }




                
