package edu.hebeu.generic;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 通过此例初步学习泛型
 * 
 * JDK5.0之后推出新特性：泛型
 * 1、泛型这种语法机制，只在程序编译阶段起作用，只是给编译器参考的(运行阶段泛型没用)
 * 2、使用泛型的好处：
 * 		第一：集合中存储的元素类型统一了；
 * 		第二：从集合中取出的元素是泛型指定的类型，不需要大量的向下转型；
 * 3、泛型的缺点：
 * 		导致集合中存储的元缺乏多样性；
 * 4、大多数业务中，集合内的元素是统一的，所以这种特性得到推广
 * 
 * 
 * JDK8.0之后引入了自动类型推断机制(钻石表达式)
 * 如此：List<Animal> l = new ArrayList<>();
 * 
 * @author 13651
 *
 */
public class GenericStu {
	public static void main(String[] args) {
		/**当不使用泛型时*/
		List l1 = new ArrayList();
		
		Cat cat = new Cat();
		Dog dog = new Dog();
		Bird bird = new Bird();
		
		l1.add(cat);
		l1.add(dog);
		l1.add(bird);
		
		Iterator it1 = l1.iterator(); // 创建l1集合的迭代器
		System.out.println("不使用泛型：");
		while(it1.hasNext()) {
//			Animal a = it1.next(); // 不能直接使用Animal接收
			Object obj = it1.next(); // 不使用泛型，在取出元素时只能用Object类型进行接收
			if(obj instanceof Animal) { // 如果需要使用不是Object类型的类，还要进行向下转型
				Animal a = (Animal)obj;
				a.move();
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		/**当使用泛型后*/
		List<Animal> l2 = new ArrayList<Animal>(); // 此时集合中只能存储Animal类型的元素了
		
		Cat cat2 = new Cat();
		Dog dog2 = new Dog();
		Bird bird2 = new Bird();
		
		l2.add(cat2);
		l2.add(dog2);
		l2.add(bird2);
//		l2.add(25); // 此时会发现，如果存入的不是Animal类型的元素会报错导致编译不通过
		
		Iterator<Animal> it2 = l2.iterator(); // 创建l2集合的迭代器，注意迭代器也应该使用泛型
		System.out.println("使用泛型：");
		while(it2.hasNext()) {
			Animal a = it2.next();
			a.move();
			
			// 但是注意：如果还要调用Animal的子类中特有的方法，还是需要进一步的转型的
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		/**
		 * 自动类型推断机制<钻石表达式>
		 * new ArrayList<>()会根据List<Animal>自动推断出类型
		 */
		List<Animal> l3 = new ArrayList<>(); // 此时集合中只能存储Animal类型的元素了
		
		Cat cat3 = new Cat();
		Dog dog3 = new Dog();
		Bird bird3 = new Bird();
		
		l3.add(cat3);
		l3.add(dog3);
		l3.add(bird3);
		
		Iterator<Animal> it3 = l3.iterator();
		System.out.println("使用泛型《钻石表达式》：");
		while(it3.hasNext()) {
			Animal a = it3.next();
			a.move();
			
			// 但是注意：如果还要调用Animal的子类中特有的方法，还是需要进一步的转型的
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
}

class Animal {
	public void move() {
		System.out.println("动物在移动");
	}
}

class Cat extends Animal {
	public void go() {
		System.out.println("猫在走路");
	}
}

class Dog extends Animal {
	public void run() {
		System.out.println("狗在跑");
	}
}

class Bird extends Animal {
	public void fly() {
		System.out.println("鸟在飞");
	}
}