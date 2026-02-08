package lld;

import java.util.ArrayList;
import java.util.List;

// Message Broker to manage publishers and subscribers
class MessageBroker {
	private List<Subscriber> subscribers = new ArrayList<>();

	public void subscribe(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	public void unsubscribe(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	public void publish(String message) {
		for (Subscriber subscriber : subscribers) {
			subscriber.receive(message);
		}
	}
}

// Publisher class
class Publisher {
	private MessageBroker broker;

	public Publisher(MessageBroker broker) {
		this.broker = broker;
	}

	public void publishMessage(String message) {
		System.out.println("Publisher: Publishing message -> " + message);
		broker.publish(message);
	}
}

// Subscriber interface
interface Subscriber {
	void receive(String message);
}

// Concrete Subscribers
class ConcreteSubscriber implements Subscriber {
	private String name;

	public ConcreteSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void receive(String message) {
		System.out.println(name + " received message: " + message);
	}
}

// Main application
public class PubSubApp {
	public static void main(String[] args) {
		MessageBroker broker = new MessageBroker();

		Subscriber sub1 = new ConcreteSubscriber("Subscriber 1");
		Subscriber sub2 = new ConcreteSubscriber("Subscriber 2");

		broker.subscribe(sub1);
		broker.subscribe(sub2);

		Publisher publisher = new Publisher(broker);
		publisher.publishMessage("Hello, World!");

		// Unsubscribe one subscriber and send another message
		broker.unsubscribe(sub1);
		publisher.publishMessage("New Update Available!");
	}
}
