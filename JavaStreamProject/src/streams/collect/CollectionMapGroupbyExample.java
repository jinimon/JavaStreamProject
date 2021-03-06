package streams.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionMapGroupbyExample {
	public static void main(String[] args) {
		// 부서별 - 사원정보
		Student s1 = new Student("이땡땡", 24, Gender.FEMALE);
		Student s2 = new Student("윤땡땡", 20, Gender.MALE);
		Student s3 = new Student("김땡땡", 28, Gender.FEMALE);
		Student s4 = new Student("최땡땡", 21, Gender.MALE);

		List<Student> students = Arrays.asList(s1, s2, s3, s4);

		// groupingBy : 뒤에오는 매개값의 조건에 따라 List에 담겠다. -> Gender 별로 요소를 담겠다.
		// Gender : grouping 지을 대상. Set<Student> : Set에 담겠다.
		Map<Gender, Set<Student>> gMap = students.stream()
				.collect(Collectors.groupingBy(new Function<Student, Gender>() {
					@Override
					public Gender apply(Student t) {
						return t.gender;
					}
				}, Collectors.toSet()));
		// 두번째 매개값으로 Collectors.toSet()하면 Set으로 반환. 이거 없으면 default로 List가 반환

		Set<Gender> set = gMap.keySet();
		for (Gender g : set) {
			System.out.println(g);
			Set<Student> list = gMap.get(g);
			for (Student s : list) {
				System.out.println(s.name);
			}
		}
	}
}
