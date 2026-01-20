public class Person {
    private int Identifiant;
    private String nom;
    private int age;

    public Person(String nom, int age,int Identifiant){
        this.nom = nom;
        this.age = age;
        this.Identifiant = Identifiant;
    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getIdentifiant() {
        return Identifiant;
    }
}
