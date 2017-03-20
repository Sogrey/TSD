package org.sogrey.tsd.log;

/**
 * Created by Sogrey on 2015/7/20.
 */
public interface Printer {
    /**
     * Debug 输出
     * @param element tag,包含当前类名及所在行数
     * @param message 信息模板
     * @param args 信息模板里对应位置上的值
     */
    void d(StackTraceElement element, String message, Object... args);
    /**
     * Debug 输出
     * @param element tag,包含当前类名及所在行数
     * @param object 信息内容
     */
    void d(StackTraceElement element, Object object);

    /**
     * Error 输出
     * @param element tag,包含当前类名及所在行数
     * @param message 信息模板
     * @param args 信息模板里对应位置上的值
     */
    void e(StackTraceElement element, String message, Object... args);
    /**
     * Error 输出
     * @param element tag,包含当前类名及所在行数
     * @param object 信息内容
     */
    void e(StackTraceElement element, Object object);

    /**
     * Warning 输出
     * @param element tag,包含当前类名及所在行数
     * @param message 信息模板
     * @param args 信息模板里对应位置上的值
     */
    void w(StackTraceElement element, String message, Object... args);
    /**
     * Warning 输出
     * @param element tag,包含当前类名及所在行数
     * @param object 信息内容
     */
    void w(StackTraceElement element, Object object);

    /**
     * Info 输出
     * @param element tag,包含当前类名及所在行数
     * @param message 信息模板
     * @param args 信息模板里对应位置上的值
     */
    void i(StackTraceElement element, String message, Object... args);
    /**
     * Info 输出
     * @param element tag,包含当前类名及所在行数
     * @param object 信息内容
     */
    void i(StackTraceElement element, Object object);

    /**
     * Verbose 输出
     * @param element tag,包含当前类名及所在行数
     * @param message 信息模板
     * @param args 信息模板里对应位置上的值
     */
    void v(StackTraceElement element, String message, Object... args);
    /**
     * Verbose 输出
     * @param element tag,包含当前类名及所在行数
     * @param object 信息内容
     */
    void v(StackTraceElement element, Object object);

    /**
     * assert 输出
     * @param element tag,包含当前类名及所在行数
     * @param message 信息模板
     * @param args 信息模板里对应位置上的值
     */
    void wtf(StackTraceElement element, String message, Object... args);
    /**
     * assert 输出
     * @param element tag,包含当前类名及所在行数
     * @param object 信息内容
     */
    void wtf(StackTraceElement element, Object object);

    /**
     * Json 输出
     * @param element tag,包含当前类名及所在行数
     * @param json Json内容
     */
    void json(StackTraceElement element, String json);
}
