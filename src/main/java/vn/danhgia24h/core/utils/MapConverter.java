package vn.danhgia24h.core.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Converter(autoApply = true)
public class MapConverter implements AttributeConverter<Map<String,Object>,String>{
    private static final Logger log = LoggerFactory.getLogger(MapConverter.class);
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        try {
            return mapper.writeValueAsString(stringObjectMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        HashMap<String,Object> res = new HashMap<>();
        if(!StringUtils.isEmpty(s)) {
            try {
                TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
                };
                res = mapper.readValue(s,typeRef);
            } catch (IOException e) {
                log.error("Error converting attribute",e);
            }
        }
        return res;

    }
}
