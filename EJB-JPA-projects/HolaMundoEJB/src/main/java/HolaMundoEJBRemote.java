import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;

@Remote
public interface HolaMundoEJBRemote {
    public int sumar(Integer a, Integer b);



}

