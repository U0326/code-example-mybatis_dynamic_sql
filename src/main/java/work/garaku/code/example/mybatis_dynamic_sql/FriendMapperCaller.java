package work.garaku.code.example.mybatis_dynamic_sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static work.garaku.code.example.mybatis_dynamic_sql.FriendDynamicSqlSupport.id;
import static work.garaku.code.example.mybatis_dynamic_sql.FriendDynamicSqlSupport.name;

@Component
public class FriendMapperCaller {
  @Autowired
  private FriendMapper friendMapper;

  public void execute() {
    System.out.println(friendMapper.selectOne(c -> c.where(id, isEqualTo(1))));
    // Create
    FriendEntity newFriend = FriendEntity.builder().name("Jon").build();
    friendMapper.insert(newFriend);
    System.out.println(friendMapper.selectOne(c -> c.where(id, isEqualTo(1))));

    // Update
    friendMapper.update(c -> c.set(name).equalTo("Bob").where(id, isEqualTo(1)));
    System.out.println(friendMapper.selectOne(c -> c.where(id, isEqualTo(1))));

    // Delete
    friendMapper.delete(c -> c.where(id, isEqualTo(1)));
    System.out.println(friendMapper.selectOne(c -> c.where(id, isEqualTo(1))));
  }
}
