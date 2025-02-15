import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
  public static void main(String[] args) {
      CompletableFuture.supplyAsync(() -> {
        System.out.println("Fetching data...");
        return "Data from API";
      }).thenApply(data -> {
        System.out.println("Processing: " + data);
        return data.toUpperCase();
      }).thenAccept(result -> {
        System.out.println("Final result: "+ result);
      });

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
      
      }
  }
}
