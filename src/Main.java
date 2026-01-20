import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Bank CIH = new Bank();
        int choix = 0;
        do {
            try {

        System.out.println("========  CIH-BANK  ========");
        System.out.println("1. Ajouter un client");
        System.out.println("2. Créer un compte bancaire");
        System.out.println("3. Consulter le solde");
        System.out.println("4. Déposer de l’argent");
        System.out.println("5. Retirer de l’argent");
        System.out.println("6. Supprimer un compte");
        System.out.println("7. supprimer un Client");
        System.out.println("8. Afficher les comptes");
        System.out.println("0. Quitter");
        System.out.println("============================");
        System.out.println("Entrer votre choix :");

            Scanner sc = new Scanner(System.in);
            choix = sc.nextInt();
            switch (choix) {
                case 1:
                        CIH.ajouterClient();
                        System.out.println("\n -------------------------- \n");
                    break;
                case 2:
                        CIH.creerCompte();
                        System.out.println("\n -------------------------- \n");

                    break;
                case 3:
                        CIH.consulterSolde();
                        System.out.println("\n -------------------------- \n");

                    break;
                case 4:
                        CIH.deposerArgent();
                        System.out.println("\n -------------------------- \n");

                    break;
                case 5:
                        CIH.retirerArgent();
                        System.out.println("\n -------------------------- \n");

                    break;
                case 6:
                        CIH.supprimerCompte();
                        System.out.println("\n -------------------------- \n");


                    break;
                case 7:
                        CIH.supprimerClient();
                        System.out.println("\n -------------------------- \n");

                    break;
                case 8:
                        CIH.afficherListAccount();
                        System.out.println("\n -------------------------- \n");

                    break;
            }
            } catch (Exception e) {
                System.out.println("\nVeuillez entrer un nombre valide.");
                choix = -1; }

        } while (choix != 0);
    }
}