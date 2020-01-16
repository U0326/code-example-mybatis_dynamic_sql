package work.garaku.code.example.mybatis_dynamic_sql;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Optional;

import static work.garaku.code.example.mybatis_dynamic_sql.FriendDynamicSqlSupport.*;

@Mapper
public interface FriendMapper {
  // Create
  @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
  int insert(InsertStatementProvider<FriendEntity> insertStatement);
  default int insert(FriendEntity entity) {
    return MyBatis3Utils.insert(this::insert, entity, friend, c -> c.map(name).toProperty("name"));
  }

  // Read
  @SelectProvider(type = SqlProviderAdapter.class, method = "select")
  @Results(
      {
        @Result(column = "id", jdbcType = JdbcType.INTEGER, property = "id", id = true),
        @Result(column = "name", jdbcType = JdbcType.VARCHAR, property = "name"),
      })
  Optional<FriendEntity> selectOne(SelectStatementProvider selectStatement);
  BasicColumn[] selectList = BasicColumn.columnList(id, name);
  default Optional<FriendEntity> selectOne(SelectDSLCompleter completer) {
    return MyBatis3Utils.selectOne(this::selectOne, selectList, friend, completer);
  }

  // Update
  @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
  int update(UpdateStatementProvider updateStatement);
  default int update(UpdateDSLCompleter completer) {
    return MyBatis3Utils.update(this::update, friend, completer);
  }

  // Delete
  @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
  int delete(DeleteStatementProvider deleteStatement);
  default int delete(DeleteDSLCompleter completer) {
    return MyBatis3Utils.deleteFrom(this::delete, friend, completer);
  }
}
