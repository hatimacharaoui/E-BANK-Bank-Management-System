import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Client> clients;
    private ArrayList<SavingsAccount> savingsAccounts;

    public Bank(){
        accounts = new ArrayList<>();
        clients = new ArrayList<>();
        savingsAccounts = new ArrayList<>();
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public ArrayList<Client> getClients(){
        return clients;
    }

    public void ajouterClient() {
        Scanner scanner = new Scanner(System.in);
        try{
        System.out.println("Entrer votre Nom: ");
        String nom = scanner.nextLine();
        System.out.println("entrer votre identifiant: ");
        int id = scanner.nextInt();
        System.out.println("Entrer votre Age: ");
        int age = scanner.nextInt();

        if( age < 18){
            System.out.println("L’âge minimum requis pour l’ouverture d’un compte est de 18 ans.");
            return;
        }
        Client c = new Client(nom,age,id);
        clients.add(c);
        System.out.println("Le client a été ajouté avec succès");
        System.out.println("   Numéro de client : "+ c.getNumeroClient());
        System.out.println("   Identifiant : "+id + ", Nom : "+nom+", Age : "+ age);

        } catch (Exception e) {
            System.out.println("\nVeuillez entrer un nombre valide.");
        }
    }
    public void supprimerClient() {
        Scanner scanner = new Scanner(System.in);
        try {
        int numClient = 0;
        int num;
        boolean trouve = false;
        do{
        System.out.println("Entrer le numéro de client: ");
        num = scanner.nextInt();
        for(Client c : clients){
            if (c.getNumeroClient() == num) {
                numClient = c.getNumeroClient();
                clients.remove(c);
                trouve = true;
                break;
            }
        }
        if (trouve){
            System.out.println("Le client a été supprimé avec succès");
        }else { System.out.println("Aucun client ne correspond à ce numéro.");}

        }while (num != numClient);

        } catch (Exception e) {
        System.out.println("\nVeuillez entrer un nombre valide."); }
    }

    public void creerCompte() {

        try {
            Scanner scanner = new Scanner(System.in);
            int numClient = 0;
            int num;
        do{
                System.out.println("Entrer le numéro de client: ");
                num = scanner.nextInt();
                for(Client c : clients){
                    if (c.getNumeroClient() == num){
                        numClient = c.getNumeroClient();
                    }else { System.out.println("Aucun client ne correspond à ce numéro.");}
                }
            }while (num != numClient);

        double solde;
        do {
            System.out.println("Entrer un solde initial: ");
            solde = scanner.nextDouble();
            if (solde < 100) {
                System.out.println("Le montant à déposer doit être supérieur à 100 DH\n");
            }
        }while (solde < 100);

        Account a = new Account(num,solde,"Compte bancaire générique");
            accounts.add(a);
            a.afficherInfo();

        System.out.println("\n Souhaitez-vous créer un compte épargne ? ");
        System.out.println("1. OUI !");
        System.out.println("2. NON !");
        int choix = scanner.nextInt();
            if (choix == 1){
                System.out.println("Entrer un solde initial: ");
                double solde1 = scanner.nextDouble();
                SavingsAccount sa = new SavingsAccount(num, solde1,"Compte bancaire d'épargne");
                savingsAccounts.add(sa);
                System.out.println("Le compte a été créé avec succès");
            }
        } catch (Exception e) {
            System.out.println("\nVeuillez entrer un nombre valide."); }
    }

    public void supprimerCompte() {
        Scanner scanner = new Scanner(System.in);
        try{
        System.out.println("Choisir le type de compte à supprimer: ");
        System.out.println("1. Compte bancaire générique ");
        System.out.println("2. Compte bancaire d'épargne ");
        int choix = scanner.nextInt();
        System.out.println("Entrer le numéro de compte: ");
        int numCompte = scanner.nextInt();

        boolean trouve = false;
        if (choix == 1){
            for (Account a : accounts){
                if(a.getNumeroCompte() == numCompte){
                    accounts.remove(a);
                    trouve = true;
                    break;
                }
            }
        } else if (choix == 2) {
            for (SavingsAccount a : savingsAccounts){
                    if(a.getNumeroCompte() == numCompte){
                        savingsAccounts.remove(a);
                        trouve = true;
                        break;
                    }
                }
        }
        if(trouve){
            System.out.println("Le compte a été supprimé avec succès");
        } else { System.out.println("Ce numéro de compte n'existe pas."); }


        } catch (Exception e) {
            System.out.println("\nVeuillez entrer un nombre valide."); }
    }

    public void nomClient(int numAccount){
        for (Client c : clients){
            if (c.getNumeroClient() == numAccount){
                System.out.println("   Numéro de Compte : "+ numAccount);
                System.out.println("      Nom : "+ c.getNom());
            }
        }
    }
    public void afficherListAccount() {
        System.out.println("Liste des comptes bancaires générique:");
        for (Account a : accounts) {
            int numAccount = a.getNumeroCompte();
            nomClient(numAccount);
            a.afficherInfo();
        }
        System.out.println("Liste des comptes bancaires d'épargne :");
        for (SavingsAccount a : savingsAccounts) {
            int numAccount = a.getNumeroCompte();
            nomClient(numAccount);
            a.afficherInfo();
        }
    }

    public void consulterSolde() {
        Scanner sc = new Scanner(System.in);
        try{

        System.out.println("Choisir votre type de compte : ");
        System.out.println("1. Compte bancaire générique ");
        System.out.println("2. Compte bancaire d'épargne ");
        int choix = sc.nextInt();
        System.out.println("Entrer le numéro de compte: ");
        int numCompte = sc.nextInt();
        boolean trouve = false;
        if (choix == 1){
            for (Account a : accounts){
                if(a.getNumeroCompte() == numCompte){
                    System.out.println("Solde actuel du compte bancaire: "+ a.getSolde()+" DH");
                    trouve = true;
                }
            }
        } else if (choix == 2) {
            for (SavingsAccount a : savingsAccounts){
                if(a.getNumeroCompte() == numCompte){
                    System.out.println("Solde actuel du compte bancaire: "+ a.getSolde()+" DH");
                    trouve = true;
                }
            }
        }
        if (!trouve){
            System.out.println("Ce numéro de compte n'existe pas.");
        }
        } catch (Exception e) {
            System.out.println("\nVeuillez entrer un nombre valide."); }
    }
    public void deposerArgent() {
        Scanner sc = new Scanner(System.in);
        try{

        System.out.println("Choisir le type de compte : ");
        System.out.println("1. Compte bancaire générique ");
        System.out.println("2. Compte bancaire d'épargne ");
        int choix = sc.nextInt();
        System.out.println("Entrer le numéro de compte: ");
        int num = sc.nextInt();
        double montant;
        do {
            System.out.println("Entrer le montant que vous souhaitez déposer: ");
             montant = sc.nextDouble();
            if (montant < 100) {
                System.out.println("Le montant à déposer doit être supérieur à 100 DH\n");
            }
        }while (montant < 100);

        boolean trouve = false;
        if (choix == 1){
            for (Account a : accounts) {
                if (a.getNumeroCompte() == num) {
                    a.setSolde(montant);
                    trouve = true;
                }
            }
        } else if (choix == 2) {
            for (SavingsAccount a : savingsAccounts) {
                if (a.getNumeroCompte() == num) {
                    a.calculerInterets(montant);
                    trouve = true;
                }
            }
        }
            if (trouve){
                System.out.println("Votre montant a été déposé avec succès.");
            }else { System.out.println("Ce numéro de compte n'existe pas."); }

        } catch (Exception e) {
            System.out.println("\nVeuillez entrer un nombre valide."); }
    }

    public void retirerArgent() {
        Scanner sc = new Scanner(System.in);
        try {

        System.out.println("Choisir le type de compte : ");
        System.out.println("1. Compte bancaire générique ");
        System.out.println("2. Compte bancaire d'épargne ");
        int choix = sc.nextInt();
        System.out.println("Entrer le numéro de compte: ");
        int num = sc.nextInt();
        double montant;
        do {
            System.out.println("Entrez le montant que vous souhaitez retirer: ");
            montant = sc.nextDouble();
            if (montant < 100) {
                System.out.println("Le montant du retrait doit être supérieur à 100 DH\n");
            }
        }while (montant < 100);

        boolean trouve = false;
        if (choix == 1){
            for (Account a : accounts) {
                if (a.getNumeroCompte() == num) {
                    a.retirerSolde(montant);
                    trouve = true;
                }
            }
        } else if (choix == 2) {
            for (SavingsAccount a : savingsAccounts) {
                if (a.getNumeroCompte() == num) {
                    a.retirerSolde(montant);
                    trouve = true;
                }
            }
        }
            if (trouve){
                System.out.println("Le retrait a été effectué avec succès.");
            }else { System.out.println("Ce numéro de compte n'existe pas."); }

        } catch (Exception e) {
            System.out.println("\nVeuillez entrer un nombre valide."); }
    }
}







