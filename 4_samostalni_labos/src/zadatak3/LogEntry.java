package zadatak3;

public class LogEntry {

	String time;
	String level;
	String thread;
	String text;

	public LogEntry(String time, String level, String thread, String text) {
		this.time = time;
		this.level = level;
		this.thread = thread;
		this.text = text;

	}

	public String getTime() {
		return time;
	}

	public String getLevel() {
		return level;
	}

	public String getThread() {
		return thread;
	}

	public String getText() {
		return text;
	}

	@Override
	public String toString() { // DODANO SAMO ZA DEMONSTRACIJU
		return "LogEntry [time=" + time + ", level=" + level + ", thread=" + thread + ", text=" + text + "]";
	}

}
