package Pomodoro;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Repository<K> {
    void save(K jsonObject, String filename) throws IOException, ClassNotFoundException;
    K get(String name, String fileName);
}
