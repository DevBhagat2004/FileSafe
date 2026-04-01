import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class fileOp {

    public void createFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.println("File Created");
        } catch (IOException e) {
            System.err.println("Problem in creating file");
        }
    }

    public void writeFile(String fileName, datablock block) throws IOException {
        ArrayList<datablock> blockChain = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(fileName);
        if (file.exists() && file.length() > 0) {

            Root newRoot;
            String rawJson = Files.readString(Paths.get(fileName));
            newRoot = gson.fromJson(rawJson, Root.class);
            int lastSize = newRoot.blockchain.size();
            block.index = lastSize;
            block.prevHash = newRoot.blockchain.get(lastSize-1).currHash;
            newRoot.blockchain.add(block);

            String jString = gson.toJson(newRoot);

            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(jString);
            } catch (IOException e) {
                System.err.println("Problem in the already existing file");
            }

        }
        else {
            Root newRoot = new Root();
            blockChain.add(block);
            newRoot.blockchain = blockChain;
            newRoot.blockchain.get(0).prevHash = "NULL";
            newRoot.blockchain.get(0).index = 0;
            String jString = gson.toJson(newRoot);
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(jString);
            } catch (IOException e) {
                System.err.println("Problem in the new/empty file");
            }
        }
    }
}
