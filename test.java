/* Test file for anything java */

public class test {

    public static void main(String[] args) {
        // DB Injection Prevention testing 
        String email = "admin@mail.com";
        String db_injection = "admin\' -- ";
        String db_injection2 = "*/admin\' /* ";
        String pass = "iotadmin";
        String query = "SELECT * FROM Users WHERE email = \'"+ email +"\' AND pass = \'"+ pass +"\';";
        String query2 = "SELECT * FROM Users WHERE email = \'"+ db_injection +"\' AND pass = \'"+ pass +"\';";
        String query3 = "SELECT * FROM Users WHERE email = \'"+ db_injection2 +"\' AND pass = \'"+ pass +"\';";
        System.out.println(query);
        System.out.println(query2);
        System.out.println(databaseInjectionFilter(query2));
        System.out.println(query3);
        System.out.println(databaseInjectionFilter(query3));
    }

    public static String databaseInjectionFilter(String query){
        /* Removes illegal inputs in the query to prevent SQL injection attacks */
        // Removes SQL comments, to prevent where condition bypass injections 
        query = query.replaceAll("--", "");
        query = query.replaceAll("/\\*", "");
        query = query.replaceAll("\\*/", "");
        // Removes two consequtive quotes input to prevent SQL error injections
        query = query.replaceAll("\'\\s*\'", "\'");
        return query;
    }

}