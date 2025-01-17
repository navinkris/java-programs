
import java.util.Iterator;

public class CountryIterator {
  public static void main(String[] args) {
    var india = new Country("India");
    var australia = new Country("Australia");
    var srilanka = new Country("Srilanka");
    var nepal = new Country("Nepal");
    var usa = new Country("USA"); 

    var countryCollection = new CountryCollection(india, australia, srilanka, nepal, usa);

    var countriesIterator = new CountriesIterator(countryCollection);

    while (countriesIterator.hasNext()) {
      var country = countriesIterator.next();
      System.out.println(country.getName());
    }
  }
}

class Country {
  private final String name;

  public Country(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }
}

class CountryCollection implements Iterable<Country>{

  private final Country[] countries;

  public CountryCollection(Country... countries) {
    this.countries = countries;
  }

  public Country[] getCountries() {
    return countries;
  }

  @Override
  public Iterator<Country> iterator() {
    return new CountriesIterator(this); 
  }

}

class CountriesIterator implements Iterator<Country> {
  
  private final CountryCollection countryCollection;
  private int index;

  public CountriesIterator(CountryCollection countryCollection) {
    this.countryCollection = countryCollection;
    this.index = 0;
  }
    
  @Override
  public boolean hasNext() {
    var countryList = countryCollection.getCountries();
    return index < countryList.length;
  }

  @Override
  public Country next() {
    var countryList = countryCollection.getCountries();
    if (hasNext()) {
      return countryList[index++];
    } else {
      return null;
    }
  }
}
