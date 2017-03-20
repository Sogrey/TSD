package org.sogrey.tsd.log;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sogrey.tsd.log.utils.ArrayUtil;
import org.sogrey.tsd.log.utils.SystemUtil;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.Set;

/**
 * Created by Sogrey on 2015/7/20.
 */
public final class Logger implements Printer {

    protected Logger() {
    }

    /**
     * 打印字符串
     *
     * @param type 日志类型，可选值有：{@link LogType#VERBOSE} ,{@link LogType#DEBUG} ,{@link LogType#INFO} ,{@link LogType#WARN} ,{@link LogType#ERROR} 和{@link LogType#WTF}
     * @param element tag,显示所在当前类及行数
     * @param msg 信息模板
     * @param args 信息模板对应位置上的值
     */
    private void logString(LogType type, StackTraceElement element, String msg, Object... args) {
        if (!L.configAllowLog) {
            return;
        }
        String tag = generateTag(element);
        if (args.length > 0) {
            try {
                msg = String.format(msg, args);
            } catch (MissingFormatArgumentException e) {

            }
        }
        switch (type) {
            case VERBOSE:
                Log.v(tag, msg);
                break;
            case DEBUG:
                Log.d(tag, msg);
                break;
            case INFO:
                Log.i(tag, msg);
                break;
            case WARN:
                Log.w(tag, msg);
                break;
            case ERROR:
                Log.e(tag, msg);
                break;
            case WTF:
                Log.wtf(tag, msg);
                break;
            default:
                break;
        }
    }

    /**
     * 打印字符串
     *
     * @param type 日志类型，可选值有：{@link LogType#VERBOSE} ,{@link LogType#DEBUG} ,{@link LogType#INFO} ,{@link LogType#WARN} ,{@link LogType#ERROR} 和{@link LogType#WTF}
     * @param element tag,显示所在当前类及行数
     * @param object 信息内容
     */
    private void logObject(LogType type, StackTraceElement element, Object object) {
        if (object != null) {
            final String simpleName = object.getClass().getSimpleName();
            if (object instanceof Throwable) {
                String tag = generateTag(element);
                String msg = object.toString();
                Exception exception = (Exception) object;
                switch (type) {
                    case VERBOSE:
                        Log.v(tag, msg, exception);
                        break;
                    case DEBUG:
                        Log.d(tag, msg, exception);
                        break;
                    case INFO:
                        Log.i(tag, msg, exception);
                        break;
                    case WARN:
                        Log.w(tag, msg, exception);
                        break;
                    case ERROR:
                        Log.e(tag, msg, exception);
                        break;
                    case WTF:
                        Log.wtf(tag, msg, exception);
                        break;
                    default:
                        break;
                }
            } else if (object instanceof String) {
                logString(type, element, (String) object);
            } else if (object.getClass().isArray()) {
                String msg = "Temporarily not support more than two dimensional Array!";
                int dim = ArrayUtil.getArrayDimension(object);
                switch (dim) {
                    case 1:
                        Pair pair = ArrayUtil.arrayToString(object);
                        msg = simpleName.replace("[]", "[" + pair.first + "] {\n");
                        msg += pair.second + "\n";
                        break;
                    case 2:
                        Pair pair1 = ArrayUtil.arrayToObject(object);
                        Pair pair2 = (Pair) pair1.first;
                        msg = simpleName.replace("[][]", "[" + pair2.first + "][" + pair2.second + "] {\n");
                        msg += pair1.second + "\n";
                        break;
                    default:
                        break;
                }
                logString(type, element, msg + "}");
            } else if (object instanceof Collection) {
                Collection collection = (Collection) object;
                String msg = "%s size = %d [\n";
                msg = String.format(msg, simpleName, collection.size());
                if (!collection.isEmpty()) {
                    Iterator<Object> iterator = collection.iterator();
                    int flag = 0;
                    while (iterator.hasNext()) {
                        String itemString = "[%d]:%s%s";
                        Object item = iterator.next();
                        msg += String.format(itemString, flag, SystemUtil.objectToString(item),
                                flag++ < collection.size() - 1 ? ",\n" : "\n");
                    }
                }
                logString(type, element, msg + "\n]");
            } else if (object instanceof Map) {
                String msg = simpleName + " {\n";
                Map<Object, Object> map = (Map<Object, Object>) object;
                Set<Object> keys = map.keySet();
                for (Object key : keys) {
                    String itemString = "[%s -> %s]\n";
                    Object value = map.get(key);
                    msg += String.format(itemString, SystemUtil.objectToString(key),
                            SystemUtil.objectToString(value));
                }
                logString(type, element, msg + "}");
            } else {
                logString(type, element, SystemUtil.objectToString(object));
            }
        } else {
            logString(type, element, SystemUtil.objectToString(object));
        }
    }

    /**
     * 自动生成tag
     *
     * @return 自动生成tag，包含所在当前类及行数
     */
    private String generateTag(StackTraceElement caller) {
        String stackTrace = caller.toString();
        stackTrace = stackTrace.substring(stackTrace.lastIndexOf('('), stackTrace.length());
        String tag = "%s%s.%s%s";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        String Prefix = TextUtils.isEmpty(L.configTagPrefix) ? "" : L.configTagPrefix;
        tag = String.format(tag, Prefix, callerClazzName, caller.getMethodName(), stackTrace);
        return tag;
    }

    @Override
    public void d(StackTraceElement element, String message, Object... args) {
        logString(LogType.DEBUG, element, message, args);
    }

    @Override
    public void d(StackTraceElement element, Object object) {
        logObject(LogType.DEBUG, element, object);
    }

    @Override
    public void e(StackTraceElement element, String message, Object... args) {
        logString(LogType.ERROR, element, message, args);
    }

    @Override
    public void e(StackTraceElement element, Object object) {
        logObject(LogType.ERROR, element, object);
    }

    @Override
    public void w(StackTraceElement element, String message, Object... args) {
        logString(LogType.WARN, element, message, args);
    }

    @Override
    public void w(StackTraceElement element, Object object) {
        logObject(LogType.WARN, element, object);
    }

    @Override
    public void i(StackTraceElement element, String message, Object... args) {
        logString(LogType.INFO, element, message, args);
    }

    @Override
    public void i(StackTraceElement element, Object object) {
        logObject(LogType.INFO, element, object);
    }

    @Override
    public void v(StackTraceElement element, String message, Object... args) {
        logString(LogType.VERBOSE, element, message, args);
    }

    @Override
    public void v(StackTraceElement element, Object object) {
        logObject(LogType.VERBOSE, element, object);
    }

    @Override
    public void wtf(StackTraceElement element, String message, Object... args) {
        logString(LogType.WTF, element, message, args);
    }

    @Override
    public void wtf(StackTraceElement element, Object object) {
        logObject(LogType.WTF, element, object);
    }

    @Override
    public void json(StackTraceElement element, String json) {
        int indent = 4;
        if (TextUtils.isEmpty(json)) {
            d(element, "JSON{json is null}");
            return;
        }
        try {
            if (json.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(json);
                String msg = jsonObject.toString(indent);
                d(element, msg);
            } else if (json.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(json);
                String msg = jsonArray.toString(indent);
                d(element, msg);
            }
        } catch (JSONException e) {
            e(element, e);
        }
    }
}
