package hu.erdos.linux.createicons;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreateIcon {

	DesktopIcon desktopIcon = new DesktopIcon();
	Scanner scn = new Scanner(System.in);
	
	public CreateIcon(String exec, String icon) {
		System.out.println("Executive: "+exec);
		System.out.println("Icon: "+icon);
		desktopIcon.setExec(exec);
		desktopIcon.setIcon(icon);
		System.out.print("Name: ");
		desktopIcon.setName(scn.nextLine());
		System.out.print("Generic Name: ");
		desktopIcon.setGeneric_name(scn.nextLine());
		System.out.print("Terminal: (true or false - default: false):  ");
		String term = scn.nextLine();
		if (term.isEmpty()) {
			desktopIcon.setTerminal("false");
		} else {
			desktopIcon.setTerminal(term);
		}
		System.out.print("Type: (default: Application): ");
		String typ = scn.nextLine();
		if (typ.isEmpty()) {
			desktopIcon.setType("Application");
		} else {
			desktopIcon.setType(typ);
		}
		System.out.println("Add categories: ");
		System.out.println("Select category: ");
		desktopIcon.addCategory(Environments.CATEG().get(categorySelect()));
		boolean isok = true;
		try {
			writeDesktop();
		} catch (IOException e) {
			isok = false;
			e.printStackTrace();
		}
		if (isok) {
			System.out.println("The icon has been created...");
		}
	}

	private void writeDesktop() throws IOException {
		String fileName = Environments.ICONSHOME+File.separator+desktopIcon.getName().replaceAll(" ", "")+".desktop";
		PrintWriter pw = new PrintWriter(new FileWriter(new File(fileName),true),true);
		pw.append("[Desktop Entry]"+"\n");
		pw.append("Name="+desktopIcon.getName()+"\n");
		pw.append("Comment="+desktopIcon.getComment()+"\n");
		pw.append("TryExec="+desktopIcon.getExec()+"\n");
		pw.append("Exec="+desktopIcon.getExec()+"\n");
		pw.append("Icon="+desktopIcon.getIcon()+"\n");
		pw.append("Terminal="+desktopIcon.getTerminal()+"\n");
		pw.append("Type="+desktopIcon.getType()+"\n");
		pw.append("Categories=");
		for (String category: desktopIcon.getCategories()) {			
			pw.append(category);
		}
		pw.append("\n");
		pw.close();
		
	}
	
	private int categorySelect() {
		int catCount = 0;
		int selection;
		Scanner input = new Scanner(System.in);
		
		for (int i=0; i< Environments.CATEG().size(); i++) {
			System.out.println(i+"::"+Environments.CATEG().get(i));
		}
		System.out.print("Category number: ");
		selection = input.nextInt();
		
		return selection;
	}
}
