import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {
    
    public static void main(String args[]) {
        List<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(4);
        al.add(9);
        al.add(15);
        al.add(20);
        
        System.out.println("Printing the collection : "+ al);
        System.out.println();
        
        List<Integer> fl = al.stream().filter(x -> x% 2 == 0).collect(Collectors.toList());
        System.out.println("Printing filtered collection : "+ fl);
        
        List<Integer> marks = new ArrayList<>();
        marks.add(44);
        marks.add(42);
        marks.add(39);
        marks.add(43);
        marks.add(41);
        marks.add(40);
        System.out.println("Marks list values: "+marks);
        
        List<Integer> updatedMarks = new ArrayList<>();
        updatedMarks = marks.stream().map(mark -> mark + 5).collect(Collectors.toList());
        System.out.println("Updated marks after grace marks "+ updatedMarks);
        
    }
}
