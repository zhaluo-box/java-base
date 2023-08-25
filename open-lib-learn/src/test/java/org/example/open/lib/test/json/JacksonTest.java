package org.example.open.lib.test.json;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.entity.Course;
import org.example.common.entity.Student;
import org.example.open.lib.learn.util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created  on 2023/7/13 15:15:56
 * <a href="https://www.baeldung.com/jackson-object-mapper-tutorial"> 官方案例</a>
 *
 * @author zl
 */
public class JacksonTest {

    private Student student = null;

    private List<Course> courses = null;

    @BeforeEach
    public void beforeEach() {
        // 准备数据
        var course1 = new Course().setName("语文").setTeacherName("张三");
        var course2 = new Course().setName("数学").setTeacherName("王五");
        var course3 = new Course().setName("英语").setTeacherName("李四");

        courses = List.of(course1, course2, course3);

        student = new Student().setName("小明").setAddress("北京").setAge(12).setCourseList(courses);
    }

    @Test
    @DisplayName("测试嵌套对象序列化  ")
    public void testNestObjSerializer() {

        // 准备objectMapper对象
        var objectMapper = new ObjectMapper();

        // json
        var json = "";
        try {
            json = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("json = " + json);

        var deserializeObj = JsonUtil.toObject(json, Student.class);
        System.out.println("这是一个干净的没有添加额外类描述信息的JSON");
        System.out.println("deserializeObj = " + deserializeObj);

        System.out.println("添加类描述信息!");

    }

    @Test
    @DisplayName("json 写入文件测试")
    public void writeValueTest() throws IOException {
        var mapper = new ObjectMapper();
        mapper.writeValue(new File("target/student.json"), student);
    }

    @Test
    @DisplayName("json 写入字符串测试")
    public void writeValueAsStringTest() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(student);
        System.out.println("json = " + json);
    }

    @Test
    @DisplayName("从文件读取JSON")
    public void readValueFromFileTest() throws IOException {
        var mapper = new ObjectMapper();
        var ds = mapper.readValue(new File("target/student.json"), Student.class);
        System.out.println("ds = " + ds);

        var ds2 = mapper.readValue(new URL("file:D:\\workspace\\personal\\java-base\\open-lib-learn\\target\\student.json"), Student.class);
        System.out.println("ds2 = " + ds2);
    }

    @Test
    @DisplayName("返回一个集合对象测试，泛型")
    public void arrayObjTest() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        var strJson = mapper.writeValueAsString(courses);

        var courseList = mapper.readValue(strJson, new TypeReference<List<Course>>() {
        });
        System.out.println("courseList = " + courseList);
    }

    @Test
    @DisplayName("返回一个集合对象测试，泛型")
    public void mapObjTest() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        var stringObjectMap = new HashMap<String, Object>();
        stringObjectMap.put("1", student);
        stringObjectMap.put("2", courses);
        stringObjectMap.put("3", Long.parseLong("1000"));

        var strJson = mapper.writeValueAsString(stringObjectMap);

        var mapObj = mapper.readValue(strJson, new TypeReference<Map<String, Object>>() {
        });
        System.out.println("mapObj = " + mapObj);

    }

    // ======================== Jackson Advanced Feature ====================================

    @Test
    @DisplayName("jackson 高级配置 : 配置忽略新字段")
    public void mapperSettingTest() {

        String jsonString = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";

        var mapper = new ObjectMapper();
        Car car = null;
        try {
            car = mapper.readValue(jsonString, Car.class);
            System.out.println("car = " + car);
        } catch (JsonProcessingException e) {
            System.err.println("Json 解析失败， 多的字段无法解析" + e.getMessage());
        }

        // 配置遇到未知属性，不失败
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // 配置允许为null
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

        //同样，FAIL_ON_NUMBERS_FOR_ENUM 控制是否允许将枚举值序列化/反序列化为数字
        mapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, false);
        try {
            car = mapper.readValue(jsonString, Car.class);
            System.out.println("car = " + car);
        } catch (JsonProcessingException e) {
            System.err.println("Json 解析失败 : " + e.getMessage());
        }

        JsonNode jsonNodeRoot = null;
        try {
            jsonNodeRoot = mapper.readTree(jsonString);
            JsonNode jsonNodeYear = jsonNodeRoot.get("year");
            String year = jsonNodeYear.asText();
            System.out.println("year = " + year);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    @DisplayName("自定义序列化测试")
    public void customSerialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomCarSerializer", new Version(1, 0, 0, null, null, null));
        module.addSerializer(Car.class, new CustomCarSerializer());
        mapper.registerModule(module);
        Car car = new Car("yellow", "renault");
        String carJson = mapper.writeValueAsString(car);
        System.out.println("carJson = " + carJson);
    }

    @Test
    @DisplayName("自定义反序列化")
    public void customDeserialize() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Car.class, new CustomCarDeserializer());
        mapper.registerModule(module);
        Car car = mapper.readValue(json, Car.class);
        System.out.println("car = " + car);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Car {

        private String color;

        private String type;
    }

    @Test
    @DisplayName("json 反序列化为 Object.class 对象")
    public void testJsonToObj() {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";

        var object = JsonUtil.toObject(json, Object.class);
        System.out.println(object);
    }

    /**
     * 自定义序列化
     */
    public class CustomCarSerializer extends StdSerializer<Car> {

        public CustomCarSerializer() {
            this(null);
        }

        public CustomCarSerializer(Class<Car> t) {
            super(t);
        }

        @Override
        public void serialize(Car car, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
            try {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeStringField("car_brand", car.getType());
                jsonGenerator.writeEndObject();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }

    /**
     * 自定义反序列化
     */
    public class CustomCarDeserializer extends StdDeserializer<Car> {

        public CustomCarDeserializer() {
            this(null);
        }

        public CustomCarDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Car deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException {
            Car car = new Car();
            ObjectCodec codec = parser.getCodec();
            JsonNode node = codec.readTree(parser);

            // try catch block
            JsonNode colorNode = node.get("color");
            String color = colorNode.asText();
            car.setColor(color);
            return car;
        }
    }
}
