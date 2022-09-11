# desing-pattern-practice


1. Stock management - YOUTUBE
2. Coffee machine - vinay will share
3. Vanding machine - vinay will share
4. Reflection in Java - GFG
5. Book my Show - Udit
6. IRCTC booking - same
7. RedBus booking - same
12. Coupon management system.
13. Food delivery
14. Ride sharing
15. Car pooling
16. Cab booking
17. Car rental
18. Amazon e-comm lld
19. NewsFeed - LLD
20. Collab edit
23. Chess
24. Crick Info
25. Excel.
26. Kanban/JIRA board


Factory Desing pattern

```java
public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu) {
        if ("PC".equalsIgnoreCase(type)) return new PC(ram, hdd, cpu);
        else if ("Server".equalsIgnoreCase(type)) return new Server(ram, hdd, cpu);
        return null;
    }
}
```

Abstract Factory
```java
public class ComputerFactory {

	public static Computer getComputer(ComputerAbstractFactory factory){
		return factory.createComputer();
	}
}

public class ServerFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;
	
	public ServerFactory(String ram, String hdd, String cpu){
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	@Override
	public Computer createComputer() {
		return new Server(ram,hdd,cpu);
	}

}
```

Behavioral Desing patterns

**1. Template desing pattern**

Intent -> 
It defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

**2. Strategy desing pattern**

Intent -> 
It lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.


3. Decorator desing pattern 
	- Its combination of IS-A and HAS-A relationship
	
<img width="637" alt="Screenshot 2022-09-11 at 2 36 18 PM" src="https://user-images.githubusercontent.com/13814143/189519990-b052dfc1-7e1b-4536-b605-02450bd248ad.png">
	
```java

abstract class Beverage {

    String description = "Beverage";

    String getDescription() {
        return description;
    }

    public abstract double cost();
}

public abstract class BeverageDecorator extends Beverage{
    public abstract String getDescription();
}




public class Mocha extends BeverageDecorator{

    Beverage beverage;

    Mocha(Beverage beverage){
        this.beverage=beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+0.5;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+" Mocha";
    }
}

public class Main {

    public static void main(String[] args) {
        
        Beverage mochaExpresso = new Mocha(new Espresso());
        System.out.println(mochaExpresso.getDescription());
        System.out.println(mochaExpresso.cost());
        
    }
}


```
