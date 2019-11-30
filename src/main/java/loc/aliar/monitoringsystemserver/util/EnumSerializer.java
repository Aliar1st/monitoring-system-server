package loc.aliar.monitoringsystemserver.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class EnumSerializer<E extends Enum<E>> extends JsonSerializer<E> {
    @Override
    @SneakyThrows
    public void serialize(E value, JsonGenerator gen, SerializerProvider serializers) {
        gen.writeStartObject();
        gen.writeFieldName("name");
        gen.writeString(value.name());

        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(value.getClass());
        for (PropertyDescriptor desc : propertyDescriptors) {
            if (desc.getName().equals("class") || desc.getName().equals("declaringClass")
                    || hasFieldAnnotation(value, desc.getName(), JsonIgnore.class)) {
                continue;
            }

            Method readMethod = desc.getReadMethod();
            Object getValue = readMethod.invoke(value);

            gen.writeFieldName(desc.getName());
            gen.writeString(getValue.toString());
        }

        gen.writeEndObject();
    }

    @SneakyThrows
    private boolean hasFieldAnnotation(E value, String fieldName, Class<? extends Annotation> annotationClass) {
        Field field = value.getDeclaringClass().getDeclaredField(fieldName);
        JsonIgnore jsonIgnore = field.getAnnotation(JsonIgnore.class);
        return jsonIgnore != null;
    }
}
