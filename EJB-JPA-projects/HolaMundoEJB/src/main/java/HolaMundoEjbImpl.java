import jakarta.ejb.Stateless;

@Stateless
public class HolaMundoEjbImpl implements HolaMundoEJBRemote{

    @Override
    public int sumar(Integer a,Integer b){
        System.out.println(a+b);
        return a+b;
    }
}
