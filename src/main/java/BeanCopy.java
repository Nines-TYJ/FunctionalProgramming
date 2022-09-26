import cn.hutool.core.bean.BeanUtil;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tanyujie
 * @classname BeanCopy
 * @description TODO
 * @date 2022/5/31 9:38
 * @since 1.0
 */
public class BeanCopy {

    public static void main(String[] args) {
//        UserDto userDto = UserDto.of("1").setName("zhangsan").setAge(20).setSex("0");
//        UserDto userDto = UserDto.builder().id("1").name("zhangsan").age(20).sex("1").build();
//        User user = new User();
//
//        BeanUtils.copyProperties(userDto, user);
//
//        System.out.println(user);
//
//        user = BeanUtil.copyProperties(userDto, User.class, "id");
//
//        System.out.println(user);

    }

}

@Data
@Builder
class UserDto {

    private String id;

    private String name;

    private Integer age;

    private String sex;

}

@Data
class User {

    private String id;

    private String name;

    private Integer age;

    private LocalDateTime createTime;

}
