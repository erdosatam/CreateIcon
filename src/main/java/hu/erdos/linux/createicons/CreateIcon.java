package hu.erdos.linux.createicons;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateIcon {

	DesktopIcon desktopIcon = new DesktopIcon();
	Scanner scn = new Scanner(System.in);
	private boolean astart = false;

	public CreateIcon(final String exec, final String icon, final boolean autostart) {
		this.astart = autostart;
		System.out.println("Executive: " + exec);
		System.out.println("Icon: " + icon);
		String stdin = new String();
		this.desktopIcon.setExec(exec);
		this.desktopIcon.setIcon(icon);
		System.out.print("Name: ");
		stdin = this.scn.nextLine();
		if (!stdin.isEmpty()) {
			this.desktopIcon.setName(stdin);
		} else {
			System.out.println("The name can not be null!");
			System.exit(2);
		}
		stdin = new String();
		System.out.print("Generic Name: ");
		stdin = this.scn.nextLine();
		if (stdin.isEmpty()) {
			stdin = " ";
		}
		this.desktopIcon.setGeneric_name(stdin);
		System.out.print("Terminal: (true or false - default: false):  ");
		final String term = this.scn.nextLine();
		if (term.isEmpty()) {
			this.desktopIcon.setTerminal("false");
		} else {
			this.desktopIcon.setTerminal(term);
		}
		System.out.print("Type: (default: Application): ");
		final String typ = this.scn.nextLine();
		if (typ.isEmpty()) {
			this.desktopIcon.setType("Application");
		} else {
			this.desktopIcon.setType(typ);
		}
		System.out.print("Comment: ");
		final String comment = this.scn.nextLine();
		if (comment.isEmpty()) {
			this.desktopIcon.setComment(this.desktopIcon.getName());
		} else {
			this.desktopIcon.setComment(comment);
		}
		this.desktopIcon.setStartupWMClass(this.desktopIcon.getName().replaceAll(" ", ""));
		System.out.println("Add categories: ");
		System.out.println("Select category: ");
		this.desktopIcon.addCategory(Environments.CATEG().get(categorySelect()));
		boolean isok = true;
		try {
			writeDesktop();
		} catch (final IOException e) {
			isok = false;
			e.printStackTrace();
		}
		if (isok) {
			System.out.println("The icon has been created...");
			System.exit(0);
		} else {
			System.out.println("Something went worng. Please check the details!");
			System.exit(1);
		}
	}

	private void writeDesktop() throws IOException {

		String fileName = Environments.ICONSHOME + File.separator + this.desktopIcon.getName().replaceAll(" ", "")
				+ ".desktop";
		final File ihome = new File(Environments.ICONSHOME);
		if (!ihome.exists()) {
			ihome.mkdirs();
		}
		final PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName), true), true);
		pw.append("[Desktop Entry]" + "\n");
		pw.append("Name=" + this.desktopIcon.getName() + "\n");
		pw.append("Comment=" + this.desktopIcon.getComment() + "\n");
		pw.append("TryExec=" + this.desktopIcon.getExec() + "\n");
		pw.append("Exec=" + this.desktopIcon.getExec() + "\n");
		pw.append("Icon=" + this.desktopIcon.getIcon() + "\n");
		pw.append("Terminal=" + this.desktopIcon.getTerminal() + "\n");
		pw.append("Type=" + this.desktopIcon.getType() + "\n");
		pw.append("startupWMClass=" + this.desktopIcon.getStartupWMClass() + "\n");
		pw.append("Categories=");
		for (final String category : this.desktopIcon.getCategories()) {
			pw.append(category);
		}
		pw.append("\n");
		pw.close();

		if (this.astart) {

			fileName = Environments.AUTOSTARTFOLDER + File.separator + this.desktopIcon.getName().replaceAll(" ", "")
					+ ".desktop";
			final File astrt = new File(Environments.AUTOSTARTFOLDER);
			if (!astrt.exists()) {
				astrt.mkdirs();
			}

			final PrintWriter pwa = new PrintWriter(new FileWriter(new File(fileName), true), true);
			pwa.append("[Desktop Entry]" + "\n");
			pwa.append("Name=" + this.desktopIcon.getName() + "\n");
			pwa.append("Comment=" + this.desktopIcon.getComment() + "\n");
			pwa.append("TryExec=" + this.desktopIcon.getExec() + "\n");
			pwa.append("Exec=" + this.desktopIcon.getExec() + "\n");
			pwa.append("Icon=" + this.desktopIcon.getIcon() + "\n");
			pwa.append("Terminal=" + this.desktopIcon.getTerminal() + "\n");
			pwa.append("Type=" + this.desktopIcon.getType() + "\n");
			pwa.append("Categories=");
			for (final String category : this.desktopIcon.getCategories()) {
				pwa.append(category);
			}
			pwa.append("\n");
			pwa.close();
		}

	}

	private int categorySelect() {
		final int catCount = 0;
		int selection = 0;
		final Scanner input = new Scanner(System.in);

		for (int i = 0; i < Environments.CATEG().size(); i++) {
			System.out.println(i + "::" + Environments.CATEG().get(i));
		}
		System.out.print("Category number: ");
		final String sel = input.nextLine();

		if (isNumber(sel)) {
			selection = Integer.parseInt(sel);
		}

		return selection;
	}

	private boolean isNumber(final String n) {
		try {
			final int number = Integer.parseInt(n);
			if (number > Environments.CATEG().size()) {
				return false;
			}
			return true;
		} catch (final NumberFormatException ne) {
			return false;
		}
	}
}
