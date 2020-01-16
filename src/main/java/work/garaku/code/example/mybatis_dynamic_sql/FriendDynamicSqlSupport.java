package work.garaku.code.example.mybatis_dynamic_sql;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;

public class FriendDynamicSqlSupport {
  public static final Friend friend = new Friend();
  public static final SqlColumn<Integer> id = friend.id;
  public static final SqlColumn<String> name = friend.name;

  public static final class Friend extends SqlTable {
    public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);
    public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

    public Friend() {
      super("friends");
    }
  }
}
