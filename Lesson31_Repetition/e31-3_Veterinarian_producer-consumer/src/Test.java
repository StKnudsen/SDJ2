public class Test
{
  public static void main(String[] args)
  {
    WaitingRoom waitingRoom = new WaitingRoom();
    Veterinarian veterinarian = new Veterinarian(waitingRoom);
    PetOwner petOwner1 = new PetOwner(waitingRoom);
    //PetOwner petOwner2 = new PetOwner(waitingRoom);
    //PetOwner petOwner3 = new PetOwner(waitingRoom);

    new Thread(veterinarian).start();
    new Thread(petOwner1).start();
    //new Thread(petOwner2).start();
    //new Thread(petOwner3).start();
  }
}
