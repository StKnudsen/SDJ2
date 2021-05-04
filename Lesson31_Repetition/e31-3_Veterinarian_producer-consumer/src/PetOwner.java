public class PetOwner implements Runnable
{
  WaitingRoom waitingRoom;
  String[] names = new String[] {"Otto", "Luna", "Paw", "Thea", "Alvin",
      "Freja", "Ben", "Ninus", "Prop", "Bertha"};

  public PetOwner(WaitingRoom waitingRoom)
  {
    this.waitingRoom = waitingRoom;
  }

  @Override public void run()
  {
    while (true)
    {
      String name = names[(int) Math.floor(Math.random() * 10)];
      int random = (int) Math.floor(Math.random() * 100);
      if (random < 15)
      {
        waitingRoom.newPatient(new Hamster(name));
      }
      if (random > 15 && random < 75)
      {
        waitingRoom.newPatient(new Dog(name));
      }
      if (random > 75)
      {
        waitingRoom.newPatient(new Cat(name));
      }
    }
  }
}
