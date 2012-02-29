package resource;

import java.sql.*;

public class test {

	  public static void main(String[] args) {
		    try {
		      /* ドライバクラスをロードする */
		      Class.forName("com.mysql.jdbc.Driver");

		      /*
		       * データベースに接続する
		       * この場合は
		       *   ホスト名      :localhost
		       *   データベース名:test
		       *   ユーザ名      :user
		       *   パスワード    :password
		       * とする.
		       */
		      String url = "jdbc:mysql://localhost:3306/resource";
		      String user="root";
		      String pass ="user00";
		      Connection con = DriverManager.getConnection(url,user,pass);

		      // ステートメントオブジェクトを生成
		      Statement stmt = con.createStatement();
		      String sql = "SELECT * FROM it_resource";

		      // クエリーを実行して結果セットを取得
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){ //よくあるIteratorのnext()と同様
		        /*
		         * getXxxx()メソッドは引数に指定したデータベースのフィールドを
		         * JavaのXxxx型として取り出します
		         */
		        int id = rs.getInt("id");
		        String name = rs.getString("name");
		        System.out.println("id=" + id + ";name=" + name);
		      }
		      // 切断
		      stmt.close();

		      /* データベース切断 */
		      con.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
		}
