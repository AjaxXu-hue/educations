package mapper.system;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(value = "mapper.system" , sqlSessionFactoryRef = "sqlSessionFactoryBean1")
public class ConfigMybatisOne {

    @Autowired
    @Qualifier("dataSystem")
    DataSource dataSystem;

    @Bean
    SqlSessionFactory sqlSessionFactoryBean1() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSystem);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean1());
    }
}
