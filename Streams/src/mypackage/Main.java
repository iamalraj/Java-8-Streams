package mypackage;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Person> people = getPeople();

		// Filter and collect to list

		// list out all females
		List<Person> females = people.stream().filter(person -> person.getGender().equals(Gender.FEMALE))
				.collect(Collectors.toList());

		// list out all males
		List<Person> males = people.stream().filter(person -> person.getGender().equals(Gender.MALE))
				.collect(Collectors.toList());

		System.out.println(females);
		System.out.println(males);

		// list of people having age in twenties
		List<Person> ageTwenties = people.stream().filter(person -> person.getAge() < 30 && person.getAge() >= 20)
				.collect(Collectors.toList());
		System.out.println(ageTwenties);

		// anyMatch
		boolean any = people.stream().anyMatch(person -> person.getAge() < 20);
		System.out.println(any);

		// allMatch
		boolean all = people.stream().allMatch(person -> person.getAge() > 20);
		System.out.println(all);

		// noneMatch
		boolean none = people.stream().noneMatch(person -> person.getAge() > 50);
		System.out.println(none);

		// max value
		people.stream().max(Comparator.comparing(person -> person.getAge()))
				.ifPresent(person -> System.out.println(person));

		// min value
		people.stream().min(Comparator.comparing(person -> person.getAge()))
				.ifPresent(person -> System.out.println(person));

		// Group by gender
		Map<Gender, List<Person>> groupByGender = people.stream()
				.collect(Collectors.groupingBy(person -> person.getGender()));

		groupByGender.forEach((gender, ppl) -> {
			System.out.println(gender);
			ppl.forEach(p -> System.out.println(p));
		});

		// map
		// to print all age
		people.stream().map(person -> person.getAge()).forEach(age -> System.out.println(age));

		// sort
		people.stream().sorted(Comparator.comparing(person -> person.getAge()))
				.forEach(person -> System.out.println(person));
	}

	private static List<Person> getPeople() {
		return List.of(

				new Person("Antonio", 20, Gender.MALE), new Person("Frank", 32, Gender.MALE),
				new Person("Ann", 24, Gender.FEMALE), new Person("Maria", 18, Gender.FEMALE),
				new Person("Candy", 30, Gender.FEMALE), new Person("Alex", 43, Gender.MALE),
				new Person("Steve", 32, Gender.MALE), new Person("Isa", 39, Gender.FEMALE)

		);
	}

}

/*
 * 
 * [Person [name=Ann, age=24, gender=FEMALE], Person [name=Maria, age=18,gender=FEMALE], Person [name=Candy, age=30, gender=FEMALE], Person [name=Isa,age=39, gender=FEMALE]] 
 * [Person [name=Antonio, age=20, gender=MALE], Person[name=Frank, age=32, gender=MALE], Person [name=Alex, age=43, gender=MALE],Person [name=Steve, age=32, gender=MALE]] 
 * [Person [name=Antonio, age=20, gender=MALE], Person [name=Ann, age=24, gender=FEMALE]] 
 * true 
 * false 
 * true
 * Person [name=Alex, age=43, gender=MALE] 
 * Person [name=Maria, age=18, gender=FEMALE] 
 * MALE
 * Person [name=Antonio, age=20, gender=MALE] 
 * Person [name=Frank, age=32, gender=MALE] 
 * Person [name=Alex, age=43, gender=MALE]
 * Person [name=Steve, age=32, gender=MALE] 
 * FEMALE 
 * Person [name=Ann, age=24, gender=FEMALE] 
 * Person [name=Maria, age=18, gender=FEMALE] 
 * Person [name=Candy, age=30, gender=FEMALE] 
 * Person [name=Isa, age=39, gender=FEMALE] 
 * 20 32 24 18 30 43 32 39 
 * Person [name=Maria, age=18, gender=FEMALE]
 * Person [name=Antonio,age=20, gender=MALE] 
 * Person [name=Ann, age=24, gender=FEMALE] 
 * Person [name=Candy, age=30, gender=FEMALE] 
 * Person [name=Frank, age=32, gender=MALE]
 * Person [name=Steve, age=32, gender=MALE] 
 * Person [name=Isa, age=39, gender=FEMALE] 
 * Person [name=Alex, age=43, gender=MALE] 
 */
