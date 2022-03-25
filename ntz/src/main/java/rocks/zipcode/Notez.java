package rocks.zipcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * ntz main command.
 */
public final class Notez {

    private FileMap filemap;

    public Notez() {
        this.filemap  = new FileMap();
    }
    /**
     * Says hello to the world.
     *
     * @param argv The arguments of the program.
     */
    public static void main(String argv[]) {
        boolean _debug = true;
        // for help in handling the command line flags and data!
        if (_debug) {
            System.err.print("Argv: [");
            for (String a : argv) {
                System.err.print(a+" ");
            }
            System.err.println("]");
        }

        Notez ntzEngine = new Notez();

        ntzEngine.loadDatabase();

        /*
         * You will spend a lot of time right here.
         *
         * instead of loadDemoEntries, you will implement a series
         * of method calls that manipulate the Notez engine.
         * See the first one:
         */


        ntzEngine.loadDemoEntries();

        ntzEngine.saveDatabase();

        if (argv.length == 0) { // there are no commandline arguments
            //just print the contents of the filemap.
            ntzEngine.printResults();
        } else {
            if (argv[0].equals("-r")) {
                ntzEngine.addToCategory("General", argv);
            } // this should give you an idea about how to TEST the Notez engine
              // without having to spend lots of time messing with command line arguments.
        }
        /*
         * what other method calls do you need here to implement the other commands??
         */

    }

    public void addToCategory(String string, String[] argv) {
        String[] newArgv = Arrays.copyOfRange(argv,1, argv.length);
        int i = 1;
        NoteList test = new NoteList();

        if (!filemap.containsKey("\t" + string)){
            filemap.put("\t" + string, new NoteList());
            for(String arg: newArgv) {
                filemap.get("\t" + string).add(i + ") " + arg);
                i++;
            }
        } else {
            for(String arg: newArgv) {
                filemap.get("\t" + string).add(i + ") " + arg);
                i++;
            }
        }
        printResults();
    }



    private void saveDatabase() {
        filemap.save();
    }

    private void loadDatabase() {
        filemap.load();
    }

    public String printResults() {
        return this.filemap.toString();
    }

    public void loadDemoEntries() {
        filemap.put("General", new NoteList("The Very first Note"));
        filemap.put("note2", new NoteList("A secret second note"));
        filemap.put("category3", new NoteList("Did you buy bread AND eggs?"));
        filemap.put("anotherNote", new NoteList("Hello from ZipCode!"));
    }

    public void forget() {
    }

    public void editOrReplace() {
    }

//    public void createOrAppend(String category, String text, String[] argv) {
//            if(asList(argv).contains("-c") && filemap.containsKey()){
//                filemap.get("General").add(string);
//            } else if (asList(argv).contains("-r")){
//                filemap.put("General", new NoteList(string));
//            }
//        }
//    }

//    public void remember(String string, String[] argv) {
//    List<String> argList = new ArrayList.
//    argv =
//            if(filemap.containsKey(string)){
//                for(String arg: argv) {
//                    filemap.get(string).add(arg));
//                }
//            } else if (asList(argv).contains("-r")){
//                filemap.put("General", new NoteList(string));
//            }
//
//    }
    /*
     * Put all your additional methods that implement commands like forget here...
     */

}
