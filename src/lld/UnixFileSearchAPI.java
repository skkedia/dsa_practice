package lld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Abstract Class for File System Entries
abstract class FileSystemEntry {
	protected String name;

	public FileSystemEntry(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract List<File> getFilesRecursively();
}

//File Class
class File extends FileSystemEntry {
	private String extension;
	private long size;

	public File(String name, String extension, long size) {
		super(name);
		this.extension = extension;
		this.size = size;
	}

	public String getExtension() {
		return extension;
	}

	public long getSize() {
		return size;
	}

	@Override
	public List<File> getFilesRecursively() {
		return Collections.singletonList(this);
	}
}

//Directory Class (Recursive)
class Directory extends FileSystemEntry {
	private List<FileSystemEntry> entries;

	public Directory(String name) {
		super(name);
		this.entries = new ArrayList<>();
	}

	public void addEntry(FileSystemEntry entry) {
		entries.add(entry);
	}

	@Override
	public List<File> getFilesRecursively() {
		List<File> files = new ArrayList<>();
		for (FileSystemEntry entry : entries) {
			files.addAll(entry.getFilesRecursively());
		}
		return files;
	}
}

//Search Criteria Interface
interface FileSearchCriteria {
	List<File> filter(List<File> files);
}

//Extension-Based Filter
class ExtensionSearchCriteria implements FileSearchCriteria {
	private String extension;

	public ExtensionSearchCriteria(String extension) {
		this.extension = extension;
	}

	@Override
	public List<File> filter(List<File> files) {
		List<File> result = new ArrayList<>();
		for (File file : files) {
			if (file.getExtension().equalsIgnoreCase(extension)) {
				result.add(file);
			}
		}
		return result;
	}
}

//Name-Based Filter
class NameSearchCriteria implements FileSearchCriteria {
	private String name;

	public NameSearchCriteria(String name) {
		this.name = name;
	}

	@Override
	public List<File> filter(List<File> files) {
		List<File> result = new ArrayList<>();
		for (File file : files) {
			if (file.getName().equalsIgnoreCase(name)) {
				result.add(file);
			}
		}
		return result;
	}
}

//Size-Based Filter
class SizeSearchCriteria implements FileSearchCriteria {
	private long minSize, maxSize;

	public SizeSearchCriteria(long minSize, long maxSize) {
		this.minSize = minSize;
		this.maxSize = maxSize;
	}

	@Override
	public List<File> filter(List<File> files) {
		List<File> result = new ArrayList<>();
		for (File file : files) {
			if (file.getSize() >= minSize && file.getSize() <= maxSize) {
				result.add(file);
			}
		}
		return result;
	}
}

//Composite AND Criteria (Supports N Conditions)
class CompositeAndCriteria implements FileSearchCriteria {
	private List<FileSearchCriteria> criteriaList;

	public CompositeAndCriteria(List<FileSearchCriteria> criteriaList) {
		this.criteriaList = criteriaList;
	}

	@Override
	public List<File> filter(List<File> files) {
		List<File> filteredFiles = new ArrayList<>(files);
		for (FileSearchCriteria criteria : criteriaList) {
			filteredFiles = criteria.filter(filteredFiles); // Apply each filter iteratively
		}
		return filteredFiles;
	}
}

//Composite OR Criteria (Supports N Conditions)
class CompositeOrCriteria implements FileSearchCriteria {
	private List<FileSearchCriteria> criteriaList;

	public CompositeOrCriteria(List<FileSearchCriteria> criteriaList) {
		this.criteriaList = criteriaList;
	}

	@Override
	public List<File> filter(List<File> files) {
		Set<File> resultSet = new HashSet<>();
		for (FileSearchCriteria criteria : criteriaList) {
			resultSet.addAll(criteria.filter(files)); // Collect results from all filters
		}
		return new ArrayList<>(resultSet);
	}
}

//File Search Service
class FileSearchService {
	private Directory rootDirectory;

	public FileSearchService(Directory rootDirectory) {
		this.rootDirectory = rootDirectory;
	}

	public List<File> search(FileSearchCriteria criteria) {
		List<File> allFiles = rootDirectory.getFilesRecursively();
		return criteria.filter(allFiles);
	}
}

//Main Class for Testing
public class UnixFileSearchAPI {
	public static void main(String[] args) {
		// Creating the file system
		Directory root = new Directory("root");
		Directory subDir1 = new Directory("documents");
		Directory subDir2 = new Directory("images");

		// Adding files
		subDir1.addEntry(new File("report", "pdf", 1200));
		subDir1.addEntry(new File("notes", "txt", 300));
		subDir2.addEntry(new File("photo", "jpg", 2500));
		subDir2.addEntry(new File("diagram", "pdf", 1500));
		root.addEntry(subDir1);
		root.addEntry(subDir2);
		root.addEntry(new File("project", "java", 5000));

		// Initializing search service
		FileSearchService searchService = new FileSearchService(root);

		// Example 1: Search for (PDF AND size < 2000)
		List<FileSearchCriteria> andCriteriaList = Arrays.asList(new ExtensionSearchCriteria("pdf"),
				new SizeSearchCriteria(0, 2000));
		FileSearchCriteria andCriteria = new CompositeAndCriteria(andCriteriaList);

		List<File> andResults = searchService.search(andCriteria);
		System.out.println("Files matching (PDF AND size < 2000):");
		for (File file : andResults) {
			System.out.println(file.getName() + "." + file.getExtension() + " - " + file.getSize() + " KB");
		}

		// Example 2: Search for (TXT OR size > 1000)
		List<FileSearchCriteria> orCriteriaList = Arrays.asList(new ExtensionSearchCriteria("txt"),
				new SizeSearchCriteria(1000, Long.MAX_VALUE));
		FileSearchCriteria orCriteria = new CompositeOrCriteria(orCriteriaList);

		List<File> orResults = searchService.search(orCriteria);
		System.out.println("\nFiles matching (TXT OR size > 1000):");
		for (File file : orResults) {
			System.out.println(file.getName() + "." + file.getExtension() + " - " + file.getSize() + " KB");
		}
	}
}
