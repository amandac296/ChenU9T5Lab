import java.util.ArrayList;

public class Cabaret {
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name){
        this.name = name;
        performers = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Performer> getPerformers(){
        return performers;
    }

    public boolean addPerformer(Performer newPerformer){
        if (!performers.contains(newPerformer)) {
            performers.add(newPerformer);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer badPerformer){
        if (performers.contains(badPerformer)) {
            performers.remove(badPerformer);
            return true;
        }
        return false;
    }

    public double averagePerformerAge(){
        double sum = 0;
        for (Performer eachP : performers){
            sum += eachP.getAge();
        }
        return sum/performers.size();
    }

    public ArrayList<Performer> performersOverAge (int age){
        ArrayList<Performer> old = new ArrayList<>();
        for (Performer each : performers){
            if (each.getAge() >= age){
                old.add(each);
            }
        }
        return old;
    }

    public void groupRehearsal() {
        for (Performer each : performers){
            System.out.println("REHEARSAL CALL! " + each.getName());
            if (each instanceof Comedian) {
                Comedian temp = (Comedian) each;
                temp.rehearse();
            } else {
                each.rehearse();
            }
        }
    }

    public void cabaretShow(){
        for (Performer each : performers){
            System.out.println("Welcome to the cabaret! Next act up is ... " + each.getName());
            if (each instanceof Dancer){
                Dancer temp = (Dancer) each;
                temp.pirouette(2);
            }
            each.perform();
        }
    }
}
