import java.util.ArrayList;

public class WaitingRoom
{
  private ArrayList<Pet> petsArrayList;
  private final int capacity = 10;
  private int dogs = 0, cats = 0, hamsters = 0;

  public WaitingRoom()
  {
    petsArrayList = new ArrayList<>();
  }

  public synchronized void newPatient(Pet pet)
  {
    while (noGo(pet))
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    petsArrayList.add(pet);
    System.out.println(
        "-->  " + pet.getName() + " som er en " + pet.getSpecies()
            + " skal reddes - Antal dyr i venteværelset: " + petsArrayList
            .size());
    if (pet.getSpecies().equals("hund"))
    {
      dogs++;
    }
    if (pet.getSpecies().equals("kat"))
    {
      cats++;
    }
    if (pet.getSpecies().equals("hamster"))
    {
      hamsters++;
    }
    notifyAll();
  }

  public synchronized void curePatient()
  {
    while (petsArrayList.isEmpty())
    {
      try
      {
        wait();
        System.out.println("Alle dyr er enten kurerede eller døde...");
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    Pet pet = petsArrayList.remove(0);
    System.out.println(
        "<--  " + pet.getSpecies() + ", der hedder " + pet.getName()
            + ", er blevet lokket ind til dyrlægen, på med plaster! Antal dyr i venteværelset: "
            + petsArrayList.size());
    if (pet.getSpecies().equals("hund"))
  {
    dogs--;
  }
    if (pet.getSpecies().equals("kat"))
    {
      cats--;
    }
    if (pet.getSpecies().equals("hamster"))
    {
      hamsters--;
    }
    notifyAll();
  }

  private boolean noGo(Pet pet)
  {
    if (petsArrayList.size() == capacity)
    {
      System.out.println("Venteværelset er fuldt! Paniiik!!!");
      return true;
    }
    if (pet.getSpecies().equals("kat") && hamsters > 0)
    {
      System.out.println("-X-  Ingen katte - der er en hamster til stede! " +
          pet.getName() + " må vente udenfor!");
      return true;
    }
    if (pet.getSpecies().equals("hamster") && cats > 0)
    {
      System.out.println("-X-  Ingen hamstere - der er en kat til stede! " +
          pet.getName() + " må vente udenfor!");
      return true;
    }
    //Hvis der er mere end 2 hunde må der ikke være katte
    if (pet.getSpecies().equals("kat") && dogs > 2)
    {
      System.out.println("-X-  Ingen katte - der er mere end to hunde! " +
          pet.getName() + " må vente udenfor!");
      return true;
    }
    if (pet.getSpecies().equals("hund") && cats > 2)
    {
      System.out.println("-X-  Ingen hunde - der er mere end to katte! " +
          pet.getName() + " må vente udenfor!");
      return true;
    }
    //Hvis der er mere end 2 katte må der ikke være hunde
    if (pet.getSpecies().equals("kat") && cats >= 2 && dogs > 0)
    {
      System.out.println("-X-  Der må ikke være flere katte i rummet!" +
          pet.getName() + " må vente udenfor!");
      return true;
    }
    if (pet.getSpecies().equals("hund") && dogs >= 2 && cats > 0)
    {
      System.out.println("-X-  Der må ikke være flere hunde i rummet!" +
          pet.getName() + " må vente udenfor!");
      return true;
    }
    return false;
  }
}
