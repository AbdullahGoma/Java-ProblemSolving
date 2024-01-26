import java.util.*;
import java.io.File;

public class FindAllGenes{
    public static int findStopCodon(String dnaStr,int startIndex,String stopCodon){
        int currIndex = dnaStr.indexOf(stopCodon,startIndex);
        while(currIndex != -1){
            int diff = currIndex - startIndex;
            if(diff % 3 == 0){
                return currIndex;
            }else{
                currIndex = dnaStr.indexOf(stopCodon,currIndex + 1);
            }
        }
        return -1;
    }
    
    public static String findGene(String dna,int where)
    {
      //Start codon is ATG 
      //End codon is TAA
      //End codon is TAG 
      //End codon is TGA
      String result = "";
      int startIndex = dna.indexOf("ATG",where);
      if(startIndex == -1){
          return "There is no gene.";
      }
      int taaIndex = findStopCodon(dna,startIndex,"TAA");
      int tagIndex = findStopCodon(dna,startIndex,"TAG");
      int tgaIndex = findStopCodon(dna,startIndex,"TGA");
//      int temp = Math.min(taaIndex,tgaIndex);
//      int minIndex = Math.min(temp,tagIndex);
      int minIndex = 0;
      if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
          minIndex = tgaIndex;
      }
      else{
          minIndex = taaIndex;
      }
      if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
          minIndex = tagIndex;
      }
      if(minIndex == -1){
         return ""; 
      }
      return dna.substring(startIndex,minIndex);
    }
    
    public static void printAllGene(String dna){
        int startIndex = 0;
        while(true){
           String currGene = findGene(dna,startIndex);
           if(currGene.isEmpty()){
               break;
           }
           System.out.println(currGene);
           startIndex = dna.indexOf(currGene,startIndex) + currGene.length();
        }
    }
    
    public static void main(String[] args) {
        
    }
}
