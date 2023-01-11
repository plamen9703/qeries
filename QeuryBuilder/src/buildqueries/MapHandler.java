package buildqueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapHandler {
	private static Connection con;
	private static String url="jdbc:mysql://localhost:3306/queries";
	private static String user="root";
	private static String pass="Npmg2022!";
	static {
		try {
			con=DriverManager.getConnection(url,user,pass);
		}catch(SQLException e) {
			
		}
		
	};
	public static MapObjects oneToMany = ((a, b) -> {
		Class bClass=b.getClass();
		Class aClass=a.getClass();
		StringBuilder sb=new StringBuilder("alter table "+bClass.getSimpleName()+" add column ");
		
	});
	public static MapObjects manyToMany = ((a, b) -> {

	});
	public static MapObjects oneToOne = ((a, b) -> {

	});
}
