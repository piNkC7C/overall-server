package cn.iocoder.yudao.framework.common.exception.util;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

/**
 * Resolve ErrorCode copy for the current request locale.
 * English stays on {@link ErrorCode#getMsg()}; Chinese is the original product template.
 */
public final class I18nMessages {

    private I18nMessages() {
    }

    public static boolean chinese() {
        try {
            Locale locale = LocaleContextHolder.getLocale();
            return locale != null && "zh".equalsIgnoreCase(locale.getLanguage());
        } catch (Exception ignored) {
            return false;
        }
    }

    public static String pattern(ErrorCode errorCode) {
        if (errorCode == null) {
            return "";
        }
        if (chinese()) {
            String zh = ErrorCodeI18n.zh(errorCode.getCode());
            if (zh != null && !zh.isEmpty()) {
                return zh;
            }
        }
        return errorCode.getMsg();
    }

}
