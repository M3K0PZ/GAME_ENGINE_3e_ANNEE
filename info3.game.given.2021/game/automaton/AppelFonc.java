package automaton;

import java.util.LinkedList;
import java.util.List;

public class AppelFonc {
	String name;
	List<String> arguments;
	int percent;

	public AppelFonc(String name, int percent) {
		this.name = name;
		this.percent = percent;
		this.arguments = new LinkedList<String>();
	}

	public AppelFonc(String name, int percent, List<String> chaine) {
		this.name = name;
		this.percent = percent;
		this.arguments = chaine;
	}

	public void addArgument(String arg) {
		arguments.add(arg);
	}

}
