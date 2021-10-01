package main;

public class Train extends Thread {
	private String name;
	private boolean running = true;
	private long startTime, tempTime, interval = 500, endTime = 3000;

	Train(String name) {
		this.name = name;
		this.setName(name);
		startTime = System.currentTimeMillis();
		endTime += startTime;
		tempTime = startTime;
		System.out.println(startTime);
	}

	public Train(String name, int interval) {
		this.name = name;
		this.setName(name);
		startTime = System.currentTimeMillis();
		endTime += startTime;
		tempTime = startTime;
		this.interval = interval;
		System.out.println(startTime);
	}
	public String time() {
		return String.valueOf(tempTime + interval);
	}

	@Override
	public void run() {
		while (running) {
			if (tempTime + interval < System.currentTimeMillis()) {
				System.out.println(name + " is Running");
				tempTime = System.currentTimeMillis();
			}
			// Stopp
			if (endTime < System.currentTimeMillis()) {
				running = false;
			}

		}
		System.out.println(name + " Stopped!");
	}

	@Override
	public void interrupt() {
		running = false;
	}

}
