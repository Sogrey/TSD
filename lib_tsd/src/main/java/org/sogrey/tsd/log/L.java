package org.sogrey.tsd.log;


import org.sogrey.tsd.BuildConfig;
import org.sogrey.tsd.log.utils.SystemUtil;

/**
 * Created by Sogrey on 2015/7/16. 日志管理器
 */
public final class L {

    private static Logger logger;

    static {
        logger = new Logger();
    }

    /**
     * 允许输出日志，默认为false，需要先调用 {@link L#init(boolean)} 方法传入参数 true，可使用Application Moudel 的 BuildConfig.DEBUG，不能使用 Libriay Moudel 的 BuildConfig.DEBUG，因为 Libriay Moudel 的 BuildConfig.DEBUG 编译后恒为false。
     */

    public static boolean configAllowLog = false/* BuildConfig.DEBUG*/;

    // 配置日志Tag前缀
    public static String configTagPrefix = "Log";

    /**
     * 初始化方法，使用前最先调用
     *
     * @param b true 允许输出日志，false 则否，可传入Application Moudel 的 BuildConfig.DEBUG
     */
    public static void init(boolean b) {
        configAllowLog = b;
    }

    /**
     * verbose输出
     *
     * @param msg  信息模板
     * @param args 信息模板对应位置上的值
     */
    public static void v(String msg, Object... args) {
        logger.v(SystemUtil.getStackTrace(), msg, args);
    }

    /**
     * verbose输出
     *
     * @param object 要打印的信息
     */
    public static void v(Object object) {
        logger.v(SystemUtil.getStackTrace(), object);
    }

    /**
     * debug输出
     *
     * @param msg  信息模板
     * @param args 信息模板对应位置上的值
     */
    public static void d(String msg, Object... args) {
        logger.d(SystemUtil.getStackTrace(), msg, args);
    }
    /**
     * debug输出
     *
     * @param object  要打印的信息
     */
    public static void d(Object object) {
        logger.d(SystemUtil.getStackTrace(), object);
    }

    /**
     * info输出
     *
     * @param msg  信息模板
     * @param args 信息模板对应位置上的值
     */
    public static void i(String msg, Object... args) {
        logger.i(SystemUtil.getStackTrace(), msg, args);
    }
    /**
     * info输出
     *
     * @param object  要打印的信息
     */
    public static void i(Object object) {
        logger.i(SystemUtil.getStackTrace(), object);
    }

    /**
     * warn输出
     *
     * @param msg  信息模板
     * @param args 信息模板对应位置上的值
     */
    public static void w(String msg, Object... args) {
        logger.w(SystemUtil.getStackTrace(), msg, args);
    }
    /**
     * warn输出
     *
     * @param object  要打印的信息
     */
    public static void w(Object object) {
        logger.w(SystemUtil.getStackTrace(), object);
    }

    /**
     * error输出
     *
     * @param msg  信息模板
     * @param args 信息模板对应位置上的值
     */
    public static void e(String msg, Object... args) {
        logger.e(SystemUtil.getStackTrace(), msg, args);
    }
    /**
     * error输出
     *
     * @param object  要打印的信息
     */
    public static void e(Object object) {
        logger.e(SystemUtil.getStackTrace(), object);
    }

    /**
     * assert输出
     *
     * @param msg  信息模板
     * @param args 信息模板对应位置上的值
     */
    public static void wtf(String msg, Object... args) {
        logger.wtf(SystemUtil.getStackTrace(), msg, args);
    }
    /**
     * assert输出
     *
     * @param object  要打印的信息
     */
    public static void wtf(Object object) {
        logger.wtf(SystemUtil.getStackTrace(), object);
    }

    /**
     * 打印json
     *
     * @param json 要打印的json字符串
     */
    public static void json(String json) {
        logger.json(SystemUtil.getStackTrace(), json);
    }

}
