package my.blog.content.model;

import lombok.Getter;
import lombok.Setter;
import my.blog.content.common.entity.BaseEntity;
import my.blog.content.resources.entity.dict.Male;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel extends BaseEntity {

    @NotNull
    @Size(max = 50, message = "昵称长度不能超过50")
    @Getter
    @Setter
    private String name;//昵称

    @Getter
    @Setter
    private Male male;

    @NotNull
    @Email
    @Getter
    @Setter
    private String email;//唯一

    @NotNull
    @Size(max = 20, message = "账号长度不能超过20")
    @Getter
    @Setter
    private String loginName;//账号（字母+数字）唯一

    @Getter
    @Setter
    private UserStatus status = UserStatus.NORMAL;

    @Getter
    @Setter
    private RoleModel role;

    public enum UserStatus {
        NORMAL("正常") {
        },
        INVALID("禁用") {
        };

        private String value;

        private UserStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }
}
