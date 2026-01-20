public class Client extends Person{
    private static int compteur = 0;
    private int NumeroClient;

    public Client(String nom, int age, int Identifiant){
        super(nom,age,Identifiant);
        this.NumeroClient = ++compteur;
    }

    public int getNumeroClient(){
        return NumeroClient;
    }

}
