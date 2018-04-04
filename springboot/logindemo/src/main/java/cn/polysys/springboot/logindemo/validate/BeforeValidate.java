package cn.polysys.springboot.logindemo.validate;

import java.lang.annotation.*;

/**
 * @author hujie
 * @date 2018/04/04
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.METHOD})
public @interface BeforeValidate {
    /**
     * 校验使用的实际校验类
     *
     * @return
     */
    Class<? extends Validator>[] value();
}