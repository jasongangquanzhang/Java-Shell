package driver;

import file_system.Directory;
import file_system.FileSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class holds all the states of the Shell Program
 */
public class JShellState implements IShellState {
    // this is the file system
    private final FileSystem fs;
    // this is the current directory of JShell program
    private Directory currentDir;
    // this indicates if the program is running or not
    private boolean running;
    // a stack used for push and pop command
    private final Stack<Directory> directoryStack;
    private final List<String> commandsHistory;
    private final List<String> correctCommandsHistory;

    /**
     * Constructs an object that holds JShell's important states including
     * the root directory, current directory, directory stack and a boolean that
     * indicates JShell is running
     */
    public JShellState() {
        this.running = true;
        this.fs = FileSystem.createFileSystemInstance();
        this.currentDir = fs.getRoot();
        this.commandsHistory = new ArrayList<>();
        this.correctCommandsHistory = new ArrayList<>();
        this.directoryStack = new Stack<>();
    }

    public boolean isRunning() {
        return running;
    }

    public void stopRunning() {
        running = false;
    }

    public FileSystem getFileSystem() {
        return fs;
    }

    public Directory getRootDir() {
        return fs.getRoot();
    }

    public Directory getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(Directory newCurrentDir) {
        currentDir = newCurrentDir;
    }

    public void addHistory(String inputLine) {
        commandsHistory.add(inputLine);
    }

    public void removeHistory(int index) {
        commandsHistory.remove(index);
    }

    public List<String> getHistory() {
        return commandsHistory;
    }

    public void addCorrectHistory(String inputLine) {
        correctCommandsHistory.add(inputLine);
    }

    public List<String> getCorrectHistory() {
        return correctCommandsHistory;
    }

    public Stack<Directory> getDirectoryStack(){
        return directoryStack;
    }

}
