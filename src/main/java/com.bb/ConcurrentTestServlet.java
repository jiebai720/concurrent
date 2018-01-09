package com.bb;


import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;


public class ConcurrentTestServlet  extends HttpServlet {

    PoolingHttpClientConnectionManager  poolingHttpClientConnectionManager ;

//    static CloseableHttpClient httpclient ;
//
//    static{
//        httpclient =  HttpClients.createDefault();
//    }


    CloseableHttpClient httpclient ;

    @Override
    public void init() throws ServletException {
        super.init();

        poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(100);

//        httpclient = HttpClients.custom()
//                .setConnectionManager(poolingHttpClientConnectionManager)
//                .build();

    }

    private static final String url = "http://localhost:8085/b/hello?username=" ;
    AtomicInteger id = new AtomicInteger(1) ;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        System.out.println(  " - id -- " + id  );
        String goUrl = url + id ;
        HttpGet httpget = new HttpGet( goUrl );

        httpclient =  HttpClients.createDefault();
        CloseableHttpResponse closeableHttpResponse = null ;
        try {
            closeableHttpResponse = httpclient.execute(httpget);
            id.getAndIncrement();

            HttpEntity entity = closeableHttpResponse.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                System.out.println( goUrl + " - result -- " + result  );
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeableHttpResponse.close();
        }

    }



}


