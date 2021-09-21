/**
 * @program: swagger-demo
 * @ClassName: User
 * @description:
 * @author: zty
 * @create: 2021-07-23 15:20
 **/
package com.zty.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Api("注释")
@ApiModel("用户实体类")
@Data
public class User {
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;

}
