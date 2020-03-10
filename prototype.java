public class Dogear
{
 private int numberOfEars;

 public int getNumberOfEars()
 {
 return numberOfEars;
 }

 public void setNumberOfEars( int numberOfEars )
 {
 this.numberOfEars = numberOfEars;
 }

 @Override
        public String toString()
        {
         return "Dogear [numberOfEars=" + numberOfEars + "]";
        }

 
}
public class Dogeye
{
 private int numberOfEyes;

 public int getNumberOfEyes()
 {
 return numberOfEyes;
 }

 public void setNumberOfEyes( int numberOfEyes )
 {
 this.numberOfEyes = numberOfEyes;
 }

 @Override
        public String toString()
        {
         return "Dogeye [numberOfEyes=" + numberOfEyes + "]";
        }

 
}
public class Dogleg
{
 private int numberOflegs;

 public int getNumberOflegs()
 {
 return numberOflegs;
 }

 public void setNumberOflegs( int numberOflegs )
 {
 this.numberOflegs = numberOflegs;
 }

 @Override
        public String toString()
        {
         return "Dogleg [numberOflegs=" + numberOflegs + "]";
        }
}
public class Dogtail
{
 private String tailLength; // long or small

 public String getTailLength()
 {
 return tailLength;
 }

 public void setTailLength( String tailLength )
 {
 this.tailLength = tailLength;
 }

 @Override
        public String toString()
        {
         return "Dogtail [tailLength=" + tailLength + "]";
        }

 
}
public interface Animal extends Cloneable
{
   public Animal clone();

}
public class Dog implements Animal
{

 private String  name;
 private int     age;
 private String  color;
 private Dogleg  dogleg;
 private Dogtail dogtail;
 private Dogear  dogear;
 private Dogeye  dogeye;

 public Dog( String name, int age, String color, Dogleg dogleg, Dogtail dogtail, Dogear dogear, Dogeye dogeye )
 {
 super();
 this.name = name;
 this.age = age;
 this.color = color;
 this.dogleg = dogleg;
 this.dogtail = dogtail;
 this.dogear = dogear;
 this.dogeye = dogeye;
 }

 public Dogleg getDogleg()
 {
 return dogleg;
 }

 public void setDogleg( Dogleg dogleg )
 {
 this.dogleg = dogleg;
 }

 public Dogtail getDogtail()
 {
 return dogtail;
 }

 public void setDogtail( Dogtail dogtail )
 {
 this.dogtail = dogtail;
 }

 public Dogear getDogear()
 {
 return dogear;
 }

 public void setDogear( Dogear dogear )
 {
 this.dogear = dogear;
 }

 public Dogeye getDogeye()
 {
 return dogeye;
 }

 public void setDogeye( Dogeye dogeye )
 {
 this.dogeye = dogeye;
 }

 public String getName()
 {
 return name;
 }

 public void setName( String name )
 {
 this.name = name;
 }

 public int getAge()
 {
 return age;
 }

 public void setAge( int age )
 {
 this.age = age;
 }

 public String getColor()
 {
 return color;
 }

 public void setColor( String color )
 {
 this.color = color;
 }

 public Animal clone()
 {

 Dog dogObject = null;

 try
 {

 dogObject = (Dog) super.clone();

 }

 catch( CloneNotSupportedException e )
 {

 e.printStackTrace();

 }

 return dogObject;
 }

 @Override
 public String toString()
 {
 return "Dog [name=" + name + ", age=" + age + ", color=" + color + ", dogleg=" + dogleg + ", dogtail="
                 + dogtail + ", dogear=" + dogear + ", dogeye=" + dogeye + "]";
 }

}
import java.util.Hashtable;

public class AnimalCache
{
 private static Hashtable<String, Animal> AnimalMap = new Hashtable<String, Animal>();

 public static Animal getAnimal( String animalType )
 {
 Dog dog = (Dog) AnimalMap.get(animalType);
 if( dog == null )
 {
 Dogleg dogleg = new Dogleg();
 dogleg.setNumberOflegs(4);

 Dogear dogear = new Dogear();
 dogear.setNumberOfEars(2);

 Dogtail dogtail = new Dogtail();
 dogtail.setTailLength("long");

 Dogeye dogeye = new Dogeye();
 dogeye.setNumberOfEyes(2);

 dog = new Dog("Tommy", 3, "White", dogleg, dogtail, dogear, dogeye);
 AnimalMap.put("dog", dog);
 System.out.println("New Dog Object is created and return\n");
 return dog;
 }
 System.out.println("\nCloned Dog Object is created and return\n");
 return dog.clone();
 }
}
public class PrototypePatternDemo
{

 public static void main(String[] args)
 {

 Dog dog = (Dog) AnimalCache.getAnimal("dog");
 displayAnimalProperty(dog);

 Dog cloneddog1 = (Dog) AnimalCache.getAnimal("dog");
 cloneddog1.setName("Jonnie");
 cloneddog1.setAge(4);
 cloneddog1.setColor("Brown");
 displayAnimalProperty(cloneddog1);

 Dog cloneddog2 = (Dog) AnimalCache.getAnimal("dog");
 cloneddog2.setName("Tony");
 cloneddog2.setAge(5);
 cloneddog2.setColor("Brown");
 displayAnimalProperty(cloneddog2);

 Dog cloneddog3 = (Dog) AnimalCache.getAnimal("dog");
 cloneddog3.setName("Jimmy");
 cloneddog3.setAge(8);
 cloneddog3.setColor("Brown");
 displayAnimalProperty(cloneddog3);

 }

 public static void displayAnimalProperty(Animal animal)
 {
 if (animal instanceof Dog)
 {
 Dog dog = (Dog) animal;
 System.out.println(dog.toString());
 System.out.println("-----------------------------------------------------------------------------------------------------");

 }
 }

}

