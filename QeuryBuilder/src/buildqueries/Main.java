package buildqueries;

import java.sql.Statement;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
	public static void main(String[] args) {
		Person p=new Person();
		p.setName("Plamen");
		p.setId(1);
		System.out.println(p);
		StringBuilder sb=new StringBuilder("create table ");
		Class<? extends Person> c=p.getClass();
		sb.append(c.getSimpleName()+"(");
		Field f[]=c.getDeclaredFields();
		System.out.println(f.length);
		for(int i=0;i<f.length;i++) {
			Field f1=f[i];
			sb.append(f1.getName()+" ");
			if(f1.getType()==String.class) {
				sb.append("varchar(255)");
			}else
				sb.append(f1.getType().getSimpleName());
			if(f1.isAnnotationPresent(PrimaryKey.class)) {
				sb.append(" primary key");
				System.out.printf("%s is primary key.\n",f1.getName());
			}
			
			if(f1.isAnnotationPresent(NotNull.class)) {
				sb.append(" NOT NULL");
				System.out.printf("%s should not be null.\n", f1.getName());
			}
			if(i!=f.length-1)sb.append(",");
			else sb.append(");");
//			Annotation a[]=f1.getDeclaredAnnotations();
//			for(Annotation a1:a) {
//				System.out.println(a1.toString());	
//				if(a1.toString().equals(PrimaryKey.class.toString())){
//					System.out.printf("%s is a primary key", f1.getName());
//				}
//				
//			}
		}
		System.out.println(sb.toString());
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/queries","root","Npmg2022!");
			Statement s=con.createStatement();
			if(s.execute(sb.toString())) {
				System.out.printf("table %s created.", c.getSimpleName());
			}else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
