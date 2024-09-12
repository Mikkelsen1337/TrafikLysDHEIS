    import java.util.Scanner;

/*
Du er ansvarlig for trafikstyringen i en by. Baseret på forskellige forhold skal du afgøre,
hvad et trafiklys skal vise (grønt, gult eller rødt), og hvilke biler der skal få adgang til et bestemt område af byen.
Der er flere faktorer, der spiller ind:

1. Tid på dagen (dag, aften eller nat).
2. Trafikmængde (høj eller lav).
3. Området er en boligzone, erhvervsområde eller en blandet zone.
4. Nød-tilstand (f.eks. ambulancer eller brandbiler) har altid prioritet.

Programmet skal bruge if-else-udsagn og logiske operatorer til at træffe beslutninger baseret på disse forhold.

Krav:

1. Brugeren skal kunne indtaste:
o Tid på dagen (dag, aften, nat).
o Trafikmængde (høj eller lav).
o Områdets type (bolig, erhverv, blandet).
o Om der er en nødsituation (ja/nej).
2. Programmet skal baseret på disse input beslutte
o Trafiklysfarve:
§ Grønt: Hvis det er dag og trafikmængden er lav, eller hvis der er en nødsituation.
§ Gult: Hvis det er aften, eller hvis det er nat med lav trafik.
§ Rødt: Hvis det er nat med høj trafik, eller hvis det er boligområde med høj trafikmængde uanset tid.
o Adgang til området:
§ Tillad biler at køre, hvis det er erhvervsområde eller blandet zone med lav trafik.
§ Forbyd biler at køre i boligområder om natten, uanset trafikmængden.
 */



public class TrafikLys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Vi starter med at få input fra brugeren
        System.out.println("Indtast tid på dagen dag/aften/nat: ");
        String tidDagen = scanner.nextLine();

        System.out.println("Trafik mængde høj eller lav: ");
        String trafikMængde = scanner.nextLine();

        System.out.println("Områdets type bolig/erhverv/blandet: ");
        String områdeType = scanner.nextLine();

        System.out.println("Nødsituation ja/nej: ");
        String nødSituation = scanner.nextLine();

        //Sæt trafiklysets farve
        String trafiklys;
        if (nødSituation.equals("ja")) {
            trafiklys = "Grøn";
        } else if (tidDagen.equals("dag") && trafikMængde.equals("lav")) {
            trafiklys = "Grøn";
        } else if (tidDagen.equals("aften")) {
            trafiklys = "Gult";
        } else if (tidDagen.equals("nat") && trafikMængde.equals("lav")) {
            trafiklys = "Gult";
        } else if (tidDagen.equals("nat") && trafikMængde.equals("høj")) {
            trafiklys = "Rødt";
        } else if (områdeType.equals("bolig") && trafikMængde.equals("høj")) {
            trafiklys = "Rødt";
        } else {
            trafiklys = "Grønt";
        }

        /*
        Her vælger vi hvordan vores adgangs funktion skal fungere, vi oplyser hvilke handlinger der skal ske hvis adgang gives,
        samt hvilke handlinger der ikke skal gives hvis der nægtes adgang.
         */
        boolean adgang;

        if (områdeType.equals("bolig") && tidDagen.equals("nat")) {
            adgang = false;
        }
        else if (områdeType.equals("erhverv") || områdeType.equals("blandet")) {
            adgang = trafikMængde.equals("lav");
            }
        else {
            adgang = true;
        }

    /*
    Her sender vi et print som altid vil vise hvad farven på trafiklyset er, ligegyldigt brugerens input
     */
        System.out.println("Trafiklyset er: " + trafiklys);


        if (adgang == true){
            System.out.println("Velkommen ind!");
        }
        else if (adgang == false){
             System.out.println(" Ingen adgang! ");
        }


    scanner.close();


    }

}





