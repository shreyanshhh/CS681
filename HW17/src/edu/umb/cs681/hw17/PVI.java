package edu.umb.cs681.hw17;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PVI {
	public static void readCSV() {
		Path tmp = FileSystems.getDefault().getPath("").toAbsolutePath();
        String pathName = tmp+"/PVI.csv";
        Path path = Paths.get (pathName);
		        try (Stream<String> lines = Files.lines(path)) {
		            List<List<String>> matrix = lines.map(line -> {
		                return Stream.of( line.split(",") ) .map(value->value.substring(0, value.length()))
		                        .collect( Collectors.toList() ); }) .collect( Collectors.toList() );

		            List Mass = matrix.stream().parallel().filter((i) -> i.get(4).contains("Massachusetts")).collect(Collectors.toList());

		            List Berkshire = matrix.stream().parallel().filter((i) -> i.get(5).contains("Berkshire")).collect(Collectors.toList()).get(0);
		            System.out.println("1. Number of cases in Berkshire county of the Massachusetts are: " + Berkshire.get(6));

		            String cases = matrix.stream().parallel().filter((i) -> i.get(4).contains("Massachusetts"))
		                    .map((i) -> i.get(6)).reduce("0", (subtotal, element) -> String.valueOf(Integer.parseInt(subtotal) + Integer.parseInt(element)));

		            System.out.println("\n2. Total number of cases in Massachusetts are: " + cases);

		            System.out.println("\n3. Average number of cases in Massachusetts are: " + Integer.parseInt(cases)/Mass.size());

		        } catch (IOException ex) {
		        	System.out.println("Code Exit due to bad file path");
		        }
	}
	public static void main(String args[]) {
		readCSV();

	}
}
