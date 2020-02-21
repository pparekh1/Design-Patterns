package studentCoursesBackup.myTree;

public interface SubjectI {
public void RegisterObserver(ObserverI ob);
public void notifyObservers(String Course,Operation t);
public void RemoveObserver(ObserverI ob);
}