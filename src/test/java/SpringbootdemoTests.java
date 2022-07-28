
import com.software.institute.kathb.springbootdemo.actor.Actor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpringbootdemoTests {

    @Test
    public void test_getActorId()
    {
        Actor actor = new Actor("John", "Smith");
        actor.setActorId(1);
        assertEquals(1, actor.getActorId(), "Cannot get actor id");
    }

    @Test
    public void test_getActorFirstName()
    {
        Actor actor = new Actor("John", "Smith");
        assertEquals("John", actor.getFirstName(), "Cannot get actor first name");
    }

    @Test
    public void test_setActorFirstName()
    {
        Actor actor = new Actor("John", "Smith");
        actor.setFirstName("Jim");
        assertEquals("Jim", actor.getFirstName(), "Set actor first name didn't work as expected");
    }

    @Test
    public void test_getActorLastName()
    {
        Actor actor = new Actor("John", "Smith");
        assertEquals("Smith", actor.getLastName(), "Cannot get actor last name");
    }

    @Test
    public void test_setActorLastName()
    {
        Actor actor = new Actor("John", "Smith");
        actor.setLastName("Smythe");
        assertEquals("Smythe", actor.getLastName(), "Set actor last name didn't work as expected");
    }

}
