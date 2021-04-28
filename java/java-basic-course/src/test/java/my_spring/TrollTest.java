package my_spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrollTest {
    @Test
    public void testInjectRandomIntIsWorking() {
        Troll troll = ObjectFactory.getInstance().createObject(Troll.class);
        Assert.assertTrue(troll.getPower() < 19);
        Assert.assertTrue(troll.getPower() > 11);
    }

}