public class datablock {
    int index;
    String Data;
    String currHash;
    String prevHash;
    long timeStamp;

    public datablock(int num, String line, String curr, String previous, long time){
        index = num;
        Data = line;
        currHash= curr;
        prevHash = previous;
        timeStamp =time;
    }

    public datablock(String line, String curr, long time){
        Data = line;
        currHash= curr;
        timeStamp =time;
    }

    public datablock(String line){
        Data = line;
    }



}
