package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

/*
	와일드 카드

	<? extends T> => 와일드 카드의 상한 제한. T와 그 자손들만 가능
	<? super T>   => 와일드 카드의 하한 제한. T와 그 조상들만 가능
	<?>			 => 모든타입이 가능 <? extends Object>와 동일
*/
public class T06_WildCardTest {
	public static void main(String[] args) {

		FruitBox<Fruit> fruitBox = new FruitBox<>(); //과일상자
		FruitBox<Apple> appleBox = new FruitBox<>(); //사과상자

		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());
		appleBox.add(new Apple());

		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
	}
}
/*

*/
class Juicer {
	// static void makeJuice(FruitBox<Fruit> box) {
	// 제한된 타입 파라미터 이용 (제너릭 메서드)
	// static <T extends Fruit>void makeJuice(FruitBox<T> box) {
	// 와일드 카드 이용
	static void makeJuice(FruitBox<? extends Fruit> box) {
		String fruitListStr = ""; //과일 목록

		int cnt = 0;
		for(Fruit f : box.getFruitList()) {
			if(cnt == 0) {
				fruitListStr += f;
			} else {
				fruitListStr += "," + f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + " => 쥬스완성!");
	}
}

class Fruit{
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override 
	public String toString() {
		return "과일(" + name + ")";
	}
}

class Apple extends Fruit {
	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit{
	public Grape() {
		super("포도");
	}
}

/*
 * 과일 상자
 * @param <T>
 */
class FruitBox<T> {
	private List<T> fruitList;

	public FruitBox() {
		fruitList = new ArrayList<>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<T> fruitList) {
		this.fruitList = fruitList;
	}

	public void add(T fruit) {
		fruitList.add(fruit);
	}
}

class Juice {
	private String name;

	public Juice(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return "쥬스[" + name + "]";
	}
}