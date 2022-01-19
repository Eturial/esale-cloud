package com.eturial.esale.common.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.eturial.esale.common.annotation.Cid;
import com.eturial.esale.common.annotation.IsMobile;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("users")
public class SystemUser implements Serializable {

    private static final long serialVersionUID = -4352868070794165001L;

    // 用户状态：有效
    public static final String STATUS_VALID = "1";
    // 用户状态：锁定
    public static final String STATUS_LOCK = "0";
    // 默认头像
    public static final String DEFAULT_AVATAR = "default.jpg";
    // 默认密码
    public static final String DEFAULT_PASSWORD = "1234qwer";
    // 性别男
    public static final String SEX_MALE = "0";
    // 性别女
    public static final String SEX_FEMALE = "1";
    // 性别保密
    public static final String SEX_UNKNOW = "2";

    /**
     * 用户 ID
     */
    @TableId(value = "USER_ID", type = IdType.AUTO)
    private String userId;

    /**
     * 用户名
     */
    @TableField("USERNAME")
    @Size(min = 4, max = 10, message = "{range}")
    private String username;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 身份证号
     */
    @TableField("ID_NUM")
//    @Cid
    private String idNum;

    /**
     * 姓名
     */
    @TableField("REAL_NAME")
    @Size(min = 4, max = 10, message = "{range}")
    private String realName;

    /**
     * 邮箱
     */
    @TableField("USER_EMAIL")
    @Size(max = 50, message = "{noMoreThan}")
    @Email(message = "{email}")
    private String userEmail;

    /**
     * 地址
     */
    @TableField("USER_ADDRESS")
    private String userAddress;

    /**
     * 联系电话
     */
    @TableField("USER_PHONE")
    @IsMobile(message = "{mobile}")
    private String userPhone;

    /**
     * 状态 0锁定 1有效
     */
    @TableField("STATUS")
    @NotBlank(message = "{required}")
    private String status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 性别 0男 1女 2 保密
     */
    @TableField("SSEX")
    @NotBlank(message = "{required}")
    private String sex;

    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 描述
     */
    @TableField("DESCRIPTION")
    @Size(max = 100, message = "{noMoreThan}")
    private String description;

    /**
     * 角色 ID
     */
    @TableField(exist = false)
    private String roleId;

    @TableField(exist = false)
    private String roleName;

}
