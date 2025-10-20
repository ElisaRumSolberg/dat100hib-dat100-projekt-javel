package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    // Hjelpemetode skriver ut en komprimert liste over alle lagrede kunder
    private static void printList(Customer[] list, String title) {
        System.out.println(title);
        if (list.length == 0) {
            System.out.println(" (empty)");
        } else {
            for (Customer c : list) {
                System.out.println(" - " + c);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {




        System.out.println("==============");
        System.out.println("OPPGAVE 4");
        System.out.println("==============");
        System.out.println();

        // a) Konstruktør-test: Opprett et Customers-objekt (referansetabell) med kapasitet 12
        System.out.println(" a: Konstruktør (Customers(int size)");
        Customers repo = new Customers(12);

        // Testdata –  fra oppgave 3)
        Customer sAlice  = new Customer("Alice Smith", "alice@example.com",
                1001, PowerAgreementType.SPOTPRICE);
        Customer sElisa  = new Customer("Elisa Rumeysa Solberg", "elisarumeysasolbeg@gmail.com",
                1002, PowerAgreementType.SPOTPRICE);
        Customer sAlissa = new Customer("Alissa Ruya Aksel", "rs.aksel.7@gmail.com",
                1003, PowerAgreementType.NORGESPRICE);
        Customer sSamsam = new Customer("Samsam Abdi-Karim", "samsam@hotmail.com",
                1004, PowerAgreementType.POWERSUPPORT);

        // Testdata – LÆRERENS eksempelsett
        Customer hBob     = new Customer("Bob Johnson",    "bob@example.com",
                1005, PowerAgreementType.NORGESPRICE);
        Customer hCharlie = new Customer("Charlie Rose",   "charlie@example.com",
                1006, PowerAgreementType.POWERSUPPORT);
        Customer hDiana   = new Customer("Diana Prince",   "diana@example.com",
                1007, PowerAgreementType.NORGESPRICE);
        Customer hEthan   = new Customer("Ethan Hunt",     "ethan@example.com",
                1008, PowerAgreementType.POWERSUPPORT);

        // d) addCustomer: Sett inn alle kundene i første ledige (null) posisjon
        System.out.println("d: Sette inn kunde (addCustomer");

        System.out.println("Add sAlice:   "  + repo.addCustomer(sAlice));
        System.out.println("Add sElisa:   "  + repo.addCustomer(sElisa));
        System.out.println("Add sAlissa:  "  + repo.addCustomer(sAlissa));
        System.out.println("Add sSamsam:  "  + repo.addCustomer(sSamsam));
        System.out.println("Add hBob:     "  + repo.addCustomer(hBob));
        System.out.println("Add hCharlie: "  + repo.addCustomer(hCharlie));
        System.out.println("Add hDiana:   "  + repo.addCustomer(hDiana));
        System.out.println("Add hEthan:   "  + repo.addCustomer(hEthan));
        System.out.println();

        System.out.println("===========================");

        // b) countNonNull Tell hvor mange ikke-null referanser som er lagret
        System.out.println( " b: Telle antall kunder (countNonNull)");
        System.out.println("Count (non-null): " + repo.countNonNull() + "\n");




        // f) getCustomers: Hent en ny komprimert tabell med alle lagrede kunder (uten null-plasser)
        System.out.println("f: Kunde referansetabell (getCustomers)");
        printList(repo.getCustomers(), "Alle kunder (komprimert liste):");

        System.out.println("===========================");

        // c) getCustomer  Finn kunde med gitt id (eksisterende og ikke-eksisterende eksempler)
        System.out.println("c: Hente kunde (getCustomer)");
        System.out.println("Get existing (1003): " + repo.getCustomer(1003)); // forventer Alissa
        System.out.println("Get existing (1007): " + repo.getCustomer(1007)); // forventer Diana
        System.out.println("Get missing  (9999): " + repo.getCustomer(9999)); // forventer null
        System.out.println();
        System.out.println("===========================");


        // e) removeCustomer  Slett kunde med id og returner referansen til slettet objekt
        System.out.println("e: Slette kunde (removeCustomer)");
        System.out.println("Remove id=1002 (Elisa): " + repo.removeCustomer(1002));
        System.out.println("Remove id=1008 (Ethan): " + repo.removeCustomer(1008));
        System.out.println("Count (after removes): " + repo.countNonNull() + "\n");

        // Vis tilstanden etter sletting
        printList(repo.getCustomers(), "Etter sletting:");

        System.out.println("===========================");
        // d) addCustomer (på nytt) Sett inn en ny kunde etter at det har blitt ledig plass
         System.out.println(" d: Sette inn ny kunde etter sletting " );
        Customer extra = new Customer("New Person", "new@example.com",
                3001, PowerAgreementType.SPOTPRICE);
        System.out.println("Add extra (3001): " + repo.addCustomer(extra));

        // Sluttstatus
        System.out.println("===========================");
        printList(repo.getCustomers(), "Endelig liste:");

    }
}
