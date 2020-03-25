package hu.erdos.linux.createicons;

import java.util.ArrayList;

public class DesktopIcon {

	private String name;
	private String exec;
	private String Version;
	private String comment;
	private String generic_name;
	private String icon;
	private String terminal;
	private String type;
	private ArrayList<String> categories = new ArrayList<String>();
	
	public int category_count() {
		return this.categories.size();
	}
	
	public void addCategory(String cat) {
		
		this.categories.add(cat);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExec() {
		return exec;
	}

	public void setExec(String exec) {
		this.exec = exec;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getGeneric_name() {
		return generic_name;
	}

	public void setGeneric_name(String generic_name) {
		this.generic_name = generic_name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}
	
	
}
