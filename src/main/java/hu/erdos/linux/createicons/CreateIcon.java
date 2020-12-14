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
	
	public CreateIcon(String exec, String icon, boolean autostart) {
		this.astart = autostart;
		System.out.println("Executive: "+exec);
		System.out.println("Icon: "+icon);
		String stdin = new String();
		desktopIcon.setExec(exec);
		desktopIcon.setIcon(icon);
		System.out.print("Name: ");
		stdin = scn.nextLine();
		if (!stdin.isEmpty()) {
			desktopIcon.setName(stdin);	
		} else {
			System.out.println("The name can not be null!");
			System.exit(2);
		}		
		stdin = new String();
		System.out.print("Generic Name: ");
		stdin = scn.nextLine();
		if (stdin.isEmpty() ) {
			stdin = " ";
		}
		desktopIcon.setGeneric_name(stdin);		
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
		File ihome = new File( Environments.ICONSHOME);
		if (!ihome.exists()) {
			ihome.mkdirs();
		}
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
		
		if (this.astart) {
		
			fileName = Environments.AUTOSTARTFOLDER+File.separator+desktopIcon.getName().replaceAll(" ", "")+".desktop";
			File astrt = new File(Environments.AUTOSTARTFOLDER);
			if (!astrt.exists()) {
				astrt.mkdirs();
			}
			
			PrintWriter pwa = new PrintWriter(new FileWriter(new File(fileName),true),true);
			pwa.append("[Desktop Entry]"+"\n");
			pwa.append("Name="+desktopIcon.getName()+"\n");
			pwa.append("Comment="+desktopIcon.getComment()+"\n");
			pwa.append("TryExec="+desktopIcon.getExec()+"\n");
			pwa.append("Exec="+desktopIcon.getExec()+"\n");
			pwa.append("Icon="+desktopIcon.getIcon()+"\n");
			pwa.append("Terminal="+desktopIcon.getTerminal()+"\n");
			pwa.append("Type="+desktopIcon.getType()+"\n");
			pwa.append("Categories=");
			for (String category: desktopIcon.getCategories()) {			
				pwa.append(category);
			}
			pwa.append("\n");
			pwa.close();
		}
	
		
	}
	
	private int categorySelect() {
		int catCount = 0;
		int selection = 0;
		Scanner input = new Scanner(System.in);
		
		for (int i=0; i< Environments.CATEG().size(); i++) {
			System.out.println(i+"::"+Environments.CATEG().get(i));
		}
		System.out.print("Category number: ");
		String sel = input.nextLine();

		if (isNumber(sel)){
			selection = Integer.parseInt(sel);
		}

		
		return selection;
	}

	private boolean isNumber(String n) {
		try {
			int number = Integer.parseInt(n);
			if (number > Environments.CATEG().size()) {
				return false;
			}
			return  true;
		} catch (NumberFormatException ne) {
			return false;
		}
	}
}
