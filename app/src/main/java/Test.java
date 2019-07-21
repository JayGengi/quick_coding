import android.widget.PopupWindow;

public class Test {

    private PopupWindow popupWindow;
    private void Jay(){
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // popupWindow隐藏时恢复屏幕正常透明度
            }
        });
    }
}
