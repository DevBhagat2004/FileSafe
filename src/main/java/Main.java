import java.io.IOException;
import java.util.Scanner; // get users input
public class Main {

    public static void options(){
        System.out.println("Please select from the options");
        System.out.println("Create a JSON file: 1");
        System.out.println("Write to a JSON file: 2");
        System.out.println("Verify the JSON file: 3");
        System.out.println("Exit: 4");
    }

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner (System.in);
        options();
        int choice=reader.nextInt();

        while (choice!=4){
            if (choice==1){
                System.out.println("Please enter the file name");
                String fileName = reader.next();
                fileOp op = new fileOp();
                op.createFile(fileName);
                }
            else if (choice==2) {
                // get the filename
                System.out.println("Please enter the filename");
                String fileName = reader.next();
                // for \n protection
                reader.nextLine();
                // get the data
                System.out.println("Please enter the string");
                String message = reader.nextLine();// reader.next() is only for word and to have line with spaces you need nextLine()
                // make the block
                datablock block = new datablock(message);
                fileOp op = new fileOp();
                // call the writeFile
                op.writeFile(fileName,block);
            }
            else if (choice==3){
                System.out.println("Please enter the file name");
                String fileName = reader.next();
                fileOp.verifyFile(fileName);
            }
            options();
            choice = reader.nextInt();
        }
    }
}
