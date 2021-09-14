import java.util.Scanner; //Da wir Eingaben über die Tastatur erhalten, haben wir die Scannerklasse definiert.
class Transaktionen {
    int Saldo = 0;//Unser Saldo ist zunächst "0".
    int neuerSaldo;//Wir haben unser temporärer Guthaben definiert.
    float neuerSaldo2;
    static int [][] Beträge = new int[][]{  //Beispielbeträge, denen Benutzer beim Abheben oder Einzahlen von Geld begegnen
            {20,50,100,200,500}
    };
    static int [][] Bewertung = new int[][]{
            {1,2,3,4,5}
    };
    static String[][] menu = new String [][] { //Wir haben ein Array für das ATM-Menü definiert.
            {"\nDrücken Sie 1, um Geld abzuheben.", "Drücken Sie 2 , um Geld einzuzahlen."},
            {"Drücken Sie 3, um Ihr Guthaben zu ermitteln.", "Bitte geben Sie die durchzuführende Aktion ein:"}
    };
    public int geldabheben(int a){
        this.neuerSaldo = Saldo - a; //Hier haben wir unser neuer Saldo gefunden, indem wir den abzuhebenden Betrag von unserem alten Saldo abgezogen haben.
        return neuerSaldo;
    }
    public float geldabheben(float a){ //overloading işlemi
        this.neuerSaldo2 = Saldo - a; //Hier haben wir unser neuer Saldo gefunden, indem wir den abzuhebenden Betrag von unserem alten Saldo abgezogen haben.
        return neuerSaldo2;
    }
    public int geldeinzahlen(int a){
        this.neuerSaldo = Saldo + a; //Hier haben wir den neuen Betrag gefunden, indem wir unser neuer Saldo zu unserem alten Saldo hinzugefügt haben.
        return neuerSaldo;
    }
    public float geldeinzahlen(float a){ //overloading işlemi
        this.neuerSaldo2 = Saldo + a; //Hier haben wir den neuen Betrag gefunden, indem wir unser neuer Saldo zu unserem alten Saldo hinzugefügt haben.
        return neuerSaldo2;
    }
    public int getSaldo(){ //Get-Funktion ist definiert.
        return Saldo;
    }
}
public class ATM extends Transaktionen{
    private int Passwort;

    public ATM() {
        this.Passwort = 1907 ; //constructor.
    }

