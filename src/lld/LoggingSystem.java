package lld;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

// Enum to define log levels
enum LogLevel {
	INFO, DEBUG, ERROR
}

// Strategy Interface
interface LogStrategy {
	void log(String message, LogLevel level);
}

// Console Logger Implementation
class ConsoleLogger implements LogStrategy {
	@Override
	public void log(String message, LogLevel level) {
		System.out.println(LocalDateTime.now() + " [" + level + "] " + message);
	}
}

// File Logger Implementation
class FileLogger implements LogStrategy {
	private String filePath;

	public FileLogger(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void log(String message, LogLevel level) {
		try (FileWriter fw = new FileWriter(filePath, true)) {
			fw.write(LocalDateTime.now() + " [" + level + "] " + message + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// Database Logger Implementation (Simulated)
class DatabaseLogger implements LogStrategy {
	@Override
	public void log(String message, LogLevel level) {
		System.out.println("Saving log to DB: " + LocalDateTime.now() + " [" + level + "] " + message);
	}
}

// Logger Class with Level Filtering
class Logger {
	private LogStrategy logStrategy;
	private LogLevel minLogLevel; // Only logs at or above this level will be logged

	public Logger(LogStrategy strategy, LogLevel minLogLevel) {
		this.logStrategy = strategy;
		this.minLogLevel = minLogLevel;
	}

	public void setLogStrategy(LogStrategy strategy) {
		this.logStrategy = strategy;
	}

	public void setMinLogLevel(LogLevel minLogLevel) {
		this.minLogLevel = minLogLevel;
	}

	public void log(String message, LogLevel level) {
		if (level.ordinal() >= minLogLevel.ordinal()) { // Log only if level is >= minLogLevel
			logStrategy.log(message, level);
		}
	}
}

// Test the Filtering Mechanism
class LoggingSystemExample {
	public static void main(String[] args) {
		Logger logger = new Logger(new ConsoleLogger(), LogLevel.INFO); // Log only INFO and higher

		logger.log("This is an INFO log.", LogLevel.INFO); // Will be printed
		logger.log("This is a DEBUG log.", LogLevel.DEBUG); // Will NOT be printed
		logger.log("This is an ERROR log.", LogLevel.ERROR); // Will be printed

		// Switching to File Logger
		logger.setLogStrategy(new FileLogger("app.log"));
		logger.log("Error logged to file!", LogLevel.ERROR); // Will be written to the file
	}
}