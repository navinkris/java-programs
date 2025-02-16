
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
      List<List<String>> listOfLists = Arrays.asList(
        Arrays.asList("Reflection", "Collection", "Stream"),
        Arrays.asList("Structure", "State", "Flow"),
        Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
      );

      Set<String> intermediateResults = new HashSet<>();

      List<String> result = listOfLists.stream()
                          .flatMap(List::stream)
                          .filter(s-> s.startsWith("S"))
                          .map(String::toUpperCase)
                          .distinct()
                          .sorted()
                          .peek(s -> intermediateResults.add(s))
                          .collect(Collectors.toList());

      System.out.println("Intermediate Results:");
      intermediateResults.forEach(System.out::println);

      System.out.println("Final Result:");
      result.forEach(System.out::println);

      List<String> names = Arrays.asList(
        "Reflection", "Collection", "Stream",
        "Structure", "Sorting", "State"
      );

      System.out.println("forEach:");
      names.stream().forEach(System.out::println);

      List<String> sNames = names.stream()
                            .filter(name -> name.startsWith("S"))
                            .collect(Collectors.toList());
      System.out.println("\ncollect (names starting with 'S'):");
      sNames.forEach(System.out::println);

      String concatenatedNames = names.stream().reduce(
        "", (partialString, element) -> partialString + " " + element
      );
      System.out.println("\nreduce (concatenated names):");
      System.out.println(concatenatedNames.trim());

      long count = names.stream().count();
      System.out.println("\ncount:");
      System.out.println(count);

      Optional<String> firstName = names.stream().findFirst();
      System.out.println("\nfindFirst:");
      firstName.ifPresent(System.out::println);

      boolean allStartWithS = names.stream().allMatch(name -> name.startsWith("S"));
      System.out.println("\nall Match (all start with 'S'):");
      System.out.println(allStartWithS);

      boolean anyStartWithS = names.stream().anyMatch(name -> name.startsWith("S"));
      System.out.println("\nanyMatch (any start with 'S'):");
      System.out.println(anyStartWithS);
    }
}
