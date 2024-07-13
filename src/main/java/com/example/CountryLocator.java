package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountryLocator {
  private static final Map<String, String[]> countryBoundaries = new HashMap<>();

  static {
    // Load country boundaries from a static data source (e.g., a CSV file)
    // For simplicity, let's hardcode some examples
    countryBoundaries.put("IN", new String[] { "20.5937", "78.9629", "35.5041", "92.5095" }); // India
    countryBoundaries.put("US", new String[] { "24.5207", "49.3843", "-124.7844", "-66.9519" }); // United States

    countryBoundaries.put("FR", new String[] { "42.2442", "51.0929", "-5.1424", "10.3424" }); // France
    countryBoundaries.put("AU", new String[] { "-39.1479", "-10.6853", "112.4093", "159.1093" });// Australia
    countryBoundaries.put("JP", new String[] { "20.4241", "45.5221", "122.9433", "146.9433" }); // Japan
    countryBoundaries.put("GB", new String[] { "49.9563", "60.8563", "-9.3824", "2.3424" }); // London UK
    // Add more country boundaries as need
  }

  /**
   * Returns the country code in ISO 3166-1 alpha-2 format based on the input
   * latitude and longitude.
   */
  public String getCountryCode(double latitude, double longitude) {
    for (Map.Entry<String, String[]> entry : countryBoundaries.entrySet()) {
      String[] bounds = entry.getValue();
      double minLat = Double.parseDouble(bounds[0]);
      double maxLat = Double.parseDouble(bounds[1]);
      double minLon = Double.parseDouble(bounds[2]);
      double maxLon = Double.parseDouble(bounds[3]);

      if (latitude >= minLat && latitude <= maxLat && longitude >= minLon && longitude <= maxLon) {
        return entry.getKey();
      }
    }
    return null; // Unknown country
  }

  public static void main(String[] args) {
    CountryLocator countryLocator = new CountryLocator();
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter latitude: ");
    double latitude = scanner.nextDouble();

    System.out.print("Enter longitude: ");
    double longitude = scanner.nextDouble();

    String countryCode = countryLocator.getCountryCode(latitude, longitude);

    if (countryCode != null) {
      System.out.println("Country code: " + countryCode);
    } else {
      System.out.println("Unknown country");
    }
  }
}
