package org.lwapp.psd2;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.apache.openejb.OpenEjbContainer;
import org.apache.openejb.core.LocalInitialContextFactory;
import org.joda.time.DateTimeUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public abstract class BasicTest {

    private static AtomicLong counter = new AtomicLong();

    private static EJBContainer ejbContainer;
    private static Context context;
    //    @PersistenceContext
    //    protected EntityManager entityManager;
    //    @Resource
    //    private UserTransaction userTransaction;

    @BeforeClass
    public static void beforeClass() throws Exception {
        final Properties properties = new Properties();
        //        properties.load(BasicTest.class.getClassLoader().getResourceAsStream("junit.persistence.properties"));
        setOpenEjbProperties(properties);
        properties.setProperty(OpenEjbContainer.OPENEJB_EMBEDDED_REMOTABLE, "true");
        ejbContainer = EJBContainer.createEJBContainer(properties);
        context = ejbContainer.getContext();
    }

    private static void setOpenEjbProperties(final Properties properties) {
        properties.setProperty(EJBContainer.APP_NAME, "oogla");
        properties.setProperty(EJBContainer.PROVIDER, OpenEjbContainer.class.getName());
        properties.put(Context.INITIAL_CONTEXT_FACTORY, LocalInitialContextFactory.class.getName());
        properties.setProperty("cxf.jaxrs.providers", JacksonJsonProvider.class.getName());

    }

    @AfterClass
    public static void afterClass() throws Exception {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

    @After
    public void after() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
    }

    @Before
    public void before() throws Exception {
        context.bind("inject", this);
        DateTimeUtils.setCurrentMillisFixed(1357119945939L);
    }

    public static String generateRandomUniqueString() {
        return String.valueOf(System.nanoTime() + counter.incrementAndGet());
    }

    public static long generateRandomUniqueNumber() {
        return System.nanoTime() + counter.incrementAndGet();
    }

    public static int generateRandomUniqueInteger() {
        return Long.valueOf(System.nanoTime() + counter.incrementAndGet()).intValue();
    }

    public static <T> T unmarshal(final String jsonData, final Class<T> clazz) throws Exception {
        final ObjectMapper objM = new ObjectMapper().setSerializationInclusion(Include.NON_NULL);
        return objM.readValue(jsonData, clazz);
    }

    public static <T> String marshal(final T object) throws Exception {
        final ObjectMapper objM = new ObjectMapper().setSerializationInclusion(Include.NON_NULL).enable(SerializationFeature.INDENT_OUTPUT);
        return objM.writeValueAsString(object);
    }

}