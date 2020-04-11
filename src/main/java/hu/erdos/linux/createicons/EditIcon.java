package hu.erdos.linux.createicons;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Scanner;

public class EditIcon {

    private ArrayList<String> desktopFiles = new ArrayList<String>();
    Scanner scn = new Scanner(System.in);


    FileFilter Deskotpfilter
                    = new FileFilter() {
                      //Override accept method
                      public boolean accept(File file) {
                         //if the file extension is .log return true, else false
                         if (file.getName().endsWith(".desktop")) {
                            return true;
                         }
                         return false;
                      }
                   };


    public EditIcon() {
        this.desktopFiles = listDestopFiles();
        int sel = this.desktopFiles.size() + 10;

        while ( sel > this.desktopFiles.size()) {
            sel = selectDesktopFiéle();
        }

        System.exit(0);
    }

    private ArrayList<String> listDestopFiles() {
        ArrayList<String> fl = new ArrayList<String>();

        File dfolder = new File(Environments.ICONSHOME);
        File[]  deskopfiles = dfolder.listFiles(Deskotpfilter);
        int count = 0;
        for (String f: desktopFiles) {
            fl.add(count+". "+f);
            count++;
        }

        return fl;
    }

    private int selectDesktopFiéle(){
        int catCount = 0;
        int selection;
        Scanner input = new Scanner(System.in);

        for (int i=0; i< this.desktopFiles.size(); i++) {
            System.out.println(this.desktopFiles.get(i));
        }
        System.out.print("number: ");
        selection = input.nextInt();

        return selection;
    }

}
