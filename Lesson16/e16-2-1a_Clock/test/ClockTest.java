import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest
{
  /*
   *  Test for normal creation of a Clock
   *  using hours, minutes, seconds
   */
  @Test public void createClock()
  {
    //  Arrange
    Clock clock = new Clock(12, 34, 56);
    //  Act
    //  Assert
    assertEquals("12:34:56", clock.toString());
  }

  /*
   *  Test Illegal Argument Exception is thrown at illegal input
   *  using HH:MM:SS
   */
  // Illegal seconds input
  @Test public void throwsIllegalArgumentExceptionAtIllegalTimeSecondsInput()
  {
    assertThrows(IllegalArgumentException.class, () -> new Clock(12, 34, 61));
  }

  // Illegal minutes input
  @Test public void throwsIllegalArgumentExceptionAtIllegalTimeMinutesInput()
  {
    assertThrows(IllegalArgumentException.class, () -> new Clock(12, 63, 32));
  }

  // Illegal hours input
  @Test public void throwsIllegalArgumentExceptionAtIllegalTimeHourInput()
  {
    assertThrows(IllegalArgumentException.class, () -> new Clock(24, 34, 32));
  }

  /*
   *  Test Illegal Argument Exception is thrown at illegal input
   *  using seconds
   */
  //  1 before boundary
  @Test public void checkOneBeforeBoundaryOnSecondsInput()
  {
    Clock clock = new Clock(86399);

    assertEquals(23, clock.getHour());
    assertEquals(59, clock.getMinute());
    assertEquals(59, clock.getSecond());
  }

  //  On boundary
  @Test public void checkOnBoundaryOnSecondsInput()
  {
    Clock clock = new Clock(86400);

    assertEquals(0, clock.getHour());
    assertEquals(0, clock.getMinute());
    assertEquals(0, clock.getSecond());
  }

  //  On boundary
  @Test public void checkOneAfterBoundaryOnSecondsInput()
  {
    Clock clock = new Clock(86401);

    assertEquals(0, clock.getHour());
    assertEquals(0, clock.getMinute());
    assertEquals(1, clock.getSecond());
  }

  //  1 after boundary
  @Test public void throwsIllegalArgumentExceptionAtIllegalSecondsInput()
  {
    assertThrows(IllegalArgumentException.class, () -> new Clock(-200));
  }

  /*
   *  Testing getters
   */
  //  Get hour
  @Test public void getHourTest()
  {
    Clock clock = new Clock(12, 34, 56);

    assertEquals(12, clock.getHour(),
        "Error fetching HOURS from the clock object");
  }

  //  Get minutes
  @Test public void getMinuteTest()
  {
    Clock clock = new Clock(12, 34, 56);

    assertEquals(34, clock.getMinute(),
        "Error fetching MINUTES from the clock object");
  }

  //  Get minutes
  @Test public void getSecondTest()
  {
    Clock clock = new Clock(12, 34, 56);

    assertEquals(56, clock.getSecond(),
        "Error fetching SECONDS from the clock object");
  }
}