package Module_7_Threads.Task_vThree;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {

    private List<Integer> list;

    public SharedResource() {
        list = new ArrayList<Integer>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public synchronized Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
}

