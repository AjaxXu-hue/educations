package mapper.course;

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
@MapperScan(value = "mapper.course" , sqlSessionFactoryRef = "sqlSessionFactoryBean3")
public class ConfigMybatisThree {

    @Autowired
    @Qualifier("dataCourse")
    DataSource dataCourse;

    @Bean
    SqlSessionFactory sqlSessionFactoryBean3() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataCourse);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate3() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryBean3());
    }
}
