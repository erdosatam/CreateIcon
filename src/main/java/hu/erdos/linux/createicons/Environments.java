package hu.erdos.linux.createicons;

import java.io.File;
import java.util.ArrayList;

public class Environments {

	public static String USERHOME = System.getProperty("user.home");
	public static String ICONSHOME = Environments.USERHOME + File.separator + ".local" + File.separator + "share"
			+ File.separator + "applications";
	public static String AUTOSTARTFOLDER = Environments.USERHOME + File.separator + ".config" + File.separator
			+ "autostart";

	public final static String VERNUM = "CreateIcon v0.1.9.0 \n(c) 2020, erdos\n";
	public static boolean root = false;

	public static ArrayList<String> CATEG() {
		final ArrayList<String> cat = new ArrayList<String>();

		cat.add("AudioVideo");
		cat.add("Audio");
		cat.add("Video");
		cat.add("Development");
		cat.add("Education");
		cat.add("Game");
		cat.add("Graphics");
		cat.add("Network");
		cat.add("Office");
		cat.add("Settings");
		cat.add("Utility");

		return cat;
	}

}
