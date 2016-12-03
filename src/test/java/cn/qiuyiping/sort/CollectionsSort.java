package cn.qiuyiping.sort;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */
public class CollectionsSort{

    public static void main(String args[]){
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Tom", 10));
        people.add(new Person("Jerry", 3));
        people.add(new Person("Jack", 8));
        people.add(new Person("Jhon", 6));
        people.add(new Person("Green", 12));
        people.add(new Person("Yi", 7));
        people.add(new Person("Lucian", 9));
        people.add(new Person("Tim", 8));

        System.out.println("排序前：");
        for(Person person : people){
            System.out.println(person.getName() + ":    " + person.getAge());
        }
        Collections.sort(people, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
//                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("排序后：");
        for(Person person : people){
            System.out.println(person.getName() + ":    " + person.getAge());
        }
    }

}

class Person{
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
