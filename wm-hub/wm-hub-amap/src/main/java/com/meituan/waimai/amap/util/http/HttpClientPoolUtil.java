package com.meituan.waimai.amap.util.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

@SuppressWarnings("all")
@Slf4j
public class HttpClientPoolUtil {
    private static final String ENCODING = "UTF-8";
    public static final int DEFAULT_CONNECT_TIMEOUT = 60000;
    public static final int DEFAULT_READ_TIMEOUT = 60000;
    public static final int DEFAULT_CONNECT_REQUEST_TIMEOUT = 60000;
    private static final int MAX_TOTAL = 64;
    private static final int MAX_PER_ROUTE = 32;
    private static final RequestConfig requestConfig;
    private static final PoolingHttpClientConnectionManager connectionManager;
    private static final HttpClientBuilder httpBuilder;
    private static final CloseableHttpClient httpClient;
    private static final CloseableHttpClient httpsClient;
    private static SSLContext sslContext;

    static {
        try {
            sslContext = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            sslContext.init(null, new TrustManager[]{tm}, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        requestConfig = RequestConfig.custom().setSocketTimeout(DEFAULT_READ_TIMEOUT).setConnectTimeout(DEFAULT_CONNECT_TIMEOUT).setConnectionRequestTimeout(DEFAULT_CONNECT_REQUEST_TIMEOUT).build();
        @SuppressWarnings("deprecation")
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", new PlainConnectionSocketFactory())
                .register("https", new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER))
                .build();
        connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connectionManager.setMaxTotal(MAX_TOTAL);
        connectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        httpBuilder = HttpClientBuilder.create();
        httpBuilder.setDefaultRequestConfig(requestConfig);
        httpBuilder.setConnectionManager(connectionManager);
        httpClient = httpBuilder.build();
        httpsClient = httpBuilder.build();
    }

    /**
     * GET
     *
     * @param url
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doGet(String url)
            throws Exception {
        return doGet(url, false);
    }

    /**
     * GET
     *
     * @param url
     * @param https
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doGet(String url, boolean https)
            throws Exception {
        return doGet(url, null, null, https);
    }

    /**
     * GET
     *
     * @param url
     * @param params
     * @param https
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doGet(String url, Map<String, String> params, boolean https)
            throws Exception {
        return doGet(url, null, params, https);
    }

    /**
     * GET
     *
     * @param url
     * @param headers
     * @param params
     * @param https
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doGet(String url, Map<String, String> headers, Map<String, String> params, boolean https)
            throws Exception {
        // ?????????????????????
        URIBuilder uriBuilder = new URIBuilder(url);
        if (params != null) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                uriBuilder.setParameter(entry.getKey(), entry.getValue());
            }
        }
        // ??????HTTP??????
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setConfig(requestConfig);
        // ???????????????
        setHeader(headers, httpGet);
        // ??????httpResponse??????
        CloseableHttpResponse httpResponse = null;
        try {
            if (https) {
                return getHttpClientResult(httpResponse, httpsClient, httpGet);
            } else {
                return getHttpClientResult(httpResponse, httpClient, httpGet);
            }
        } finally {
            httpGet.releaseConnection();
            release(httpResponse);
        }
    }

    /**
     * POST????????????
     *
     * @param url
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doPost(String url)
            throws Exception {
        return doPost(url, Boolean.FALSE);
    }

    /**
     * @param url
     * @param https
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doPost(String url, boolean https)
            throws Exception {
        return doPost(url, null, (Map<String, String>) null, https);
    }

    /**
     * ???????????????
     *
     * @param url
     * @param params
     * @param https
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doPost(String url, Map<String, String> params, boolean https)
            throws Exception {
        return doPost(url, null, params, https);
    }

    /**
     * POST
     *
     * @param url
     * @param headers
     * @param params
     * @param https
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doPost(String url, Map<String, String> headers, Map<String, String> params, boolean https)
            throws Exception {
        // ??????HTTP??????
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        // ???????????????
        setHeader(headers, httpPost);
        // ??????????????????
        setParam(params, httpPost);
        // ??????httpResponse??????
        CloseableHttpResponse httpResponse = null;
        try {
            if (https) {
                return getHttpClientResult(httpResponse, httpsClient, httpPost);
            } else {
                return getHttpClientResult(httpResponse, httpClient, httpPost);
            }
        } finally {
            httpPost.releaseConnection();
            release(httpResponse);
        }
    }

    /**
     * POST??????JSON
     *
     * @param url
     * @param headers
     * @param json
     * @param https
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doPost(String url, Map<String, String> headers, String json, boolean https)
            throws Exception {
        // ??????HTTP??????
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        // ???????????????
        setHeader(headers, httpPost);
        StringEntity stringEntity = new StringEntity(json, ENCODING);
        stringEntity.setContentEncoding(ENCODING);
        httpPost.setEntity(stringEntity);
        // ??????httpResponse??????
        CloseableHttpResponse httpResponse = null;
        try {
            if (https) {
                return getHttpClientResult(httpResponse, httpsClient, httpPost);
            } else {
                return getHttpClientResult(httpResponse, httpClient, httpPost);
            }
        } finally {
            httpPost.releaseConnection();
            release(httpResponse);
        }
    }


    /**
     * ??????put???????????????????????????
     *
     * @param url ????????????
     * @return
     * @throws Exception
     */
    public static HttpClientResult doPut(String url)
            throws Exception {
        return doPut(url);
    }

    /**
     * ??????put????????????????????????
     *
     * @param url    ????????????
     * @param params ????????????
     * @return
     * @throws Exception
     */
    public static HttpClientResult doPut(String url, Map<String, String> params)
            throws Exception {
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut(url);
        // RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpPut.setConfig(requestConfig);
        setParam(params, httpPut);
        CloseableHttpResponse httpResponse = null;
        try {
            return getHttpClientResult(httpResponse, httpClient, httpPut);
        } finally {
            httpPut.releaseConnection();
            release(httpResponse);
        }
    }

    /**
     * ??????????????????
     *
     * @param url
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doDelete(String url)
            throws Exception {
        // CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete(url);
        // RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT).setSocketTimeout(SOCKET_TIMEOUT).build();
        httpDelete.setConfig(requestConfig);
        CloseableHttpResponse httpResponse = null;
        try {
            return getHttpClientResult(httpResponse, httpClient, httpDelete);
        } finally {
            httpDelete.releaseConnection();
            release(httpResponse);
        }
    }

    /**
     * ???????????????
     *
     * @param url
     * @param params
     * @param https
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult doDelete(String url, Map<String, String> params, boolean https)
            throws Exception {
        if (params == null) {
            params = new HashMap<String, String>();
        }
        params.put("_method", "delete");
        return doPost(url, params, https);
    }

    /**
     * ?????????????????????
     *
     * @param params
     * @param httpMethod
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static void setHeader(Map<String, String> params, HttpRequestBase httpMethod) {
        // ???????????????
        if (null != params && params.size() > 0) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                // ?????????????????????HttpRequestBase?????????
                httpMethod.setHeader(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * ??????????????????
     *
     * @param params
     * @param httpMethod
     * @throws UnsupportedEncodingException
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static void setParam(Map<String, String> params, HttpEntityEnclosingRequestBase httpMethod)
            throws UnsupportedEncodingException {
        // ??????????????????
        if (null != params && params.size() > 0) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            // ??????????????????http?????????
            httpMethod.setEntity(new UrlEncodedFormEntity(nvps, ENCODING));
        }
    }

    /**
     * ??????????????????
     *
     * @param httpResponse
     * @param httpClient
     * @param httpMethod
     * @return
     * @throws Exception
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static HttpClientResult getHttpClientResult(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient, HttpRequestBase httpMethod)
            throws Exception {
        // ????????????
        long start = System.currentTimeMillis();
        try {
            httpResponse = httpClient.execute(httpMethod);
        } catch (Exception e) {
            log.error("[HttpClientPoolUtil getHttpClientResult]??????: {}, error: {}", System.currentTimeMillis() - start, e.getLocalizedMessage());
            e.printStackTrace();
        }
        log.info("[HttpClientPoolUtil getHttpClientResult]??????: {}", System.currentTimeMillis() - start);
        // ??????????????????
        if (httpResponse != null && httpResponse.getStatusLine() != null) {
            String content = "";
            if (httpResponse.getEntity() != null) {
                content = EntityUtils.toString(httpResponse.getEntity(), ENCODING);
            }
            log.info("[HttpClientPoolUtil getHttpClientResult][content: {}]", content);
            return new HttpClientResult(httpResponse.getStatusLine().getStatusCode(), content);
        }
        return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    /**
     * ????????????
     *
     * @param httpResponse
     * @throws IOException
     * @author Henry(fba02)
     * @version [?????????, 2019???12???8???]
     * @see [?????????#????????????#??????]
     */
    public static void release(CloseableHttpResponse httpResponse)
            throws IOException {
        // ????????????
        if (httpResponse != null) {
            httpResponse.close();
        }
    }
}

