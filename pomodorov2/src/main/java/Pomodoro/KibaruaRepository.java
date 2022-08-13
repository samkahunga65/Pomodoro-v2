package Pomodoro;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class KibaruaRepository {
    RepoSaver repoSaver = new RepoSaver();
    KibaruaRepository() throws IOException {
        this.vibarua = getVibarua();
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Kibarua kibs = new Kibarua("PomPom making", UUID.randomUUID());
        RepoSaver repoSaver = new RepoSaver();
        repoSaver.save(kibs, Kibarua.saveFile);
    }
    ArrayList<Kibarua> vibarua;


    void addKibarua(Kibarua kibarua) throws IOException {
        this.vibarua.add(kibarua);
        saveToFile();
    }
    Kibarua getKibarua(String name) {
        return vibarua.stream().filter(kibarua -> Objects.equals(kibarua.name, name)).findFirst().orElse(null);
    }

    private ArrayList<Kibarua> getVibarua() throws IOException {
        var file = new File("vibarua.god");
        if(!file.exists()) {
            file.createNewFile();
            return new ArrayList<>();
        }
        try
        {
            FileInputStream fis = new FileInputStream("vibarua.god");
            ObjectInputStream ois = new ObjectInputStream(fis);

            vibarua = (ArrayList<Kibarua>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return null;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }
        return vibarua;
    }
    void saveToFile () throws IOException {
        try
        {
            FileOutputStream fos = new FileOutputStream("vibarua.god");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(vibarua);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}
