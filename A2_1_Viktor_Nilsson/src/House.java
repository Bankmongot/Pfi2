
public class House{
 private int yearBuilt;
 private final int maxYrs = 2015;
 private final int minYrs = 1800;
 private int size;
 private final int minSize = 10;
 private final int maxSize = 1000;
 
 public House(int yearBuiltOk,int sizeOk){
	 if(yearBuiltOk < maxYrs && yearBuiltOk > minYrs){
			yearBuilt = yearBuiltOk;
		}else {
			yearBuilt = 2015;
		}
	 	if(sizeOk > minSize && sizeOk < 1000){
	 		size = sizeOk;
	 	}else {
			size = 1000;
		}
	 }
 public int getYearBuilt(){
 return this.yearBuilt;
 }
 public int getSize(){
 return this.size;
 }
 
 
 
}