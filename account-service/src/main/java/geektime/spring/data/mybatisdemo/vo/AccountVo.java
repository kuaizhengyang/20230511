package geektime.spring.data.mybatisdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class AccountVo {
    private String userId;
    private String name;
}
