package org.youngstone.practice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.containsString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void whenSerializingUsingJsonAnyGetter_thenCorrect() throws JsonProcessingException {

        ExtendableBean bean = new ExtendableBean("My Bean");

        bean.add("attr1","val1");
        bean.add("attr2","val2");

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(bean);

        System.out.println(result);
        assertThat(result,containsString("attr1"));
        assertThat(result,containsString("val1"));


    }


    @Test
    public void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {

        MyBean bean = new MyBean(1, "My Bean");

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(bean);

        System.out.println(result);
        assertThat(result,containsString("My Bean"));
        assertThat(result,containsString("1"));


    }


    @Test
    public void whenSerializingUsingRawBean_thenCorrect() throws JsonProcessingException {


        RawBean bean = new RawBean("My bean", "{\"attr\":false}");
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(bean);

        System.out.println(result);
        assertThat(result,containsString("My Bean"));
        assertThat(result,containsString("{\"attr\":false}"));


    }


    @Test
    public void whenSerializingUsingJsonValue_thenCorrect() throws JsonProcessingException {


        ObjectMapper mapper = new ObjectMapper();
        String enumAsString = mapper.writeValueAsString(EnumBean.TypeEnumWithValue.TYPE1);



        System.out.println(enumAsString);
        assertThat(enumAsString,is("\"Type A\""));


    }


    @Test
    public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException {


        UserWithRoot user = new UserWithRoot(1,"John");
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        String result = mapper.writeValueAsString(user);


        System.out.println(result);
        assertThat(result,CoreMatchers.containsString("John"));
        assertThat(result,CoreMatchers.containsString("1"));

    }

    @Test
    public void whenSerializingUsingJsonSerialize_thenCorrect() throws JsonProcessingException, ParseException {

        SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        Event event = new Event("party",date);
        String result = new ObjectMapper().writeValueAsString(event);

        System.out.println(result);
        assertThat(result, CoreMatchers.containsString(toParse));
    }


    @Test
    public void whenSerializingUsingJsonCreator_thenCorrect() throws IOException, ParseException {

        String json = "{\"id\":1,\"theName\":\"My Bean\"}";
        ObjectMapper mapper = new ObjectMapper();

        BeanWithCreator a = mapper.readValue(json, BeanWithCreator.class);

        assertEquals("My Bean",a.name);

        System.out.println(a);
    }
}
