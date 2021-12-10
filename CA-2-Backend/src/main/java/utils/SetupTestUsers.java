package utils;


import entities.Movie;
import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords


    User user = new User("user", "1234");
    User admin = new User("admin", "12345");
    User both = new User("user_admin", "1234");

    Movie movie1 = new Movie(1L, "Dick Johnson Is Dead", "As her father nears the end of his life, filmmaker Kirsten Johnson stages his death in inventive and comical ways to help them both face the inevitable.", "dick_johnson.jpeg");
    Movie movie2 = new Movie(2L, "Blood & Water", "After crossing paths at a party, a Cape Town teen sets out to prove whether a private-school swimming star is her sister who was abducted at birth.", "blood_water.jpg");
    Movie movie3 = new Movie(3L, "Ganglands", "To protect his family from a powerful drug lord, skilled thief Mehdi and his expert team of robbers are pulled into a violent and deadly turf war.", "ganglands.jpg");
    Movie movie4 = new Movie(4L, "Jailbirds New Orleans", "Feuds, flirtations and toilet talk go down among the incarcerated women at the Orleans Justice Center in New Orleans on this gritty reality series.", "new_orleans.jpg");
    Movie movie5 = new Movie(5L, "Kota Factory", "In a city of coaching centers known to train India’s finest collegiate minds, an earnest but unexceptional student and his friends navigate campus life.", "kota_factory.jpg");
    Movie movie6 = new Movie(6L, "Midnight Mass","The arrival of a charismatic young priest brings glorious miracles, ominous mysteries and renewed religious fervor to a dying town desperate to believe.","midnight_mass.jpg");
    Movie movie7 = new Movie(7L,"My Little Pony: A New Generation","Equestria's divided. But a bright-eyed hero believes Earth Ponies, Pegasi and Unicorns should be pals — and, hoof to heart, she’s determined to prove it.","my_little_pony_a_new_generation.jpg");
    Movie movie8 = new Movie(8L,"Spider-man 1","When bitten by a genetically modified spider, a nerdy, shy, and awkward high school student gains spider-like abilities that he eventually must use to fight evil as a superhero after tragedy befalls his family.","spider_man.jpg");
    Movie movie9 = new Movie(9L,"Spider-man 2","Peter Parker is beset with troubles in his failing personal life as he battles a brilliant scientist named Doctor Otto Octavius.", "spider_man_2.jpg");
    Movie movie10 = new Movie(10L,"Pulp Fiction","In the realm of underworld, a series of incidents intertwines the lives of two Los Angeles mobsters, a gangster's wife, a boxer and two small-time criminals.", "pulp-fiction.jpeg");

    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");


    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    em.persist(movie1);
    em.persist(movie2);
    em.persist(movie3);
    em.persist(movie4);
    em.persist(movie5);
    em.persist(movie6);
    em.persist(movie7);
    em.persist(movie8);
    em.persist(movie9);
    em.persist(movie10);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
    System.out.println("Created 4 movies in database for test");


  }

}
