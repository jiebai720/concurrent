package com.bb;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2018/1/9.
 */
public class JsonUtil {


    private static final ObjectMapper mapper = new ObjectMapper();

    public static ObjectMapper getJsonObjectMapper() {
        return mapper;
    }
    
    public static List parseJsonToList( String jsonString , Class clazz) throws IOException {

        TypeFactory typeFactory = getJsonObjectMapper().getTypeFactory();
        List resultList =  getJsonObjectMapper().readValue( jsonString , typeFactory.constructCollectionType(List.class, clazz ));

        return resultList ;
    }


    public static void main(String[] args) {

        String str = "[\n" +
                "  {\n" +
                "    \"activityName\": \"test1\",\n" +
                "    \"activityNum\": \"fqnull00001531\",\n" +
                "    \"actBeginTime\": \"20170826000000\",\n" +
                "    \"actEndTime\": \"20170830235959\",\n" +
                "    \"cardDenomination\": \"200M\",\n" +
                "    \"categoryNum\": \"CC000291\",\n" +
                "    \"categoryName\": \"流量券\",\n" +
                "    \"cardContent\": \"test1\",\n" +
                "    \"cardExplain\": \"test1\",\n" +
                "    \"actStatus\": 0\n" +
                "  },\n" +
                "  {\n" +
                "    \"activityName\": \"新人120M\",\n" +
                "    \"activityNum\": \"fqnull00001532\",\n" +
                "    \"actBeginTime\": \"20170921000000\",\n" +
                "    \"actEndTime\": \"20170921235959\",\n" +
                "    \"cardDenomination\": \"12200M\",\n" +
                "    \"categoryNum\": \"CC000291\",\n" +
                "    \"categoryName\": \"流量券\",\n" +
                "    \"cardContent\": \"test2\",\n" +
                "    \"cardExplain\": \"test2\",\n" +
                "    \"actStatus\": 0\n" +
                "  }\n" +
                "]";
        try {
            List list = JsonUtil.parseJsonToList( str ,  CardMarketInfoBean.class );
            System.out.println( list.size() );
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
