/*
 * @Descripttion: 
 * @version: 
 * @Author: HuSharp
 * @Date: 2020-07-11 21:12:32
 * @LastEditors: HuSharp
 * @LastEditTime: 2020-12-02 18:40:37
 * @@Email: 8211180515@csu.edu.cn
 */
package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparatorTest {
	public static class Student {
		public String name;
		public int id;
		public int age;

		public Student(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}
	}
	
	public static class IdAscendingComparator implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.id - o2.id;
		}
		
	}
	
	public static void printStudents(Student[] students) {
		for (Student student : students) {
			System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
		}
		System.out.println("===========================");
	}
	
	public static void main(String[] args) {
		Student student1 = new Student("A", 1, 23);
		Student student2 = new Student("B", 2, 21);
		Student student3 = new Student("C", 3, 22);

		Student[] students = new Student[] { student3, student2, student1 };
		printStudents(students);
		
		Arrays.sort(students, new IdAscendingComparator());
		printStudents(students);
		
		
		PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
		heap.add(student1);
		heap.add(student2);
		heap.add(student3);
		
		while(!heap.isEmpty()) {
			Student student = heap.poll();
			System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
		}
		
	}
}





