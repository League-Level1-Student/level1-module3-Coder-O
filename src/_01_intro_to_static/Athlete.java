package _01_intro_to_static;

public class Athlete {
    static int nextBibNumber = 1;
    static String raceLocation = "New York";
    static String raceStartTime = "9.00am";

    String name;
    int speed;
    int bibNumber;

    Athlete (String name, int speed){
        this.name = name;
        this.speed = speed;
        this.bibNumber = nextBibNumber;
        nextBibNumber++;
    }

    public static void main(String[] args) {
        //create two athletes
        //print their names, bibNumbers, and the location of their race. 
    	Athlete joana = new Athlete("Joana",41);
    	Athlete jared = new Athlete("Jared",40);
    	System.out.println(joana.name);
    	System.out.println(joana.bibNumber);
    	System.out.println(joana.raceLocation);
    	System.out.println(jared.name);
    	System.out.println(jared.bibNumber);
    	System.out.println(jared.raceLocation);
    }
}