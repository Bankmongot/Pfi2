
public class Dog extends Mammal {
	private boolean stupid;

	public Dog(String latinName, boolean stupid, int gestationTime){
		super (latinName, gestationTime);
		this.latinName = latinName;
		this.stupid = stupid;
	}

	public Dog(String friendlyName, String latinName, int gestationTime, boolean stupid){
		super (latinName, gestationTime);
		this.friendlyName = friendlyName;
		this.latinName = latinName;
		this.stupid = stupid;
	}

	public boolean isStupid(){
		return this.stupid;
	}

	@Override
	public String getInfo() {
		String isStupido = "";
		if (isStupid() == true){
			isStupido = new String("stupid");
		}
		else{
			isStupido = new String("not stupid");
		}
		return ("The dog named " + getFriendlyName()+", and " + getLatinName() + " in latin, nurses for " + getGestationTime() + " months and is " + isStupido + ".");
	}

}
