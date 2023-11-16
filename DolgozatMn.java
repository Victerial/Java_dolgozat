class Noveny
{
    String nev;
    int viz;

    public Noveny(String nev, int viz){
        this.nev=nev;
        this.viz=viz;
    }

    boolean vizKell(){
        return false;
    }

    void ontozes(int osztas){}

    public String toString(){
        return "A " + nev + " növényt öntözni kell";
    }
}

class Virag extends Noveny{
    public Virag(String nev, int viz){
        super(nev, viz);
    }

    boolean vizKellViragnak(){
        return viz < 5;
    }

    void ontoz(int osztas){
        viz += osztas * 0.75;
    }
}

class Fa extends Noveny{
    public Fa(String nev, int viz){
        super(nev, viz);
    }

    boolean vizKellFanak(){
        return viz < 10;
    }

    void ontoz(int osztas){
        viz+=osztas*0.4;
    }
}

class Kert{
    Noveny[] noveny;

    public Kert(){
        noveny = new Noveny[0];
    }

    void Allapot(){
        System.out.println("A kert állapota: ");
        for(Noveny noveny:noveny){
            System.out.println(", " + noveny);
        }
    }

    void ontoz(int viz){
        System.out.println("Öntöz: ");
        int db=0;
        for(Noveny noveny: noveny){
            if(noveny.vizKell()){
                db++;
            }
        }

        int osztas = db > 0 ? viz/db : 0;

        for(Noveny noveny : noveny){
            if(noveny.vizKell()){
                noveny.ontozes(osztas);
                System.out.println(" " + noveny);
            } else{
                System.out.println(" " + noveny);
            }


        }
    }
}

public class DolgozatMn{
    public static void main(String[] args){
        Kert kert = new Kert();
        new Virag("Sárga", 0);
        new Virag("Kék", 0);

        new Fa("lonc fa", 0);
        new Fa("Narancs", 0);

        kert.Allapot();

        kert.ontoz(40);
        kert.ontoz(70);
    }
}