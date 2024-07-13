package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;

public class CountryLocatorTest {
  private CountryLocator locator;

  @Before
  public void setUp() {
    locator = new CountryLocator();
  }

  @Test
  public void testValidCoordinates() {
    assertEquals("IN", locator.getCountryCode(22.5937, 88.3629)); // Kolkata, India

    assertEquals("US", locator.getCountryCode(37.7749, -122.4194)); // San Francisco, USA

    assertEquals("FR", locator.getCountryCode(48.8567, 2.2943)); // Paris, France

    assertEquals("AU", locator.getCountryCode(-33.8651, 151.2099)); // Sydney, Australia

    assertEquals("JP", locator.getCountryCode(35.6895, 139.7670)); // Tokyo, Japan

    assertEquals("GB", locator.getCountryCode(51.5074, -0.1278)); // London, UK
  }

  @Test
  public void testInvalidCoordinates() {
    assertNull(locator.getCountryCode(-90, 180)); // Outside the boundaries of any country
  }
}
