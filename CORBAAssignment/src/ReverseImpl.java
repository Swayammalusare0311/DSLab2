import ReverseModule.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

class ReverseImpl extends ReversePOA {

    private ORB orb;

    public void setORB(ORB orb_val) {

        orb = orb_val;
    }

    public String reverse_string(String name) {

        StringBuffer str =
                new StringBuffer(name);

        return str.reverse().toString();
    }
}