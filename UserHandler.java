
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class UserHandler {

	public static void main(String[] args) {
		System.out.println("Welcome");
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			listFileAndDirs();
			createFile();
			deleteFile(sc);
			searchFile(sc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		System.out.println("Goodbye");
	}

	public static void listFileAndDirs() {
		System.out.println("-------------------");
		System.out.println("List of files");
		System.out.println();
		File folder = new File("src");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println(listOfFiles[i].getName());
			} // else if (listOfFiles[i].isDirectory()) {
				// System.out.println("Directory " + listOfFiles[i].getName());
				// }
		}
		System.out.println("-------------------");
	}

	public static void createFile() {
		try {
			File file = new File("src/abc.txt");
			if (file.createNewFile()) {
				System.out.println("File created- " + file.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		System.out.println("-------------------");
	}

	public static void deleteFile(Scanner sc) {
		System.out.print("Enter file name to delete: ");
		String fileName = sc.nextLine();
		try {
			Files.delete(Paths.get("src/" + fileName));
			System.out.println("Deletion successful.");
		} catch (NoSuchFileException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("No files deleted");
			System.out.println("-------------------");
		}
	}

	public static void searchFile(Scanner sc) {
		System.out.println("-------------------");
		System.out.println("Search a file");
		System.out.println();
		File folder = new File("src");
		File[] listOfFiles = folder.listFiles();
		System.out.print("Enter file name to search: ");
		String fileName = sc.nextLine();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile() && listOfFiles[i].getName().equals(fileName)) {
				System.out.println("File '" + listOfFiles[i].getName() + "' found");
				System.out.println("-------------------");
				return;
			}
		}
		System.out.println("File '" + fileName + "' not found");
		System.out.println("-------------------");
	}

}
