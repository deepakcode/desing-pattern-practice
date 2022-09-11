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


