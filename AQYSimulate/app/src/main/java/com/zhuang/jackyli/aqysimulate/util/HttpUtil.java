package com.zhuang.jackyli.aqysimulate.util;

import android.accounts.NetworkErrorException;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jackyli on 2017/8/1.
 * 请求与失败都是在主线程中
 */

public class HttpUtil {
    public static ExecutorService threadPool = Executors.newCachedThreadPool();
    public static Gson gson = new Gson();

    /**
     * GET方法，将数据解析为T
     *
     * @param context
     * @param address
     * @param listener
     */
    public static <T> void doGet(final Context context, final String address,
                                 final HttpCallbackModelListener listener, final Class<T> clazz) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                URL url;
                try {
                    url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    if (connection.getResponseCode() == 200) {
                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        reader.close();
                        in.close();
                        new ResponseCall(context, listener).doSuccess(gson.fromJson(response.toString(), clazz));
                    } else {
                        if (listener != null) {
                            new ResponseCall(context, listener).doFail(new NetworkErrorException("response err code" +
                                    connection.getResponseCode()));
                        }
                    }

                } catch (MalformedURLException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } catch (IOException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }

    /**
     * GET方法，将数据解析为String
     *
     * @param context
     * @param address
     * @param listener
     */
    public static void doGet(final Context context, final String address,
                             final HttpCallbackStringListener listener) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                URL url;
                try {
                    url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(8000);
                    if (connection.getResponseCode() == 200) {
                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                        StringBuffer response = new StringBuffer();
                        String line = "";
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        reader.close();
                        in.close();
                        new ResponseCall(context, listener).doSuccess(response.toString());


                    } else {
                        if (listener != null) {
                            new ResponseCall(context, listener).doFail(new NetworkErrorException("response err code" +
                                    connection.getResponseCode()));
                        }
                    }

                } catch (MalformedURLException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } catch (IOException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }

    /**
     * GET方法，将数据解析为byte[]数组
     *
     * @param context
     * @param address
     * @param listener
     */
    public static void doGet(final Context context, final String address,
                             final HttpCallbackBytesListener listener) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                URL url;
                try {
                    url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    if (connection.getResponseCode() == 200) {
                        InputStream in = connection.getInputStream();
                        BufferedInputStream bis = new BufferedInputStream(in);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] bytes = new byte[1024];
                        int len = -1;
                        while ((len = bis.read(bytes)) != -1) {
                            baos.write(bytes, 0, len);
                        }
                        new ResponseCall(context, listener).doSuccess(baos.toByteArray());
                        baos.close();
                        bis.close();
                        in.close();
                    } else {
                        if (listener != null) {
                            new ResponseCall(context, listener).doFail(new NetworkErrorException("response err code" +
                                    connection.getResponseCode()));
                        }
                    }

                } catch (MalformedURLException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } catch (IOException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }

    /**
     * Post方法，将数据解析为byte[]数组
     *
     * @param context
     * @param address
     * @param listener
     */
    public static void doPost(final Context context, final String address,
                              final HttpCallbackBytesListener listener, final Map<String, Object> params) {
        final StringBuffer out = new StringBuffer();
        //组织请求参数
        for (String key : params.keySet()) {
            if (out.length() != 0) {
                out.append("&");
            }
            out.append(key).append("=").append(params.get(key));
        }
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                URL url;
                try {
                    url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestProperty("accept", "*/*");
                    connection.setRequestProperty("connection", "Keep-Alive");
                    connection.setRequestProperty("Content-Length", String.valueOf(out.length()));

                    PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
                    printWriter.write(out.toString());//发送请求参数
                    //flush输出流的缓冲
                    printWriter.flush();
                    printWriter.close();
                    if (connection.getResponseCode() == 200) {
                        InputStream in = connection.getInputStream();
                        BufferedInputStream bis = new BufferedInputStream(in);
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] bytes = new byte[1024];
                        int len = -1;
                        while ((len = bis.read(bytes)) != -1) {
                            baos.write(bytes, 0, len);
                        }
                        new ResponseCall(context, listener).doSuccess(baos.toByteArray());
                        baos.close();
                        bis.close();
                        in.close();
                    } else {
                        if (listener != null) {
                            new ResponseCall(context, listener).doFail(new NetworkErrorException("response err code" +
                                    connection.getResponseCode()));
                        }
                    }

                } catch (MalformedURLException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } catch (IOException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }

    /**
     * Post方法，将数据解析为String
     *
     * @param context
     * @param address
     * @param listener
     */
    public static void doPost(final Context context, final String address,
                              final HttpCallbackStringListener listener, final Map<String, Object> params) {
        final StringBuffer out = new StringBuffer();
        //组织请求参数
        for (String key : params.keySet()) {
            if (out.length() != 0) {
                out.append("&");
            }
            out.append(key).append("=").append(params.get(key));
        }
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                URL url;
                try {
                    url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestProperty("accept", "*/*");
                    connection.setRequestProperty("connection", "Keep-Alive");
                    connection.setRequestProperty("Content-Length", String.valueOf(out.length()));

                    PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
                    printWriter.write(out.toString());//发送请求参数
                    //flush输出流的缓冲
                    printWriter.flush();
                    printWriter.close();
                    if (connection.getResponseCode() == 200) {
                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                        StringBuffer sb = new StringBuffer();
                        String line = "";
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                        new ResponseCall(context, listener).doSuccess(sb.toString());
                        reader.close();
                        in.close();
                    } else {
                        if (listener != null) {
                            new ResponseCall(context, listener).doFail(new NetworkErrorException("response err code" +
                                    connection.getResponseCode()));
                        }
                    }

                } catch (MalformedURLException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } catch (IOException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }

    /**
     * Post方法，将数据解析为T 对象
     *
     * @param context
     * @param address
     * @param listener
     */
    public static <T> void doPost(final Context context, final String address,
                                  final HttpCallbackModelListener listener, final Map<String, Object> params,
                                  final Class<T> clazz) {
        final StringBuffer out = new StringBuffer();
        //组织请求参数
        for (String key : params.keySet()) {
            if (out.length() != 0) {
                out.append("&");
            }
            out.append(key).append("=").append(params.get(key));
        }
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                URL url;
                try {
                    url = new URL(address);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    connection.setRequestProperty("accept", "*/*");
                    connection.setRequestProperty("connection", "Keep-Alive");
                    connection.setRequestProperty("Content-Length", String.valueOf(out.length()));

                    PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
                    printWriter.write(out.toString());//发送请求参数
                    //flush输出流的缓冲
                    printWriter.flush();
                    printWriter.close();
                    if (connection.getResponseCode() == 200) {
                        InputStream in = connection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                        StringBuffer sb = new StringBuffer();
                        String line = "";
                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                        }
                        new ResponseCall(context, listener).doSuccess(gson.fromJson(sb.toString(), clazz));
                        reader.close();
                        in.close();
                    } else {
                        if (listener != null) {
                            new ResponseCall(context, listener).doFail(new NetworkErrorException("response err code" +
                                    connection.getResponseCode()));
                        }
                    }

                } catch (MalformedURLException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } catch (IOException e) {
                    if (listener != null) {
                        new ResponseCall(context, listener).doFail(e);
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        });
    }
}
