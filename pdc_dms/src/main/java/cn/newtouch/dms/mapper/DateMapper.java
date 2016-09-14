package cn.newtouch.dms.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DateMapper.
 */
public class DateMapper {

    /** The Constant DATE_FORMAT. */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy 年 MM 月 dd 日");

    /**
     * As string.
     *
     * @param date the date
     * @return the string
     */
    public String asString(Date date) {
        if (date != null) {
            return DATE_FORMAT.format(date);
        }
        return null;
    }

    /**
     * As date.
     *
     * @param str the str
     * @return the date
     * @throws ParseException the parse exception
     */
    public Date asDate(String str) throws ParseException {
        if (str != null) {
            return DATE_FORMAT.parse(str);
        }
        return null;
    }
}
