package commands;

import java.util.List;

import driver.IShellState;
import fileSystem.Directory;
import helperClasses.PathHandler;

/**
 * This class allows user to move between directories
 */
public class Cd extends Command {

    public Cd( ) {
        super(1, 1);
    }

    /**
     * Switches the current directory that JShell program is in to the one
     * defined by given path
     * @param shellState is the state of JShell program
     * @param arguments is list of arguments that were passed along with command
     * (includes the path of directory to be switched to)
     */
    public String executeCommand(IShellState shellState, List<String> arguments)
            throws Exception{
        // check number of arguments
        checkArgumentsNum(arguments);
        // get the path
        String path = arguments.get(0);
        // get the wanted directory and make it current directory
        Directory wantedDir = PathHandler.getDirectoryByPath(shellState, path);
        shellState.setCurrentDir(wantedDir);
        return "";
    }

}
