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
	private String startupWMClass;
	private final ArrayList<String> categories = new ArrayList<String>();

	public int category_count() {
		return this.categories.size();
	}

	public void addCategory(final String cat) {

		this.categories.add(cat);
	}

	public String getStartupWMClass() {
		return this.startupWMClass;
	}

	public void setStartupWMClass(final String swclass) {
		this.startupWMClass = swclass;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getExec() {
		return this.exec;
	}

	public void setExec(final String exec) {
		this.exec = exec;
	}

	public String getVersion() {
		return this.Version;
	}

	public void setVersion(final String version) {
		this.Version = version;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}

	public String getGeneric_name() {
		return this.generic_name;
	}

	public void setGeneric_name(final String generic_name) {
		this.generic_name = generic_name;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(final String icon) {
		this.icon = icon;
	}

	public String getTerminal() {
		return this.terminal;
	}

	public void setTerminal(final String terminal) {
		this.terminal = terminal;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public ArrayList<String> getCategories() {
		return this.categories;
	}

}
