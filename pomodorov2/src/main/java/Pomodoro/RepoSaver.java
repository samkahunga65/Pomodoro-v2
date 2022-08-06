package Pomodoro;

import java.io.*;
import java.util.ArrayList;

public class RepoSaver<K> implements  Repository<K>{
    @Override
    public void save(K jsonObject, String filename) throws IOException, ClassNotFoundException {
        //check if fie exists
        File file = new File(filename);
        ArrayList<K> newList = new ArrayList<>();
        newList.add(jsonObject);
        if(file.exists()){
            FileInputStream scannerObj = new FileInputStream(file);
            ObjectInputStream obj = new ObjectInputStream(scannerObj);
            var originalList = (ArrayList<K>) obj.readObject();
            newList.addAll(originalList);
            obj.close();
            scannerObj.close();
        }
        try
        {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newList);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    @Override
    public K get(String name, String fileName) {
        
        return null;
    }
}
