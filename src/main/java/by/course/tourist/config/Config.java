package by.course.tourist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@ComponentScan("by.course.tourist")
@PropertySource("classpath:db.properties")
@EnableWebMvc
@EnableAspectJAutoProxy
public class Config {
  @Value("${driver}")
  private String driver;

  @Value("${url}")
  private String url;

  @Value("${user_name}")
  private String user;

  @Value("${password}")
  private String pass;

  @Bean
  public JdbcTemplate getJdbcTemplate() {
    return new JdbcTemplate(getDataSource());
  }

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(user);
    dataSource.setPassword(pass);
    return dataSource;
  }
}
