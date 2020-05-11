package mapper.user;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "mapper.user" , sqlSessionFactoryRef = "sqlSessionFactoryBean2")
public class MybatisConfigTwo {

    @Autowired
    @Qualifier("dataUser")
    DataSource dataUser;

    @Bean
    SqlSessionFactory sqlSessionFactoryBean2() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataUser);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate2() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean2());
    }
}
