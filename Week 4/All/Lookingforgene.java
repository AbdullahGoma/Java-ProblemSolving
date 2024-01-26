 

public class Test {
    public static String findSimplegene(String dna)
    {
      //Start codon is ATG 
      //End codon is TAA
      String result = "";
      int startIndex = dna.indexOf("ATG");
      if(startIndex == -1){
          return "There is no gene.";
      }
      int stopIndex = dna.indexOf("TAA",startIndex+3);
      if(stopIndex == -1){
          return "There is no gene.";
      }
      result = dna.substring(startIndex,stopIndex+3);
      
      return result;
    }
    public static void main(String[] args) {
      Scanner m = new Scanner(System.in);
      System.out.println("Enter the dna to find the gene : ");
      String x = m.nextLine();
      String result = findSimplegene(x);
      System.out.println(result);
    }
    
}
