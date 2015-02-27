
public class Human {
	private Dog dog;
	private String name;
	
	public Human (String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void buyDog (Dog dog){
		this.dog = dog;
	}

	public String getInfo() {
		if (dog !=null) { return this.getName() + " �ger en hund som heter " + 
		this.dog.getName().toString() + " .";
	}
		else { return this.getName() + " �ger inte n�gon hund.";
}
	}
}

