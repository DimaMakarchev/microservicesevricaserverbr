package com.ribbon.ribbon;

import com.ribbon.ribbon.dto.Adres;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

@SpringBootTest
class RibbonApplicationServerTests {

    @Test
    void contextLoads() {
        Adres adres = new Adres();
        adres.setNameadress("Moscow");
        Adres adres2 = new Adres();
        adres2.setNameadress("Now-York");

        Assert.assertEquals(adres, adres2);
        Assert.assertNotNull(adres);
    }

    @Test
    void contextLoadsTwo() {
        Adres adres = new Adres();
        adres.setNameadress("Moscow");
        Adres adres2 = new Adres();
        adres2.setNameadress("Now-York");

        Assert.assertNotNull(adres);
    }
}
