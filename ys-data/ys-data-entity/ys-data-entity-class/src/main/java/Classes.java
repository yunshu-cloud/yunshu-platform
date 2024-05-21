import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Classes {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String className;
    private Integer classNum;
}
