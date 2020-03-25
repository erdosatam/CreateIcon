package hu.erdos.linux.createicons;

/**
 * Create Icons
 *
 */
public class App 
{

	
    public static void main( String[] args )
    {
    	String executive = null;
    	String icon = null;
    	
        if (args.length > 0) {
        	for (int i=0; i < args.length; i++) {
        		switch (args[i]) {
				case "-e": executive = args[i+1];				
					break;
				case "-i": icon = args[i+1];
					break;
				case "-v": 
					System.out.println(Environments.VERNUM);
					System.exit(0);
					break;
				case "-h":
					Help();
					System.exit(0);
					break;
				default:
					break;
				}
        	}
        	if ((executive != null) && (icon != null) ) {
        		new CreateIcon(executive, icon);
        	} else {
        		Help();
        	}
        } else {
        	Help();
        }
    }

	private static void Help() {
		StringBuffer hlp = new StringBuffer();
		
		hlp.append(Environments.VERNUM);
		hlp.append("usage: cricon <options>\n");
		hlp.append("options:\n");
		hlp.append("\t-e <executive (with absolute path)>\n");
		hlp.append("\t-i <icon (with absolute path)>\n");
		
		System.out.println(hlp.toString());
	}
}
