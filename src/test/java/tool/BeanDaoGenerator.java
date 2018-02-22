package tool;

import org.junit.Test;

import com.own.generator.MybatisBeanDaoGenerator;

/**
 * mybatis bean，dao生成工具类
 *
 */
public class BeanDaoGenerator {
    @Test
    public void generator() {
        try {
            MybatisBeanDaoGenerator.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
