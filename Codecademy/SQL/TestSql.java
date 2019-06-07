import java.sql.*; // get all the library to use mysql

class TestSql {

    private static final String url = "jdbc:mysql://localhost:3306/javabase"; // the url connect to the database

    private static final String user = "java"; // username

    private static final String password = "password"; //passowrd

    public static void main(String args[]) {
        try {
            Connection con = DriverManager.getConnection(url, user, password); // for the connection
            Statement stmt = con.createStatement(); // this is for the statement
            String create_table_test = " CREATE TABLE test (id INTEGER, name TEXT, age INTEGER);"; // the mysql commend
            stmt.execute(create_table_test); // execute it
            stmt.close();
            System.out.println("Success");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