    public static void main(String[] args) {
        ATM atm1 = new ATM();
        System.out.println();

        int Passwort; //Wir haben unser Passwort definiert.
        int Handlungsbedarf; //Wir haben die zu ergreifenden Maßnahmen definiert.
        int neuerSaldo;
        int Saldo = 0;

        Scanner read = new Scanner(System.in); //Um Eingaben über die Tastatur zu erhalten.
        System.out.println("Hallo... Willkommen bei der Turan-Bank."); // Wir haben einen Willkommenssatz definiert, wenn unser Geldautomat funktioniert.
        System.out.println("\nBitte holen Sie sich Hilfe von unserer Kundendienstnummer 0216 xxx xx 00, um mehr über die Sonderangebote unserer Bank für Sie zu erfahren."); //
        System.out.println("\nBitte geben Sie Ihr Passwort ein:"); //Das Passwort erhalten wir vom Benutzer, unser Passwort ist fest, da wir keine Datenbank verwenden.
        Passwort = read.nextInt(); //Wir haben unser Passwort.
        for (int i = 1; i < 4; i++) { //Wir haben die for-Schleife verwendet, um den Benutzer nach 3 falschen Logins aus dem System zu werfen.
            if (Passwort == atm1.Passwort) { //Wenn das Passwort korrekt ist, wollten wir, dass es ohne Unterprozesse direkt zur Aktionsoption geht.
                System.out.println("\nIhr Passwort ist korrekt, Sie haben sich erfolgreich eingeloggt!");
                break;
            } else if (i == 3) { //Da i jedes Mal erhöht wird, wenn das Passwort falsch eingegeben wird, wird der Benutzer rausgeschmissen, wenn unser i-Wert gleich 3 ist.
                System.out.println("\nSie haben zu viele falsche Passwörter eingegeben, das System verlassen...");
                System.exit(0);
            } else { //Hier haben wir dafür gesorgt, dass wir bei jeder falschen Passworteingabe erneut eine Passworteingabe erhalten.
                System.err.println("\nSie haben ein falsches Passwort eingegeben!");
                System.err.println("\nBitte geben Sie Ihr Passwort ein:");
                Passwort = read.nextInt();
            }
        }
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); // Hier haben wir die Operationen ausgewählt, die wir in Cases* verwenden werden.
        for(int i=0 ; i<2 ; i++)
        {
            for(int j=0 ; j<2 ; j++)
            {
                System.out.println(menu[i][j]);
            }
        }
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Handlungsbedarf = read.nextInt(); //Wir haben die Aktion.
        switch (Handlungsbedarf) {
            case 1:
                for(int i=0; i<1; i++){
                    for(int j=0; j<5; j++) {
                        System.out.print(Transaktionen.Beträge[i][j] + "\n" );
                    }
                }
                System.out.print("\nSie können die Beträge nur im Menü abheben:"); //Wie oben erwähnt, haben wir jeweils Operationen für case1 definiert.
                int abzuhebenderBetrag; //Wir haben den abzuhebenden Betrag definiert.

                abzuhebenderBetrag = read.nextInt(); //Wir haben den abzuhebenden Betrag erhalten.
                if(abzuhebenderBetrag == 20 || abzuhebenderBetrag == 50 || abzuhebenderBetrag == 100 || abzuhebenderBetrag == 200 || abzuhebenderBetrag == 500 ){
                    neuerSaldo = atm1.geldabheben(abzuhebenderBetrag);
                    System.out.println("Transaktion Erfolgreich!");
                    System.out.println("Ihr neuer Saldo:" + neuerSaldo);
                    System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    for(int i=0; i<1; i++){
                        for(int j=0; j<5; j++) {
                            System.out.print(Transaktionen.Bewertung[i][j] + "\n" );
                        }
                    }
                    System.out.print("\nBitte bewerten Sie unseren Service (1-5):");
                    int degerlendirme;
                    degerlendirme = read.nextInt(); //Wir haben die Bewertung bekommen.
                    System.out.println("Vielen Dank, dass Sie uns bewertet haben. Einen schönen Tag noch!");
                    break; //Wir haben diesen Befehl verwendet, damit der Prozess nicht ständig wiederholt wird, damit er an den Unterprozess übergeben werden kann.
                }
                else{
                    System.out.print("\nSie können nur die Beträge auf der Speisekarte abheben!!!");
                    break;
                }
            case 2: //Wie oben in Case 2 erwähnt, haben wir die Operationen der Reihe nach definiert.

                for(int i=0; i<1; i++){
                    for(int j=0; j<5; j++) {
                        System.out.print(Transaktionen.Beträge[i][j] + "\n" );
                    }
                }
                System.out.print("\nSie können die Beträge nur im Menü abheben:");  //Wir baten um die Einzahlung des Betrags.
                int EinzuzahlenderBetrag; // Wir haben den einzuzahlenden Betrag definiert.
                EinzuzahlenderBetrag = read.nextInt();
                if(EinzuzahlenderBetrag == 20 || EinzuzahlenderBetrag == 50 || EinzuzahlenderBetrag == 100 || EinzuzahlenderBetrag == 200 || EinzuzahlenderBetrag == 500 ){
                    neuerSaldo = atm1.geldeinzahlen(EinzuzahlenderBetrag); // Wir haben den einzuzahlenden Betrag unserem Saldo hinzugefügt und unser neuer Saldo gefunden.
                    System.out.println("Transaktion Erfolgreich!\"");
                    System.out.println("Ihr neuer Saldo:" + neuerSaldo); // Wir haben unser neuer Saldo gedruckt.
                    System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                    for(int i=0; i<1; i++){
                        for(int j=0; j<5; j++) {
                            System.out.print(Transaktionen.Bewertung[i][j] + "\n" );
                        }
                    }
                    System.out.print("\nBitte bewerten Sie unseren Service (1-5):");
                    int degerlendirme;
                    degerlendirme = read.nextInt(); //Wir haben die Bewertung bekommen.
                    System.out.println("Vielen Dank, dass Sie uns bewertet haben. Einen schönen Tag noch!");
                    break; //Wir haben diesen Befehl verwendet, damit der Prozess nicht ständig wiederholt wird, damit er an den Unterprozess übergeben werden kann.
                }
                else{
                    System.out.print("\nSie können nur so viel einzahlen, wie es auf der Speisekarte steht!!!");
                    break;
                }
            case 3: //Wie oben erwähnt, haben wir jeweils Operationen für Case3 definiert. //// Wo die Funktion verwendet wird:
                System.out.println("Dein Kontostand:" + atm1.getSaldo()); //Wir haben unsere Bilanz auf dem Bildschirm ausgedruckt.
                break; //Wir haben diesen Befehl verwendet, damit der Prozess nicht ständig wiederholt wird, damit er an den Unterprozess übergeben werden kann.

            default: //Wir starten das Programm nach der falschen Eingabe des Benutzers neu.
                System.err.println("Sie haben falsch eingegeben, bitte versuchen Sie es erneut.");
        }
    }
}
