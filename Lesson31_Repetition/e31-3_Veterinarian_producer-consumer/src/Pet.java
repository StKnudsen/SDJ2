public abstract class Pet
{
  private String species;
  private String sound;
  private String name;

  public Pet(String species, String sound, String name)
  {
    this.species = species;
    this.sound = sound;
    this.name = name;
  }

  public String getSpecies()
  {
    return species;
  }

  public String getSound()
  {
    return sound;
  }

  public String getName()
  {
    return name;
  }
}
