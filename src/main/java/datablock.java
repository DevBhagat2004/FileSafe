public class datablock {
    int index;
    String Data;
    String currHash;
    String prevHash;

    public datablock(int num, String line, String curr, String previous){
        index = num;
        Data = line;
        currHash= curr;
        prevHash = previous;
    }
}
