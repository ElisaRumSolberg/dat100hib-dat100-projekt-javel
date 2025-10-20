package no.hvl.dat100.javel.oppgave3;

import no.hvl.dat100.javel.oppgave4.Customers;

public class CustomerMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 3");
        System.out.println("==============");
        System.out.println();

        // 1) Create a Customer object (constructor test)
        Customer c = new Customer(
                "Alice Smith",
                "alice@example.com",
                1001,
                PowerAgreementType.SPOTPRICE
        );


        Customer c1 = new Customer(
                "Elisa Rumeysa Solberg",
                "elisarumeysasolbeg@gmail.com",
                1001,
                PowerAgreementType.SPOTPRICE
        );
        Customer c2 = new Customer(
                "Alissa Ruya Aksel",
                "rs.aksel.7@gmail.com",
                1002,
                PowerAgreementType.NORGESPRICE
        );
        Customer c3 = new Customer(
                "Samsam Abdi-Kerim",
                "samsam@hotmail.com",
                1003,
                PowerAgreementType.POWERSUPPORT
        );

        System.out.println("== Created customer ==");
        // Print using toString()
        System.out.println(c);
        System.out.println();
        System.out.println(c1);
        System.out.println("======================");
        System.out.println(c2);
        System.out.println("======================");
        System.out.println(c3);
        System.out.println();

        // 3) Test getters
        System.out.println("== Getter tests ==");
        System.out.println("Name: " + c.getName());
        System.out.println("Email: " + c.getEmail());
        System.out.println("Customer ID: " + c.getCustomer_id());
        System.out.println("Agreement: " + c.getAgreement());
        System.out.println("==========================");

        // 4) Test setters (update some fields)
        // Test setters (change some fields)
        c.setName("Alice B. Smith");
        c.setEmail("alice.b@example.com");
        c.setAgreement(PowerAgreementType.NORGESPRICE);

        c1.setEmail("elsol0297@hvl.no");
        c1.setAgreement(PowerAgreementType.POWERSUPPORT);
        c1.setName("Elisa R. Solberg");

        c3.setEmail("190154@stud.hvl.no");

        // 5) Print again after updates
        System.out.println("== After updates (setter tests) ==");
        System.out.println(c);
        System.out.println("========================");
        System.out.println(c1);
        System.out.println("========================");
        System.out.println(c2);
        System.out.println("========================");
        System.out.println(c3);
        System.out.println("========================");

        boolean ok =
                "Alice Smith".equals(c.getName()) &&
                        "alice@example.com".equals(c.getEmail()) &&
                        c.getCustomer_id() == 1001 &&
                        c.getAgreement() == PowerAgreementType.SPOTPRICE;

        System.out.println("All basic tests passed for c?: " + ok);
        System.out.println("====================================");

        boolean ok1 =
                "Elisa R. Solberg".equals(c1.getName()) &&
                        "elisa.r.solberg@hvl.no".equals(c1.getEmail()) &&
                        c1.getCustomer_id() == 1001 &&
                        c1.getAgreement() == PowerAgreementType.NORGESPRICE;
        System.out.println("All basic tests passed for c1?: " + ok1);
        System.out.println("====================================");

        boolean ok2 =
                "Alissa Ruya Aksel".equals(c2.getName()) &&
                        "rs.aksel.7@gmail.com".equals(c2.getEmail())&&
                        c2.getCustomer_id()==1002 &&
                        c2.getAgreement() ==PowerAgreementType.NORGESPRICE;
        System.out.println("All basic tests passed for c2?: " + ok2);
        System.out.println("====================================");

        boolean ok3=
                "Samsam Abdi-Kerim".equals(c3.getName()) &&
                        "190154@stud.hvl.no".equals(c3.getEmail()) &&
                        c3.getCustomer_id()==1003 &&
                        c3.getAgreement() == PowerAgreementType.SPOTPRICE;
        System.out.println("All basic tests passed for c3?: " + ok3);










    }
}
