import org.w3c.dom.ls.LSOutput;

public class SavingsAccount extends Account{
    private double TauxInteret = 0.03;

    public SavingsAccount( int NumeroCompte, double Solde, String TypeCompte) {
        super( NumeroCompte, Solde, TypeCompte);
    }

    public double getTauxInteret(){
        return TauxInteret;
    }
    public void setTauxInteret(double TauxInteret){
        this.TauxInteret = TauxInteret;
    }

    public void calculerInterets(double montant) {
          double montantInterets = ( montant * TauxInteret ) + montant ;
          setSolde(montantInterets);
    }

    @Override
    public void afficherInfo(){
        System.out.println("      Numéro de Compte : " + getNumeroCompte());
        System.out.println("      Type de Compte : " + getTypeCompte());
        System.out.println("      Solde : "+ getSolde() +" DH");
    }
}
