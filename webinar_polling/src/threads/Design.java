package threads;

import java.util.ArrayList;
import java.util.List;

public class Design {
    private int code;
    private String name;
    private List<Long> votes;
    
    public Design(int code, String name) {
        this.code = code;
        this.name = name;
        this.votes = new ArrayList();
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<Long> getVotes() {
        return this.votes;
    }
}
