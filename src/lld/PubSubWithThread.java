package lld;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Thread-safe Message Broker
class MessageBrokerWithThread {
	private List<SubscriberWithThread> subscribers = new CopyOnWriteArrayList<>();
	private ExecutorService executor = Executors.newFixedThreadPool(5);

	public void subscribe(SubscriberWithThread subscriber) {
		subscribers.add(subscriber);
	}

	public void unsubscribe(SubscriberWithThread subscriber) {
		subscribers.remove(subscriber);
	}

	public void publish(String message) {
		for (SubscriberWithThread subscriber : subscribers) {
			executor.submit(() -> subscriber.receive(message));
		}
	}

	public void shutdown() {
		executor.shutdown();
	}
}

// Publisher class
class PublisherWithThread {
	private MessageBrokerWithThread broker;

	public PublisherWithThread(MessageBrokerWithThread broker) {
		this.broker = broker;
	}

	public void publishMessage(String message) {
		System.out.println("Publisher: Publishing message -> " + message);
		broker.publish(message);
	}
}

// Subscriber interface
interface SubscriberWithThread {
	void receive(String message);
}

// Concrete Subscriber with threading
class ConcreteSubscriberThread implements SubscriberWithThread {
	private String name;

	public ConcreteSubscriberThread(String name) {
		this.name = name;
	}

	@Override
	public void receive(String message) {
		System.out.println(
				name + " received message: " + message + " (Thread: " + Thread.currentThread().getName() + ")");
		try {
			Thread.sleep(1000); // Simulating processing time
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

// Main Application
public class PubSubWithThread {
	public static void main(String[] args) throws InterruptedException {
		MessageBrokerWithThread broker = new MessageBrokerWithThread();

		SubscriberWithThread sub1 = new ConcreteSubscriberThread("Subscriber 1");
		SubscriberWithThread sub2 = new ConcreteSubscriberThread("Subscriber 2");
		SubscriberWithThread sub3 = new ConcreteSubscriberThread("Subscriber 3");

		broker.subscribe(sub1);
		broker.subscribe(sub2);
		broker.subscribe(sub3);

		PublisherWithThread publisher = new PublisherWithThread(broker);
		publisher.publishMessage("Hello, World!");
		publisher.publishMessage("New Update Available!");

		Thread.sleep(3000); // Wait for all messages to be processed

		broker.shutdown(); // Shutdown executor service
	}
}
