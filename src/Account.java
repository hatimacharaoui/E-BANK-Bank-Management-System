import java.util.Scanner;

public class Account {
    private int NumeroCompte;
    private double Solde;
    private String TypeCompte;

    public Account(int NumeroCompte, double Solde, String TypeCompte) {
        this.NumeroCompte = NumeroCompte;
        this.Solde = Solde;
        this.TypeCompte = TypeCompte;
    }

    public int getNumeroCompte(){
        return NumeroCompte;
    }

    public String getTypeCompte(){

        return TypeCompte;
    }
    public void setTypeCompte(String Tc){

        TypeCompte = Tc;
    }
    public double getSolde(){

        return Solde;
    }
    public void setSolde(double s){
        Solde += s;
    }
    public void retirerSolde(double s){

        Solde -= s;
    }
    public void afficherInfo(){
        System.out.println("      Numéro de Compte : " + NumeroCompte);
        System.out.println("      Type de Compte : " + TypeCompte);
        System.out.println("      Solde : "+ Solde +" DH");
    }

}
