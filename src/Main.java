import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Bank CIH = new Bank();
        int choix = 0;
        do {
            try {

        System.out.println("=========  CIH-BANK  =========");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Créer un compte bancaire");
        System.out.println("3. Créer un compte bancaire d'épargne");
        System.out.println("4. Consulter le solde");
        System.out.println("5. Déposer de l’argent");
        System.out.println("6. Retirer de l’argent");
        System.out.println("7. Supprimer un compte");
        System.out.println("8. supprimer un Client");
        System.out.println("9. Afficher les comptes");
        System.out.println("0. Quitter");
        System.out.println("==============================");
        System.out.println("Entrer votre choix :");

            Scanner sc = new Scanner(System.in);
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                        CIH.ajouterClient();
                        System.out.println("----------------------------");
                    break;
                case 2:
                        CIH.creerCompte();
                        System.out.println("----------------------------");
                    break;
                case 3:
                        CIH.creerCompteEpargne();
                    System.out.println("----------------------------");
                    break;
                case 4:
                    CIH.consulterSolde();
                    System.out.println("----------------------------");
                    break;
                case 5:
                    CIH.deposerArgent();
                    System.out.println("----------------------------");
                    break;
                case 6:
                    CIH.retirerArgent();
                    System.out.println("----------------------------");
                    break;
                case 7:
                    CIH.supprimerCompte();
                    System.out.println("----------------------------");
                    break;
                case 8:
                    CIH.supprimerClient();
                    System.out.println("----------------------------");
                    break;
                case 9:
                    CIH.afficherListAccount();
                    System.out.println("----------------------------");
                    break;
            }
            } catch (Exception e) {
                System.out.println("\nVeuillez entrer un nombre valide.");
                choix = -1; }

        } while (choix != 0);
    }
}