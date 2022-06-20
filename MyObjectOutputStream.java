import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class myObjectOutputStream extends ObjectOutputStream {
    public myObjectOutputStream() throws IOException{
        super();
    }

    public myObjectOutputStream(OutputStream o) throws IOException{
        super(o);
    }

    public void writeStreamHeader(){

    }
    
}
