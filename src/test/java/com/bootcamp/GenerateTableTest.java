package com.bootcamp;

import org.testng.annotations.Test;
import javax.persistence.*;
import java.util.Properties;

/**
 * Created by darextossa on 9/22/17.
 */
public class GenerateTableTest {

    @Test
    public void generateTablesDerby() {
        Persistence.generateSchema("com.bootcamp_TpJPA", new Properties());
    }

    @Test
    public void generateTablesMysql() {
        Persistence.generateSchema("tpJpa", new Properties());
    }
}
