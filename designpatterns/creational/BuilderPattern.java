package creational;

class Notification {
	private final int id;
	private final String name;
	private final String message;
	private final String mode;

	private Notification(NotificationBuilder notificationBuilder) {
		this.id = notificationBuilder.id;
		this.name = notificationBuilder.name;
		this.message = notificationBuilder.message;
		this.mode = notificationBuilder.mode;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public String getMode() {
		return mode;
	}

	@Override
	public String toString() {
		return this.id + " : " + this.name + " : " + this.message + " : " + this.mode;
	}

	static class NotificationBuilder {
		private int id;
		private String name;
		private String message;
		private String mode;

		public NotificationBuilder() {

		}

		public NotificationBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public NotificationBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public NotificationBuilder setMessage(String message) {
			this.message = message;
			return this;
		}

		public NotificationBuilder setMode(String mode) {
			this.mode = mode;
			return this;
		}

		public Notification build() {
			return new Notification(this);
		}
	}

}

public class BuilderPattern {

	public static void main(String[] args) {
		Notification notification = new Notification.NotificationBuilder().setMessage("hi").setId(23).setMode("Email")
				.setName("yay").build();
		System.out.println(notification);
	}

}
