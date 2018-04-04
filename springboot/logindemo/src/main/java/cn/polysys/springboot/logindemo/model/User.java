package cn.polysys.springboot.logindemo.model;


import java.io.Serializable;

/**
 * @author hujie
 * @date 2018/03/29
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8306152498273074368L;

    /**
     * 用户ID，主键，自增列
     */
    private Integer id;

    /**
     * 用户名，登陆使用
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
