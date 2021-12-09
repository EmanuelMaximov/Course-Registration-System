package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.api.Database;
import bgu.spl.net.api.MessageEncoderDecoderImpl;
import bgu.spl.net.api.MessagingProtocolImpl;
import bgu.spl.net.srv.Server;

public class TPCMain {

    public static void main(String[] args) { // server in order to run the client!!
        Database database = Database.getInstance(); //one shared object

        database.init("./Courses.txt");
// you can use any server...
        //
        Server.threadPerClient(
                Integer.parseInt(args[0]), //port
                () -> new MessagingProtocolImpl(database), //protocol factory
                () -> new MessageEncoderDecoderImpl() {
                } //message encoder decoder factory
        ).serve();

    }
}
