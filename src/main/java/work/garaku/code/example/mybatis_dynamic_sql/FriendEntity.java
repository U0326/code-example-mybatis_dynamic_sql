package work.garaku.code.example.mybatis_dynamic_sql;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class FriendEntity {
  private int id;
  private String name;
}
