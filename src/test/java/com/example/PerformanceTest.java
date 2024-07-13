package com.example;

import org.junit.Test;

public class PerformanceTest {
  private CountryLocator locator = new CountryLocator();

  @Test
  public void testPerformance() {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 100; i++) {
      locator.getCountryCode(22.5937, 88.3629); // Kolkata, India
    }
    long endTime = System.currentTimeMillis();
    double averageExecutionTime = (endTime - startTime) / 100.0;
    System.out.println("Average execution time: " + averageExecutionTime + " ms");
  }
}
