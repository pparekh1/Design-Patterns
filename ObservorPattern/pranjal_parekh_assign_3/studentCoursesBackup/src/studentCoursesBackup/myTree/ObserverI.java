package studentCoursesBackup.myTree;

/**
 *
 * @author Pranjal Parekh
 */
public interface ObserverI {
    /**
     * @param course course to be added in the particular observer
     * @param t denotes the operation
     */
    void update(String course, Operation t);
    
}