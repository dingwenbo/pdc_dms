/*
 * Creation : 2016年9月8日
 */
package cn.newtouch.dms.util;

import org.apache.commons.lang3.StringUtils;

/**
 * The Class StringUtil.
 */
public class StringUtil {

    /** The Constant REGEX_FORMAT. */
    private static final String REGEX_FORMAT = "%s%s%s %s%s%s%s %s%s%s%s";

    /** The Constant REGEX_TRIM_SPACE. */
    private static final String REGEX_TRIM_SPACE = "\\s*";

    /**
     * Format str.
     *
     * @param args the args
     * @return the string
     */
    public static String formatStr(Object... args) {
        return String.format(REGEX_FORMAT, args);
    }

    /**
     * Format str.
     *
     * @param str the str
     * @return the string
     */
    public static String formatStr(String str) {
        String formatStr = StringUtils.EMPTY;
        if (StringUtils.isNotEmpty(str)) {
            formatStr = formatStr((Object[]) str.split(StringUtils.EMPTY));
        }
        return formatStr;
    }

    /**
     * Trim all space.
     *
     * @param str the str
     * @return the string
     */
    public static String trimAllSpace(String str) {
        String trimStr = StringUtils.EMPTY;
        if (StringUtils.isNotBlank(str)) {
            trimStr = str.replaceAll(REGEX_TRIM_SPACE, StringUtils.EMPTY);
        }
        return trimStr;
    }
}
