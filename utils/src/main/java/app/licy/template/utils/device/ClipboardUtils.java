package app.licy.template.utils.device;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import app.licy.template.utils.Predictions;

/**
 * Created by 程序亦非猿 on 2019/1/9.
 */
public final class ClipboardUtils {

    private ClipboardUtils() {
        throw new AssertionError("No instances.");
    }

    public static boolean copy(@NonNull Context context, @NonNull CharSequence label, @NonNull CharSequence text) {
        Predictions.notNull(context);
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, text);
        if (clipboard != null) {
            clipboard.setPrimaryClip(clip);
            return true;
        }
        return false;
    }

}
