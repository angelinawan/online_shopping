
package onlineShop;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class ApplicationConfig {

    @Bean(name = "sessionFactory")
    // match Java class with database
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("onlineShop.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        // Type in your RDS ip between "mysql://" and ":3306"
        dataSource.setUrl("jdbc:mysql://laiproject-instance.cetaaebeavn5.us-east-2.rds.amazonaws.com:3306/ecommerce?createDatabaseIfNotExist=true&serverTimezone=UTC");
        // Type in your username
        dataSource.setUsername("admin");
        // Type in your password
        dataSource.setPassword("wjp19930622");

        return dataSource;
    }


    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop"); // use "update" if want to save the table when restart the server
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return hibernateProperties;
    }
}
