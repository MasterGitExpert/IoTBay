import java.sql.Timestamp;

public class test {

    public static void main(String[] args) {
        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println((new Timestamp(System.currentTimeMillis())).toString());

    }
    
}