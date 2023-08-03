package zadania;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ListaZadan {

    private String opisZadania;

    private String opisNowegoZadania;
    private List<Zadanie> taskList = new ArrayList<Zadanie>();

    public ListaZadan(String opisZadania, String opisNowegoZadania, List<Zadanie> taskList) {
        this.opisZadania = opisZadania;
        this.opisNowegoZadania = opisNowegoZadania;
        this.taskList = taskList;
    }

    public String getOpisZadania() {
        return opisZadania;
    }

    public void setOpisZadania(String description) {
        this.opisZadania = description;
    }

    public String getOpisNowegoZadania() {
        return opisNowegoZadania;
    }

    public void setOpisNowegoZadania(String opisNowegoZadania) {
        this.opisNowegoZadania = opisNowegoZadania;
    }

    public List<Zadanie> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Zadanie> taskList) {
        this.taskList = taskList;
    }
}
