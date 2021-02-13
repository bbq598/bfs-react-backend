package com.bfs.employee_server.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateProperty {

    @Value("jdbc:mysql://team-proj-2-mysql.czznqc9erwsv.us-east-2.rds.amazonaws.com:3306/db?serverTimezone=UTC")
    private String url;

    @Value("com.mysql.cj.jdbc.Driver")
    private String driver;

    @Value("dev")
    private String username;

    @Value("dev123")
    private String password;

    @Value("org.hibernate.dialect.MySQLDialect")
    private String dialect;

    @Value("true")
    private String showsql;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
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

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getShowsql() {
        return showsql;
    }

    public void setShowsql(String showsql) {
        this.showsql = showsql;
    }
}