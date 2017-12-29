import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    String note;
    
    public Solution(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        for(String entry : magazine.split(" ")){
            if(magazineMap.get(entry)==null){
                magazineMap.put(entry, 1);
            } else {
                magazineMap.put(entry, magazineMap.get(entry)+1);
            }
        }
        this.note = note;
    }
    
    public boolean solve() {
        for(String threat : note.split(" ")){
            if(magazineMap.get(threat)==null || magazineMap.get(threat)==0){
                return false;
            } else {
                magazineMap.put(threat, magazineMap.get(threat)-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}

