import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	public static void ListStudents(List<Student> students, Stream<String> individual) {
        List<String> data = individual.collect(Collectors.toList());

        for (String line : data) {
            String[] val = line.split(",");
            students.add(new Student(val[0], val[1], val[2],
                    Integer.valueOf(val[3]), Float.valueOf(val[4])));
        }

        data.forEach(elem -> System.out.println(elem));
    }


	public static void main(String[] args) {
		String path = "/Users/ancutamorarasu/Documents/school/DB_Tech_School/week_1/Facultate";
		File Facultate = new File(path);
		
		Facultate.mkdir();
		String[] files = Facultate.list();
		for(String doc : files) {
			System.out.println(doc);
		}
	
	List<Student> students = new ArrayList<>();
	try {
        Stream<String> individual = Files.lines(Paths.get("Facultate/studenti-automatica.txt"));
        ListStudents(students, individual);

    } catch (IOException e) {
        System.err.format("IOException: %s%n", e);
    }

    try {
        Stream<String> individual = Files.lines(Paths.get("Facultate/studenti-calculatoare.txt"));
        ListStudents(students, individual);

    } catch (IOException e) {
        System.err.format("IOException: ", e);
    }

    System.out.println();
    
    Comparator<Student> compareAverage = (Student A, Student B)
            -> Double.compare(A.getAverage(),B.getAverage());

    Comparator<Student> compareLastName = (Student A, Student B)
            -> A.getLastName().compareTo(B.getLastName());

    Comparator<Student> compareFirstName = (Student A, Student B)
            -> A.getFirstName().compareTo(B.getFirstName());
            
            if(compareAverage.equals(0) && compareLastName.equals(0)) {
                Collections.sort(students,compareFirstName);
            } else if (compareAverage.equals(0)) {
                Collections.sort(students,compareLastName);
            } else Collections.sort(students,compareAverage.reversed());
            
            try {
                FileWriter myWriter = new FileWriter("Facultate/studenti.txt");
                students.forEach(el -> {
                    try {
                        myWriter.write(el.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                myWriter.close();
                System.out.println("Operation completed successfully.");
            } catch (IOException e) {
                System.out.println("Error, please try again.");
                e.printStackTrace();
            }

}
}